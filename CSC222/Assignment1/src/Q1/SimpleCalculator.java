package Q1;

public class SimpleCalculator {
	
	double number1;
	double number2;
	
	void setNumber1(double number1) {
		this.number1 = number1;
	}
	
	void setNumber2(double number2) {
		this.number2 = number2;
	}
	
	double add() {
		return number1 + number2;	
	}
	
	double subtract() {
		return number1 - number2;	
	}
	
	double multiply() {
		return number1 * number2;	
	}
	
	double divide() {
		if (number2 == 0) {
			System.out.println("Division by zero not allowed.");
			return Double.NaN;
		}
		else {
			return number1 / number2;
		}	
	}
}

