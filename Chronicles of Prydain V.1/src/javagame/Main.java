package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Main extends StateBasedGame{

   // declares the game name as the Chronicles of Prydain
   public static final String gamename = "Chronicles of Prydain";
   
   // declares start as an integer variable with the state of 0
   public static final int title = 0;
   
   // declares menu as an integer variable with the state of 1
   public static final int menu = 1;
   
   // declares map1 as an integer variable with the state of 2
   public static final int map1 = 2;
   
   // declares map2 as an integer variable with the state of 3
   public static final int map2 = 3;
   
   // declares sound as an integer variable with the state of 4
   public static final int sound = 4;
   
   public Main(String gamename){
      super(gamename);
      this.addState(new Title(title));
      this.addState(new Menu(menu));
      this.addState(new Map1(map1));
      this.addState(new Map2(map2));
      this.addState(new Sound(sound));
   }
   
   public void initStatesList(GameContainer gc) throws SlickException{
      this.getState(title).init(gc, this);
      this.getState(menu).init(gc, this);
      this.getState(map1).init(gc, this);
      this.getState(map2).init(gc, this);
      this.getState(sound).init(gc, this);
      
      // tells the program to start in the start state at the beginning of the game
      this.enterState(title);
   }
   
   public static void main(String[] args) {
      AppGameContainer appgc;
      try{
         appgc = new AppGameContainer(new Main(gamename));
         // window size (length, height, full screen)
         appgc.setDisplayMode(640, 360, false);
         appgc.start();
      }catch(SlickException e){
         e.printStackTrace();
      }
   }
}
