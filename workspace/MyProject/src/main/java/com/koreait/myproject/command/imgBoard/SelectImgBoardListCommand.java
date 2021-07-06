package com.koreait.myproject.command.imgBoard;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.myproject.dao.ImgBoardDAO;
import com.koreait.myproject.dto.ImgBoardDTO;
import com.koreait.myproject.dto.PageDTO;
import com.koreait.myproject.util.PagingUtils;

public class SelectImgBoardListCommand implements ImgBoardCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		Optional<String> opt = Optional.ofNullable(request.getParameter("page"));
		int page = Integer.parseInt(opt.orElse("1"));
		
		ImgBoardDAO imgBoardDAO = sqlSession.getMapper(ImgBoardDAO.class);
		int totalRecord = imgBoardDAO.getTotalRecord();
		
		PageDTO pageDTO = PagingUtils.getPage(totalRecord, page);
		
		List<ImgBoardDTO> imgList = imgBoardDAO.selectImgBoardList(pageDTO);
		String paging = PagingUtils.getPaging("searchAll.do", page);
		
		model.addAttribute("imgList", imgList);
		model.addAttribute("paging", paging);
		model.addAttribute("totalRecord", totalRecord);
		
	}
		
}



