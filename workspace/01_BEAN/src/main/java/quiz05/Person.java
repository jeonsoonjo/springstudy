package quiz05;

public class Person {

	// field
	private String name;
	private String gender;

	// constructor
	public Person() {}
	public Person(String name, String gender) {
		super();
		this.name = name;
		this.gender = gender;
	}
	
	// getter, setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
}


