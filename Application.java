package com.Gerardo.GdL.calculator;
import java.util.Scanner;
/**
 * @author Gerardo GarciadeLeon <a
 * 	href="mailto:gerardo.garciadeleon@ucalgary.ca"> gerardo.garciadeleon@ucalgary.ca</a>
 * 
 * @version 1.0
 * 
 * @since 1.0
 * 
 */

/*
 * This is a program which creates a simple CLI calculator 
 */

public class Application {
	
	/**
	 * This creates a simple CLI calculator
	 * @param args Optional command-line argument, defines the operation to be performed
	 */

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		boolean flag = false; //Initialize a flag with the assumption that an argument was provided during compilation
		String operation = "";
		if (args.length == 0) {
			flag = true; //If there was no arguments provided, set to true so program asks for input when entering loop
		}
		while (true) { //Continue the loop until the user prompts an exit
			if (flag) { //If input is necessary
				System.out.println("\nEnter operation (add, subtract, multiply, divide, pow, sqrt, log, log10, sin, cos, tan, factorial) or 'exit' to quit:");
				operation = scn.nextLine();
	        
				if (operation.equalsIgnoreCase("exit")) { //If user entered exit, terminate program
					System.out.println("Exiting calculator...");
	            	break;
				}
			} else { //Input was given at compilation
				if (args.length > 1) { //Checking if more than one operation was entered
					System.out.println("Error, you entered multiple operations");
					scn.close();
					System.exit(1); //Exit the program
				}
				operation = args[0];
			}
			
			flag = true; //Ensures that the next iteration of the loop will ask for input

	        // For operations requiring two inputs
	        if (!operation.equalsIgnoreCase("sqrt") && !operation.equalsIgnoreCase("log") && !operation.equalsIgnoreCase("log10") && !operation.equalsIgnoreCase("sin") && !operation.equalsIgnoreCase("cos") && !operation.equalsIgnoreCase("tan") && !operation.equalsIgnoreCase("factorial")) {
	            System.out.print("Enter first number: ");
	            double num1 = scn.nextDouble();
	            scn.nextLine(); //This ensures that the newline character is consumed and does not interrupt the flow of consequent entries, this is repeated after each entry from the user
	            System.out.print("Enter second number: ");
	            double num2 = scn.nextDouble();
	            scn.nextLine();
	            

	            switch (operation.toLowerCase()) {
	                case "add":
	                    System.out.println("Result: " + add(num1, num2));
	                    break;
	                case "subtract":
	                    System.out.println("Result: " + subtract(num1, num2));
	                    break;
	                case "multiply":
	                    System.out.println("Result: " + multiply(num1, num2));
	                    break;
	                case "divide":
	                    System.out.println("Result: " + divide(num1, num2));
	                    break;
	                case "pow":
	                    System.out.println("Result: " + power(num1, num2));
	                    break;
	                default:
	                    System.out.println("Invalid operation.");
	                    break;
	            }
	        } else {
	            // For operations requiring one input
	            System.out.print("Enter number: ");
	            double num = scn.nextDouble();
	            scn.nextLine();

	            switch (operation.toLowerCase()) {
	                case "sqrt":
	                    System.out.println("Result: " + sqrt(num));
	                    break;
	                case "log":
	                    System.out.println("Result: " + log(num));
	                    break;
	                case "log10":
	                    System.out.println("Result: " + log10(num));
	                    break;
	                case "sin":
	                    System.out.println("Result: " + sin(num));
	                    break;
	                case "cos":
	                    System.out.println("Result: " + cos(num));
	                    break;
	                case "tan":
	                    System.out.println("Result: " + tan(num));
	                    break;
	                case "factorial":
	                    // Factorial is a special case requiring an integer
	                    System.out.println("Result: " + factorial((int)num));
	                    break;
	                default:
	                    System.out.println("Invalid operation.");
	                    break;
	            }
	        }
	    }
	    
