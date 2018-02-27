package introduction;

public class PreT4 {

	public static void main(String[] args) {
		String x = "1";
		String y = new String("1");
		//String z = "1";
		
		System.out.println(x);
		System.out.println(y);
		//System.out.println(z);
		
		if(x == y){
			System.out.println("Equal");
		}
		else{
			//why does it print not equal.....?
			System.out.println("Not Equal");
		}
	}

}