package com.koreait.contact03.dao;

import java.util.List;

import com.koreait.contact03.dto.Contact;

public interface ContactDAO {

	// ContactDAO는 contact.xml과 직접 연결한다
	
	public List<Contact> selectContactList();
	public Contact selectContactByNo(long no);
	public void insertContact(String name, String tel, String addr, String email, String note);
	
	
	
	
}

