package com.koreait.file.command;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.koreait.file.dao.BoardDAO;

public class InsertBoardCommand implements BoardCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		// 첨부파일은 HttpServletRequest로 받을 수 없다
		// MultipartHttpServletRequest로 받아야 한다
		Map<String, Object> map = model.asMap();
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)map.get("multipartRequest");

		// writer, title, content 파라미터 처리 -> multipartRequest에서 뺄 수 있다
		String writer = multipartRequest.getParameter("writer");
		String title = multipartRequest.getParameter("title");
		String content = multipartRequest.getParameter("content");
		
		/*
			<input type="file" name="filename"> : 단일 파일 첨부
			MultipartFile file = multipartRequest.getFile("filename");
		*/
		/*
			<input type="file" name="files" multiple> : 다중 파일 첨부
			List<MultipartFile> files = multipartRequest.getFiles("files");
			: 첨부파일 하나 당 MultipartFile을 사용하면 된다
			: List에 담아 반복문으로 하나씩 꺼내면 된다
		*/
		List<MultipartFile> files = multipartRequest.getFiles("files");
		BoardDAO boardDAO = sqlSession.getMapper(BoardDAO.class);
		for(MultipartFile file : files) {
			// NullPointException 방지
			if(file != null && !file.isEmpty()) { // file이 null이 아니고, file이 비어있지 않으면
				
				// 첨부할 때 파일명 : file.getOriginalFilename()
				String originalFilename = file.getOriginalFilename();
				// 첨부된 파일명 확인
				System.out.println("첨부파일명: " + file.getOriginalFilename());
				
				// 서버에 저장할 파일명
				// 파일명의 중복 방지 대책이 필요 : 파일명_올린시간.확장자 or 파일명+IP주소 등 중복을 피한다
				String extension = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
				// extension : 확장자, 본 파일명에서 마지막 "."을 기준으로 추출
				// +1 은 .txt이면 "." 다음 글자 t까지 구분하겠다는 의미
				String filename = originalFilename.substring(0, originalFilename.lastIndexOf("."));
				// filename : 파일명, 시작부터 마지막 "." 직전까지 추출
				String uploadFilename = filename + "_" + System.currentTimeMillis() + "." + extension;
				// 업로드할 파일명 : 파일명_올린시간.확장자
				// currenTimeMillis 1(초)/1000(분) 이기 때문에 동시에 올려도 파일명이 다르게 올라간다
				
				// 첨부파일을 저장할 서버 위치(archive 디렉터리는 없으므로 생성이 필요(코드로 디렉터리 생성하는 걸 추천))
				// realPath : springstudy\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\14_FILE\resources\archive
				String realPath = multipartRequest.getServletContext().getRealPath("resources/archive");
				// archive 디렉터리 생성
				File archive = new File(realPath);
				if(!archive.exists()) {
					archive.mkdirs();
				}
				
				// 서버에 첨부파일 저장 file(저장할 디렉터리, 저장할 파일명)
				File attach = new File(archive, uploadFilename);
				try {
					file.transferTo(attach); // 저장된 파일명 attach에 보낸다는 의미, try-catch 필요
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				// DB에 데이터 저장(첨부파일이 있는 경우)
				boardDAO.insertBoard(writer, title, content, uploadFilename);

			} else {
				// DB에 데이터 저장(첨부파일이 없는 경우)
				boardDAO.insertBoard(writer, title, content, "");
			}
		}
		
	}

}

