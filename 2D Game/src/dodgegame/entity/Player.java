package dodgegame.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import dodgegame.Dodge;

public class Player extends Entity {
	
	private int xdir, ydir; // x direction and y direction
	private Dodge instance;
	private Rectangle hitbox;
	private int lives = 3;
	
	// constructor
	public Player(Dodge instance, int x, int y) {
		super(x, y);
		this.instance = instance;
		w = 16; h = 16;
		
		hitbox = new Rectangle(x, y, w, h);
	}
	
	public void draw(Graphics g) {
		move();
			
		g.setColor(Color.ORANGE);
		g.fillOval(hitbox.x, hitbox.y, hitbox.width, hitbox.height);
		g.setColor(Color.WHITE);
		g.drawString("Lives: " + lives, 20, 20);	
	}

	private void move() {
		
		if(!instance.getStage().isHit(hitbox)) { // collision detection to make sure the ball is on the ground
			ydir = 1;
		} else {
			ydir = 0;
		}
		
		if(instance.getStage().leftWall(hitbox)) { // collision detection to make sure the ball can't go through the left wall
			hitbox.x -= (xdir - 10);
		} else if (instance.getStage().rightWall(hitbox)) { // collision detection to make sure the ball can't go through the right wall
			hitbox.x -= (xdir + 10);
		}
		
		hitbox.x += xdir;
		hitbox.y += ydir;
		
		if(instance.getEnemyManager().isColliding(hitbox)) { // if the player collides with an enemy
			if(lives - 1 > 0) { // and the player has more than 0 lives (subtracting one because of the starting life)
				lives -- ; // the player loses one life
				
				hitbox.x = 400 - 8; // respawn the player in the middle of the screen
				hitbox.y = 300 - 8; // respawn the player in the middle of the screen
			} else {
				instance.isGameOver(true);
			}
		}
	}
	
	public void setXDir(int value) {
		xdir = value; // x direction 
	}
	
	public void setYDir(int value) {
		ydir = value; // y direction
	}
}
