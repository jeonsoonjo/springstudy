package quiz02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContext {

	@Bean
	public Speaker speaker() { // TV.class에 @Autowired한 Speaker타입이 Bean의 Speaker와 일치해야 한다
		return new Speaker();
	}
	
	@Bean
	public TV tv() {
		return new TV();
	}
	
}


