package midterm_review;

public class Shape{
public static void main(String[] args) {

Runnable r1 = new Runnable() {

public void run(){
try{
Circle cOne = new Circle();
cOne.draw();
System.out.println(Thread.currentThread().getName() + " runnable 1");
}catch (Exception ie) {ie.printStackTrace();}
}
};

Runnable r2 = new Runnable() {

public void run(){
try{
Circle cTwo = new Circle();
cTwo.drawTwo();
System.out.println(Thread.currentThread().getName() + " runnable 2");
}catch (Exception ie) {ie.printStackTrace();}
}
};

Runnable r3 = new Runnable() {

public void run(){
try{
Circle cThree = new Circle();
cThree.drawThree();
System.out.println(Thread.currentThread().getName() + " runnable 3");
}catch (Exception ie) {ie.printStackTrace();}
}
};


Thread c1 = new Thread(r1, "Circle 1");
Thread c2 = new Thread(r2, "Circle 2");
Thread c3 = new Thread(r3, "Circle 3");

c1.start();
c2.start();
c3.start();

}
}