	    scn.close();
	}
	
	public static double add(double a, double b) {
		/**
		 * This performs the addition of two numbers
		 * @param a Mandatory First number
		 * @param b Mandatory Second number
		 * @return The sum of a and b
		 * 
		 */
		return a + b;
	}
	
	//Factorial calculation with progress display
	//This function only checks for a negative input
	public static long factorial(int num) {
		/**
		 * This checks for a negative input before progressing to perform factorial
		 * @param num Mandatory Number to perform factorial
		 * @return The function call of factorialHelper to perform the factorial calculation
		 */
	    if (num < 0) {
	        System.out.println("Factorial of negative number is undefined.");
	        return 0;
	    }
	    return factorialHelper(num, num);
	}

	//This function is the one performing the calculations
	private static long factorialHelper(int originalNum, int num) {
		/**
		 * This performs the factorial of a number
		 * @param originalNum Mandatory Number to keep track of progress during factorial calculation
		 * @param num Mandatory Number to perform factorial
		 * @return The factorial of num entered
		 */
	    if (num <= 1) { //Originally, the progress bar does not cover 1 as it does not go through the recursive path which includes the code for it
	        //Solution to add progress bar:
	    	int progress = 100;
	    	System.out.print("\rCalculating factorial: " + progress + "%");
	    	return 1;
	    }
	    // Calculate progress and update progress bar
	    int progress = (int) (((originalNum - num) / (double) originalNum) * 100);
	    System.out.print("\rCalculating factorial: " + progress + "%");
	    return num * factorialHelper(originalNum, num - 1);
	}
	
	//Subtraction
	public static double subtract(double a, double b) {
		/**
		 * This performs the subtraction of two numbers
		 * @param a Mandatory First number
		 * @param b Mandatory Second number
		 * @return The subtraction of b from a
		 */
		return a - b;
	}
	
	//Multiplication
	public static double multiply(double a, double b) {
		/**
		 * This performs the multiplication of two numbers
		 * @param a Mandatory First number
		 * @param b Mandatory Second number
		 * @return The multiplication of a with b
		 */
		return a * b;
	}
	
	//Division
	public static double divide(double a, double b) {
		/**
		 * This performs the division of two numbers
		 * @param a Mandatory First number
		 * @param b Mandatory Second number
		 * @return The division of a by b
		 */
		
		if (b == 0) {
			System.out.println("Division by zero is undefined");
			return 0;
		}
		return a / b;
	}
	
	// Exponentiation
	public static double power(double base, double exponent) {
		/**
		 * This performs the exponential of two numbers using the java Math class
		 * @param base Mandatory Base number
		 * @param exponent Mandatory Exponent number
		 * @return The value of base^exponent
		 */
	    return Math.pow(base, exponent);
	}

	// Square root
	public static double sqrt(double number) {
		/**
		 * This performs the square root of a number using the java Math class
		 * @param number Mandatory Number to square root
		 * @return The square root of number
		 */
	    return Math.sqrt(number);
	}

	// Natural logarithm
	public static double log(double number) {
		/**
		 * This performs the natural log of a number using the java Math class
		 * @param number Mandatory Number to find natural log
		 * @return The natural log of number
		 */
	    return Math.log(number);
	}

	// Base-10 logarithm
	public static double log10(double number) {
		/**
		 * This performs the log (base 10) of a number using the java Math class
		 * @param number Mandatory Number to find log
		 * @return The base 10 log of number
		 */
	    return Math.log10(number);
	}

	// Sine function
	public static double sin(double angleDegrees) {
		/**
		 * This performs the sin of a number in degrees, transforming it to radians using the java Math class
		 * @param angleRadians Mandatory Angle in degrees
		 * @return Sine value of angleRadians in radians
		 */
		double angleRadians = Math.toRadians(angleDegrees); //Transforms angle from degrees to radians
	    return Math.sin(angleRadians);
	}

	// Cosine function
	public static double cos(double angleDegrees) {
		/**
		 * This performs the cos of a number in degrees, transforming it to radians using the java Math class
		 * @param angleRadians Mandatory Angle in degrees
		 * @return Cosine value of angleRadians in radians
		 */
		double angleRadians = Math.toRadians(angleDegrees); //Transforms angle from degrees to radians
	    return Math.cos(angleRadians);
	}

	// Tangent function
	public static double tan(double angleDegrees) {
		/**
		 * This performs the tan of a number in degrees, transforming it to radians using the java Math class
		 * @param angleRadians Mandatory Angle in degrees
		 * @return Tangent value of angleRadians in radians
		 */
		double angleRadians = Math.toRadians(angleDegrees); //Transforms angle from degrees to radians 
	    return Math.tan(angleRadians);
	}
	
}