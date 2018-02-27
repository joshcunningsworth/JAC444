package prompackage;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Game extends StateBasedGame{

   // declares the game's name as Prom?
   public static final String gamename = "Prom?: The Game";
   
   // declares start as an integer variable with the state of 0
   public static final int title = 0;
   
   // declares menu as an integer variable with the state of 1
   public static final int menu = 1;

   // declares spawn as an integer variable with the state of 2
   public static final int spawn = 2;
   
   // declares street as an integer variable with the state of 3
   public static final int street = 3;
   
   // declares house as an integer variable with the state of 4
   public static final int house = 4;
   
   // declares sound as an integer variable with the state of 5
   public static final int room = 5;
   
   public Game(String gamename){
      super(gamename);
      this.addState(new Title(title));
      this.addState(new Menu(menu));
      this.addState(new Spawn(spawn));
      this.addState(new Street(street));
      this.addState(new House(house));
      this.addState(new Room(room));
   }
   
   public void initStatesList(GameContainer gc) throws SlickException{
      this.getState(title).init(gc, this);
      this.getState(menu).init(gc, this);
      this.getState(spawn).init(gc, this);
      this.getState(street).init(gc, this);
      this.getState(house).init(gc, this);
      this.getState(room).init(gc, this);
      
      // tells the program to start in the start state at the beginning of the game
      this.enterState(title);
   }
   
   public static void main(String[] args) {
      AppGameContainer appgc;
      try{
         appgc = new AppGameContainer(new Game(gamename));
         // window size (length, height, full screen)
         appgc.setDisplayMode(640, 360, false);
         appgc.start();
      }catch(SlickException e){
         e.printStackTrace();
      }
   }
}