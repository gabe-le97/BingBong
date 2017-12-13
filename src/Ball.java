/**
 * 
 * file: Ball.java
 * @author Gabe Le
 * 
 * Ball class to represent a bouncing ball and implement the methods
 * used to modify a ball object
 *
 *
 */


import java.awt.Color;
import java.awt.Graphics;

/*
 ***************************************************
 * 
 * Creates a ball with set variables which are then put into
 *  a collection and called by the main program.
 * 
 ***************************************************
 */
public class Ball {
	
// Instance variables of the Ball
	private int ballSize;			
	private int x;				
	private int y;				
	private double sX;		
	private double sY;			
	private double gravity = -9.8;
	private double bounce = 0.8;  // 80% for a decent bouncing ball
	
	private Color ballColor;
	
/*
 ****************************************************
 * 
 * Default constructor does nothing
 * 
 * Constructor with an integer argument creates a new ball with
 *  set values such as size and x position.
 * 
 ****************************************************
 */
	public Ball() {	
	}

	public Ball(int aSize) {
// Constructor sets all the variables to a random value
		ballSize = aSize;	
		x = (int)(1 + 800*Math.random());			
		y = (int)(1 + 600*Math.random());						
		sX = (int)(Math.random() * 45); 									// Didn't work when not multiplied
		sY = (int)(Math.random()* 45);	
// Sets a random RGB color to the Ball		
		ballColor = new Color((int) (Math.random()*255), 					// initialize ball color to random RGB value
					(int) (Math.random()*255), (int) (Math.random()*255));
	}
//--------------------------------------------------	
	
/*
 ****************************************************
 * 
 * Called by BallDemo.java which continuously redraws the Balls
 *  at a new location to make an animation.
 * 
 ****************************************************
 */
	public void draw() {
		x += sX;						// X Position is changed by speed
		y += sY;						// Y Position is changed by speed
		sY = sY - gravity;				// gravity affects the velocity during move
	}
//--------------------------------------------------	
	
	
/*
 ****************************************************
 * 
 * Checks if the Ball makes contact with any of the walls and changes their 
 *  velocity to negative in order to bounce back.
 * (coordinates are slightly less because they pass the walls with the setSize numbers in 
 *  Program2.java)
 * 
 ****************************************************
 */
	public void collision() {
		if (x <= 5 || x >= 790)	
			sX = -sX*(bounce);			
		if (y >= 585)						
			sY = -sY*(bounce);	
	}
//--------------------------------------------------	

	
/*
 ****************************************************
 * 
 * Calls the paint method that the Ball class has.
 * 
 ****************************************************
 */
	public void paint(Graphics pen) {
		pen.setColor(ballColor);
		pen.drawOval(x, y, ballSize, ballSize);
		pen.fillOval(x, y, ballSize, ballSize);
	}
//--------------------------------------------------
	
}

// end of Ball.java