package ex02_resource;

import javax.annotation.Resource;

/*
	@Resource
	1. 객체의 이름(id)이 일치하는 객체를 자동으로 주입한다
	2. 필드, setter를 대상으로 한다(생성자는 안 됨)

*/

public class SelectListCommand {

	// 1. 필드를 이용한 주입 방법
	/*
		@Resource
		private Dao boardDao; // app-context2.xml에 bean id와 일치해야 자동으로 주입된다
	*/	
	
	// 2. setter를 이용한 주입 방법
	/*
		private Dao boardDao;
		
		@Resource
		public void setBoardDao(Dao boardDao) {
			this.boardDao = boardDao;
		}
	*/

	
	// field
	private Dao boardDao;
	
	// setter
	@Resource
	public void setBoardDao(Dao boardDao) { // setter를 이용한 주입 방법 추천
		this.boardDao = boardDao;
	}
	
	// getter
	public Dao getBoardDao() {
		return boardDao;
	}
	
	// method
	public void execute() {
		boardDao.selectList();
	}
	
}


