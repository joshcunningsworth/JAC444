package introduction;

//The Fibonacci sequence starts as follows: 1, 1, 2, 3, 5, . . .
//The rules for generating the sequence are, where f(k) means
//the k'th Fibonacci number: f(1) = 1, f(2 )= 1, and for any k > 2,
//f(k) = f(k-1) + f(k-2)


/*if(f<=1){
	f++;
}
else if(f==2){
	f=1;
}*/


public class Fibonacci {
	public static void main(String[] args) {
		
		int f = 1;
		int k = 7;
		
		while(f < 13){

		if(f>2){
				f = (k-1) + (k-2);
			}
			System.out.println(k);
		}
	}
}
