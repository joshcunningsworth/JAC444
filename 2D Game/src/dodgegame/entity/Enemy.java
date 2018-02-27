package dodgegame.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import dodgegame.Dodge;

public class Enemy extends Entity {

	private Rectangle hitbox;
	private boolean dead = false;
	private int enemyXpos = 0, enemyYpos = 0;
	private Dodge instance;
	
	public Enemy(Dodge instance, int x, int y) {
		super(x, y);
		this.instance = instance;
		hitbox = new Rectangle(x, y, 32, 32);
		
		enemyXpos = 0;
		enemyYpos = 1;
	}
	
	private void move() {
		if(instance.getStage().isHit(hitbox)) {
			enemyYpos = 0;
			dead = true;
		}
		
		hitbox.x += enemyXpos;
		hitbox.y += enemyYpos;
	}
	
	public boolean isDead() {
		return dead;
	}
	
	public Rectangle getHitbox() {
		return hitbox;
	}
	
	public void draw(Graphics g) {
		move();
		g.setColor(Color.RED);
		g.fillRect(hitbox.x, hitbox.y, hitbox.width, hitbox.height);
	}

}
