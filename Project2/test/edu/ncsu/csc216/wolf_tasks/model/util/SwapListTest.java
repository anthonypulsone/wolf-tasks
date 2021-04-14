/**
 * 
 */
package edu.ncsu.csc216.wolf_tasks.model.util;

import static org.junit.Assert.*;

import org.junit.Test;


/**
 * Test class for SwapList
 * 
 * @author anthonypulsone
 *
 */
public class SwapListTest {


	/**
	 * Test method for {@link edu.ncsu.csc216.wolf_tasks.model.util.SwapList#add(java.lang.Object)}.
	 */
	@Test
	public void testAdd() {
		SwapList<String> list = new SwapList<String>();
		
		// invalid - add null element 
		try {
			list.add(null);
			fail();
		} catch (NullPointerException e) {
			assertEquals(0, list.size());
		}

		// valid add to empty list
		list.add("Bananas");
		assertEquals(1, list.size());
		assertEquals("Bananas", list.get(0));
		// valid add to front
		list.add("Apples");
		assertEquals(2, list.size());
		assertEquals("Bananas", list.get(0));
		assertEquals("Apples", list.get(1));
		// valid add to middle
		list.add("Orange");
		assertEquals(3, list.size());
		assertEquals("Bananas", list.get(0));
		assertEquals("Apples", list.get(1));
		assertEquals("Orange", list.get(2));
		// test that array grows properly
		list.add("Apricot");
		list.add("Grapefruit");
		list.add("Grapes");
		list.add("Guava");
		list.add("Blueberries");
		list.add("Cranberries");
		list.add("Coconuts");
		list.add("Pineapple");
		assertEquals(11, list.size());
		list.add("12");
		list.add("13");
		list.add("14");
		list.add("15");
		list.add("16");
		list.add("17");
		list.add("18");
		list.add("19");
		list.add("20");
		list.add("21");
		assertEquals(21, list.size());
		assertEquals("21", list.get(20));
		
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.wolf_tasks.model.util.SwapList#remove(int)}.
	 */
	@Test
	public void testRemove() {
		SwapList<String> list = new SwapList<String>();
		list.add("Apples");
		list.add("Orange");
		list.add("Bananas");
		list.add("Pineapple");
		// index OOBs
		try {
			list.remove(4);
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(4, list.size());
		}

		// remove end
		list.remove(3);
		assertEquals(3, list.size());
		assertEquals("Apples", list.get(0));
		assertEquals("Orange", list.get(1));
		assertEquals("Bananas", list.get(2));
		
		// remove middle
		list.remove(1);
		assertEquals(2, list.size());
		assertEquals("Apples", list.get(0));
		assertEquals("Bananas", list.get(1));
		
		// remove front
		list.remove(0);
		assertEquals(1, list.size());
		assertEquals("Bananas", list.get(0));

		// remove last
		list.remove(0);
		assertEquals(0, list.size());
		

	}

	/**
	 * Test method for {@link edu.ncsu.csc216.wolf_tasks.model.util.SwapList#moveUp(int)}.
	 */
	@Test
	public void testMoveUp() {
		SwapList<String> list = new SwapList<String>();
		list.add("Bananas");
		list.add("Apples");
		list.add("Oranges");
		list.add("Apricot");
		list.add("Grapefruit");
		list.add("Grapes");
		list.add("Guava");
		list.add("Blueberries");
		list.add("Cranberries");
		list.add("Coconuts");
		list.add("Pineapple");
		// last item in list
		list.moveUp(10);
		assertEquals(list.get(9), "Pineapple");
		assertEquals(list.get(10), "Coconuts");
		// first item in list (nothing should change);
		list.moveUp(0);
		assertEquals(list.get(0), "Bananas");
		assertEquals(list.get(1), "Apples");
		// item in middle of list
		list.moveUp(4);
		assertEquals(list.get(3), "Grapefruit");
		assertEquals(list.get(4), "Apricot");
		// second item in list
		list.moveUp(1);
		assertEquals(list.get(0), "Apples");
		assertEquals(list.get(1), "Bananas");	
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.wolf_tasks.model.util.SwapList#moveDown(int)}.
	 */
	@Test
	public void testMoveDown() {
		SwapList<String> list = new SwapList<String>();
		list.add("Bananas");
		list.add("Apples");
		list.add("Oranges");
		list.add("Apricot");
		list.add("Grapefruit");
		list.add("Grapes");
		list.add("Guava");
		list.add("Blueberries");
		list.add("Cranberries");
		list.add("Coconuts");
		list.add("Pineapple");
		// last item in list (nothing should change)
		list.moveDown(10);
		assertEquals("Coconuts", list.get(9));
		assertEquals("Pineapple", list.get(10));
		// first item in list 
		list.moveDown(0);
		assertEquals("Apples", list.get(0));
		assertEquals("Bananas", list.get(1));
		// item in middle of list
		list.moveDown(4);
		assertEquals("Apricot", list.get(3));
		assertEquals("Grapes", list.get(4));
		assertEquals("Grapefruit", list.get(5));
		// second to last item in list
		list.moveDown(9); 
		assertEquals("Pineapple", list.get(9));
		assertEquals("Coconuts", list.get(10));
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.wolf_tasks.model.util.SwapList#moveToFront(int)}.
	 */
	@Test
	public void testMoveToFront() {
		SwapList<String> list = new SwapList<String>();
		list.add("Bananas");
		list.add("Apples");
		list.add("Oranges");
		list.add("Apricot");
		list.add("Grapefruit");
		list.add("Grapes");
		list.add("Guava");
		list.add("Blueberries");
		list.add("Cranberries");
		list.add("Coconuts");
		list.add("Pineapple");
		// front to front (nothing should happen)
		list.moveToFront(0);
		assertEquals(list.get(0), "Bananas");
		assertEquals(list.get(1), "Apples");
		// 2nd to front
		list.moveToFront(1);
		assertEquals(list.get(0), "Apples");
		assertEquals(list.get(1), "Bananas");
		// middle to front
		list.moveToFront(4);
		assertEquals(list.get(0), "Grapefruit");
		assertEquals(list.get(1), "Apples");
		// back to front
		list.moveToFront(10);
		assertEquals(list.get(0), "Pineapple");
		assertEquals(list.get(1), "Grapefruit");
		assertEquals(list.get(10), "Coconuts");
		// check size is still same
		assertEquals(11, list.size());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.wolf_tasks.model.util.SwapList#moveToBack(int)}.
	 */
	@Test
	public void testMoveToBack() {
		SwapList<String> list = new SwapList<String>();
		list.add("Bananas");
		list.add("Apples");
		list.add("Oranges");
		list.add("Apricot");
		list.add("Grapefruit");
		list.add("Grapes");
		list.add("Guava");
		list.add("Blueberries");
		list.add("Cranberries");
		list.add("Coconuts");
		list.add("Pineapple");
		// back to back (nothing should happen)
		list.moveToBack(10);
		assertEquals(list.get(9), "Coconuts");
		assertEquals(list.get(10), "Pineapple");
		// 2nd to last to back
		list.moveToBack(9);
		assertEquals(list.get(9), "Pineapple");
		assertEquals(list.get(10), "Coconuts");
		// middle to back
		list.moveToBack(4);
		assertEquals(list.get(9), "Coconuts");
		assertEquals(list.get(10), "Grapefruit");
		// front to back
		list.moveToBack(0);
		assertEquals(list.get(9), "Grapefruit");
		assertEquals(list.get(10), "Bananas");
		assertEquals("Apples", list.get(0));
		
		// check size is still same
		assertEquals(11, list.size());
	}
}
