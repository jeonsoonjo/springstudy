package quiz05;

public class HoneyMoon {

	// field
	private String city;
	private Person husband;
	private Person wife;
	
	// constructor
	public HoneyMoon() {}
	public HoneyMoon(String city, Person husband, Person wife) {
		super();
		this.city = city;
		this.husband = husband;
		this.wife = wife;
	}
	
	// method
	public void info() {
		System.out.println("신혼여행지: " + city);
		System.out.println("신랑명: " + husband.getName() + "(" + husband.getGender() + ")");
		System.out.println("신부명: " + wife.getName() + "(" + wife.getGender() + ")");
	}
	
	// getter, setter
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Person getHusband() {
		return husband;
	}
	public void setHusband(Person husband) {
		this.husband = husband;
	}
	public Person getWife() {
		return wife;
	}
	public void setWife(Person wife) {
		this.wife = wife;
	}
	
}


