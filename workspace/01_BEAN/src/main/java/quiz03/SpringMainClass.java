package quiz03;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringMainClass {

	public static void main(String[] args) {
		
		String resourceLocations = "quiz03.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(resourceLocations);
		
		Student student = ctx.getBean("student", Student.class);
		student.info();
		
		ctx.close();

	}

}


