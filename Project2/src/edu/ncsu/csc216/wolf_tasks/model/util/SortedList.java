package edu.ncsu.csc216.wolf_tasks.model.util;



/**
 * Custom LinkedList that implements the ISortedList interface. List maintains
 * sorted order by always adding in the correct position. Contains
 * 
 * @author anthonypulsone
 *
 * @param <E> the generic type
 */
public class SortedList<E extends Comparable<E>> implements ISortedList<E> {

	/** reference to the front LinkedNode of the LinkedList */
	private ListNode front;
	/** the number of elements stored in LinkedNodes */
	private int size;

	/**
	 * Constructor for SortedList. Initializes size to 0 and the front reference to
	 * null.
	 */
	public SortedList() {
		this.size = 0;
		this.front = null;
	}

	/**
	 * Private helper method that checks that the index is in bounds
	 * 
	 * @param idx the index being checked for legality of bounds
	 * @throws IndexOutOfBoundsException if index is greater than or equal to size
	 *                                   or less than 0
	 */
	private void checkIndex(int idx) {
		if (idx < 0 || idx >= size()) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}
	}
	
	/**
	 * Adds the element to the list in sorted order.
	 * 
	 * @param element element to add
	 * @throws NullPointerException     if element is null
	 * @throws IllegalArgumentException if element cannot be added
	 */
	@Override
	public void add(E element) {
		if (element == null) {
			throw new NullPointerException();
		}
		if (contains(element)) {
			throw new IllegalArgumentException("Cannot add duplicate element");
		}
		if (front == null) {
			front = new ListNode(element);
		} else if (element.compareTo(front.data) <= 0) {
			front = new ListNode(element, front);
		} else {
			ListNode current = front;
			while(current.next != null && current.next.data.compareTo(element) <= 0) {
				current = current.next;
			}
			current.next = new ListNode(element, current.next);
		}
		size++;
	}

	/**
	 * Returns the element from the given index. The element is removed from the
	 * list.
	 * 
	 * @param idx index to remove element from
	 * @return element at given index
	 * @throws IndexOutOfBoundsException if the idx is out of bounds for the list
	 */
	@Override
	public E remove(int idx) {
		checkIndex(idx);
		E value = null;
		if (idx == 0) { // special case where removing front of list
			value = front.data;
			front = front.next;
		} else {
			// removing elsewhere 
			ListNode current = front;
			for (int i = 0; i < idx - 1; i++) {
				current = current.next;
			}
			value = current.next.data;
			current.next = current.next.next;
		}
		size--;
		return value;
	}

	/**
	 * Returns true if the element is in the list.
	 * 
	 * @param element element to search for
	 * @return true if element is found
	 */
	@Override
	public boolean contains(E element) {
		if (element == null || front == null) {
			return false;
		}
		if (front.data.equals(element)) { // check if front contains the element
			return true;
		} else { // if not then we will iterate through the nodes 
			ListNode current = front;
			while (current.next != null) {
				current = current.next;
				if (current.data.equals(element)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Returns the element at the given index.
	 * 
	 * @param idx index of the element to retrieve
	 * @return element at the given index
	 * @throws IndexOutOfBoundsException if the idx is out of bounds for the list
	 */
	@Override
	public E get(int idx) {
		checkIndex(idx);
		ListNode current = front;
		for (int i = 0; i < idx; i++) {
			current = current.next;
		}
		return current.data;
	}

	/**
	 * Returns the number of elements in the list.
	 * 
	 * @return number of elements in the list
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Private inner class that represents the ListNodes. Contains two constructors.
	 * Field data contains the data in the node. Next is the reference to the next
	 * node in the list.
	 * 
	 * @author anthonypulsone
	 *
	 */
	private class ListNode {
		/** The data for the ListNode */
		public E data;
		/** the reference to the next ListNode */
		public ListNode next;

		/**
		 * ListNode constructor for adding node to empty list or end of list
		 * sequentially
		 * 
		 * @param data the data that will be stored in the node
		 */
		public ListNode(E data) {
			this(data, null);
		}

		/**
		 * ListNode constructor for adding a node to the middle or front of the list
		 * when we also able to pass the reference to the next node in the list
		 * 
		 * @param data the data to be stored in the node
		 * @param next the reference to the next ListNode in the List
		 */
		public ListNode(E data, ListNode next) {
			this.data = data;
			this.next = next;
		}
	}
}
