/*
 * This application evaluates the factorials of the integers from 1 to 5.
 * Display the results in tabular format.
 */

package question4;

public class factorials {
	public static void main(String[] args){
		System.out.println("n\tn!");
		
		for(int i=1; i != 6; i++){ 
			System.out.println(i+"\t"+findfactorial(i));
		}
	}
	
	public static int findfactorial(int num){
		if(num <= 1) return 1;
		  else
		   return num * (findfactorial(num -1));
		 }
}
