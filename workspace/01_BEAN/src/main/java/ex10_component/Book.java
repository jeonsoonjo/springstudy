package ex10_component;

import org.springframework.stereotype.Component;

@Component("bk") // 자동으로 book이 생성되었지만, 직접 "bk"라는 id를 잡아줌으로써 변경되었다
public class Book {
	
	// field
	
	// constructor
	
	// method
	public void info() {
		System.out.println("나는 책이다.");
	}
	
}


