package javagame;

// import java.util.ArrayList;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Map1 extends BasicGameState{
	
	// hero walking animations
	Animation hero, movingUp, movingDown, movingLeft, movingRight;
	// hero standing animations
	Animation faceUp, faceDown, faceLeft, faceRight, lastAnimation;
	// hero sprint animations
	Animation sprintUp, sprintDown, sprintLeft, sprintRight;
	// hero attack animations
	Animation attUp, attDown, attLeft, attRight;
	// enemy animations
	Animation enemy, enemyUp, enemyDown, enemyLeft, enemyRight;
	
	// declares worldMap as a new Image
	Image worldMap;
	// declares quit as a boolean variable and sets it equal to false
	boolean quit = false;
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
	float enemyPositionX = 0;
	float enemyPositionY = 0;
	int enemyDirection = 0;
	float enShiftX = enemyPositionX + 120;
	float enShiftY = enemyPositionY + 200;
	float enemyX;
	float enemyY;
	// ArrayList<Play> enemies = new ArrayList<Play>();
	
   public Map1(int state){
   }
   
   public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
	   // image for the map of the game loaded in through the resource folder (res)
	   worldMap = new Image ("res/Path 1 Day.png");
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
	   
	   // attack animations
	   Image[] hitUp = {new Image("res/attUp1.png"), new Image("res/attUp2.png")};
	   Image[] hitDown = {new Image("res/attDown1.png"), new Image("res/attDown2.png")};
	   Image[] hitLeft = {new Image("res/attLeft1.png"), new Image("res/attLeft2.png")};
	   Image[] hitRight = {new Image("res/attRight1.png"), new Image("res/attRight2.png")};
	   
	   // hero sanding still
	   Image[] lookUp = {new Image ("res/HeroUp.png"), new Image("res/HeroUp.png")};
	   Image[] lookDown = {new Image ("res/HeroDown.png"), new Image("res/HeroDown.png")};
	   Image[] lookLeft = {new Image ("res/HeroLeft.png"), new Image("res/HeroLeft.png")};
	   Image[] lookRight = {new Image ("res/HeroRight.png"), new Image("res/HeroRight.png")};
	   
	   // hero 2 image animations
	   movingUp = new Animation(walkUp, duration, true);
	   movingDown = new Animation(walkDown, duration, true);
	   movingLeft = new Animation(walkLeft, duration, true);
	   movingRight = new Animation(walkRight, duration, true);
	   
	   sprintUp = new Animation(runUp, duration, true);
	   sprintDown = new Animation(runDown, duration, true);
	   sprintLeft = new Animation(runLeft, duration, true);
	   sprintRight = new Animation(runRight, duration, true);
	   
	   attUp = new Animation(hitUp, duration, true);
	   attDown = new Animation(hitDown, duration, true);
	   attLeft = new Animation(hitLeft, duration, true);
	   attRight = new Animation(hitRight, duration, true);
	   
	   faceUp = new Animation(lookUp, duration, true);
	   faceDown = new Animation(lookDown, duration, true);
	   faceLeft = new Animation(lookLeft, duration, true);
	   faceRight = new Animation(lookRight, duration, true);
	   hero = faceDown;
	   lastAnimation = faceDown;
	   
	   // images loaded for the enemy animations
	   Image[] moveUp = {new Image("res/EnemyUp1.png"), new Image("res/EnemyUp2.png")};
	   Image[] moveDown = {new Image("res/EnemyDown1.png"), new Image("res/EnemyDown2.png")};
	   Image[] moveLeft = {new Image("res/EnemyLeft1.png"), new Image("res/EnemyLeft2.png")};
	   Image[] moveRight = {new Image("res/EnemyRight1.png"), new Image("res/EnemyRight2.png")};
	   
	   enemyUp = new Animation(moveUp, duration, true);
	   enemyDown = new Animation(moveDown, duration, true);
	   enemyLeft = new Animation(moveLeft, duration, true);
	   enemyRight = new Animation(moveRight, duration, true);
	   enemy = enemyDown;
	   
   }
   
   public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
	   // map
	   worldMap.draw(heroPositionX - 100, heroPositionY - 450);
	   
	   // drawing an enemy to the screen
	   enemy.draw(enemyPositionX + 200, enemyPositionY + 100);
	   
	   enemyX = enemyPositionX - heroPositionX;
	   enemyY = enemyPositionY - heroPositionY;
	   
	   // draws the hero sprite to the screen
	   hero.draw(shiftX, shiftY);
	   // outputs the hero's coordinates to the screen
	   g.drawString("Hero's X Position: " + heroPositionX + "\nHero's Y Position: " + heroPositionY , 400, 20);
	   
	   g.drawString("Enemy's X Position: " + enemyX + "\nEnemy's Y Position: " + enemyY , 400, 60);
	   
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
   
   public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
	   Input input = gc.getInput();
	   
	   ++time;
	   if(time%3000 == 0){
		   time = 1;
	   enemyDirection = (int) (Math.random() * 4) + 1;
	   }
	   
	   if(enemyDirection == 1){
		   enemyPositionY -= delta * .1f;
		   enemy = enemyUp;
	   }
	   if(enemyDirection == 2){
		   enemyPositionY += delta * .1f;
		   enemy = enemyDown;
	   }
	   if(enemyDirection == 3){
		   enemyPositionX -= delta * .1f;
		   enemy = enemyLeft;
		   
	   }
	   else if(enemyDirection == 4){
		   enemyPositionX += delta * .1f;
		   enemy = enemyRight;
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
		   hero = movingUp;
		   heroPositionY += delta * .1f;
		   enemyPositionY += delta * .1f;
		   lastAnimation = faceUp;
		   
		   if(lastAnimation == faceUp){
			   if(input.isKeyDown(Input.KEY_SPACE)){
				   hero = attUp;
				   lastAnimation = faceUp;
				   heroPositionY -= delta * .1f;
				   enemyPositionY -= delta * .1f;
				   }
			   }
		   
		   // collision detection for the top of the map
		   if(heroPositionY>521){
			   heroPositionY -= delta * .1f;
			   enemyPositionY -= delta * .1f;
		   }
	   }
	   
	   // else statement saying that if the hero isn't moving he should face his last direction that he was moving
	   else{
		   hero = lastAnimation;
	   }
	   
	   // walking down movement
	   if(input.isKeyDown(Input.KEY_DOWN)){
		   hero = movingDown;
		   heroPositionY -= delta * .1f;
		   enemyPositionY -= delta * .1f;
		   lastAnimation = faceDown;
		   
		   if(lastAnimation == faceDown){
			   if(input.isKeyDown(Input.KEY_SPACE)){
				   hero = attDown;
				   lastAnimation = faceDown;
				   heroPositionY += delta * .1f;
				   enemyPositionY += delta * .1f;
				   if(heroPositionX <= enemyPositionX + 1 && heroPositionX >= enemyPositionX - 1 && heroPositionY <= enemyPositionY +1 && heroPositionY >= enemyPositionY - 1){
					   sbg.enterState(1);
				   }
				 }
			   }
		   
		   // collision detection for the bottom of the map
		   if(heroPositionY<-70){
			   heroPositionY += delta * .1f;
			   enemyPositionY += delta * .1f;
		   }
	   }
	   
	   // walking left movement
	   if(input.isKeyDown(Input.KEY_LEFT)){
		   hero = movingLeft;
		   heroPositionX += delta * .1f;
		   enemyPositionX += delta * .1f;
		   lastAnimation = faceLeft;
		   
		   if(lastAnimation == faceLeft){
			   if(input.isKeyDown(Input.KEY_SPACE)){
				   hero = attLeft;
				   lastAnimation = faceLeft;
				   heroPositionX -= delta * .1f;
				   enemyPositionX -= delta * .1f;
				   }
			   }
		   
		   // walking collision detection for the left side of the map
		   if(heroPositionX>305){
			   heroPositionX -= delta * .1f;
			   enemyPositionX -= delta * .1f;
		   }
	   }
	   
	   // walking right movement
	   if(input.isKeyDown(Input.KEY_RIGHT)){
		   hero = movingRight;
		   heroPositionX -= delta * .1f;
		   enemyPositionX -= delta * .1f;
		   lastAnimation = faceRight;
		   
		   if(lastAnimation == faceRight){
			   if(input.isKeyDown(Input.KEY_SPACE)){
				   hero = attRight;
				   lastAnimation = faceRight;
				   heroPositionX += delta * .1f;
				   enemyPositionX += delta * .1f;
				   }
			   }
		   
		   // collision detection for the right side of the map
		   if(heroPositionX<-1095){
			   heroPositionX += delta * .1f;
			   enemyPositionX += delta * .1f;
		   }
	   }
	   
	   // running up movement
	   if(input.isKeyDown(Input.KEY_LSHIFT)){
	   if(input.isKeyDown(Input.KEY_UP)){
		   hero = sprintUp;
		   heroPositionY += delta * .1000000001f;
		   enemyPositionY += delta * .1000000001f;
		   lastAnimation = faceUp;
		   
		   // collision detection for the top of the map
		   if(heroPositionY>521){
			   heroPositionY -= delta * .1000000001f;
			   enemyPositionY += delta * .1000000001f;
		   }
	   }
	}	   
	 
	   // running down movement
	   if(input.isKeyDown(Input.KEY_LSHIFT)){
	   if(input.isKeyDown(Input.KEY_DOWN)){
		   hero = sprintDown;
		   heroPositionY -= delta * .1000000001f;
		   enemyPositionY -= delta * .1000000001f;
		   lastAnimation = faceDown;
		   
		   // collision detection for the bottom of the map
		   if(heroPositionY<-70){
			   heroPositionY += delta * .1000000001f;
			   enemyPositionY -= delta * .1000000001f;
		   }
	   }
	}
	   
	   // Running left movement
	   if(input.isKeyDown(Input.KEY_LSHIFT)){
	   if(input.isKeyDown(Input.KEY_LEFT)){
		   hero = sprintLeft;
		   heroPositionX += delta * .1000000001f;
		   enemyPositionX += delta * .1000000001f;
		   lastAnimation = faceLeft;
		   
		   // walking collision detection for the left side of the map
		   if(heroPositionX>305){
			   heroPositionX -= delta * .1000000001f;
			   enemyPositionX += delta * .1000000001f;
		   }
	   }
	}
	   
	   // running right movement
	   if(input.isKeyDown(Input.KEY_LSHIFT)){
	   if(input.isKeyDown(Input.KEY_RIGHT)){
		   hero = sprintRight;
		   heroPositionX -= delta * .1000000001f;
		   enemyPositionX -= delta * .1000000001f;
		   lastAnimation = faceRight;
		   
		   // collision detection for the right side of the map
		   if(heroPositionX<-1095){
			   heroPositionX += delta * .1000000001f;
			   enemyPositionX -= delta * .1000000001f;
		   }
	   }
	}
	   
	   // detection for moving to the next map (state 3)
	   if(heroPositionX <= - 1070 && heroPositionX >= - 1095 && heroPositionY >= 80 && heroPositionY <= 150){
		   sbg.enterState(3);
			   } 
	   
	   // collision detection for the tent 
	   if(heroPositionX <= -15 && heroPositionX >= -90 && heroPositionY >= -41 && heroPositionY <= 64){
		   if(input.isKeyDown(Input.KEY_RIGHT)){
			   heroPositionX += delta * .2f;
		   }
		   if(input.isKeyDown(Input.KEY_LEFT)){
			   heroPositionX -= delta * .2f;
		   }
		   if(input.isKeyDown(Input.KEY_DOWN)){
			   heroPositionY += delta * .2f;
		   }
		   if(input.isKeyDown(Input.KEY_UP)){
			   heroPositionY -= delta * .2f;
		   }
       }
	   
	   // collision detection for statue 1
	   if(heroPositionX <= 213 && heroPositionX >= 127 && heroPositionY >= 497 && heroPositionY <= 521){
		   if(input.isKeyDown(Input.KEY_RIGHT)){
			   heroPositionX += delta * .2f;
		   }
		   if(input.isKeyDown(Input.KEY_LEFT)){
			   heroPositionX -= delta * .2f;
		   }
		   if(input.isKeyDown(Input.KEY_DOWN)){
			   heroPositionY += delta * .2f;
		   }
		   if(input.isKeyDown(Input.KEY_UP)){
			   heroPositionY -= delta * .2f;
		   }
       }
	   
	   // collision detection for statue 2
	   if(heroPositionX <= -10 && heroPositionX >= -92 && heroPositionY >= 497 && heroPositionY <= 521){
		   if(input.isKeyDown(Input.KEY_RIGHT)){
			   heroPositionX += delta * .2f;
		   }
		   if(input.isKeyDown(Input.KEY_LEFT)){
			   heroPositionX -= delta * .2f;
		   }
		   if(input.isKeyDown(Input.KEY_DOWN)){
			   heroPositionY += delta * .2f;
		   }
		   if(input.isKeyDown(Input.KEY_UP)){
			   heroPositionY -= delta * .2f;
		   }
       }
   }

   public int getID(){
      return 2;
   }
}