package mcc.examples;

import java.util.Scanner;

public class Calculator1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Enter first number: ");
			double num1 = scanner.nextDouble();
			System.out.println("Enter an operator (+, -, *, /): ");
			char operator = scanner.next().charAt(0);
			System.out.println("Enter second number: ");
			double num2 = scanner.nextDouble();
			double result = 0;
			switch (operator) {
			case '+':
				result = num1 + num2;
				break;
			case '-':
				result = num1 - num2;
				break;
			case '*':
				result = num1 * num2;
				break;
			case '/':
				result = num2 != 0 ? num1 / num2 : 0;
				break;
			default:
				System.out.println("Invalid operator");
				continue;
			}
			System.out.println("Result: " + result);
		}
	}
}