/**
 * 
 */
package edu.ncsu.csc216.wolf_tasks.model.tasks;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test class for AbstractTaskList
 * 
 * @author anthonypulsone
 *
 */
public class TaskListTest {

	/**
	 * Test method for {@link edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList#getTasksAsArray()}.
	 */
	@Test
	public void testGetTasksAsArray() {
		TaskList tl1 = new TaskList("AA", 0);
		Task t1 = new Task("File paperwork", "File mundane paperwork", false, false);
		Task t2 = new Task("Lunch", "Lunch with coworker", false, false);
		tl1.addTask(t1);
		tl1.addTask(t2);
		
		String[][] array = tl1.getTasksAsArray();
		assertEquals("1", array[0][0]);
		assertEquals("File paperwork", array[0][1]);
		assertEquals("2", array[1][0]);
		assertEquals("Lunch", array[1][1]);
	}


	/**
	 * Test method for {@link edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList#compareTo(edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList)}.
	 */
	@Test
	public void testCompareTo() {
		TaskList tl1 = new TaskList("AA", 0);
		TaskList tl2 = new TaskList("Aba", 0);
		TaskList tl3 = new TaskList("ACZ", 0);
		assertTrue(tl2.compareTo(tl1) > 0);
		assertTrue(tl3.compareTo(tl2) > 0);
		assertTrue(tl1.compareTo(tl2) < 0);
		assertTrue(tl2.compareTo(tl3) < 0);
		
	}

}
