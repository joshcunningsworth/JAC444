/*
 * This application prints a diamond shape using asterisks
 */

package question1;

public class diamond{
	public static void main(String[] args) {
		
		//nested for loops to increment the width of the diamond using spaces and asterisks
		for(int count = 1; count < 10; count += 2) {
			for(int x = 0; x < 9 - count / 2; x++){
				System.out.print(" ");
			}
			
			for(int x = 0; x < count; x++){
				System.out.print("*");
			}
			
			System.out.print("\n");
		}
		
		//nested for loops to decrease the width of the diamond
		for(int count = 7; count > 0; count -= 2){
			for(int x = 0; x < 9 - count / 2; x++){
				System.out.print(" ");
			}
			
			for(int x = 0; x < count; x++){
				System.out.print("*");
			}
			
			System.out.print("\n");
		}
	}
}
