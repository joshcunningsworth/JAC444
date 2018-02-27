package GUI;

import java.awt.*;
import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

public class GUI {

	public static void main (String[] args) {
		
		JFrame frame = new JFrame(); //creating a new JFrame called frame
		JPanel panel = new JPanel(); //creating a new JPanel called panel
		
		panel.setBackground(Color.BLACK); //setting the background color of the panel to black
		frame.getContentPane().add(panel); //adding the panel to the content pane inside the frame
		
		JButton button = new JButton("Test Button"); //creating a new JButton called button
		panel.add(button);
		
		frame.setVisible(true); //setting the visibility of frame to true
		frame.setResizable(false); //setting the ability to resize the frame
		frame.setSize(new Dimension(600, 400)); //setting the size of the frame
		frame.setLocationRelativeTo(null); //setting the start location to null (center)
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //EXIT_ON_CLOSE closes the program, DISPOSE_ON_CLOSE closes the window but not the program
		frame.setTitle("GUI \"Title\""); //setting the title of the JFrame window
		
	}
}
