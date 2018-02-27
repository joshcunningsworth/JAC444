package dodgegame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Stage {
	
	private Rectangle platform = new Rectangle(0, 540, 800, 40);
	private Rectangle leftWall= new Rectangle(0, 0, 10, 600);
	private Rectangle rightWall= new Rectangle(790, 0, 10, 600);
	
	public Stage() { 
	}
	
	public boolean isHit(Rectangle entity) {
		return platform.intersects(entity);
	}
	
	public boolean leftWall(Rectangle entity) {
		return leftWall.intersects(entity);
	}
	
	public boolean rightWall(Rectangle entity) {
		return rightWall.intersects(entity);
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(platform.x, platform.y, platform.width, platform.height); 
		g.fillRect(leftWall.x, leftWall.y, leftWall.width, leftWall.height);
		g.fillRect(rightWall.x, rightWall.y, rightWall.width, rightWall.height);
	}
	
}
