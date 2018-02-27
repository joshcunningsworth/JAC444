/*
 * This application allows you to input five numbers, each between 10 and 100, inclusive.
 * As each number is read, it display only unique numbers.
 * 
 * One bug is that it only error checks once so if the user enters an invalid number
 * twice in a row it will accept the second invalid number. This could be fixed with a loop.
 */

package question2;

import java.util.Scanner;

public class duplicate{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		int num[] = {0,0,0,0,0};
		
		//for loop to accept the values
		for(int i = 0; i < 5; i++){
			System.out.println("Enter a number between 10 and 100: ");
			num[i] = input.nextInt();
			//error checking to see if the number is between 10 and 100
			if(num[i] < 10 || num[i] > 100){
				System.out.println("Incorrect value, please enter a number between 10 and 100: ");
				//input to overwrite if the value is incorrect
				num[i] = input.nextInt();
			}
		}
		
		System.out.println("\nUnique Values: ");
		System.out.println(num[0]);
		
		
		//if statements comparing if the numbers are unique or not
		if(num[1] != num[0] && num[1] != num[2] && num[1] != num[3] && num[1] != num[4]){
			System.out.println(num[1]);
		}
		
		if(num[2] != num[0] && num[2] != num[3] && num[2] != num[4]){
			System.out.println(num[2]);
		}
		
		if(num[3] != num[0] && num[3] != num[4]){
			System.out.println(num[3]);
		}
		
		if(num[4] != num[0]){
			System.out.println(num[4]);
		}
		
		input.close();
	
	}
}
