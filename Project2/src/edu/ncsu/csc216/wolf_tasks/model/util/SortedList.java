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
	private E front;
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
	 * Adds the element to the list in sorted order.
	 * 
	 * @param element element to add
	 * @throws NullPointerException     if element is null
	 * @throws IllegalArgumentException if element cannot be added
	 */
	@Override
	public void add(E element) {
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Returns true if the element is in the list.
	 * 
	 * @param element element to search for
	 * @return true if element is found
	 */
	@Override
	public boolean contains(E element) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Returns the number of elements in the list.
	 * 
	 * @return number of elements in the list
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
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
