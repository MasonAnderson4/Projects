package Q1;

public class Main {
	public static void main(String[] args) {
		// Create an object of the SimpleCalculator class
		SimpleCalculator calculator = new SimpleCalculator();
		
		
		// Use methods to set number1 and number2
		calculator.setNumber1(4.0);
		calculator.setNumber2(3.0);
		
		
		// Perform all four operations and display the results
		System.out.println("Addition Result: " + calculator.add());
		
		System.out.println("Subtraction Result: " + calculator.subtract());
		
		System.out.println("Multiplication Result: " + calculator.multiply());
		
		double divisionResult = calculator.divide();
		
		if (!Double.isNaN(divisionResult)) {
			System.out.printf("Division Result: %.2f %n", divisionResult);
		}
	}
}
