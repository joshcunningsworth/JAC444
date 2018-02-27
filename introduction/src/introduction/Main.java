package introduction;

public class Main{
	 public static void main(String []args){
			boolean omg = false;
			int[] lol = {1, 2, 1, 1, 8};
			omg = isOscilant(lol);
			
			System.out.println(omg);
     }

	

	
	
	public static boolean isOscilant(int[] arr) {
		if (arr.length < 2) 
			return true;
					
		if (arr[0] == arr[1])
			return false;

		for (int i = 1; i < arr.length - 1; i++) 
			if (!((arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) 
					|| (arr[i - 1] > arr[i] && arr[i] < arr[i + 1]))) 
				return false;

		return true;
		}  
}
