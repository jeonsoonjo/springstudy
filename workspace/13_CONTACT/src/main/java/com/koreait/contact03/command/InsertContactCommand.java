package com.koreait.contact03.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.contact03.dao.ContactDAO;
import com.koreait.contact03.dto.Contact;

public class InsertContactCommand implements ContactCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		// NAME, TEL, ADDR, EMAIL, NOTE
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String addr = request.getParameter("addr");
		String email = request.getParameter("email");
		String note = request.getParameter("note");
		
		Contact contact = new Contact();
		contact.setName(name);
		contact.setTel(tel);
		contact.setAddr(addr);
		contact.setEmail(email);
		contact.setNote(note);
		
		ContactDAO contactDAO = sqlSession.getMapper(ContactDAO.class);
		contactDAO.insertContact(name, tel, addr, email, note);

	}

}


