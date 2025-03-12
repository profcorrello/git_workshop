package mcc.examples;

import java.util.Scanner;

import java.util.ArrayList;
import java.util.Scanner;

public class Calculator3 {
	static double lastResult = 0;
	static ArrayList<String> calculationLog = new ArrayList<>();

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
			String logEntry = num1 + " " + operator + " " + num2 + " = " + lastResult;
			calculationLog.add(logEntry);
			System.out.println("Result: " + lastResult);
			// Display recent calculations
			System.out.println("\nRecent Calculations:");
			for (String entry : calculationLog) {
				System.out.println(entry);
			}
		}
	}
}