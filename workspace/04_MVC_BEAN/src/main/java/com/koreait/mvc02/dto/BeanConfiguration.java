package com.koreait.mvc02.dto;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// @Configuration 애너테이션 사용을 위해서 CGLIB 디펜던시를 추가해야 한다

@Configuration
public class BeanConfiguration {

	@Bean
	public Contact contact3() {
		return new Contact("010-4444-5555", "경기도 덕양구 삼송동");
	}
	
	@Bean
	public Member member3() {
		return new Member("bongbong", contact3());
	}
	
}


