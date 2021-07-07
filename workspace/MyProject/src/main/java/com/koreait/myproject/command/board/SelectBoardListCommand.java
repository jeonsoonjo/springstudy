package com.koreait.myproject.command.board;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;
import com.koreait.myproject.dao.BoardDAO;
import com.koreait.myproject.dto.BoardDTO;
import com.koreait.myproject.dto.PageDTO;
import com.koreait.myproject.util.PagingUtils;


public class SelectBoardListCommand implements BoardCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		Optional<String> opt = Optional.ofNullable(request.getParameter("page"));
		int page = Integer.parseInt(opt.orElse("1"));
		
		BoardDAO boardDAO = sqlSession.getMapper(BoardDAO.class);
		int totalRecord = boardDAO.getTotalRecord();
		
		PageDTO pageDTO = PagingUtils.getPage(totalRecord, page);
		
		List<BoardDTO> list = boardDAO.selectBoardList(pageDTO);
		String paging = PagingUtils.getPaging("selectBoardList.do", page);

		model.addAttribute("list", list);
		model.addAttribute("paging", paging);
		model.addAttribute("totalRecord", totalRecord);
			
	}

}
