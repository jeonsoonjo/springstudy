package com.koreait.myproject.dao;

import java.util.List;

import com.koreait.myproject.dto.ImgBoardDTO;

public interface ImgBoardDAO {

	public int getTotalImgBoardCount();
	public int updateHit(long idx);
	public List<ImgBoardDTO> selectImgBoardList();
	public ImgBoardDTO selectImgBoardByIdx(long idx);
	public int insertImgBoard(String writer, String title, String content, String filename, String ip);
	
	
}
