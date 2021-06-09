package quiz03;

import java.util.List;

public class Exam {

	// property
	private List<Integer> scores; // 5개의 점수
	private double average; // 평균
	private char grade; // A~F 학점
	
	// constructor
	
	
	// method
	public void info() {
		setAverage();
		setGrade();
		System.out.println("scores: " + scores.toString());
		System.out.println("average: " + average);
		System.out.println("grade: " + grade);
	}
	
	// getter, setter
	public List<Integer> getScores() {
		return scores;
	}
	public void setScores(List<Integer> scores) {
		this.scores = scores;
	}
	public double getAverage() {
		return average;
	}
	public void setAverage(double average) {
		this.average = average;
	}
	public void setAverage() { // 매개변수 없는 타입으로 생성해야 위에 setter(double average)와 다르게 인식한다
		int total = 0;
		for(Integer score : scores) {
			total += score;
		}
		this.average = total / scores.size();
	}
	public char getGrade() {
		return grade;
	}
	public void setGrade(char grade) {
		this.grade = grade;
	}
	public void setGrade() {
		if(average >= 90) grade = 'A';
		else if(average >= 80) grade = 'B';
		else if(average >= 70) grade = 'C';
		else if(average >= 60) grade = 'D';
		else grade = 'F';
	}
	
}


