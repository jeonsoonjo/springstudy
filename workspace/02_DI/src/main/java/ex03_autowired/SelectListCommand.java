package ex03_autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/*
	@Autowired (=@Inject)
	1. 객체의 타입(<bean class="">)이 일치하는 객체를 자동으로 주입한다
	2. 필드, 생성자, setter를 대상으로 한다
	3. 디펜던시 추가가 없어도 자동으로 된다(Inject와 다른점)
	
*/

public class SelectListCommand {

	// 1. 필드를 이용한 주입 방법
	/*
		@Autowired
		private Dao dao;
	*/

	// 2. 생성자를 이용한 주입 방법
	/*
		private Dao dao;
		
		@Autowired
		public SelectListCommand(Dao dao) {
			super();
			this.dao = dao;
		}
	*/
	
	// 3. setter를 이용한 주입 방법
	/*
		private Dao dao;
	
		@Autowired
		public void setDao(Dao dao) {
			this.dao = dao;
		}
	*/
	
	// field
	private Dao dao;
	
	// constructor
	public SelectListCommand() {}
	public SelectListCommand(Dao dao) {
		super();
		this.dao = dao;
	}
	
	// getter, setter
	public Dao getDao() {
		return dao;
	}
	@Autowired
	@Qualifier("boardDao1") // 구분하기 위해
	public void setDao(Dao dao) {
		this.dao = dao;
	}
	
	// method
	public void execute() {
		dao.selectList();
	}
	
}


