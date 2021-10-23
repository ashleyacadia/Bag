package Bag;

/**
 * This class represents a bag as an array of items inside it. 
 * @author Ashley C 
 *
 */

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ArrayBag<E> implements Bag<Object>{
	private Object []items;
	private int numItems;
	public static final int FINAL_CAPACITY = 5;
/**
 * class constructor for no input given by user
 */
	public ArrayBag() {
		this.items = new Object[FINAL_CAPACITY];
		this.numItems = 0;
	}
/**
 * Class constructor for input given by user for size of bag
 * @param size
 */
	public ArrayBag(int size) {
		System.out.println(size);
		if (size <= 0) {
			throw new IllegalArgumentException("Size must be more than 0");
		} else {
		this.items = new Object[size];
		this.numItems = 0;
		}
	}
/**
 * this method returns how many items are in the bag
 */
	@Override
	public int size() {
		return this.numItems;
	}
/**
 * This method add an object into the bag and makes sure there is space for the new item
 */
	@Override
	public boolean add(Object item) {
		if(item == null) {
			throw new IllegalArgumentException("item must not be null");
		} else if (this.numItems == this.items.length) {
			return false;
		} else {
			this.items[this.numItems]=item;
			this.numItems++;
			return true;
		}
	}
/**
 * This method returns a random item from the bag array
 */
	@Override
	public Object grab() {
		// TODO Auto-generated method stub
		if(this.numItems==0) {
			throw new IllegalStateException("No items in bag");
		}
		int randItem = (int)(Math.random()*this.numItems);
				return this.items[randItem];
	}
/** 
 * This method removes an item from the bag array.
 */
	@Override
	public boolean remove(Object item) {
		// TODO Auto-generated method stub
		for (int i = 0; i < this.numItems; i++) {
			if (this.items[i].equals(item)) {
				for (int j = i; j < this.numItems - 1; j++) {
					this.items[j] = this.items[j + 1];
				}
				this.items[this.numItems - 1] = null;
				this.numItems--;
				return true;
			}
		}
		return false;

	}
/**
 * This method returns the amount of free space in the array to add items
 */
	@Override
	public int capacityRemaining() {
		// TODO Auto-generated method stub
		int remaining = FINAL_CAPACITY - numItems;
		return remaining;
	}
/**
 * this method checks of the bag is full and returns a boolean true or false.
 */
	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		if (numItems==FINAL_CAPACITY) {
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
		if (numItems == 0) {
			return true;
		}
		return false;
	}
/**
 * This method clears all items in the bag
 */
	@Override
	public void clear() {
		this.items=null;
		// TODO Auto-generated method stub

	}
/**
 * Method which returns an iterator to 
 * @return
 */
	//@Override
	public ArrayIterator<E> iterator() {
		
		return new ArrayIterator<E>(items, numItems) ;
	}
	
	  private class ArrayIterator<E> implements Iterator<E>
	   {
	      private int numElements; 
	      private E[] elements; 
	      private int nextIndex;
	      
	      public ArrayIterator(Object[] items, int numElements)
	      {  if (numElements > items.length)
	            numElements = items.length;
	         this.numElements = numElements;
	         this.elements = (E[]) items;
	         nextIndex = 0;
	      }
	     
	      public boolean hasNext()
	      {  return (nextIndex<numElements);
	      }
	      
	      public E next() throws NoSuchElementException
	      {  if (!hasNext())
	            throw new NoSuchElementException();
	         return elements[nextIndex++];
	      }
	      
	      public void remove() throws UnsupportedOperationException
	      {  throw new UnsupportedOperationException();
	      }
	   }

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		Object[] copy = new Object[this.numItems];
				for(int x=0;x<this.numItems;x++) {
					copy[x] = this.items[x];
				}
		return copy;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		System.out.println("[New Empty Bag]");
		System.out.println("Please enter the bag's capacity of items: ");
		int capacity = scan.nextInt();
		ArrayBag<Object> newBag = new ArrayBag<Object>(capacity);
		scan.hasNextLine();
		System.out.println("Spots remaining: " + newBag.capacityRemaining());
		
		for (int counter = 1; counter < newBag.items.length+1; counter++) {
			scan.hasNextLine();
          System.out.print("item [" + counter + "] : ");
            newBag.add(scan.nextLine());
            scan.hasNextLine();
        }
		scan.close();
		
		Object item = newBag.grab();
		System.out.println("You grabbed "+item+" ");
		
		System.out.println( newBag.capacityRemaining()+" spots remaining in your bag for items");
		
		System.out.println("Removing an item...");
		newBag.remove(newBag.grab());
		System.out.println("Number of items now in bag: "+newBag.size());
		
		
		
		
		
		

		

	}

}
