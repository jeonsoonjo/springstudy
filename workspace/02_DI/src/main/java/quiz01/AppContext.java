package quiz01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContext {

	@Bean
	public Calculator calculator() {
		return new Calculator();
	}
	// <bean id="calculator" class="Calculator"> 생성
	// xml 파일 없이 여기서 bean 생성을 하면 된다
	
	@Bean
	public EngineerCalculator engineerCalculator() {
		return new EngineerCalculator();
	}
	
}


