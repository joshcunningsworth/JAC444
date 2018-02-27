package dodgegame;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import dodgegame.entity.Enemy;

public class EnemyManager {

	private int amount;
	private List<Enemy> enemies = new ArrayList<Enemy>();
	private Dodge instance;
	
	public EnemyManager(Dodge instance, int a) {
		this.amount = a;
		this.instance = instance;
		spawn();
	}
	
	private void spawn() {
		Random random = new Random();
		int enemyStack = enemies.size();
		
		if(enemyStack < amount) {
			for(int i = 0; i < amount - enemyStack; i++) {
				enemies.add(new Enemy(instance, random.nextInt(778), random.nextInt(100) + 11));
			}
		} else if(enemyStack > amount) {
			for(int i = 0; i < enemyStack - amount; i++) {
				enemies.remove(i);
			}
		}
	}
	
	public void draw(Graphics g) {
		update();
		for(Enemy e : enemies) e.draw(g);
	}
	
	
	private void update() {
		boolean removeEnemy = false;
		for(int i = 0; i < enemies.size(); i++) {
			if(enemies.get(i).isDead()) {
				enemies.remove(i);
				removeEnemy = true;
			}
		}
		
		if(removeEnemy) {
			spawn();
		}
	}
	
	public boolean isColliding(Rectangle hitbox) {
		boolean collided = false;
		
		for(int i = 0; i < enemies.size(); i++) {
			if(hitbox.intersects(enemies.get(i).getHitbox())) {
				collided = true;
			}
		}

		return collided;		
	}
	
}
