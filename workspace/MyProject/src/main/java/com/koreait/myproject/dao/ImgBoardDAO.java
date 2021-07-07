package com.koreait.myproject.dao;

import java.util.List;

import com.koreait.myproject.dto.ImgBoardDTO;

public interface ImgBoardDAO {

	public int getTotalRecord();
	public int updateHit(long idx);
	public List<ImgBoardDTO> selectImgBoardList();
	public int insertImgBoard(ImgBoardDTO imgBoardDTO);
	public ImgBoardDTO selectImgBoardByIdx(long idx);
	public int updateImgBoard(ImgBoardDTO imgBoardDTO);
	public int deleteImgBoard(long no);
	
}
