package prompackage;

import org.lwjgl.input.*;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Menu extends BasicGameState{
	
	// declares MenuScreen, PlayGame, and QuitGame as Image variables
	Image MenuScreen;
	public String mouse = "loading..." ;
   
   public Menu(int state){
   }
   
   public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
	   // loading new image
	   MenuScreen = new Image("res/MenuScreen.png");
   }
   
   public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
	   // draws the image
	   MenuScreen.draw(0, 0);
	   // draws mouse coordinates to the screen
	  // g.drawString(mouse, 10, 25);
   }
   
   public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
	   // integer variable declaring the mouse X and Y positions
	   int posX = Mouse.getX();
	   int posY = Mouse.getY();
	   Input input = gc.getInput();
	   mouse = "Mouse Position x:" + posX + "y: " + posY;
	   
	   // play button coordinates for mouse click
	   if ((posX>115 && posX<300) && (posY>125 && posY<150)){
		   if(Mouse.isButtonDown(0)){
			   sbg.enterState(2);
		   }
	   }
	   
	   // quit button coordinates for mouse click
	   if ((posX>325 && posX<500) && (posY>125 && posY<150)){
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
