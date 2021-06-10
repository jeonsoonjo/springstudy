package ex01_inject;

import javax.inject.Inject;

/*
	@Inject
	1. 객체의 타입(<bean class="">)이 일치하는 객체를 자동으로 주입한다
	2. 필드, 생성자, setter를 대상으로 한다

*/

public class SelectListCommand {
	
		// 1. 필드를 이용해서 주입 방법
		/*	
		   	@Inject // dao를 가져다 사용하고 싶으면 @Inject 애너테이션을 추가한다
			private Dao dao;
		*/
		
		
		// 2. 생성자를 이용해서 주입 방법
		/*
			private Dao dao;
			
			@Inject
			public SelectListCommand(Dao dao) { // 매개변수 Dao dao에 주입된다
				this.dao = dao;
			}
		*/
	
	
		// 3. setter를 이용해서 주입 방법(추천)
		// 매개변수는 여러개 줄 수 있으니 필드에 일일이 inject 하는 것보다 깔끔하다
		/*
			private Dao dao;
			
			@Inject
			public void setDao(Dao dao) { // 매개변수 Dao dao에 주입된다(생성자와 같다)
				this.dao = dao;
			}
		*/
		
	
		// 실전
	
		// field
		private Dao dao;
		
		// setter
		@Inject
		public void setDao(Dao dao) {
			this.dao = dao;
		}
		
		// method
		public void execute() {
			dao.selectList(); // dao가 자동으로 주입되지 않았다면 NullPointerException 발생
		}
		
}


