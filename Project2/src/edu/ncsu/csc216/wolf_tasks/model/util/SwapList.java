/**
 * 
 */
package edu.ncsu.csc216.wolf_tasks.model.util;

/**
 * Custom ArrayList that implements ISwapList. List allows the client to move
 * objects in the list up, down, to front, and to back. Allows for generic
 * object type E. Also has add, remove, size, and get.
 * 
 * @author anthonypulsone
 *
 * @param <E> the generic type
 */
public class SwapList<E> implements ISwapList<E> {

	/** the initial capacity of the array */
	private static final int INITIAL_CAPACITY = 10;
	/** the private array that stores the elements */
	private E[] list;
	/** the current number of elements in array */
	private int size;

	/**
	 * Constructor for SwapList. Initializes size to 0 and list to a null array with
	 * 10 elements.
	 */
	@SuppressWarnings("unchecked")
	public SwapList() {
		list = (E[]) new Object[INITIAL_CAPACITY];
		size = 0;
	}

	/**
	 * Adds the element to the end of the list.
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
		checkCapacity();
		list[size] = element;
		size++;

	}

	/**
	 * method to check ArrayList capacity and increase the size of the Array if it
	 * has reached capacity.
	 */
	private void checkCapacity() {
		if (size == list.length) {
			@SuppressWarnings("unchecked")
			E[] enlargedList = (E[]) new Object[list.length * 2];
			for (int i = 0; i < size; i++) {
				enlargedList[i] = list[i];
			}
			list = enlargedList;
		}
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
			throw new IndexOutOfBoundsException();
		}
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
		E rtn = list[idx];

		for (int i = idx; i < size - 1; i++) {
			list[i] = list[i + 1];
		}
		list[size - 1] = null;
		size--;
		return rtn;
	}

	/**
	 * Moves the element at the given index to index-1. If the element is already at
	 * the front of the list, the list is not changed.
	 * 
	 * @param idx index of element to move up
	 * @throws IndexOutOfBoundsException if the idx is out of bounds for the list
	 */
	@Override
	public void moveUp(int idx) {
		checkIndex(idx);
		if (idx != 0) {
			E temp = list[idx - 1];
			list[idx - 1] = list[idx];
			list[idx] = temp;
		}

	}

	/**
	 * Moves the element at the given index to index+1. If the element is already at
	 * the end of the list, the list is not changed.
	 * 
	 * @param idx index of element to move down
	 * @throws IndexOutOfBoundsException if the idx is out of bounds for the list
	 */
	@Override
	public void moveDown(int idx) {
		checkIndex(idx);
		if (idx != size() - 1) {
			E temp = list[idx + 1];
			list[idx + 1] = list[idx];
			list[idx] = temp;
		}
	}

	/**
	 * Moves the element at the given index to index 0. If the element is already at
	 * the front of the list, the list is not changed.
	 * 
	 * @param idx index of element to move to the front
	 * @throws IndexOutOfBoundsException if the idx is out of bounds for the list
	 */
	@Override
	public void moveToFront(int idx) {
		checkIndex(idx);
		if (idx != 0) {
			E temp = remove(idx);
			for (int i = size - 1; i >= 0; i--) {
				list[i + 1] = list[i];
			}
			list[0] = temp;
			size++;
		}

	}

	/**
	 * Moves the element at the given index to size-1. If the element is already at
	 * the end of the list, the list is not changed.
	 * 
	 * @param idx index of element to move to the back
	 * @throws IndexOutOfBoundsException if the idx is out of bounds for the list
	 */
	@Override
	public void moveToBack(int idx) {
		checkIndex(idx);
		if (idx != size() - 1) {
			E temp = remove(idx);
			add(temp);
		}
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
		return list[idx];
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

}
