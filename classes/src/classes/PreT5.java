package classes;

public class PreT5 {
	
	public int i = 10;
	
	public class Inner {
		public int j = 20;
	}

	public static void main(String[] args) {
		PreT5.Inner ref = new PreT5().new Inner();
		System.out.print(ref.j);
	}
}