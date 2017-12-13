/**
 *
 * file: BingBong.java
 * @author Gabe Le
 * 
 * This is the main file which starts up the Applet.
 * 
 */

import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

/*
 ***************************************************
 *
 * Start of Program2 class
 * 
 ***************************************************
 */
public class BingBong extends Applet 
					implements ActionListener {

	private Button Reset, Slower, Faster, Throw, Remove;
	private BallDemo myShape;
//--------------------------------------------------

	
/*
 **************************************************
 *
 * Runs as soon as the Applet is initialized.
 * It also creates the buttons needed to interact
 *  with the collection of balls.
 * 
 **************************************************
 */
	public void init()  {
		myShape = new BallDemo(this);				// We instantiate the "timer"
		
// Creating the buttons
		Reset = new Button("Reset");
		add(Reset);
		Reset.addActionListener(this);

		Slower = new Button("Slower");
		add(Slower);
		Slower.addActionListener(this);
		
		Faster = new Button("Faster");
		add(Faster);
		Faster.addActionListener(this);
		
		Throw = new Button("Throw");
		add(Throw);
		Throw.addActionListener(this);
		
		Remove = new Button("Remove");
		add(Remove);
		Remove.addActionListener(this);
	}
//--------------------------------------------------


/*
 ***************************************************
 * 
 * The paint method refreshes the Applet.
 *  
 ***************************************************
 */
	public void paint(Graphics pane) {
// setting the interface elements
		setBackground(Color.pink);		
		setSize(800, 600);
		
		if (myShape != null)
			myShape.paint(pane);
	}
//--------------------------------------------------	
	
	
/*
 *************************************************** 
 * 
 * Checks which button initialized in init() is pressed 
 *  and does the appropriate action.
 *
 ***************************************************
 */
	public void actionPerformed(ActionEvent e) {
		try {
			if(e.getSource() == Reset) {
				myShape.resetIsPressed();
			}
			
			else if(e.getSource() == Slower) {
				myShape.slowerIsPressed();
			}
			
			else if(e.getSource() == Faster) {
				myShape.fasterIsPressed();
			}
			
			else if(e.getSource() == Throw) {
				myShape.throwIsPressed(true);
			}
			
			else if(e.getSource() == Remove) {
				myShape.removeIsPressed();
			}
		}
		catch(CollectionException Problem) {
			System.out.println("Collection is empty");
		}
	}		
//--------------------------------------------------

}	

// end Program2.java