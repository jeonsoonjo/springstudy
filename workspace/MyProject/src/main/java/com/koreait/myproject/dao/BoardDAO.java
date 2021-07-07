package com.koreait.myproject.dao;

import java.util.List;

import com.koreait.myproject.dto.BoardDTO;
import com.koreait.myproject.dto.PageDTO;

public interface BoardDAO {
	
	public int getTotalRecord();
	public List<BoardDTO> selectBoardList(PageDTO pageDTO);
	public int insertBoard(BoardDTO boardDTO);
	
	// public void updateBoard(BoardDTO boardDTO);
	
	public void deleteBoard(long idx);
	
}
