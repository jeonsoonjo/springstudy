package ex03_xml;

import java.util.List;

public class ListBean {

	// property
	private List<String> list;
	
	// constructor
	
	// method
	public void info() {
		for(int i=0, length=list.size(); i<length; i++) {
			System.out.println((i + 1) + "번째 요소: " + list.get(i));
		}
	}

	// getter, setter
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	
}


