package quiz05;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@ImportResource("quiz05.xml")
@Configuration
public class AppContext {

	@Bean
	public Person husband1() {
		return new Person("이신랑", "남");
	}
	
	@Bean
	public Person wife1() {
		return new Person("이신부", "여");
	}
	
	@Bean
	public HoneyMoon honeyMoon1() {
		return new HoneyMoon("발리", husband1(), wife1());
	}
	
}


