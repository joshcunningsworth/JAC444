package midterm_review;

class Shapes {
void draw(){

}
}
class Circle extends Shape{ 

public synchronized void draw(){
System.out.println("draw circle");
}

public synchronized void drawTwo(){
System.out.println("draw circle2");
}

public synchronized void drawThree(){
System.out.println("draw circle3");
}

}

