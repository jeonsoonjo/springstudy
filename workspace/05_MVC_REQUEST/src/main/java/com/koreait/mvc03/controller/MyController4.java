package com.koreait.mvc03.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.koreait.mvc03.dto.Person;

@Controller
public class MyController4 {

	/*
		Spring의 Model 인터페이스
		
		1. ModelAndView 대신 사용된다
		2. Model은 응답View로 값을 전달할 때 사용한다
		3. Model은 내부적으로 request의 attribute를 이용한다
			- 기존 : request.setAttribute("속성명", 값)
			- Model : model.addAttribute("속성명", 값)
		4. new Model()은 불가능하다(인터페이스 이기 때문에)
	*/
	
	@RequestMapping("f3/v01")
	public String a(Model model) {
		
		// 응답View에 전달할 데이터
		model.addAttribute("name", "브레드");
		model.addAttribute("age", 50);
		
		return "folder03/view01";

	}
	
	@RequestMapping("f3/v02")
	public String b(Model model) {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "아토");
		map.put("age", "3");
		
		model.addAttribute("map", map);
		
		return "folder03/view02";
		
	}
	
	// root-context.xml에 존재하는 bean 생성 방법
	// @Inject, @Resource, @Autowired 등의 애너테이션 이용하기
	
	// <bean id="p1" class="com.koreait.mvc03.dto.Person">
	
	// 1. @Inject
	//		1) pom.xml에 디펜던시 추가(02_DI 참고)
	//		2) 필드, 생성자, setter를 이용해 주입
	//		3) 클래스를 기반으로 생성(같은 클래스를 찾는다)
	//		4) 예시: 필드를 이용한 주입
	//				@Inject -> 클래스명이 같아야 한다(Person)
	//				private Person p;
	//
	// 2. @Resource
	//		1) pom.xml에 디펜던시 추가(02_DI 참고)
	//		2) 필드, setter를 이용해 주입(생성자는 안 됨)
	//		3) bean의 id속성(매개변수)을 기반으로 생성(같은 id를 찾는다)
	//		4) 예시: setter를 이용한 주입
	//				@Resource -> id=매개변수명이 같아야 한다(p1)
	//				public void setP1(Person p1){}
	//
	// 3. @Autowired(가장 많이 사용)
	//		1) 별도 디펜던시를 추가하지 않아도 된다
	//		2) 1)번 빼고 @Inject와 같다
	//		3) 즉, 클래스명이 같아야 한다
	
	// field
	@Autowired
	@Qualifier("p1")
	// Autowired는 클래스타입이 일치하는 것을 찾는다
	// root-context.xml에 Bean class가 Person인 것이 복수이기 때문에 Autowired는 찾을 수 없다
	// 그래서 Qualifier("") 애너테이션으로 명칭을 다르게 주어 구별한다
	private Person person1;
	
	// method
	@RequestMapping("f3/v03")
	public String c(Model model) {
		model.addAttribute("person1", person1);
		return "folder03/view03";
	}
	
	@Autowired
	@Qualifier("p2")
	private Person person2;
	
	@RequestMapping("f3/v04")
	public String d(Model model) {
		model.addAttribute("person2", person2);
		return "folder03/view04";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}


