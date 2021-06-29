package com.koreait.ajax.controller;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.ajax.command.InsertMemberCommand;
import com.koreait.ajax.command.SelectMemberListCommand;
import com.koreait.ajax.command.SelectMemberViewCommand;
import com.koreait.ajax.dto.Member;
import com.koreait.ajax.dto.Page;

@RestController // 모든 메소드의 전환값을 @ResponseBody로 처리한다(일반 controller과는 다르니 주의!)
public class MemberRestController {

	// 앞으로 모든 메소드는 @ResponseBody 애너테이션을
	// 추가하지 않아도 ajax 처리가 된다
	
	// field
	private SqlSession sqlSession;
	private InsertMemberCommand insertMemberCommand;
	private SelectMemberListCommand selectMemberListCommand;
	private SelectMemberViewCommand selectMemberViewCommand;

	// constructor
	@Autowired
	public MemberRestController(SqlSession sqlSession,
								InsertMemberCommand insertMemberCommand,
								SelectMemberListCommand selectMemberListCommand,
								SelectMemberViewCommand selectMemberViewCommand) {
		this.sqlSession = sqlSession;
		this.insertMemberCommand = insertMemberCommand;
		this.selectMemberListCommand = selectMemberListCommand;
		this.selectMemberViewCommand = selectMemberViewCommand;
	}
	
	// method
	@PostMapping(value="insertMember.do",
				 produces="application/json; charset=utf-8")
	public Map<String, Object> insertMember(@RequestBody Member member,
											HttpServletResponse response,
											Model model) {
		model.addAttribute("member", member);
		model.addAttribute("response", response);
		return insertMemberCommand.execute(sqlSession, model);
	}
	
	@PostMapping(value="selectMemberList.do",
				 produces="application/json; charset=utf-8")
	public Map<String, Object> selectMemberList(@RequestBody Page page,
												Model model){
		model.addAttribute("page", page.getPage());
		return selectMemberListCommand.execute(sqlSession, model);
	}
	
	@PostMapping(value="selectMemberByNo.do",
				 produces="application/json; charset=utf-8")
	public Map<String, Object> selectMemberByNo(@RequestBody Member member,
												Model model){
		model.addAttribute("no", member.getNo());
		return selectMemberViewCommand.execute(sqlSession, model);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}


