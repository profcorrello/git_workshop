package mcc.examples.calc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Calculator {
	static double lastResult = 0;
	static ArrayList<String> calculationLog = new ArrayList<>();
	private static final Logger logger = Logger.getLogger(Calculator.class.getName());
	private static FileHandler fileHandler;

	static {
		try {
			fileHandler = new FileHandler("calculator.log", true);
			fileHandler.setFormatter(new SimpleFormatter());
			logger.addHandler(fileHandler);
			logger.setUseParentHandlers(false);
		} catch (IOException e) {
			System.err.println("Failed to initialize logger: " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Enter first number (or type 'M' to use last result, or 'Q' to quit): ");
			String input = scanner.next();

			if (input.equalsIgnoreCase("Q")) {
				System.out.println("Exiting calculator. Goodbye!");
				logger.info("Calculator exited by user.");
				if (fileHandler != null) {
					fileHandler.close();
				}
				scanner.close();
				break;
			}

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
			logger.info(logEntry);

			System.out.println("Result: " + lastResult);

			System.out.println("\nRecent Calculations:");
			for (String entry : calculationLog) {
				System.out.println(entry);
			}
		}
	}
}
