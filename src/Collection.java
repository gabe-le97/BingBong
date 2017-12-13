/**
 * 
 * file: Collection.java
 * @author Gabe Le
 * 
 * This file stores a collection of balls that will be used in
 *  Shape.java and the buttons
 *
 */

import java.awt.Graphics;

/*
 ***************************************************
 * 
 * Class which instantiates a new array to store the Balls
 * 
 ***************************************************
 */
public class Collection 
				implements CollectionInterface {
	
// Instance variables that the Collection has
	private static int arraySize = 2;					// arraySize will be shared
	private Ball[] ballArray;
	private int size; 									// tracks how many balls are in the array
//--------------------------------------------------
	
/*
 ***************************************************
 * 
 * Constructor makes a new ballArray every time a new
 *  object is made.
 * 
 ***************************************************
 */
	public Collection() {
		ballArray = new Ball[arraySize]; 
		size = 0; 
	}

/*
 ***************************************************
 * 
 * Start of the methods that need to be implemented which were
 *  declared in CollectionInterface.
 * - The methods are explained in CollectionInterface.java
 * 
 * 
 ***************************************************
 */
	public void add(Ball someBall) {
// Creates a new array with double the size for ballArray to be
		if (size >= arraySize) {
			Ball newArray[] = new Ball[arraySize*2];
			arraySize *= 2;
			for(int i = 0; i < size; i++) {
				newArray[i] = ballArray[i];
			}
			ballArray = newArray;
		}
// Adds the item to the ballArray
			ballArray[size] = someBall;
			size++; 
	}
//--------------------------------------------------
	
// Removes the last element in the ballArray
	public void remove() throws CollectionException {
		if (isEmpty()) {
			throw new CollectionException("Collection is Empty");
		}
		ballArray[--size] = null;
	}
//--------------------------------------------------

// Checks if the ballArray is empty
	public boolean isEmpty() {
		if (size == 0) 						
			return true;
		else 
			return false;
	}
//--------------------------------------------------
	
	
/*
 ***************************************************
 * 
 * Sets ballArray to null to make it an empty array and make
 *  the balls disappear when reset button is pressed
 * 
 ***************************************************
 */
	public void reset() {
// make a new empty array and set the ballArray to reset it to nothing
		for(int i = 0; i < size; i++) {
			ballArray[i] = null;		
		}
		size = 0;
	}
//--------------------------------------------------

	
/*
 ***************************************************
 * 
 * Calls the draw & collision Ball methods to keep track of
 *  when it hits the wall and keeps updating/refreshing
 * 
 ***************************************************
 */
	public void ballTravel() {
		for (int i = 0; i < size; i++) {
			ballArray[i].draw();
			ballArray[i].collision(); 
		}
	}
//--------------------------------------------------
	

/*
 ***************************************************
 * 
 * Paints each ball in ballArray continuously.
 * 
 ***************************************************
 */
	public void paint(Graphics pen) {
		for (int i = 0; i < size; i++) {
			ballArray[i].paint(pen);
		}		
	}
//--------------------------------------------------

}

// end of Collection.java