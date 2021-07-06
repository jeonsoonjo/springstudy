package com.koreait.myproject.dao;

import java.util.List;

import com.koreait.myproject.dto.ImgBoardDTO;
import com.koreait.myproject.dto.PageDTO;

public interface ImgBoardDAO {

	public int getTotalRecord();
	public int updateHit(long idx);
	public List<ImgBoardDTO> selectImgBoardList(PageDTO pageDTO);
	public ImgBoardDTO selectImgBoardByIdx(long idx);
	public int insertImgBoard(String writer, String title, String content, String filename, String ip);
	
	
}
