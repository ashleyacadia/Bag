package Bag;

//import java.util.Iterator;

public interface Bag<E> {
	
	public boolean add(E item);
	public E grab();
	public boolean remove(E item);
	public int size();
	public int capacityRemaining();
	public boolean isFull();
	public boolean isEmpty();
	public void clear();
	//public Iterator<E> iterator();
	public E[] toArray();
	
}
