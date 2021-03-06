package ex05_java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 *	@Configuration
	: 안녕. 나는 bean(객체)을 만들어 주는 java 클래스야
 * 
*/

@Configuration
public class AppContext {

	// Bean을 만드는 메소드를 하나씩 만든다
	// 메소드 당 -> Bean 생성
	
	@Bean // 나는 Bean을 만드는 메소드이다
	// 반환타입 : Song -> <bean class="Song">
	// 메소드명 : song -> <bean id="song">
	public Song song() {
		Song s = new Song();
		s.setTitle("hello"); // <property name="title">
		s.setGenre("balad"); // <property name="genre">
		return s;
	}
	
	@Bean(name="singer") // 애너테이션에 아이디(메소드명)를 직접 지정해 주는 방식
	// 메소드명 : singer -> <bean id="singer">
	// 반환타입 : Singer -> <bean class="Singer">
	public Singer aaa() { // 위에서 지정해 두었기 때문에 여기서의 메소드명(aaa)은 중요하지 않다
		return new Singer("adele", song()); // <constructor-arg>
	}
	
}


