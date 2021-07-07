package com.koreait.myproject.command.imgBoard;

import java.io.File;
import java.util.Map;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.koreait.myproject.dao.ImgBoardDAO;
import com.koreait.myproject.dto.ImgBoardDTO;


public class UpdateImgBoardCommand implements ImgBoardCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
	Map<String, Object> map = model.asMap();
	MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)map.get("multipartRequest");
	
	ImgBoardDTO imgBoardDTO = new ImgBoardDTO();
	imgBoardDTO.setIdx(Long.parseLong(multipartRequest.getParameter("idx")));
	imgBoardDTO.setTitle(multipartRequest.getParameter("title"));
	imgBoardDTO.setContent(multipartRequest.getParameter("content"));	
	
	String origin_filename = multipartRequest.getParameter("origin_filename");
	String save_filename = multipartRequest.getParameter("save_filename");
	
	MultipartFile new_file = multipartRequest.getFile("new_file");
	
	try {
		
		if (new_file != null && !new_file.isEmpty()) {  // 새로운 첨부가 있다.
			
			String new_origin_filename = new_file.getOriginalFilename();
			
			String extension = new_origin_filename.substring( new_origin_filename.lastIndexOf(".") );
			String new_save_filename = UUID.randomUUID().toString().replaceAll("-", "") + extension;
			
			// 첨부파일을 저장할 서버 위치
			String realPath = multipartRequest.getServletContext().getRealPath("resources/archive");

			// 서버에 새 첨부파일 저장
			File new_save_file = new File(realPath, new_save_filename);
			try {
				new_file.transferTo(new_save_file);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			// 기존 첨부와 새로운 첨부가 모두 있으면 -> 기존 첨부를 지운다.
			File file = new File(realPath, save_filename);  // 서버에 저장된 파일(기존의 첨부)
			if (file != null) {
				// 기존 첨부 지우기
				if (file.exists()) {
					file.delete();
				}
			}
			
			imgBoardDTO.setOrigin_filename(new_origin_filename);
			imgBoardDTO.setSave_filename(new_save_filename);
			
		} else {
			
			imgBoardDTO.setOrigin_filename(origin_filename);
			imgBoardDTO.setSave_filename(save_filename);
			
		}
			
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	// DB에 데이터 저장
	ImgBoardDAO imgBoardDAO = sqlSession.getMapper(ImgBoardDAO.class);
	imgBoardDAO.updateImgBoard(imgBoardDTO);
	
	}

}

