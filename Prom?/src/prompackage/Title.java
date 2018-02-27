package prompackage;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Title extends BasicGameState {
	
	Image TitleScreen;
	
	public Title(int state) {
	}
   
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		   TitleScreen = new Image("res/TitleScreen.png");
	   }

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		   TitleScreen.draw(0, 0);
	   }
	
	public void UP (GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{		
	   }

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		Input input = gc.getInput();
		
		// start by pressing the enter button to continue to the main menu
		if(input.isKeyDown(Input.KEY_ENTER)){
			//sound1.play();
			sbg.enterState(1);
			}
		
		// start by pressing the enter button to continue to the main menu
		if(input.isKeyPressed(Input.KEY_ESCAPE)){
			System.exit(0);
			}
		}	
		
	public int getID(){
	      return 0;
	      }

}
