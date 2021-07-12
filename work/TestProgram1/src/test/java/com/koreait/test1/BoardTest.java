package com.koreait.test1;


import static org.junit.Assert.assertEquals;


import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.koreait.test1.config.BeanConfiguration;
import com.koreait.test1.dao.BoardDAO;
import com.koreait.test1.dto.BoardDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {BeanConfiguration.class})
public class BoardTest {

	// field
	@Autowired
	private SqlSession sqlSession;
	
	/*@Test
	public void insertTest() {
		BoardDTO board = new BoardDTO();
		board.setbWriter("테스터");
		board.setbTitle("테스트제목");
		board.setbContent("테스트내용");
		
		BoardDAO boardDAO = sqlSession.getMapper(BoardDAO.class);
		int count = boardDAO.insertBoard(bWriter, bTitle, bContent);
		
		assertEquals("가입 실패", 1, count);
	}*/
	
	@Test
	public void selectTest(){
		BoardDAO boardDAO = sqlSession.getMapper(BoardDAO.class);
		BoardDTO count = boardDAO.selectBybIdx(9999);
		assertEquals("조회 실패", 1, count);
	}
	
	@Test
	public void deleteTest(){
		
	}

}
