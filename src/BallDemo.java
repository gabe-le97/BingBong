/**
 * 
 * file: BallDemo.java
 * @author Gabe Le
 * 
 * Does the painting of the program and actually calls the 
 *  collection class & ball class to get them on the Applet screen.
 *
 */

import java.applet.*;
import java.awt.*;


/*
 **************************************************
 *
 * This is the main Applet program which handles the graphics
 * 
 **************************************************
 */
public class BallDemo
			implements AlarmListener {

// Instance variables
	private Applet theApplet;
	private Collection collection;
	private boolean running;
	private Alarm alarm;
	private int size = 25; 							// Determines the size of the ball when called
	private int delay = 0;
//--------------------------------------------------

	
/*
 ***************************************************
 * 
 * The constructor sets the scene with the buttons for the user interaction.
 * 
 **************************************************
 */
	public BallDemo() {
	}

	public BallDemo(Applet mainProgram) {
		theApplet = mainProgram;	
		collection = new Collection();
		delay = 100;

		alarm = null;						
		alarm = new Alarm("Beep", this);	
		alarm.start();
	}
//--------------------------------------------------
	
	
// Is the alarm being run? If so run the code in a loop.
	public void takeNotice() {
		if(running) {
			collection.ballTravel();				// Balls are now moving
			alarm.setPeriod(delay);			
			theApplet.repaint();					// Constantly update the Applet 
		}
	}
//--------------------------------------------------	

		
/*
 ***************************************************
 * 
 * The methods called in Program2.java which selects what to 
 *  do with the collection.
 * 
 **************************************************
 */
	public void resetIsPressed() {
		collection.reset();
		running = false;
		theApplet.repaint();
	}
	
	public void slowerIsPressed() {
		delay += 5;									// Alarm is delayed more
	}
	
	public void fasterIsPressed() {			
		delay -= 5;									// Alarm is delayed less
	}
	
	public void throwIsPressed(boolean isIt) {
// calls the takeNotice method since running is set to true
		running = isIt;
		collection.add(new Ball(size));
	}
	
	public void removeIsPressed() throws CollectionException {
		collection.remove();
	}	
//--------------------------------------------------		

	
// paint the collection of balls	
	public void paint(Graphics pane) {	
			collection.paint(pane);
			pane.setColor(Color.black);
			pane.drawLine(5, 0, 0, 695);
			pane.drawLine(0, 595, 795, 595);
			pane.drawLine(795, 0, 795, 595);
	}
//--------------------------------------------------
	
}

// end of BallDemo.java