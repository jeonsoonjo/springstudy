package quiz02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringMainClass {

	public static void main(String[] args) {
		
		String resourceLocations = "quiz02.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(resourceLocations);
		
		MultiplicationTable multiplicationTable = ctx.getBean("gugudan", MultiplicationTable.class);
		multiplicationTable.info();
		
		ctx.close();

	}

}


