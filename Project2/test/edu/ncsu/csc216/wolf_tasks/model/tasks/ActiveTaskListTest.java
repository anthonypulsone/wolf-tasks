/**
 * 
 */
package edu.ncsu.csc216.wolf_tasks.model.tasks;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test class for ActiveTaskList
 * 
 * @author anthonypulsone
 *
 */
public class ActiveTaskListTest {

	/**
	 * Test method for {@link edu.ncsu.csc216.wolf_tasks.model.tasks.ActiveTaskList#setTaskListName(java.lang.String)}.
	 */
	@Test
	public void testSetTaskListName() {
		AbstractTaskList tl = new ActiveTaskList();
		try {
			tl.setTaskListName("Billy's Tasks");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Active Tasks", tl.getTaskListName());
			assertEquals("The Active Tasks list may not be edited.", e.getMessage());
		}
		try {
			tl.setTaskListName("Active Tasks");
			assertEquals("Active Tasks", tl.getTaskListName());
		} catch (IllegalArgumentException e) {
			fail();
		}
		
		
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.wolf_tasks.model.tasks.ActiveTaskList#addTask(edu.ncsu.csc216.wolf_tasks.model.tasks.Task)}.
	 */
	@Test
	public void testAddTask() {
		AbstractTaskList tl = new ActiveTaskList();
		Task t1 = new Task("File paperwork", "File mundane paperwork", false, false);
		try {
			tl.addTask(t1);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Cannot add task to Active Tasks.", e.getMessage());
			assertEquals(0, tl.getTasks().size());
		}
		Task t2 = new Task("Lunch", "Lunch with coworker", false, true);
		tl.addTask(t2);
		assertEquals(1, tl.getTasks().size());
		assertEquals("Lunch", tl.getTasks().get(0).getTaskName());
		
		
		
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.wolf_tasks.model.tasks.ActiveTaskList#getTasksAsArray()}.
	 */
	@Test
	public void testGetTasksAsArray() {
		AbstractTaskList tl1 = new ActiveTaskList();
		Task t1 = new Task("File paperwork", "File mundane paperwork", false, true);
		Task t2 = new Task("Lunch", "Lunch with coworker", false, true);
		tl1.addTask(t1);
		tl1.addTask(t2);
		
		String[][] array = tl1.getTasksAsArray();
		assertEquals("Active Tasks", array[0][0]);
		assertEquals("File paperwork", array[0][1]);
		assertEquals("Active Tasks", array[1][0]);
		assertEquals("Lunch", array[1][1]);
	}


	/**
	 * Test method for {@link edu.ncsu.csc216.wolf_tasks.model.tasks.ActiveTaskList#clearTasks()}.
	 */
	@Test
	public void testClearTasks() {
		ActiveTaskList tl1 = new ActiveTaskList();
		Task t1 = new Task("File paperwork", "File mundane paperwork", false, true);
		Task t2 = new Task("Lunch", "Lunch with coworker", false, true);
		Task t3 = new Task("Staple papers", "Staple all the papers", false, true);
		Task t4 = new Task("Meeting", "Meeting with boss", false, true);
		tl1.addTask(t1);
		tl1.addTask(t2);
		tl1.addTask(t3);
		tl1.addTask(t4);
		assertEquals(4, tl1.getTasks().size());
		tl1.clearTasks();
		assertEquals(0, tl1.getTasks().size());
		
	}

}
