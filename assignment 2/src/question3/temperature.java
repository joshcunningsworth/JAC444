/*
 * This is a simple program that converts from Fahrenheit to Celsius.
 * The Fahrenheit temperature should be entered from the keyboard (via a JTextField).
 * A JLabel should be used to display the converted temperature.
 */

package question3;

import javax.swing.JOptionPane;

public class temperature {
	public static void main(String[] args){
		
		double fahrenheit = 0.00;
		double celsius = 0.00;
		
		//prompting the user to input a number
		fahrenheit = Double.parseDouble(
				JOptionPane.showInputDialog("Please Enter the Temperature in Farenheit"));
		
		//printing out the temperature they entered
		System.out.println(fahrenheit);
		
		//converting the the temperature and printing it out
		celsius = (fahrenheit - 32) * (0.555555);
		System.out.printf("The Conversion to Celcius is: %.2f", celsius);
		
	}
}
