package ex03_xml;

import java.util.Set;

public class SetBean {

	// property
	private Set<String> set; // set은 순서가 없는 list이다
	
	// constructor
	
	// method
	public void info() {
		/*
			Iterator<String> itr = set.iterator();
			while(itr.hasNext()) { // hasNext는 있는지 확인
				System.out.println(itr.next()); // next가 실제로 값을 가져온다
			}
		*/
		for(String s : set) {
			System.out.println(s);
		}
	}

	// getter, setter
	public Set<String> getSet() {
		return set;
	}
	public void setSet(Set<String> set) {
		this.set = set;
	}
	
}


