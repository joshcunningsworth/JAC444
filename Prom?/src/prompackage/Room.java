package prompackage;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Room extends BasicGameState{
	
	// hero walking animations
	Animation josh, movingUp, movingDown, movingLeft, movingRight;
	// hero standing animations
	Animation faceUp, faceDown, faceLeft, faceRight, lastAnimation;
	
	// declares map as a new image variable
	Image map;
	// declares quit as a boolean variable and sets it equal to false
	boolean quit = false;
	boolean text = false;
	boolean win = false;
	boolean lose = false;
	// integer array for the image animation durations 200 for each image
	int[] duration = {200,200};
	// declares the heroPositions and sets the values equal to 0
	float heroPositionX = 0;
	float heroPositionY = 0;
	
	// declares time as an integer and sets it equal to 0
	int time = 0;
	
	// declares variables for the map coordinates
	float mapx = 0;
	float mapy = 0;
	
	// declares shift variables for the hero to stay in the middle
	float shiftX = heroPositionX + 320;
	float shiftY = heroPositionY + 160;
	
   public Room(int state){
   }
   
   public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
	   // image for the map of the game loaded in through the resource folder (res)
	   map = new Image ("res/map.png");
	   
	   // images loaded from the resource folder (res) for the direction of the sprite to match the movement
	   Image[] walkUp = {new Image("res/StepUp1.png"), new Image("res/StepUp2.png")};
	   Image[] walkDown = {new Image("res/StepDown1.png"), new Image("res/StepDown2.png")};
	   Image[] walkLeft = {new Image("res/StepLeft1.png"), new Image("res/StepLeft2.png")};
	   Image[] walkRight = {new Image("res/StepRight1.png"), new Image("res/StepRight2.png")};
	   
	   // hero sanding still
	   Image[] lookUp = {new Image ("res/Back.png"), new Image("res/Back.png")};
	   Image[] lookDown = {new Image ("res/Front.png"), new Image("res/Front.png")};
	   Image[] lookLeft = {new Image ("res/Left.png"), new Image("res/Left.png")};
	   Image[] lookRight = {new Image ("res/Right.png"), new Image("res/Right.png")};
	   
	   // hero 2 image animations
	   movingUp = new Animation(walkUp, duration, true);
	   movingDown = new Animation(walkDown, duration, true);
	   movingLeft = new Animation(walkLeft, duration, true);
	   movingRight = new Animation(walkRight, duration, true);
	   
	   faceUp = new Animation(lookUp, duration, true);
	   faceDown = new Animation(lookDown, duration, true);
	   faceLeft = new Animation(lookLeft, duration, true);
	   faceRight = new Animation(lookRight, duration, true);
	   josh = faceLeft;
	   lastAnimation = faceLeft;
	   
   }
   
   public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
	   // map
	   map.draw(heroPositionX + 25, heroPositionY + 85);
	   
	   // draws the hero sprite to the screen
	   josh.draw(shiftX, shiftY);
	   
	   // outputs josh's coordinates to the screen
	   // g.drawString("Josh's X Position: " + heroPositionX + "\nJosh's Y Position: " + heroPositionY , 400, 20);
	   g.setColor(Color.red);
	   if(quit == true){
		   
		   g.drawString("Resume       (R)", 250, 100);
		   g.drawString("Main Menu    (M)", 250, 150);
		   g.drawString("Quit Game    (Q)", 250, 200);
		   if(quit == false){
			   g.clear();
		   }  
		}
	   
	   if(text == true){
		   g.setColor(Color.black);
		   quit = false;
		   g.drawString("Will You Go To Prom With ME?!", 190, 125);
		   g.setColor(Color.blue);
		   g.drawString("YES :)", 250, 150);
		   g.setColor(Color.red);
		   g.drawString("NO :(", 350, 150);
	   }
	   
		if (win == true){
			g.clear();
			quit = false;
			g.drawString("CONGRATULATIONS!", 250, 175);
		}
		
		if (lose == true){
			g.clear();
			quit = false;
			g.drawString("GAME OVER!", 275, 175);
		}
   }
   
   public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
	   Input input = gc.getInput();
	   
	   // escape key for in game pause menu
	   if(input.isKeyDown(Input.KEY_ESCAPE)){
		   quit = true;
	   }
	   
	   // when in game pause menu is up
	   if(quit == true){
		   
		   // if the input key is R then quit is equal to false and the game resumes
		   if(input.isKeyDown(Input.KEY_R)){
			   quit = false;
			   }
		   
		   // if the input key is M then then the StateBasedGame (sbg) returns to state 1 which is the main menu
		   if(input.isKeyDown(Input.KEY_M)){
			   sbg.enterState(1);
			   }
		   
		   // if the input key is Q then the System exits with a return value of 0 and the game ends
		   if(input.isKeyDown(Input.KEY_Q)){
			   System.exit(0);
			   }
	   }
	   
	// walking up movement
	   if(input.isKeyDown(Input.KEY_UP)){
		   josh = movingUp;
		   heroPositionY += delta * .1f;
		   lastAnimation = faceUp;
		   
		   if(lastAnimation == faceUp){
			   if(input.isKeyDown(Input.KEY_SPACE)){
				   lastAnimation = faceUp;
				   heroPositionY -= delta * .1f;
				   }
			   }
		   
		   // collision detection for the top of the map
		   if(heroPositionY>60){
			   heroPositionY -= delta * .1f;
		   }
	   }
	   
	   // else statement saying that if the hero isn't moving he should face his last direction that he was moving
	   else{
		   josh = lastAnimation;
	   }
	   
	   // walking down movement
	   if(input.isKeyDown(Input.KEY_DOWN)){
		   josh = movingDown;
		   heroPositionY -= delta * .1f;
		   lastAnimation = faceDown;
		   
		   if(lastAnimation == faceDown){
			   if(input.isKeyDown(Input.KEY_SPACE)){
				   lastAnimation = faceDown;
				   heroPositionY += delta * .1f;
				   }
				 }
			   }
		   
		   // collision detection for the bottom of the map
		   if(heroPositionY<-260){
			   heroPositionY += delta * .1f;
		   }
	   
	   
	   // walking left movement
	   if(input.isKeyDown(Input.KEY_LEFT)){
		   josh = movingLeft;
		   heroPositionX += delta * .1f;
		   lastAnimation = faceLeft;
		   
		   if(lastAnimation == faceLeft){
			   if(input.isKeyDown(Input.KEY_SPACE)){
				   lastAnimation = faceLeft;
				   heroPositionX -= delta * .1f;
				   }
			   }
		   
		   // walking collision detection for the left side of the map
		   if(heroPositionX>310){
			   heroPositionX -= delta * .1f;
		   }
	   }
	   
	   // walking right movement
	   if(input.isKeyDown(Input.KEY_RIGHT)){
		   josh = movingRight;
		   heroPositionX -= delta * .1f;
		   lastAnimation = faceRight;
		   
		   if(lastAnimation == faceRight){
			   if(input.isKeyDown(Input.KEY_SPACE)){
				   lastAnimation = faceRight;
				   heroPositionX += delta * .1f;
				   }
			   }
		   
		   // collision detection for the right side of the map
		   if(heroPositionX<-50){
			   heroPositionX += delta * .1f;
		   }
	   }
	   
		// collision detection for clara
		if (heroPositionX <= 80 && heroPositionX >= 50 && heroPositionY <= -50 && heroPositionY >= -106) {
			if (input.isKeyDown(Input.KEY_RIGHT)) {
					heroPositionX += delta * .1f;
			}
			if (input.isKeyDown(Input.KEY_LEFT)) {
					heroPositionX -= delta * .1f;
			}
			if (input.isKeyDown(Input.KEY_DOWN)) {
					heroPositionY += delta * .1f;
			}
			if (input.isKeyDown(Input.KEY_UP)) {
					heroPositionY -= delta * .1f;
			}
		}
		
		// collision detection for speaking
		if (heroPositionX <= 50 && heroPositionX >= 47 && heroPositionY <= -90 && heroPositionY >= -100) {
			text = true;
			if (text == true){
				if(input.isKeyDown(Input.KEY_Y)){
					win = true;
				}
				if(input.isKeyDown(Input.KEY_N)){
					lose = true;
				}
			}
		}
		
		// collision detection for the bookshelves
		if (heroPositionX <= 310 && heroPositionX >= 215 && heroPositionY <= 60 && heroPositionY >= 16) {
			if (input.isKeyDown(Input.KEY_RIGHT)) {
					heroPositionX += delta * .1f;
			}
			if (input.isKeyDown(Input.KEY_LEFT)) {
					heroPositionX -= delta * .1f;
			}
			if (input.isKeyDown(Input.KEY_DOWN)) {
					heroPositionY += delta * .1f;
			}
			if (input.isKeyDown(Input.KEY_UP)) {
					heroPositionY -= delta * .1f;
			}
		}
		// collision detection for the tv
		if (heroPositionX <= 185 && heroPositionX >= 118 && heroPositionY <= 60 && heroPositionY >= 16) {
			if (input.isKeyDown(Input.KEY_RIGHT)) {
					heroPositionX += delta * .1f;
			}
			if (input.isKeyDown(Input.KEY_LEFT)) {
					heroPositionX -= delta * .1f;
			}
			if (input.isKeyDown(Input.KEY_DOWN)) {
					heroPositionY += delta * .1f;
			}
			if (input.isKeyDown(Input.KEY_UP)) {
					heroPositionY -= delta * .1f;
			}
		}
		// collision detection for the table
		if (heroPositionX <= 185 && heroPositionX >= 70 && heroPositionY <= -65 && heroPositionY >= -175) {
			if (input.isKeyDown(Input.KEY_RIGHT)) {
					heroPositionX += delta * .1f;
			}
			if (input.isKeyDown(Input.KEY_LEFT)) {
					heroPositionX -= delta * .1f;
			}
			if (input.isKeyDown(Input.KEY_DOWN)) {
					heroPositionY += delta * .1f;
			}
			if (input.isKeyDown(Input.KEY_UP)) {
					heroPositionY -= delta * .1f;
			}
		}
		// collision detection for the bed
		if (heroPositionX <= 310 && heroPositionX >= 258 && heroPositionY <= -168 && heroPositionY >= -259) {
			if (input.isKeyDown(Input.KEY_RIGHT)) {
					heroPositionX += delta * .1f;
			}
			if (input.isKeyDown(Input.KEY_LEFT)) {
					heroPositionX -= delta * .1f;
			}
			if (input.isKeyDown(Input.KEY_DOWN)) {
					heroPositionY += delta * .1f;
			}
			if (input.isKeyDown(Input.KEY_UP)) {
					heroPositionY -= delta * .1f;
			}
		}
   }

   public int getID(){
      return 5;
   }
}