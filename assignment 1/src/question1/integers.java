/*
 * This application asks the user to enter two integers then obtains them from the user.
 * Then it prints their sum, product, difference and quotient of the two numbers provided.
 */

package question1;

import java.util.Scanner;

public class integers {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//creating the integer variables to store the data
		int num1 = 0, num2 = 0;
		int sum = 0, pro = 0, dif = 0, quo = 0;
		
		//prompting the user what the program will do
		System.out.println("This program will accept two integers and return the sum,\n"
				+ "product, difference, and quotient of the two numbers.\n\n"
				+ "Please enter the first integer: ");
		
		//scans for the integer value that will be stored in num1
		num1 = input.nextInt();
		
		//prompting for the second number
		System.out.println("Please enter the second integer: ");
		
		//scans for the integer value that will be stored in num2
		num2 = input.nextInt();
		
		//closes the scanner
		input.close();
		
		//formulas to calculate the results
		sum = num1 + num2;
		pro = num1 * num2;
		dif = num1 - num2;
		quo = num1 / num2;
		
		//prints the calculated results of the two integers
		System.out.println("The sum is: \t\t" + sum);
		System.out.println("The product is: \t" + pro);
		System.out.println("The difference is: \t" + dif);
		System.out.println("The quotient is: \t" + quo);
	}
}
