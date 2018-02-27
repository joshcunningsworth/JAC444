package javagame;

// import java.util.ArrayList;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Map2 extends BasicGameState{
	
	Animation hero, movingUp, movingDown, movingLeft, movingRight, faceUp, faceDown, faceLeft, faceRight, lastAnimation;
	Animation sprintUp, sprintDown, sprintLeft, sprintRight;
	Image worldMap;
	Image newMap;
	boolean quit = false;
	boolean changestate = false;
	
	int[] duration = {200,200};
	float heroPositionX = 0;
	float heroPositionY = 0;
	float shiftX = heroPositionX + 320;
	float shiftY = heroPositionY + 160;
	// ArrayList<Play> enemies = new ArrayList<Play>();
   public Map2(int state){
   }
   
   public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
	   // image for the map of the game loaded in through the resource folder (res)
	   worldMap = new Image ("res/Village1.png");
	   // images loaded from the resource folder (res) for the direction of the sprite to match the movement
	   Image[] walkUp = {new Image("res/UpStep2.png"), new Image("res/UpStep4.png")};
	   Image[] walkDown = {new Image("res/DownStep2.png"), new Image("res/DownStep4.png")};
	   Image[] walkLeft = {new Image("res/LeftStep2.png"), new Image("res/LeftStep3.png")};
	   Image[] walkRight = {new Image("res/RightStep2.png"), new Image("res/RightStep3.png")};
	   
	   // hero sprinting
	   Image[] runUp = {new Image("res/runUp1.png"), new Image("res/runUp2.png")};
	   Image[] runDown = {new Image("res/runDown1.png"), new Image("res/runDown2.png")};
	   Image[] runLeft = {new Image("res/runLeft1.png"), new Image("res/runLeft2.png")};
	   Image[] runRight = {new Image("res/runRight1.png"), new Image("res/runRight2.png")};
	   
	   // hero sanding still
	   Image[] lookUp = {new Image ("res/HeroUp.png"), new Image("res/HeroUp.png")};
	   Image[] lookDown = {new Image ("res/HeroDown.png"), new Image("res/HeroDown.png")};
	   Image[] lookLeft = {new Image ("res/HeroLeft.png"), new Image("res/HeroLeft.png")};
	   Image[] lookRight = {new Image ("res/HeroRight.png"), new Image("res/HeroRight.png")};
	   
	   movingUp = new Animation(walkUp, duration, true);
	   movingDown = new Animation(walkDown, duration, true);
	   movingLeft = new Animation(walkLeft, duration, true);
	   movingRight = new Animation(walkRight, duration, true);
	   
	   sprintUp = new Animation(runUp, duration, true);
	   sprintDown = new Animation(runDown, duration, true);
	   sprintLeft = new Animation(runLeft, duration, true);
	   sprintRight = new Animation(runRight, duration, true);
	   
	   faceUp = new Animation(lookUp, duration, true);
	   faceDown = new Animation(lookDown, duration, true);
	   faceLeft = new Animation(lookLeft, duration, true);
	   faceRight = new Animation(lookRight, duration, true);
	   hero = faceDown;
	   lastAnimation = faceDown;
   }
   
   public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
	   // map
	   worldMap.draw(heroPositionX + 250, heroPositionY - 600);
	   // draws the hero sprite to the screen
	   hero.draw(shiftX, shiftY);
	   // outputs the hero's coordinates to the screen
	   g.drawString("Hero's X Position: " + heroPositionX + "\nHero's Y Position: " + heroPositionY , 400, 20);
	   
	   
	   
	   // if statement for the in game pause menu
	   if(quit == true){
		   
		   g.drawString("Resume       (R)", 250, 100);
		   g.drawString("Main Menu    (M)", 250, 150);
		   g.drawString("Quit Game    (Q)", 250, 200);
		   if(quit == false){
			   g.clear();
		   }
	   }
   }
   
