package com.koreait.contact03.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.koreait.contact03.command.InsertContactCommand;
import com.koreait.contact03.command.SelectContactListCommand;
import com.koreait.contact03.command.SelectContactViewCommand;
import com.koreait.contact03.command.UpdateContactCommand;

@Controller
public class ContactController {

	// field
	private SqlSession sqlSession;
	private SelectContactListCommand selectContactListCommand;
	private SelectContactViewCommand selectContactViewCommand;
	private InsertContactCommand insertContactCommand;
	private UpdateContactCommand updateContactCommand;
	
	// constructor
	@Autowired
	public ContactController(SqlSession sqlSession,
							 SelectContactListCommand selectContactListCommand,
							 SelectContactViewCommand selectContactViewCommand,
							 InsertContactCommand insertContactCommand,
							 UpdateContactCommand updateContactCommand) {
		super();
		this.sqlSession = sqlSession;
		this.selectContactListCommand = selectContactListCommand;
		this.selectContactViewCommand = selectContactViewCommand;
		this.insertContactCommand = insertContactCommand;
		this.updateContactCommand = updateContactCommand;
	}
	
	// method
	@GetMapping(value= {"/", "selectContactList.do"})
	public String selectContactList(Model model) {
		selectContactListCommand.execute(sqlSession, model);
		return "contact/list";
	}
	
	@GetMapping(value="selectContactByNo.do")
	public String selectContactByNo(HttpServletRequest request,
									Model model) {
		model.addAttribute("request", request);
		selectContactViewCommand.execute(sqlSession, model);
		return "contact/view";
	}
	
	@GetMapping(value="insertContactPage.do")
	public String insertContactPage() {
		return "contact/insert";
	}
	@GetMapping(value="insertContact.do")
	public String insertContact(HttpServletRequest request,
								Model model) {
		model.addAttribute("request", request);
		insertContactCommand.execute(sqlSession, model);
		return "redirect:selectContactList.do";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}

