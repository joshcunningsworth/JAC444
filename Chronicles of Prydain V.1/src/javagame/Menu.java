package javagame;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Menu extends BasicGameState{
	
	// declares MenuBG, PlayGame, and ExitGame as Image variables
	Image MenuBG;
	Image PlayGame;
	Image ExitGame;
   
   public Menu(int state){
   }
   
   public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
	   // loading new images for the background, play button and exit button
	   MenuBG = new Image("res/MainMenu.png");
	   PlayGame = new Image("res/StartGame.png");
	   ExitGame = new Image("res/ExitGame.png");
   }
   
   public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
	   MenuBG.draw(0,0);
	   PlayGame.draw(190, 150);
	   ExitGame.draw(190, 250);
	   
   }
   
   public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
	   // integer variable declaring the mouse X and Y positions
	   int posX = Mouse.getX();
	   int posY = Mouse.getY();
	   Input input = gc.getInput();
	   
	   // play button coordinates for mouse click
	   if ((posX>190 && posX<450) && (posY>150 && posY<210)){
		   if(Mouse.isButtonDown(0)){
			   sbg.enterState(2);
		   }
	   }
	   
	   // quit button coordinates for mouse click
	   if ((posX>190 && posX<550) && (posY>50 && posY<110)){
		   if(Mouse.isButtonDown(0)){
			   System.exit(0);
		   }
	   }
	   
	   // by pressing escape it allows the user to return to the title screen
	   if(input.isKeyPressed(Input.KEY_ESCAPE)){
		   sbg.enterState(0);
		   }
   }
   
   public int getID(){
      return 1;
   }
}
