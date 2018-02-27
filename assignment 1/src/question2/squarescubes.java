/*
 * This program will calculate the squares and cubed values from 0 to 10
 * and display them to the screen.
 */

package question2;

public class squarescubes {
	public static void main(String[] args) {
		
		//variables to store squared and cubed values
		int squares = 0, cubes = 0;
		
		//tabular format
		System.out.println("Squares \tCubes\n---------------------");
		
		//loop that runs until x equals 10
		for(int x = 0; x < 11; x++){
			
			//runs the loop to output the results of the squared and cubed numbers
			for(int count = 0; count < 1; count++){
				System.out.println(squares*squares + "\t\t" + cubes*cubes*cubes);
			}
			
			//incrementing squares and cubes until the loop reaches 10
			squares++;
			cubes++;
		}
	}
}
