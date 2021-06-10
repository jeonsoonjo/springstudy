package ex10_component;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringMainClass {

	public static void main(String[] args) {
		
		// xml에서 component로 작업
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("app-context10.xml");
		
		Person p = ctx.getBean("person", Person.class);
		Book b = ctx.getBean("bk", Book.class);
		
		p.info();
		b.info();
		
		ctx.close();
		
		
		// java에서 componentscan으로 작업
		AbstractApplicationContext ctx2 = new AnnotationConfigApplicationContext(AppContext.class);
		
		Person p2 = ctx2.getBean("person", Person.class);
		Book b2 = ctx2.getBean("bk", Book.class);
		Computer com1 = ctx2.getBean("com", Computer.class);
		Computer com2 = ctx2.getBean("com", Computer.class);
		
		p2.info();
		b2.info();
		com1.info();
		
		System.out.println(com1 == com2); // false
		// scope로 prototype을 지정해줬기 때문
		
		ctx2.close();
		

	}

}


