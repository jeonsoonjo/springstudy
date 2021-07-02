package com.koreait.integration.domain;

import java.sql.Date;

public class Staff {

	private long no;
	private String name;
	private String depart;
	private int salary;
	private Date regdate;
	
	public Staff() {
		super();
	}
	public Staff(long no, String name, String depart, int salary, Date regdate) {
		super();
		this.no = no;
		this.name = name;
		this.depart = depart;
		this.salary = salary;
		this.regdate = regdate;
	}
	
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepart() {
		return depart;
	}
	public void setDepart(String depart) {
		this.depart = depart;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	
}

