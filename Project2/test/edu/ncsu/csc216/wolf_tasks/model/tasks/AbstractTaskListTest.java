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
public class AbstractTaskListTest {

	/**
	 * Test method for {@link edu.ncsu.csc216.wolf_tasks.model.tasks.AbstractTaskList#AbstractTaskList(java.lang.String, int)}.
	 */
	@Test
	public void testAbstractTaskList() {
		// invalid construction tests
		AbstractTaskList atl = null;
		try {
			atl = new TaskList(null, 3);
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(atl);
			assertEquals("Invalid name.", e.getMessage());
		}
		try {
			atl = new TaskList("School Tasks", -1);
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(atl);
			assertEquals("Invalid completed count.", e.getMessage());
		}
		// valid
		atl = new TaskList("School Tasks", 5);
		
		assertEquals("School Tasks", atl.getTaskListName());
		assertEquals(5, atl.getCompletedCount());
		assertNotNull(atl.getTasks());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.wolf_tasks.model.tasks.AbstractTaskList#addTask(edu.ncsu.csc216.wolf_tasks.model.tasks.Task)}.
	 */
	@Test
	public void testAddTask() {
		AbstractTaskList atl = new TaskList("Work", 0);
		Task t1 = new Task("File paperwork", "File mundane paperwork", false, false);
		try {
			atl.addTask(null);	
			fail();
		} catch (NullPointerException e) {
			assertEquals(0, atl.getTasks().size());
		}
		atl.addTask(t1);
		assertEquals(1, atl.getTasks().size());
		assertEquals(t1, atl.getTask(0));
		assertEquals("Work", atl.getTask(0).getTaskListName());
		
		Task t2 = new Task("Lunch", "Lunch with coworker", false, false);
		atl.addTask(t2);
		assertEquals(2, atl.getTasks().size());
		assertEquals(t2, atl.getTask(1));
		assertEquals("Work", atl.getTask(1).getTaskListName());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.wolf_tasks.model.tasks.AbstractTaskList#removeTask(int)}.
	 */
	@Test
	public void testRemoveTask() {
		AbstractTaskList atl = new TaskList("Work", 0);
		Task t1 = new Task("File paperwork", "File mundane paperwork", false, false);
		Task t2 = new Task("Lunch", "Lunch with coworker", false, false);
		atl.addTask(t1);
		atl.addTask(t2);
		
		assertEquals(t1, atl.removeTask(0));
		assertEquals(1, atl.getTasks().size());
		assertEquals(t2, atl.getTask(0));
		
		assertEquals(t2, atl.removeTask(0));
		assertEquals(0, atl.getTasks().size());
		
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.wolf_tasks.model.tasks.AbstractTaskList#completeTask(edu.ncsu.csc216.wolf_tasks.model.tasks.Task)}.
	 */
	@Test
	public void testCompleteTask() {
		AbstractTaskList atl = new TaskList("Work", 0);
		Task t1 = new Task("File paperwork", "File mundane paperwork", false, false);
		Task t2 = new Task("Lunch", "Lunch with coworker", false, false);
		atl.addTask(t1);
		atl.addTask(t2);
		
		atl.completeTask(t1);
		assertEquals(1, atl.getTasks().size());
		assertEquals(t2, atl.getTask(0));
		assertEquals(1, atl.getCompletedCount());
		
		atl.completeTask(t2);
		
		assertEquals(0, atl.getTasks().size());
		assertEquals(2, atl.getCompletedCount());
	}


}
