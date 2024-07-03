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
		if (args.length > 0) {
			if (args.length > 1) {
				System.out.println("Error, you entered multiple operations");
				scn.close();
				System.exit(1); //Exit the program if multiple operations are entered
			}
			
			String operation = args[0];
			
			switch (operation.toLowerCase()) { //Handles each case of possible valid input of operations
		    case "add":
		        System.out.println("Enter the first operand: ");
		        double num1 = scn.nextDouble();
		        System.out.println("Enter the second operand: ");
		        double num2 = scn.nextDouble();
		        System.out.println("Result: " + add(num1, num2));
		        break;
		    case "factorial":
		        System.out.println("Enter a number:");
		        double number = scn.nextDouble();
		        System.out.println("Result: " + factorial(number));
		        break;
		    case "subtract":
		    	System.out.println("Enter the first operand: ");
		    	double num3 = scn.nextDouble();
		    	System.out.println("Enter the second operand: ");
		    	double num4 = scn.nextDouble();
		    	System.out.println("Result: " + sub(num3, num4));
		    	break;
		    case "multiply":
		    	System.out.println("Enter the first operand: ");
		    	double num5 = scn.nextDouble();
		    	System.out.println("Enter the second operand: ");
		    	double num6 = scn.nextDouble();
		    	System.out.println("Result: " + mul(num5, num6));
		    	break;
		    case "divide":
		    	System.out.println("Enter the first operand: ");
		    	double num7 = scn.nextDouble();
		    	System.out.println("Enter the second operand: ");
		    	double num8 = scn.nextDouble();
		    	System.out.println("Result: " + div(num7, num8));
		    	break;
		    default: //No input matched any possible operation
		    	System.out.println("Invalid operation entered");
		    	scn.close();
		    	System.exit(1); //Exit the program if invalid input
		}
			
		} else {
			//No CLI inputs entered, ask for user input of operation
			System.out.println("Enter operation (e.g. add, subtract, multiply, divide): ");
			String operation = scn.nextLine();
			
			switch (operation.toLowerCase()) { //Handles each case of possible valid input of operations
		    case "add":
		        System.out.println("Enter the first operand: ");
		        double num1 = scn.nextDouble();
		        System.out.println("Enter the second operand: ");
		        double num2 = scn.nextDouble();
		        System.out.println("Result: " + add(num1, num2));
		        break;
		    case "factorial":
		        System.out.println("Enter a number:");
		        double number = scn.nextDouble();
		        System.out.println("Result: " + factorial(number));
		        break;
		    case "subtract":
		    	System.out.println("Enter the first operand: ");
		    	double num3 = scn.nextDouble();
		    	System.out.println("Enter the second operand: ");
		    	double num4 = scn.nextDouble();
		    	System.out.println("Result: " + sub(num3, num4));
		    	break;
		    case "multiply":
		    	System.out.println("Enter the first operand: ");
		    	double num5 = scn.nextDouble();
		    	System.out.println("Enter the second operand: ");
		    	double num6 = scn.nextDouble();
		    	System.out.println("Result: " + mul(num5, num6));
		    	break;
		    case "divide":
		    	System.out.println("Enter the first operand: ");
		    	double num7 = scn.nextDouble();
		    	System.out.println("Enter the second operand: ");
		    	double num8 = scn.nextDouble();
		    	System.out.println("Result: " + div(num7, num8));
		    	break;
		    default: //No input matched any possible operation
		    	System.out.println("Invalid operation entered");
		    	scn.close();
		    	System.exit(1);
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
	
	public static double factorial(double n) {
		
		/**
		 * This performs the factorial of a number
		 * @param n Mandatory Number to perform factorial
		 * @return The factorial of the number entered
		 */
	    if (n <= 1) {
	        return 1;
	    } else {
	        return n * factorial(n - 1);
	    }
	}
	
	public static double sub(double a, double b) {
		/**
		 * This performs the subtraction of two numbers
		 * @param a Mandatory First number
		 * @param b Mandatory Second number
		 * @return The subtraction of b from a
		 */
		return a - b;
	}
	
	public static double mul(double a, double b) {
		/**
		 * This performs the multiplication of two numbers
		 * @param a Mandatory First number
		 * @param b Mandatory Second number
		 * @return The multiplication of a with b
		 */
		return a * b;
	}
	
	public static double div(double a, double b) {
		/**
		 * This performs the division of two numbers
		 * @param a Mandatory First number
		 * @param b Mandatory Second number
		 * @return The division of a by b
		 */
		return a / b;
	}
	
	
	
}