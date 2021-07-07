package com.koreait.myproject.command.imgBoard;



import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.myproject.dao.ImgBoardDAO;


public class SelectImgBoardListCommand implements ImgBoardCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		/*Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		Optional<String> opt = Optional.ofNullable(request.getParameter("page"));
		int page = Integer.parseInt(opt.orElse("1"));
		
		ImgBoardDAO imgBoardDAO = sqlSession.getMapper(ImgBoardDAO.class);
		int totalRecord = imgBoardDAO.getTotalRecord();
		
		PageDTO pageDTO = PagingUtils.getPage(totalRecord, page);
		
		List<ImgBoardDTO> imgList = imgBoardDAO.selectImgBoardList();
		String paging = PagingUtils.getPaging("selectImgBoardList.do", page);
		
		model.addAttribute("imgList", imgList);
		model.addAttribute("paging", paging);
		model.addAttribute("totalRecord", totalRecord);*/
		
		ImgBoardDAO imgBoardDAO = sqlSession.getMapper(ImgBoardDAO.class);
		model.addAttribute("imgList", imgBoardDAO.selectImgBoardList());
		
	}
		
}



