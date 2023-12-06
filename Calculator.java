/* This code is based on the code found in this video
https://youtu.be/AJMZGQy0JtU 
There is also an alternate link to the video on the Side Projects Page
Watch the video to find out how to add the missing code and customize the 
calculator!
*/
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/* This part of the program creates the visual components
the calculations are done in the Evaluation.java class
*/
public class Calculator {
	
	private JFrame frame = new JFrame("GUI Calculator by Java Coding Community - v.1.0"); // set the title
	
	private JTextArea txtScreen = new JTextArea(); // this is the screen where the user types numbers from the calc
	private JTextArea outputScreen = new JTextArea(); // this is the screen to present the output / invalid values
	
	private ImageIcon image = new ImageIcon("PopeCSSmall.png"); // icon in top left
	
	// creating number buttons;
	private JButton button0 = new JButton("0");
	private JButton button1 = new JButton("1");
	private JButton button2 = new JButton("2");
	private JButton button3 = new JButton("3");
	private JButton button4 = new JButton("4");
	private JButton button5 = new JButton("5");
	private JButton button6 = new JButton("6");
	private JButton button7 = new JButton("7");
	private JButton button8 = new JButton("8");
	private JButton button9 = new JButton("9");
	
	
	// creating operator numbers
	private JButton divideButton = new JButton("/");
	private JButton multiplyButton = new JButton("*");
	private JButton addButton = new JButton("+");
	private JButton subtractButton = new JButton("-");
	private JButton powerOf = new JButton("^");
	private JButton root = new JButton("Sqrt");
	private JButton clears = new JButton("Clear");
	private JButton parenthesis_left = new JButton("(");
	private JButton parenthesis_right = new JButton(")");
	private JButton back = new JButton("←");
	private JButton image1 = new JButton(image);
	
	// equals button is more special
	private JButton equals = new JButton("=");
	
	public Calculator() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // default close operation
		frame.setSize(500,500); // calculator size
		frame.setResizable(false); // can't resize it
		frame.setLayout(null); // default layout
		Color customBackground = new Color(80, 100, 230); // custom colors
		Color customGray = new Color(80,220,230); // custom colors
		frame.getContentPane().setBackground(customBackground);
		outputScreen.setText("Answer:");
		// set background
		
		
		//editing the txtScreen 
		txtScreen.setSize(450,60);
		txtScreen.setLocation(25,15);
		
		//editing the output screen
		outputScreen.setSize(450,60);
		outputScreen.setLocation(25,85);
		outputScreen.setBackground(customGray);
		
