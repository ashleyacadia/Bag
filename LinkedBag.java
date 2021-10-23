package Bag;
/**
 * This class represents a bag as a double linked list of items. 
 * @author Ashley C
 *
 */
import java.util.*;

public class LinkedBag<E> extends AbstractSet<E> implements Bag<E> {
	private int numElements;
	private Node<E> firstNode;
	private Node<E> previousNode;
	public static final int FINAL_CAPACITY = 5;
/**
 * Constructor for Linked bag.
 */
	public LinkedBag() {
		super();
		numElements = 0;
		firstNode = null;
		previousNode = null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedBag newBag = new LinkedBag();
		
		newBag.add("pencil");
	}

	/**
	 * This method add an object into the bag and makes sure there is space for the new item
	 */
	@Override
	public boolean add(E item) {
		// TODO Auto-generated method stub
		{
			if (!(contains(item))) {
				Node<E> newNode = new Node<E>(item);
				// add the new node to the front of the list
				newNode.next = firstNode;
				firstNode = newNode;
				
				numElements++;
				return true;
			} else {
				return false;
			}
		}
	}
	/**
	 * This method returns a random item from the bag array
	 */
	@Override
	public E grab() {
		// TODO Auto-generated method stub
		return null;
	}
	/** 
	 * This method removes an item from the bag array.
	 */
	@Override
	public boolean remove(Object item) {
		// TODO Auto-generated method stub
		boolean found = false;
		if (firstNode != null) { // check if the element is first in list
			if ((firstNode.element == null && item == null)
					|| (firstNode.element != null && firstNode.element.equals(item))) {
				found = true;
				firstNode = firstNode.next;
				numElements--;
			} else { // check the other nodes in the list
				Node<E> previous = firstNode;
				Node<E> current = firstNode.next;
				while (current != null && !found) {
					if ((current.element == null && item == null)
							|| (current.element != null && current.element.equals(item))) {
						found = true;
						previous.next = current.next;
						numElements--;
					} else {
						previous = current;
						current = current.next;
					}
				}
			}
		}
		return found;
	}
	/**
	 * this method returns how many items are in the bag
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return numElements;
	}
	/**
	 * This method returns the amount of free space in the array to add items
	 */
	@Override
	public int capacityRemaining() {
		// TODO Auto-generated method stub
		return 0;
	}
	/**
	 * this method checks of the bag is full and returns a boolean true or false.
	 */
		@Override
		public boolean isFull() {
			// TODO Auto-generated method stub
			if (numElements==FINAL_CAPACITY) {
				return true;
			}
			return false;
		}
		/**
		 * This checks if the bag is empty.
		 */
			@Override
			public boolean isEmpty() {
				// TODO Auto-generated method stub
				if (numElements == 0) {
					return true;
				}
				return false;
			}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		firstNode = null;
		previous=null;
		   numElements = 0;

	}

	@Override
	public E[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Method which returns an iterator to 
	 * @return
	 */
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		 return new LinkedIterator<E>(firstNode);
		
	}
/**
 * Class which creates a node to use
 * @param <E>
 */
	protected class Node<E> {
		public E element;
		public Node<E> next;
		private Node<E> previous;

		public Node(E item) {
			this.element = item;
			next = null;
		}
	}
	private class LinkedIterator<E> implements Iterator<E>
	{
	   private Node<E> nextNode;
	   
	   
	   public LinkedIterator(Node<E> firstNode){  
		   nextNode = firstNode; 
	   }
	   
	   public boolean hasNext() {  
		   return (nextNode!=null);
	   }

	   public E next() throws NoSuchElementException {  
		   if (!hasNext())
	         throw new NoSuchElementException();
	      E element = nextNode.element;
	      nextNode = nextNode.next;
	      return element;
	   }

	   public void remove() throws UnsupportedOperationException { 
		   throw new UnsupportedOperationException();
	   }
	}

}
