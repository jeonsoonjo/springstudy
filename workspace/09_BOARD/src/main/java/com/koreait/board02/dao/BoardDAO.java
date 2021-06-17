package com.koreait.board02.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.koreait.board02.dto.Board;

public class BoardDAO {
	
	// BoardDAO boardDAO bean은 스프링에 의해서 singleton으로 생성된다(servlet-context.xml)

	@Autowired
	private JdbcTemplate template; // con, ps, rs를 알아서 처리한다(양식을 가지고 있음)
	private String sql;
	
	// 1. list
	public List<Board> selectBoardList(){
		sql = "SELECT NO, WRITER, TITLE, CONTENT, POSTDATE FROM BOARD";
		return template.query(sql, new BeanPropertyRowMapper<Board>(Board.class)); // BoardDTO.calss generic(1.8버전 이후에서는 generic 생략 가능)
	}
	
	// 2. view
	public Board selectBoardByNo(long no) {
		sql = "SELECT NO, WRITER, TITLE, CONTENT, POSTDATE FROM BOARD WHERE NO=?";
		return template.queryForObject(sql, new BeanPropertyRowMapper<Board>(Board.class), no);
	}
	
	// 3. update
	public void updateBoard(Board board) {
		sql = "UPDATE BOARD SET TITLE=?, CONTENT=? WHERE NO=?";
		template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// 매개변수 ps를 이용해서 ?를 채운다
				ps.setString(1, board.getTitle());
				ps.setString(2, board.getContent());
				ps.setLong(3, board.getNo());
			}
		});
	}
	
	// 4. delete
	public void deleteBoard(long no) {
		sql = "DELETE FROM BOARD WHERE NO=?";
		template.update(sql, new PreparedStatementSetter() { // update는  int로 반환된다. 그러면 void를 int타입으로 변경하고 template를 return 하면 됨
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setLong(1, no);
			}
		});
	}
	
	// 5. insert(return 사용해보기)
	public int insertBoard(Board board) {
		return template.update(new PreparedStatementCreator() {
			//PreparedStatementCreator, setter로 해도 된다
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// 매개변수 con으로 ps를 만들어서 반환
				String sql = "INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL, ?, ?, ?, SYSDATE)";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, board.getWriter());
				ps.setString(2, board.getTitle());
				ps.setString(3, board.getContent());
				return ps;
			}
		}); 
	}
	
}

