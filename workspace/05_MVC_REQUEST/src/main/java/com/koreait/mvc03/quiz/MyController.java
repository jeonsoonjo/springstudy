package com.koreait.mvc03.quiz;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("quiz")
public class MyController {

	// 1. HttpServletRequest 이용
	@RequestMapping("v01")
	public String a(HttpServletRequest request, Model model) {
		/*
			String title = request.getParameter("title");
			int hit = Integer.parseInt(request.getParameter("hit"));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String today = sdf.format(new Date());
			
			model.addAttribute("title", title);
			model.addAttribute("hit", hit);
			model.addAttribute("date", today);
		*/
		
		model.addAttribute("title", request.getParameter("title"));
		model.addAttribute("hit", Integer.parseInt(request.getParameter("hit")));
		model.addAttribute("date", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		
		return "quiz/view01";
	}
	
	// 2. @RequestParam 이용
	@RequestMapping("v02")
	public String b(@RequestParam("title") String title,
					@RequestParam("hit") int hit,
					Model model) {
		model.addAttribute("title", title);
		model.addAttribute("hit", hit);
		model.addAttribute("date", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		
		return "quiz/view02";
	}
	
	// 3. DTO 이용
	@RequestMapping("v03")
	public String c(Board board, Model model) {
		board.setDate(new Date());
		model.addAttribute("board", board);
		
		return "quiz/view03";
	}
	
	// 4. @ModelAttribute 이용
	@RequestMapping("v04")
	public String d(@ModelAttribute("title") String title,
					@ModelAttribute("hit") int hit,
					Model model) {
		model.addAttribute("date", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		
		return "quiz/view04";
	}
	
	
}


