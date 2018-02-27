package dodgegame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import dodgegame.entity.Player;

public class Dodge extends JPanel implements KeyListener {

	private static final long serialVersionUID = 1L; // default serial
	
	private final int WIDTH = 800;
	private final int HEIGHT = 600;
	
	private Player player;
	private Stage stage;
	private EnemyManager enemyManager;
	private boolean gameOver = false;
	private boolean paused = false;
	
	public Dodge(){
		// setting the size and preferred size of the window
		setSize(new Dimension(WIDTH, HEIGHT));
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);
		addKeyListener(this);
		
		stage = new Stage();
		player = new Player(this, WIDTH / 2, HEIGHT / 2);
		enemyManager = new EnemyManager(this, 3);
	}
	
	@Override
	public void update(Graphics g) {
		paint(g);
	}
	
	public void paint(Graphics g){
		g.setColor(Color.BLACK); // setting the rectangle color black
		g.fillRect(0, 0, getWidth(), getHeight());	
		
		stage.draw(g);
		
		if(!gameOver && !paused) {
			player.draw(g);
			enemyManager.draw(g);	
		}
		
		if(gameOver) {
			g.setFont(new Font("VCR OSD Mono", Font.PLAIN, 34));
			g.drawString("GAME OVER!", (WIDTH / 2) - (g.getFontMetrics().stringWidth("GAME OVER!") / 2), HEIGHT / 2);
		}
		
		if(paused) {
			g.setFont(new Font("VCR OSD Mono", Font.PLAIN, 34));
			g.drawString("PAUSED", (WIDTH / 2) - (g.getFontMetrics().stringWidth("PAUSED") / 2), HEIGHT / 2);

		}
		
		g.dispose();
		repaint(); // method to re draw images
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int c = e.getKeyCode(); // c stands for code, e stands for event

		// if the game is paused then allow up and down inputs (TODO pause menu later)
		if(paused) {
			if(c == KeyEvent.VK_W || c == KeyEvent.VK_UP) { // if statement for moving up with "W" and up arrow key
				player.setYDir(-1);
			}
			if(c == KeyEvent.VK_S || c == KeyEvent.VK_DOWN) { // if statement for moving down with "S" and down arrow key
				player.setYDir(+1);
			}
		}
		
		if(c == KeyEvent.VK_A || c == KeyEvent.VK_LEFT) { // if statement for moving left with "A" and left arrow key
			player.setXDir(-1);
		}
		if(c == KeyEvent.VK_D || c == KeyEvent.VK_RIGHT) { // if statement for moving right with "D" and right arrow key
			player.setXDir(+1);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int c = e.getKeyCode();
		
		player.setXDir(0);
		player.setYDir(0);
		
		// if it's not game over and the game is not paused and the player presses the "P" key then set isPaused to true
		if(!gameOver) {			
			if(c == KeyEvent.VK_P && paused == false) {
				paused = !paused; // equals the opposite, so in this case pause will be set to true;
				System.out.println("Paused...");
				return; // returns void out of the function (this prevents the next if statement being checked and reversing the pause function)
			}
			
			// if the game has been paused then resume playing 
			if(c == KeyEvent.VK_P && paused == true){
				paused = !paused; // equals the opposite, so in this case pause will be set to false;
				System.out.println("Playing...");
				return; // returns void out of the function
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
	
	public void isGameOver(boolean gameOverFlag) {
		gameOver = gameOverFlag;
	}
	
	public void isPaused(boolean isPausedFlag) {
		paused = isPausedFlag;
	}
	
	public Stage getStage() {
		return stage;
	}
	
	public EnemyManager getEnemyManager() {
		return enemyManager;
	}
	
	public static void main(String[] args) {
		
		Dodge game = new Dodge(); // creating a new instance of Dodge class
		JFrame frame = new JFrame(); // creating a new JFrame window
		frame.setTitle("Dodge 2D Game"); // naming the window
		frame.add(game);
		frame.pack(); // packing its contents to adjust dimensions to the component size 500 x 400
		frame.setSize(new Dimension(800, 600)); // creating the size of the frame
		frame.setResizable(false); // revoking the user ability to resize the window 
		
		// when the user closes the window it ends the program so it doesn't run in the background
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setting the location of the window to the middle of the screen
		frame.setLocationRelativeTo(null);
		// setting the window to visible
		frame.setVisible(true);
	}
}