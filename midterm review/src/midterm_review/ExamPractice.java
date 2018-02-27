package midterm_review;

public class ExamPractice {
	private double i;
	public ExamPractice(double i) {
		
		this.t();
		this.i = i;  
    }

	public ExamPractice() {
		this(1);
		System.out.println("Default constructor");

    }

	public void t() {
		System.out.println("Invoking t");
	}
}