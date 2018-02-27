package exam;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ColourGUI { 


	public static void main(String[] args) {
		JFrame frame = new JFrame("Background ColourGUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 200);
		
		JPanel panelColour = new JPanel(new FlowLayout());
		
		JButton jB1 = new JButton("Yellow");
		JButton jB2 = new JButton("Blue");
		JButton jB3 = new JButton("Red");
	
		panelColour.add(jB1);  
		panelColour.add(jB2);  
		panelColour.add(jB3);    
	
		frame.add(panelColour);
		frame.setVisible(true);
		jB1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {        
				panelColour.setBackground(Color.YELLOW);
				panelColour.setOpaque(true);
			}
		});  
	
		jB2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelColour.setBackground(Color.BLUE);
				panelColour.setOpaque(true);
			}
		});  
	
		jB3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelColour.setBackground(Color.RED);
				panelColour.setOpaque(true);
			}
		});   
	} 
}
