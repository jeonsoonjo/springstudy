package quiz04;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContext {

	@Bean(name="lecture2")
	public Lecture aaa() {
		return new Lecture("자바", "김자바");
	}
	
	/*	
	    @Bean
		public Lecture lecture2() {
			return new Lecture("", "");
		}
	*/
	
	@Bean(name="student2")
	public Student bbb() {
		return new Student("전순조", aaa());
	}
	
	
}


