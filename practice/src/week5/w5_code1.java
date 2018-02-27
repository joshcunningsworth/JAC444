package week5;

import java.util.Scanner;
import java.util.Arrays;

public class w5_code1 {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int arraySize = 0;
		int maxNum = 0;
		
		System.out.print("How long do you want your array to be? ");
		arraySize = input.nextInt();
		
		System.out.print("What is the largest number possible? ");
		maxNum = input.nextInt();
		
		input.close();
		
		int[] myArray = new int[arraySize];
		
		//populating the array with random numbers lim
		for(int count = 0; count < arraySize; count++){
			myArray[count] = (int) (Math.random() * (maxNum + 1));	
		}
		
		//printing out the randomly generated array values
		for(int count = 0; count < arraySize; count++){
			System.out.print(myArray[count] + " ");	
		}
		
		//sorts the array numerically
		Arrays.sort(myArray);
		System.out.println("\n********************");
		
		//printing out the newly sorted array
		for(int count = 0; count < arraySize; count++){
			System.out.print(myArray[count] + " ");	
		}
	}
}
