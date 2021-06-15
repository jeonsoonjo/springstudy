package com.koreait.mvc03.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.koreait.mvc03.dto.Person;

@Controller
public class MyController6 {

	/*
		전달 받은 파라미터 처리
		
		1. HttpServletRequest
		2. @RequestParam, null 처리
		3. DTO
		4. @ModelAttribute
	*/
	
	// 1. HttpServletRequest 이용
	@RequestMapping("f5/v01")
	public String a(HttpServletRequest request, Model model) { // request에 name, age 파라미터
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		
		return "folder05/view01"; // forward
	}
	
	// 2. @ReqeustParam 이용
	// @RequestParam(value="파라미터")
	// @RequestParam("파라미터") : value 생략 가능
	@RequestMapping("f5/v02")
	public String b(@RequestParam("name") String name,
					@RequestParam("age") int age,
					Model model) {
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		
		return "folder05/view02";
	}
	
	// 2-1. @RequestParam의 null 처리
	// @RequestParam(value="파라미터", required=false) : 복수로 사용할 때에는 value="" 생략 불가
	// required=false : 파라미터가 없어도 처리된다
	// defaultValue="" : 파라미터가 없으면 0을 사용한다(문자는 null이 가능하지만, 숫자는 불가능하기 때문에 "0"을 쓴다)
	@RequestMapping("f5/v03")
	public String c(@RequestParam(value="name", required=false) String name,
				    @RequestParam(value="age", required=false, defaultValue="0") int age,
				    Model model) {
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		
		return "folder05/view03";
	}
	
	// 3. DTO 이용
	@RequestMapping("f5/v04")
	public String d(Person person, Model model) { // 파라미터 name, age가 person에 저장된다
		model.addAttribute("person", person);
		
		return "folder05/view04";
	}
	
	// 4. @ModelAttribute 이용(속성)
	// 파라미터 값을 받아서 알아서  model에 저장한다(model선언을 안 해도 됨)
	@RequestMapping("f5/v05")
	public String e(@ModelAttribute(value="name") String name, // 파라미터 name을 String name에 저장한 뒤 model에 저장한다
					@ModelAttribute("age") int age) {
		return "folder05/view05";
	}
	
	// 4-1. @ModelAttribute 이용(DTO)
	@RequestMapping("f5/v06")
	public String f(@ModelAttribute("person") Person person) {
		return "folder05/view06";
	}
	
}


