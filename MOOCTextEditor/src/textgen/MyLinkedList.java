package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		size = 0;
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		head.next = tail;
		tail.prev = head;
		
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		
		if (element == null) {
			throw new NullPointerException("Invalid input");
		}
		
		// TODO: Implement this method
		LLNode<E> addNode = new LLNode<E>(element);
		LLNode<E> prev = tail.prev;
		prev.next = addNode;
		addNode.prev = prev;
		addNode.next = tail;
		tail.prev = addNode;
		size++;
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		
		LLNode<E> node = head.next;
		while (index > 0) {
			node = node.next;
			index--;
		}

		return node.data;
		
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		
		if (element == null) {
			throw new NullPointerException("Invalid input");
		}
		
		if ((index < 0 || index > size - 1) && (index != 0 || size != 0)) {
			throw new IndexOutOfBoundsException("Invalid input");
		}
		
		LLNode<E> addNode = new LLNode<E>(element);
		LLNode<E> indexNode = head;
		for (int i = 0; i <= index; i++) {
			indexNode = indexNode.next;
		}
		
		LLNode<E> prev = indexNode.prev;
		prev.next = addNode;
		addNode.prev = prev;
		addNode.next = indexNode;
		indexNode.prev = addNode;
		size++;
		
		// TODO: Implement this method
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		
		
		LLNode<E> remNode = head.next;
		while (index > 0) {
			remNode = remNode.next;
			index--;
		}
		
		
		remNode.next.prev = remNode.prev;
		remNode.prev.next = remNode.next;
		size--;
		return remNode.data;
		//works
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		
		if (index < 0 || index > size - 1) {
			throw new IndexOutOfBoundsException("Invalid input");
		}
		
		if (element == null) {
			throw new NullPointerException("Invalid input");
		}
		
		LLNode<E> setnode = head;
		for (int i = 0; i <= index; i++) {
			setnode = setnode.next;
		}
		setnode.data = element;
		
		// TODO: Implement this method
		return element;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