/*   public void addEnemy(Play e){
   } */
   
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
	   
	   // up movement
	   if(input.isKeyDown(Input.KEY_UP)){
		   hero = movingUp;
		   heroPositionY += delta * .1f;
		   lastAnimation = faceUp;
		   
		   // collision detection for the top of the map
		   if(heroPositionY>495){
			   heroPositionY -= delta * .1f;
		   }
	   }
	   
	   else{
		   hero = lastAnimation;
	   }
	   
	   // down movement
	   if(input.isKeyDown(Input.KEY_DOWN)){
		   hero = movingDown;
		   heroPositionY -= delta * .1f;
		   lastAnimation = faceDown;
		   
		   // collision detection for the bottom of the map
		   if(heroPositionY<-540){
			   heroPositionY += delta * .1f;   
		   }
	   }
	   
	   // left movement
	   if(input.isKeyDown(Input.KEY_LEFT)){
		   hero = movingLeft;
		   heroPositionX += delta * .1f;
		   lastAnimation = faceLeft;
		   
		   // collision detection for the left side of the map
		   if(heroPositionX>1009){
			   heroPositionX -= delta * .1f;
		   }
	   }
	   
	   // right movement
	   if(input.isKeyDown(Input.KEY_RIGHT)){
		   hero = movingRight;
		   heroPositionX -= delta * .1f;
		   lastAnimation = faceRight;
		   
		   // collision detection for the right side of the map
		   if(heroPositionX<-1178){
			   heroPositionX += delta * .1f;
		   }
		   
		   // running up animation
		   if(input.isKeyDown(Input.KEY_LCONTROL)){
			   if(input.isKeyDown(Input.KEY_UP)){
				   hero = sprintUp;
				   heroPositionY += delta * .1000000001f;
				   lastAnimation = faceUp;
				   
				   // collision detection for the top of the map
				   if(heroPositionY>495){
					   heroPositionY -= delta * .1000000001f;
				   }
			   }
		   }
		   
		   // running up animation
		   if(input.isKeyDown(Input.KEY_LCONTROL)){
			   if(input.isKeyDown(Input.KEY_DOWN)){
				   hero = sprintDown;
				   heroPositionY -= delta * .1000000001f;
				   lastAnimation = faceUp;
				   
				   // collision detection for the top of the map
				   if(heroPositionY>-540){
					   heroPositionY += delta * .1000000001f;
				   }
			   }
		   }
		   
		   // running left movement
		   if(input.isKeyDown(Input.KEY_LCONTROL)){
		   if(input.isKeyDown(Input.KEY_LEFT)){
			   hero = sprintLeft;
			   heroPositionX += delta * .1000000001f;
			   lastAnimation = faceLeft;
			   
			   // collision detection for the left side of the map
			   if(heroPositionX>1009){
				   heroPositionX -= delta * .1000000001f;
			   }
		   }
		}
		   
		   // right movement
		   if(input.isKeyDown(Input.KEY_LCONTROL)){
		   if(input.isKeyDown(Input.KEY_RIGHT)){
			   hero = sprintRight;
			   heroPositionX -= delta * .1000000001f;
			   lastAnimation = faceRight;
			   
			   // collision detection for the right side of the map
			   if(heroPositionX<-1178){
				   heroPositionX += delta * .1000000001f;
			   }
		   }
		}
		   
		// detection for moving to the next map (state 2)
		if(heroPositionX >= 10 && heroPositionX <= 70 && heroPositionY >= -30 && heroPositionY <= 30){ 
				   sbg.enterState(2);
			   }
			
		
		// collision detection for the green tent 
		   if(heroPositionX <= -265 && heroPositionX >= -377 && heroPositionY >= 395 && heroPositionY <= 467){
			  
			   if(input.isKeyDown(Input.KEY_LEFT)){
				   heroPositionX -= delta * .1f;
			   }
			   if(input.isKeyDown(Input.KEY_DOWN)){
				   heroPositionY += delta * .1f;
			   }
			   if(input.isKeyDown(Input.KEY_UP)){
				   heroPositionY -= delta * .1f;
			   }
			   if(input.isKeyDown(Input.KEY_RIGHT)){
				   heroPositionX += delta * .1f;
			   }
	       }
		   
		// collision detection for the brown tent 
		   if(heroPositionX <= -1090 && heroPositionX >= -1170 && heroPositionY >= -18 && heroPositionY <= 85){
			   if(input.isKeyDown(Input.KEY_LEFT)){
				   heroPositionX -= delta * .1f;
			   }
			   if(input.isKeyDown(Input.KEY_DOWN)){
				   heroPositionY += delta * .1f;
			   }
			   if(input.isKeyDown(Input.KEY_UP)){
				   heroPositionY -= delta * .1f;
			   }
			   if(input.isKeyDown(Input.KEY_RIGHT)){
				   heroPositionX += delta * .1f;
			   }
		   }		   
	   }
   }
   
   public int getID(){
      return 3;
   }
}