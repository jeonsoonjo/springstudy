package quiz01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class SpringMainClass {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
		
		EngineerCalculator e = ctx.getBean("engineerCalculator", EngineerCalculator.class);
		e.add(10, 3);
		e.subtract(11, 8);
		e.multiply(6, 9);
		e.divide(14, 3);
		
		ctx.close();
		
	}

}


