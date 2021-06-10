package quiz04;

public class Student {

	// field
	private String name;
	private Lecture lecture;
	
	// constructor
	public Student() {}
	public Student(String name, Lecture lecture) {
		super();
		this.name = name;
		this.lecture = lecture;
	}
	
	// method
	public void info() {
		System.out.println("학생 이름: " + name);
		System.out.println("강의명: " + lecture.getName());
		System.out.println("교수: " + lecture.getProfessor());
	}
	
	// getter, setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Lecture getLecture() {
		return lecture;
	}
	public void setLecture(Lecture lecture) {
		this.lecture = lecture;
	}
	
}


