package ex04_xml;

public class BMICalculator {

	// property
	private double normal; // 정상(20 <= normal < 25), normal 이하는 저체중
	private double over; // 과체중(25 <= over < 30)
	private double obesity; // 비만(30 <= obesity)
	private Calculator calculator;
	
	// constructor
	public BMICalculator() {}
	public BMICalculator(double normal, double over, double obesity, Calculator calculator) {
		super();
		this.normal = normal;
		this.over = over;
		this.obesity = obesity;
		this.calculator = calculator;
	}
	
	// method
	public void info(double height, double weight) {
		// 체질량지수(bmi) = 몸무게(kg) / 키(m)제곱
		height = calculator.divide(height, 100);
		double bmi = calculator.divide(weight, calculator.multiply(height, height));
		String health = null;
		if(bmi >= obesity) {
			health = "비만";
		} else if(bmi >= over) {
			health = "과체중";
		} else if(bmi >= normal) {
			health = "정상";
		} else {
			health = "저체중";
		}
		System.out.println("체질량지수: " + bmi + "(" + health + ")");
	}
	
	// getter, setter
	public double getNormal() {
		return normal;
	}
	public void setNormal(double normal) {
		this.normal = normal;
	}
	public double getOver() {
		return over;
	}
	public void setOver(double over) {
		this.over = over;
	}
	public double getObesity() {
		return obesity;
	}
	public void setObesity(double obesity) {
		this.obesity = obesity;
	}
	public Calculator getCalculator() {
		return calculator;
	}
	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}
	
}


