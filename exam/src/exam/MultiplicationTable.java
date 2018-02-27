package exam;

import java.util.Scanner;

public class MultiplicationTable {
	
	static int max;
	
	public static void main(String[] args) {
		userPrompt(); 
		setupTopRow(max); 
		printInfo(max); 
	}  


	public static void userPrompt(){  
		System.out.print("What is the largest number in the multiplication Table? ");  
		Scanner input = new Scanner(System.in); 
		max = input.nextInt(); 
		input.close(); 
	}


	public static void setupTopRow(int answer){
		for(int i = 1; i < max+1;i++){ 
			System.out.print("\t"+i); 
		} 
		
		System.out.print("\n");
		
		for(int x = 0; x <= 10*max;x++){
			System.out.print("-"); 
		} 
		
		System.out.print("\n");
	}


	public static int calculateNumber(int x, int y){ 
		return x * y; 
	}


	public static void printInfo(int maxNumber){  
		for(int y = 1; y <= max;y++){ 
			for(int x = 0; x <= max;x++){ 
				if(x == 0){ 
					System.out.print(calculateNumber(1,y)+"\t"); 
				}
				else{ 
					System.out.print(calculateNumber(x,y)+"\t"); 
				} 
			} 
			System.out.print("\n"); 
		}  
	}
}