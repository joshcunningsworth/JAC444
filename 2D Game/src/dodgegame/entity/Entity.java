package dodgegame.entity;

import java.awt.Graphics;

public abstract class Entity {
	
	protected int x, y, w, h;
	protected boolean removed = false;
	
	public Entity(int x, int y){ // constructor
		this.x = x;
		this.y = y;
	}
	
	public void draw(Graphics g) {
	}
	
	/*
	 * 
	public int getX(){return x;} // in line function for returning the value of x
	public int getY(){return y;} // in line function for returning the value of y
	public int getW(){return w;} // in line function for returning the width
	public int getH(){return h;} // in line function for returning the height
	*
	*/
}
