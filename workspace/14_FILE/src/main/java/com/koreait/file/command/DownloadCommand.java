package com.koreait.file.command;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;

public class DownloadCommand {

	// DB 접근이 없는 Command이기 때문에 sqlSession을 사용하지 않는다
	// DAO, mapper 작성을 안 해도 된다
	// 즉, interface를 구현하지 않아도 된다(구현해도 상관 없음)
	
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		HttpServletResponse response = (HttpServletResponse)map.get("response");
		
		// 디렉터리 경로, 파일명 파라미터 처리
		String realPath = request.getServletContext().getRealPath("resources/archive");
		String filename = request.getParameter("filename"); // DB에 저장된 파일명(_과 시간이 포함되어 있다)
		
		// 파일명 원상 복구(선택) : _과 시간 빼기
		String extension = filename.substring(filename.lastIndexOf(".") + 1); // 확장자 추출
		String originalFilename = filename.substring(0, filename.lastIndexOf("_")); // 파일명 추출
		String downloadFilename = originalFilename + "." + extension; // 파일명.확장자
		
		// 다운로드 할 file 생성(디렉터리 경로, 파일명)
		File download = new File(realPath, filename); // 서버에서 찾아야 하는 파일명 작성(=DB에 저장된 파일명)
		
		// 스트림 준비 및 생성
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			
			// response 다운로드 처리
			response.setHeader("Content-Type", "application/x-msdownload");
			response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(downloadFilename, "utf-8")); 
			response.setHeader("Content-Length", download.length() + ""); // Header는 문자열 처리를 해야 한다
			
			// 서버에 저장된 download할 파일을 읽는 스트림
			bis = new BufferedInputStream(new FileInputStream(download)); 
			// 사용자에게 파일을 생성하는 출력 스트림
			bos = new BufferedOutputStream(response.getOutputStream());
			
			// bis로 읽은 내용을 bos로 전송(파일 복사 진행) : 스프링에서는 FileCopyUtils를 지원한다(while문 사용 안 해도 됨)
			FileCopyUtils.copy(bis, bos);
			
			// 혹시 남은 게 있다면
			bos.flush();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(bos != null) bos.close();
				if(bis != null) bis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}

