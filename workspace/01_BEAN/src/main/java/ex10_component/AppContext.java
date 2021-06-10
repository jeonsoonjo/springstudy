package ex10_component;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="ex10_component")
// @ComponentScan(basePackages= {"ex10_component", "", "", ...}) 여러 패키지를 등록할 경우, 배열로 지정된다
public class AppContext {

	
	
}


