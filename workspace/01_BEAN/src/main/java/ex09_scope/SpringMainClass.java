package ex09_scope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringMainClass {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("app-context9.xml");
		
		Person p1 = ctx.getBean("person1", Person.class);
		Person p2 = ctx.getBean("person1", Person.class);
		
		System.out.println(p1 == p2); // false
		// xml에서 scope="prototype"으로 해주었기 때문에 주소를 다르게 인식하여 false를 출력한다
		
		ctx.close();
		
		
		AbstractApplicationContext ctx2 = new AnnotationConfigApplicationContext(AppContext.class);
		
		Person p3 = ctx2.getBean("person2", Person.class);
		Person p4 = ctx2.getBean("person2", Person.class);
		
		System.out.println(p3 == p4); // true, false
		// java에서 생성한 Bean은 기본적으로 singleton으로 처리되기 때문에 같은 주소로 인식한다 : true
		// 그래서 AppContext.java에 @scope(value="prototype") 애너테이션을 추가하면 p1==p2 처럼 다르게 인식한다 : false
		// 자주 사용할 일은 없지만, 같은 주소에 다른 값을 생성하고 싶을 때  scope=prototype을 사용하면 된다
		
		ctx2.close();

	}

}


