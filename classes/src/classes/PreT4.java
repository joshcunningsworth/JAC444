package classes;

class A {
	public void m(int i) {
		System.out.println("A: " + i);
	}
	public void m(String s) {
		System.out.println("A: " + s);
	}	
}

public class PreT4 extends A {
	
	public void m(String s) {
		System.out.println("PreT4: " + s);
	}

	public static void main(String[] args) {
		A ref = new PreT4();
		ref.m(10);
		ref.m("10");
	}
}