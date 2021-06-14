package com.koreait.mvc03.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.koreait.mvc03.dto.Person;

@Configuration
public class BeanConfiguration {

	@Bean
	public Person man() {
		Person m = new Person();
		m.setName("버터");
		m.setAge(15);
		List<String> hobbies = new ArrayList<String>();
		hobbies.add("수영");
		hobbies.add("게임");
		m.setHobbies(hobbies);
		
		return m;
	}
	
	@Bean
	public Person woman() {
		Person w = new Person();
		w.setName("봉봉");
		w.setAge(20);
		List<String> hobbies = new ArrayList<String>();
		hobbies.add("도박");
		hobbies.add("게임");
		w.setHobbies(hobbies);
		
		return w;
	}
	
	
}


