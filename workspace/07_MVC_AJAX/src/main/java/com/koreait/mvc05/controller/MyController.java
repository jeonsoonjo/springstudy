package com.koreait.mvc05.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreait.mvc05.dto.Person;

@Controller
public class MyController {

	@RequestMapping("/")
	public String contextPath() {
		return "index";
	}
	
	// 1. String 반환하기
	@RequestMapping(value="v01",
					method=RequestMethod.GET,
					produces="text/plain; charset=utf-8")
	@ResponseBody // ajax 처리를 위한 필수 애너테이션이다
	public String v01(@RequestParam("name") String name,
			   		  @RequestParam("age") int age) {
	
		return name + ", " + age;
	}
	
	// 2. json 반환하기
	@RequestMapping(value="v02",
					method=RequestMethod.GET,
					produces="application/json; charset=utf-8")
	@ResponseBody // ajax 처리를 위한 필수 애너테이션이다
	public Person v02(@RequestParam("name") String name,
					  @RequestParam("age") int age){
		Person p = new Person();
		p.setName(name);
		p.setAge(age);
		
		return p; // bean을 반환한다. produces="application/json; charset=utf-8"
		// return은 ViewResolver에 의해서 jsp로 처리가 되는데
	}
	
	// 3. json 받아서 json 반환하기
	@RequestMapping(value="v03",
					method=RequestMethod.GET,
					produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Person v03(@RequestBody Person person) {
		return person;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}


