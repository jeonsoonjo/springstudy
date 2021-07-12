package com.koreait.test1.dao;

import java.util.ArrayList;

import com.koreait.test1.dto.BoardDTO;

public interface BoardDAO {

	public ArrayList<BoardDTO> selectBoardList(); 
	public int getTotalBoardCount();
	public int insertBoard(String bWriter, String bTitle, String bContent);
	public BoardDTO selectBybIdx(int bIdx);
	public int updateBoard(String bTitle, String bContent, int bIdx);
	public int deleteBoard(int bIdx);
	
}
