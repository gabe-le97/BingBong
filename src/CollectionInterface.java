/**
 * 
 * file: CollectionInterface.java
 * 
 * @author Gabe Le
 */

/**
 * This interface allows items to be added and removed from a collection of items
 * It also allows traversing the collection one item at a time,
 *  selecting each item in turn.
 * This traversal defines an implicit ordering of the items in the collection,
 *  imposed by the order in which the items were added to the collection.
 * 
 */

public interface CollectionInterface {
	
	public void add(Ball someItem);
	// Adds the given item to the collection.
	// That item becomes the item currently selected.
	
	public void remove() throws CollectionException;
	// Removes the last item from the collection
	// If there is no item then do nothing
	
	public boolean isEmpty();
	// Checks if the collection is empty or not
}