		// button equals;
		// it is more special than the others :P
		equals.setSize(110,50);
		equals.setLocation(361,425);
		equals.addActionListener(new ActionListener() {
			//this happens when the button is clicked
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					// we try to evaluate the text from the text screen
					// using eval function from Evaluation.java
					double x = Evaluation.eval(txtScreen.getText());
					
					if(x == (1.0/0.0) || x ==(-1.0/0.0) || x == (0.0/0.0)) {
						// just forbidding the division by 0 as it is Infinity in Java
						outputScreen.setText("Division by 0 is NOT  allowed.");
					}
					else {
						// if it works then it is printed on the screen
						outputScreen.setText("Answer: \n\n" + Double.toString(x));

					}
				} catch (Exception e1) {
					// catching any exception
					// printing it on the screen
					// and console
					outputScreen.setText("Invalid Input, Please Try Again!");	
					outputScreen.append("\n"+e1.getMessage());
					//e1.printStackTrace();
				}
				
			}
		});
		
		
		createButtons(); // method that creates buttons
		
		createActionListeners(); // method that creates  Action Listeners that add numbers
		
		addObjectsToScreen(); // method that adds objects to screen
		
	
		
		frame.setVisible(true); // this goes after adding elements
		// so it repaints normally
		
	}
	private void addObjectsToScreen() {
		//adds everything to the screen
		frame.add(txtScreen);
		frame.add(outputScreen);
		frame.add(clears);
		frame.add(equals);
		frame.add(button0);
		frame.add(button1);
		frame.add(button2);
		frame.add(button3);
		frame.add(button4);
		frame.add(button5);
		frame.add(button6);
		frame.add(button7);
		frame.add(button8);
		frame.add(button9);
		frame.add(divideButton);
		frame.add(multiplyButton);
		frame.add(addButton);
		frame.add(subtractButton);
		frame.add(powerOf);
		frame.add(root);
		frame.add(parenthesis_left);
		frame.add(parenthesis_right);
		frame.add(back);
		frame.setIconImage(image.getImage());
	}

	private void createButtons() {
		
		// creates buttons
		// it is here to make the program more readable
		
			//button 0;
			button0.setSize(110,60);
			button0.setLocation(25,415);
			
			// button 1;
			button1.setSize(110,60);
			button1.setLocation(25,350);
			
			// button 2;
			button2.setSize(110,60);
			button2.setLocation(137,350);

			// button 3;
			button3.setSize(110,60);
			button3.setLocation(249,350);
			
			// button 4;
			button4.setSize(110,60);
			button4.setLocation(25,285);

			// button 5;
			button5.setSize(110,60);
			button5.setLocation(137,285);

			// button 6;
			button6.setSize(110,60);
			button6.setLocation(249,285);
		
			// button 7;
			button7.setSize(110,60);
			button7.setLocation(25,220);

			// button 8;
			button8.setSize(110,60);
			button8.setLocation(137,220);

			//button 9;
			button9.setSize(110,60);
			button9.setLocation(249,220);
			
			//button clear
			clears.setSize(110,60);
			clears.setLocation(249, 155);
			
			// button divide
			divideButton.setSize(110,50);
			divideButton.setLocation(361,205);
			
			// multiply button
			multiplyButton.setSize(110,50);
			multiplyButton.setLocation(361,260);
			
			// addition button
			addButton.setSize(110,50);
			addButton.setLocation(361,370);
			
			// subtract button
			subtractButton.setSize(110,50);
			subtractButton.setLocation(361,315);	
			
			//to the power of
			powerOf.setSize(110,60);
			powerOf.setLocation(137,155);
			
			// square root button
			root.setSize(110,60);
			root.setLocation(25,155);
			
			// ( button
			parenthesis_left.setSize(110,60);
			parenthesis_left.setLocation(137,415);
			
			// ) button
			parenthesis_right.setSize(110,60);
			parenthesis_right.setLocation(249,415);
			
			// back button
			back.setSize(110,45);
			back.setLocation(361,155);
			
			// image
			image1.setSize(50,50);
			image1.setLocation(9,299);
			
	}

	private void createActionListeners() {
		
		// creates action listeners that add text to screen
		// it is here to make the program more readable
		
		button9.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				txtScreen.append("9");
			}
		});
		
		
		button8.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				txtScreen.append("8");
			}
		});
		
		
		button7.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				txtScreen.append("7");
			}
		});
		
		
		button6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				txtScreen.append("6");
			}
		});
		
			button5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				txtScreen.append("5");
			}
		});
			
			button4.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					txtScreen.append("4");
				}
			});
			
			
			button3.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					txtScreen.append("3");
				}
			});
			
			
			button2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					txtScreen.append("2");
				}
			});
			
			button1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					txtScreen.append("1");
				}
			});
			
			button0.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					txtScreen.append("0");
				}
			});
			
			
			divideButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					txtScreen.append("/");
				}
			});
			
			
			multiplyButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					txtScreen.append("*");
				}
			});
			
			
			addButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					txtScreen.append("+");
				}
			});
			
			
			subtractButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					txtScreen.append("-");
				}
			});
			
			
			powerOf.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					txtScreen.append("^");
				}
			});
			
			
			root.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					txtScreen.append("Sqrt(");
				}
			});
			
			
			clears.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					txtScreen.setText("");
				}
			});
			
				parenthesis_left.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					txtScreen.append("(");
				}
			});
				
				parenthesis_right.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						txtScreen.append(")");
					}
				});
				
				
				back.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						if(txtScreen.getText().length() != 0) {
							String text = txtScreen.getText().substring(0,txtScreen.getText().length()-1);
							txtScreen.setText(text);
						}
						else {
							outputScreen.setText("There is nothing to remove!");

						}
						
					}
				});
		
	}

	public static void main(String[] args) {
		
		new Calculator(); // we call the Calculator constructor and start the program.

	}

}
