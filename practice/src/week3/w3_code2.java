package week3;

import java.util.Scanner;

public class w3_code2 {
	public static void main(String[] args) {
		//initializing three integers with no values
		int num1, num2, answer;
		
		//new instance of the scanner class called input
		Scanner input = new Scanner(System.in);
		
		//prompting the user to enter an interger value
		System.out.print("Please enter an integer: ");
		
		//reads in the next integer value the user enters, separated by whitespace
		num1 = input.nextInt();
		
		System.out.print("Please enter another integer: ");
		num2 = input.nextInt();
		
		//calculating the sum of num1 plus num2
		answer = num1 + num2;
		
		//outputting the formatted solution to the user
		System.out.println("The sum of " + num1 + " plus " + num2 + " is: " + answer);
	}
}
