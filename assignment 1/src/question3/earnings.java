/*
 * This application allows a user to input one salesperson’s items sold for
 * last week and displays the calculation of that salesperson’s earnings.
 * There is no limit to the number of items that can be sold by a salesperson.
 */

package question3;

import java.util.Scanner;

public class earnings {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		//creating variables for each product and the totals
		double prod1 = 239.99, prod2 = 129.75, prod3 = 99.95, prod4 = 350.89;
		double earnings = 200, totalsales;
		
		//prompting user for the numbers and storing them in their product variable
		System.out.println("Enter number sold of product #1");
		prod1 = input.nextInt() * prod1;
		
		System.out.println("Enter number sold of product #2");
		prod2 = input.nextInt() * prod2;
		
		System.out.println("Enter number sold of product #3");
		prod3 = input.nextInt() * prod3;
		
		System.out.println("Enter number sold of product #4");
		prod4 = input.nextInt() * prod4;
		
		//calculating the total cost of items sold
		totalsales = prod1 + prod2 + prod3 + prod4;
		
		//calculating the earnings for the week
		earnings = earnings + (totalsales * 0.09); 
		
		//displaying the salesperson's earnings
		System.out.printf("The total earnings for this week is: %.2f", earnings);
		
		input.close();
	}
}
