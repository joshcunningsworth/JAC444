/*
 * 
 */

package final_project;

import java.awt.*;
import javax.swing.*;

public class Frame{
	public static void main(String[] args){
		JFrame frame = new JFrame("Drone Enrollment Application");
		frame.setLayout(new GridLayout(8,1));
		JTextArea studID = new JTextArea();
		JTextArea Fname = new JTextArea();
		JTextArea Lname = new JTextArea();
		JTextArea gender = new JTextArea();
		JTextArea age = new JTextArea();
		JTextArea address = new JTextArea();
		
		
		studID.setEditable(false);
		Fname.setEditable(false);
		Lname.setEditable(false);
		gender.setEditable(false);
		age.setEditable(false);
		address.setEditable(false);
		
		studID.setBackground(new Color(238, 238, 238));
		Fname.setBackground(new Color(238, 238, 238));
		Lname.setBackground(new Color(238, 238, 238));
		gender.setBackground(new Color(238, 238, 238));
		age.setBackground(new Color(238, 238, 238));
		address.setBackground(new Color(238, 238, 238));
		
		
		studID.append("Enter Student ID: ");
		Fname.append("First Name: ");
		Lname.append("Last Name: ");		
		gender.append("Gender: ");				
		age.append("Age: ");				
		address.append("Address: ");
		
		
		frame.add(studID);
		frame.add(Fname);
		frame.add(Lname);
		frame.add(gender);
		frame.add(age);
		frame.add(address);
		
		
		frame.setSize(400, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}