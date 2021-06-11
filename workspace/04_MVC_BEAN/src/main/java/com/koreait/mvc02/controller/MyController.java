package com.koreait.mvc02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller // 애너테이션을 해줘야 한다
public class MyController {

	// URLMapping을 처리하는 메소드 단위로 구성한다
	// @RequestMapping(value="/") // URLMapping이 contextPath인 경우이다(http://localhost:9090/mvc02/)
	// @RequestMapping(method=RequestMethod.GET) // GET방식의 요청(생략 가능)
	@RequestMapping(value="/", method=RequestMethod.GET) // 한 번에 작성
	// 1. 반환타입 : String, 응답View의 이름을 반환한다
	// 2. 메소드명 : a, 아무 역할이 없다
	// 3. 매개변수 : Model model, request를 이용하는 객체이다
	public String a(Model model) {
		// return "index" 의미
		// 1. DispatherServlet : servlet-context.xml에 정의된 ViewResolver에 의해서 처리된다
		// 	1) prefix : "/WEB-INF/views/", return 앞에 추가한다
		//	2) suffix : ".jsp", return 뒤에 추가한다
		// 2. forward로 이동된다(기본값은 forward)
		return "index"; // return "/WEB-INF/views/index.jsp" 경로
	}
	
}


