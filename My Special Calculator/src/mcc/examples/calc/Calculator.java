package mcc.examples.calc;

import java.util.Scanner;

public class Calculator {
	static double lastResult = 0; // Memory feature to store the latest result

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Enter first number (or type 'M' to use last result): ");
			String input = scanner.next();
			double num1 = input.equalsIgnoreCase("M") ? lastResult : Double.parseDouble(input);
			System.out.print("Enter operator (+, -, *, /): ");
			char operator = scanner.next().charAt(0);
			System.out.print("Enter second number: ");
			double num2 = scanner.nextDouble();
			switch (operator) {
			case '+':
				lastResult = num1 + num2;
				break;
			case '-':
				lastResult = num1 - num2;
				break;
			case '*':
				lastResult = num1 * num2;
				break;
			case '/':
				lastResult = num2 != 0 ? num1 / num2 : 0;
				break;
			default:
				System.out.println("Invalid operator.");
				continue;
			}
			System.out.println("Result: " + lastResult);
		}
	}
}