/**
 * 
 */
package edu.ncsu.csc216.wolf_tasks.model.tasks;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test class for Task
 * 
 * @author anthonypulsone
 *
 */
public class TaskTest {

	/**
	 * Test method for {@link edu.ncsu.csc216.wolf_tasks.model.tasks.Task#Task(java.lang.String, java.lang.String, boolean, boolean)}.
	 */
	@Test
	public void testTask() {
		Task task = new Task("Walk Dog", "Walk Fluffy to the dog park", false, false);
		
		assertEquals("Walk Dog", task.getTaskName());
		assertEquals("Walk Fluffy to the dog park", task.getTaskDescription());
		assertFalse(task.isActive());
		assertFalse(task.isRecurring());
		
		Task task2 = new Task("Exercise", "Go for a run at the greenway", true, true);
		assertEquals("Exercise", task2.getTaskName());
		assertEquals("Go for a run at the greenway", task2.getTaskDescription());
		assertTrue(task2.isActive());
		assertTrue(task2.isRecurring());
		
		Task task3 = null;
		try {
			task3 = new Task(null, "Go for a run at the greenway", true, true);
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(task3);
			assertEquals("Incomplete task information.", e.getMessage());
		}
		
		Task task4 = null;
		try {
			task4 = new Task("Walk Dog", null, true, true);
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(task4);
			assertEquals("Incomplete task information.", e.getMessage());
		}
		
	}

	
	/**
	 * Test method for {@link edu.ncsu.csc216.wolf_tasks.model.tasks.Task#getTaskListName()}.
	 */
	@Test
	public void testGetTaskListName() {
		Task task = new Task("Walk Dog", "Walk Fluffy to the dog park", false, false);
		// empty taskLists
		assertEquals("Walk Dog", task.getTaskName());
		assertEquals("Walk Fluffy to the dog park", task.getTaskDescription());
		assertFalse(task.isActive());
		assertFalse(task.isRecurring());
		
		assertEquals("", task.getTaskListName());
		// test with TaskList in taskLists
		// TaskList tl = new TaskList("Nam")
		// task.addTaskList(tl);
		
		// test with multiple TaskLists in taskLists
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.wolf_tasks.model.tasks.Task#addTaskList(edu.ncsu.csc216.wolf_tasks.model.tasks.AbstractTaskList)}.
	 */
	@Test
	public void testAddTaskList() {
		Task task = new Task("Walk Dog", "Walk Fluffy to the dog park", false, false);
		// Try to add null task list catch IAE
		try {
			task.addTaskList(null);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("", task.getTaskListName());
		}
	}
//
//	/**
//	 * Test method for {@link edu.ncsu.csc216.wolf_tasks.model.tasks.Task#completeTask()}.
//	 */
//	@Test
//	public void testCompleteTask() {
//		// non recurring
//		Task task = new Task("Walk Dog", "Walk Fluffy to the dog park", false, false);
//		task.completeTask();
//		// recurring
//		Task task2 = new Task("Exercise", "Go for a run at the greenway", true, true);
//		task2.completeTask();
//		
//	}

	/**
	 * Test method for {@link edu.ncsu.csc216.wolf_tasks.model.tasks.Task#clone()}.
	 */
	@Test
	public void testClone() {
		Task task = new Task("Walk Dog", "Walk Fluffy to the dog park", false, false);
		// try task with no TaskList
		Task clone = null;
		try {
			clone = (Task) task.clone();
			fail();
		} catch (CloneNotSupportedException e) {
			assertNull(clone);
		}
		
		// task with TaskList
		
		// task with multiple TaskLists
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.wolf_tasks.model.tasks.Task#toString()}.
	 */
	@Test
	public void testToString() {
		Task task = new Task("Walk Dog", "Walk Fluffy to the dog park", false, false);
		assertEquals("* Walk Dog\nWalk Fluffy to the dog park", task.toString());
		task.setActive(true);
		assertEquals("* Walk Dog,active\nWalk Fluffy to the dog park", task.toString());
		task.setRecurring(true);
		assertEquals("* Walk Dog,recurring,active\nWalk Fluffy to the dog park", task.toString());
		task.setActive(false);
		assertEquals("* Walk Dog,recurring\nWalk Fluffy to the dog park", task.toString());
	}

}
