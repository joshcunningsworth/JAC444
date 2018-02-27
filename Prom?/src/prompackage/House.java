package prompackage;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class House extends BasicGameState{
	
	// hero walking animations
	Animation josh, movingUp, movingDown, movingLeft, movingRight;
	// hero standing animations
	Animation faceUp, faceDown, faceLeft, faceRight, lastAnimation;
	
	// declares worldMap as a new Image
	Image worldMap;
	// declares quit as a boolean variable and sets it equal to false
	boolean quit = false;
	// integer array for the image animation durations 200 for each image
	int[] duration = {200,200};
	// declares the heroPositions and sets the values equal to 0
	float heroPositionX = 0;
	float heroPositionY = 0;

	public String text = "Where is She!?";
	
	// declares time as an integer and sets it equal to 0
	int time = 0;
	
	// declares variables for the map coordinates
	float mapx = 0;
	float mapy = 0;
	
	// declares shift variables for the hero to stay in the middle
	float shiftX = heroPositionX + 320;
	float shiftY = heroPositionY + 160;
	
   public House(int state){
   }
   
   public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
	   // image for the map of the game loaded in through the resource folder (res)
	   worldMap = new Image ("res/House.png");
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
	   josh = faceUp;
	   lastAnimation = faceUp;

   }
   
   public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
	   // map
	   worldMap.draw(heroPositionX + 160, heroPositionY - 110);
	   
	   // draws the hero sprite to the screen
	   josh.draw(shiftX, shiftY);
	   // outputs the hero's coordinates to the screen
	   g.setColor(Color.white);
	   // draws josh's x and y coordinates
	   // g.drawString("Josh's X Position: " + heroPositionX + "\nJosh's Y Position: " + heroPositionY , 400, 20);
	   g.setColor(Color.black);
	   g.drawString(text, 280, 125);
	   if(quit == true){
		   g.setColor(Color.white);
		   g.drawString("Resume       (R)", 250, 100);
		   g.drawString("Main Menu    (M)", 250, 150);
		   g.drawString("Quit Game    (Q)", 250, 200);
		   if(quit == false){
			   g.clear();
		   }  
		}
   }
   
   public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
	   Input input = gc.getInput();

		// collision detection for text update
		if (heroPositionX <= 70 && heroPositionX >= -155 && heroPositionY <= 125 && heroPositionY >= -10) {
			text = "Where is She!?";
		}
		else {
			text = " ";
		}
	   
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
		   if(heroPositionY>225){
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
		   if(heroPositionY<-10){
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
		   if(heroPositionX>175){
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
		   if(heroPositionX<-260){
			   heroPositionX += delta * .1f;
		   }
	   }
	   
	   	// collision detection for sink, bookshelf and tv
		if (heroPositionX <= 155 && heroPositionX >= -70 && heroPositionY >= 205 && heroPositionY <= 225) {
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
		
		// collision detection for top left corner
		if (heroPositionX <= 175 && heroPositionX >= 161 && heroPositionY <= 225 && heroPositionY >= 205) {
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
		
		// collision detection for left plants
		if (heroPositionX <= 175 && heroPositionX >= 140 && heroPositionY <= 160 && heroPositionY >= -10) {
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
		if (heroPositionX <= -10 && heroPositionX >= -115 && heroPositionY <= 157 && heroPositionY >= 65) {
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
		// collision detection for the half wall
		if (heroPositionX <= -160 && heroPositionX >= -205 && heroPositionY <= 225 && heroPositionY >= 150) {
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
		// change states from the street to the yellow house
		if (heroPositionX <= -250 && heroPositionX >= -260 && heroPositionY >= 175 && heroPositionY <= 200) {
			sbg.enterState(5);
		}
   }

   public int getID(){
      return 4;
   }
}