/*
 * This application displays the GUI for a calculator with no functionality
 */

package question4;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class calculator{

	public static void main(String[] args) {
		JFrame frame = new JFrame("Calculator");
		frame.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		//changing the font
		Font newFont = new Font("Sans Serif", Font.PLAIN, 54);
		//creating a bevel for the buttons
		Border loweredBevel = BorderFactory.createLoweredBevelBorder();
		
		JTextArea calcArea = new JTextArea();
		
		calcArea.setFont(newFont);
		calcArea.setBorder(loweredBevel);
		
		calcArea.setEditable(true);
		
		c.weightx = 1;
		c.weighty = 1;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 4;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		c.fill = GridBagConstraints.BOTH;
		frame.add(calcArea, c);
		
		//adding all the necessary calculator buttons
		JButton divide = new JButton("/");
		divide.setFont(newFont);
		JButton nine = new JButton("9");
		nine.setFont(newFont);
		JButton eight = new JButton("8");
		eight.setFont(newFont);
		JButton seven = new JButton("7");
		seven.setFont(newFont);
		
		JButton multiply = new JButton("*");
		multiply.setFont(newFont);
		JButton six = new JButton("6");
		six.setFont(newFont);
		JButton five = new JButton("5");
		five.setFont(newFont);
		JButton four = new JButton("4");
		four.setFont(newFont);
		
		JButton subtract = new JButton("-");
		subtract.setFont(newFont);
		JButton three = new JButton("3");
		three.setFont(newFont);
		JButton two = new JButton("2");
		two.setFont(newFont);
		JButton one = new JButton("1");
		one.setFont(newFont);
		
		JButton add = new JButton("+");
		add.setFont(newFont);
		JButton equal = new JButton("=");
		equal.setFont(newFont);
		JButton dot = new JButton(".");
		dot.setFont(newFont);
		JButton zero = new JButton("0");
		zero.setFont(newFont);
		
		c.weightx = 1;
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.BOTH;
		
		frame.add(seven, c);
		c.gridx = 1;
		frame.add(eight, c);
		c.gridx = 2;
		frame.add(nine, c);
		c.gridx = 3;
		frame.add(divide, c);
		
		c.gridx = 0;
		c.gridy = 2;
		frame.add(four, c);
		c.gridx = 1;
		frame.add(five, c);
		c.gridx = 2;
		frame.add(six, c);
		c.gridx = 3;
		frame.add(multiply, c);
		
		c.gridx = 3;
		c.gridy = 3;
		frame.add(subtract, c);
		c.gridx = 2;
		frame.add(three, c);
		c.gridx = 1;
		frame.add(two, c);
		c.gridx = 0;
		frame.add(one, c);
		
		c.gridx = 3;
		c.gridy = 4;
		frame.add(add, c);
		c.gridx = 2;
		frame.add(equal, c);
		c.gridx = 1;
		frame.add(dot, c);
		c.gridx = 0;
		frame.add(zero, c);
		
		//setting the size of the window
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(
		JFrame.EXIT_ON_CLOSE);

	}

}
