/**
 * file: CollectionException.java
 * @author Gabe Le
 * 
 * Exception class which allow my remove method to throw an exception (a message)
 *
 */

public class CollectionException extends Exception{
	   public CollectionException(String msg){
		      super(msg);
		   }
}

// end of CollectionException.java