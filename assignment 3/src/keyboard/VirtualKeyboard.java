/*
 * TYPEWRITER APPLICATION
 * 
 * Josh Cunningham
 * Sunday, August 14th, 2016.
 * 
 * This application can help users learn to type correctly without looking at the keyboard.
 * The application displays a virtual keyboard and allows the user to watch what they are
 * typing on the screen without having to look at the actual keyboard. It uses JButtons to
 * represent the keys. As the user presses each key, the application highlights the
 * corresponding JButton on the GUI and adds the character to a JTextArea that shows what
 * the user has typed so far.
 */

package keyboard;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class VirtualKeyboard implements KeyListener{
	
	Map<Integer, JButton> map = new HashMap<Integer, JButton>();
	
	 private final JFrame typewriter = new JFrame("Type Writer Application: Learn to Type!");   //creates frame and sets name
	 
	 private final JPanel qwerty = new JPanel(new GridBagLayout());   //creates frame and sets name
	
	String keyboardData[][] = {{"~","1","2","3","4","5","6","7","8","9","0","-","+","Backspace"},
							{"Tab","Q","W","E","R","T","Y","U","I","O","P","[","]","\\"},
							{"Caps","A","S","D","F","G","H","J","K","L",":","\"","Enter"},
							{"Shift","Z","X","C","V","B","N","M",",",".","?","^"},
							{" ","<" ,"v",">" }};
	
	String noShift="`1234567890-=qwertyuiop[]\\asdfghjkl;'zxcvbnm,./";
	
	String specialChars ="~-+[]\\;',.?";
	
	Color jBColor = new JButton().getBackground();

	public static void main(String[] args){
		
		new VirtualKeyboard();
		 
	}
	public VirtualKeyboard(){
		
	    typewriter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    // disabling the sizing feature on the window 
	    typewriter.setResizable(false);
	    
	    // sets the size of the frame
	    typewriter.setSize(new Dimension(950,580));

	    // where the frame will be when it opens
	    typewriter.setLocation(50,50);
	    
	    // sets the frames layout
	    typewriter.setLayout(new GridBagLayout());
	    
	    initWidgets();
	    typewriter.setVisible(true);
	}

	private void initWidgets()
	{
		
		JPanel topText = new JPanel(new GridBagLayout()),
				typeText = new JPanel(new GridBagLayout());
		
		GridBagConstraints cText = new GridBagConstraints(),
							typeAreaColor = new GridBagConstraints();
		
		// displaying the instructions to the users and the applications limitations
		JLabel instruct = new JLabel("<html>Learn to type without looking at the keyboard!! Type some text on your computers keyboard and the keys you press will be highlighted.<br>The text you type will be displayed --- NOTE: Clicking the onscreen buttons with your mouse will not display the corresponding key to the screen. <br><br> </html>" );
	    
		instruct.setFont(new Font("Arial",Font.BOLD,11));
		instruct.setForeground(new Color(34,88,86));
	    topText.add(instruct);
	    
	    cText.gridy = 0;
	    cText.weightx = 1;
	    cText.insets = new Insets(0, 20, 0, 0);
	    
	    cText.anchor = GridBagConstraints.FIRST_LINE_START;   //start from top-left
	    
	    typewriter.add(topText, cText);
	    
	    Border loweredbevel = BorderFactory.createLoweredBevelBorder(); //creates preset border
	    
	    //set the text area on top 
	    JTextArea typeArea = new JTextArea();
	    typeArea.setPreferredSize(new Dimension(900,150));
	    typeArea.setEditable(true); //field can be edited
	    typeArea.setBorder(loweredbevel); //sets preset border
	    typeArea.addKeyListener(this);
	    
	    typeText.add(typeArea);
	    
	    typeAreaColor.insets = new Insets(0, 20, 20, 0);
	    typeAreaColor.gridy = 1;  //start from top-left
	    typeAreaColor.weightx = 1;
	    typeAreaColor.anchor = GridBagConstraints.FIRST_LINE_START;   //start from top-left
	    
	    typewriter.add(typeText, typeAreaColor);
		
	
	    initKeyboard();
	    
	    }   
	
	

	private void initKeyboard(){
		GridBagConstraints jBut = new GridBagConstraints(),
							jRow = new GridBagConstraints(),
							jPan = new GridBagConstraints(); //constraints object to set constraints for items
		
		JPanel tRow;
		JButton b;
		
		jPan.gridx = 0;
		jPan.weightx = 1;
		jPan.anchor = GridBagConstraints.FIRST_LINE_START;   //start from top-left
		jPan.insets = new Insets(0, 20, 0, 0);
		
		jBut.ipady = 21;
		
		for (int row = 0; row < keyboardData.length; ++row) {
			tRow = new JPanel(new GridBagLayout());
			
			jRow.anchor = GridBagConstraints.WEST;
			jRow.gridy = row;
			
			// second dimension representing each key
			for (int col = 0; col < keyboardData[row].length; ++col) {
			
				b = new JButton(keyboardData[row][col]);
				
				b.setBackground(new Color(131,207,204));
				
			    // creating the padding and insets for the buttons
			    switch (keyboardData[row][col]) {
			        case "Backspace":   b.setPreferredSize(new Dimension(120,40)); 
			        	break;
			        case "Tab":         b.setPreferredSize(new Dimension(90,40)); 
			        	break;
			        case "Caps":        b.setPreferredSize(new Dimension(90,40)); 
			        	break;
			        case "Enter":       b.setPreferredSize(new Dimension(120,40)); 
			        	break;
			        case "Shift":       b.setPreferredSize(new Dimension(120,40)); 
			        	break;
			        case "?":
			        	b.setPreferredSize(new Dimension(60,40));
			            jBut.insets = new Insets(0, 0, 0, 30);
			            break;
			        case " ":
			        	b.setPreferredSize(new Dimension(360,40));
			            jBut.insets = new Insets(0, 240, 0, 90);
			            break;
			        default:
			        	b.setPreferredSize(new Dimension(60,40));
			            jBut.insets = new Insets(0, 0, 0, 0);
			    }
			
			    b.setFocusable(false);
			    map.put(getKeyCode(keyboardData[row][col]), b);
			    tRow.add(b, jBut);
			}
			
			qwerty.add(tRow, jRow);
		}
		
		typewriter.add(qwerty, jPan);
		
	}
	
	public void keyPressed(KeyEvent evt) {
	    int keycode = evt.getKeyCode();
	    @SuppressWarnings("unused")
		String strText = String.format("%s", KeyEvent.getKeyText(evt.getKeyCode()));

	    JButton b = map.get(keycode);
	    if (b != null) {
	    	// when the key is pressed it will change to red
	    	map.get(keycode).setBackground(Color.RED);
	    	map.get(keycode).setOpaque(true);
	    }

	}
	
	public void keyReleased(KeyEvent evt) {
        int keycode = evt.getKeyCode();
        @SuppressWarnings("unused")
		String strText = String.format("%s", KeyEvent.getKeyText(evt.getKeyCode()));

        JButton b = map.get(keycode);
        if (b != null) {
        	// on release of the key it will return to its original color
        	map.get(keycode).setBackground(typewriter.getBackground());
            map.get(keycode).setOpaque(true);
        }
    }
	
	public void keyTyped(KeyEvent evt) {
        @SuppressWarnings("unused")
		String strText = String.format("%s", evt.getKeyChar());
        // testing key input/output -- System.out.println(strText);
    }
	
	// cases for character inputs from the keyboard
	private int getKeyCode(String key) {
	    if (key.equals("Backspace")) {
	        return KeyEvent.VK_BACK_SPACE;
	    }
	    
	    else if (key.equals("")) {
	        return KeyEvent.VK_SPACE;
	    }
	    
	    else if (key.equals("Tab")) {
	        return KeyEvent.VK_TAB;
	    }
	    
	    else if (key.equals("Caps")) {
	        return KeyEvent.VK_CAPS_LOCK;
	    }
	    
	    else if (key.equals("Enter")) {
	        return KeyEvent.VK_ENTER;
	    }
	    
	    else if (key.equals("Shift")) {
	        return KeyEvent.VK_SHIFT;
	    }
	    
	    else if (key.equals("+")) {
	        return KeyEvent.VK_EQUALS;
	    }
	    
	    else if (key.equals(":")) {
	        return KeyEvent.VK_SEMICOLON;
	    }
	    
	    else if (key.equals("\"")) {
	        return KeyEvent.VK_QUOTE;
	    }
	    
	    else if (key.equals("?")) {
	        return KeyEvent.VK_SLASH;
	    }
	    
	    else if (key.equals("~")) {
	        return KeyEvent.VK_BACK_QUOTE;
	    }

	    else {
	        return (int) key.charAt(0);
	    }
	}

}
