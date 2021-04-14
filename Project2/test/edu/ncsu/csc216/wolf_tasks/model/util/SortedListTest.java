/**
 * 
 */
package edu.ncsu.csc216.wolf_tasks.model.util;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test class for SortedList
 * 
 * @author anthonypulsone
 *
 */
public class SortedListTest {


	/**
	 * Test method for {@link edu.ncsu.csc216.wolf_tasks.model.util.SortedList#add(java.lang.Comparable)}.
	 */
	@Test
	public void testAdd() {
		SortedList<String> list = new SortedList<String>();
		// invalid: null
		try {
			list.add(null);
			fail();
		} catch (NullPointerException e) {
			assertEquals(0, list.size());
		}
		// valid add to empty list
		list.add("Oranges");
		assertEquals(1, list.size());
		
		assertEquals("Oranges", list.get(0));
		// valid add to front
		list.add("Berries");
		assertEquals(2, list.size());
		assertEquals("Berries", list.get(0));
		assertEquals("Oranges", list.get(1));
		// valid add to middle
		list.add("Kiwi");
		assertEquals(3, list.size());
		assertEquals("Berries", list.get(0));
		assertEquals("Kiwi", list.get(1));
		assertEquals("Oranges", list.get(2));
		// valid add to end
		list.add("Pineapple");
		assertEquals(4, list.size());
		assertEquals("Berries", list.get(0));
		assertEquals("Kiwi", list.get(1));
		assertEquals("Oranges", list.get(2));
		assertEquals("Pineapple", list.get(3));
		// valid add to front
		list.add("Apple");
		assertEquals("Apple", list.get(0));
		assertEquals("Berries", list.get(1));
		assertEquals("Kiwi", list.get(2));
		assertEquals("Oranges", list.get(3));
		assertEquals("Pineapple", list.get(4));
		list.add("Guava");
		assertEquals("Guava", list.get(2));
		
		// invalid duplicate
		try {
			list.add("Oranges");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(6, list.size());
		}
		
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.wolf_tasks.model.util.SortedList#remove(int)}.
	 */
	@Test
	public void testRemove() {
		SortedList<String> list = new SortedList<String>();
		list.add("Apples");
		list.add("Bananas");
		list.add("Oranges");
		list.add("Pineapple");
		// remove end
		list.remove(3);
		assertEquals(3, list.size());
		assertEquals("Apples", list.get(0));
		assertEquals("Bananas", list.get(1));
		assertEquals("Oranges", list.get(2));
		
		// remove middle
		list.remove(1);
		assertEquals(2, list.size());
		assertEquals("Apples", list.get(0));
		assertEquals("Oranges", list.get(1));
		
		// remove front
		list.remove(0);
		assertEquals(1, list.size());
		assertEquals("Oranges", list.get(0));

		// remove last
		list.remove(0);
		assertEquals(0, list.size());
		
		try {
			list.remove(0);
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(0, list.size());
		}
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.wolf_tasks.model.util.SortedList#contains(java.lang.Comparable)}.
	 */
	@Test
	public void testContains() {
		SortedList<String> list = new SortedList<String>();
		assertFalse(list.contains("Apples"));
		list.add("Apples");
		list.add("Bananas");
		list.add("Oranges");
		list.add("Pineapple");
		
		assertTrue(list.contains("Apples"));
		assertTrue(list.contains("Pineapple"));
		assertTrue(list.contains("Bananas"));
		assertTrue(list.contains("Oranges"));
		assertFalse(list.contains("Cheese"));
		
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.wolf_tasks.model.util.SortedList#get(int)}.
	 */
	@Test
	public void testGet() {
		SortedList<String> list = new SortedList<String>();
		list.add("Apples");
		list.add("Bananas");
		list.add("Oranges");
		list.add("Pineapple");
		
		assertEquals("Apples", list.get(0));
		assertEquals("Bananas", list.get(1));
		assertEquals("Oranges", list.get(2));
		assertEquals("Pineapple", list.get(3));
		
	}

}
