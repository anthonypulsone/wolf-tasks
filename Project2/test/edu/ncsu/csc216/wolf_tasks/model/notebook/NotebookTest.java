/**
 * 
 */
package edu.ncsu.csc216.wolf_tasks.model.notebook;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import edu.ncsu.csc216.wolf_tasks.model.tasks.Task;
import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;

/**
 * Test class for Notebook
 * 
 * @author anthonypulsone
 *
 */
public class NotebookTest {

	/**
	 * Test method for {@link edu.ncsu.csc216.wolf_tasks.model.notebook.Notebook#Notebook(java.lang.String)}.
	 */
	@Test
	public void testNotebook() {
		// test invalid construction
		Notebook n = null;
		try {
			n = new Notebook("Active Tasks");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid name.", e.getMessage());
			assertNull(n);
		}
		
		try {
			n = new Notebook(null);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid name.", e.getMessage());
			assertNull(n);
		}
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.wolf_tasks.model.notebook.Notebook#saveNotebook(java.io.File)}.
	 */
	@Test
	public void testSaveNotebook() {
		Notebook n = new Notebook("Test Notebook");
		TaskList tl1 = new TaskList("Test TL1", 0);
		n.addTaskList(tl1);
		//TaskList tl2 = new TaskList("Test TL2", 0);
		//n.addTaskList(tl2);
		Task t1 = new Task("Task 1", "Test Task 1", false, false);
		Task t2 = new Task("Task 2", "Test Task 2", false, false);
		tl1.addTask(t1);
		tl1.addTask(t2);
		n.setChanged(true);
		n.saveNotebook(new File("test-files/testSaveNotebook.txt"));
		assertFalse(n.isChanged());
		assertEquals("Test Notebook", n.getNotebookName());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.wolf_tasks.model.notebook.Notebook#addTaskList(edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList)}.
	 */
	@Test
	public void testAddTaskList() {
		Notebook n = new Notebook("Test Notebook");
		TaskList tl1 = new TaskList("Test TL1", 0);
		n.addTaskList(tl1);
		assertTrue(n.isChanged());
		//TaskList tl2 = new TaskList("Test TL2", 0);
		//n.addTaskList(tl2);
		Task t1 = new Task("Task 1", "Test Task 1", false, false);
		Task t2 = new Task("Task 2", "Test Task 2", false, false);
		tl1.addTask(t1);
		tl1.addTask(t2);
		TaskList tl2 = new TaskList("ACTIVE tasks", 0);
		// try adding TL with name "active tasks"
		try {
			n.addTaskList(tl2);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid name.", e.getMessage());
			assertEquals(2, n.getTaskListsNames().length);
		}
		// try adding duplicate tl name
		TaskList tl3 = new TaskList("Test TL1", 0);
		try {
			n.addTaskList(tl3);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid name.", e.getMessage());
			assertEquals(2, n.getTaskListsNames().length);
		}
		// add one more valid
		TaskList tl4 = new TaskList("Test TL4", 0);
		n.addTaskList(tl4);
		assertEquals(3, n.getTaskListsNames().length);
		
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.wolf_tasks.model.notebook.Notebook#getTaskListsNames()}.
	 */
	@Test
	public void testGetTaskListsNames() {
		Notebook n = new Notebook("Test Notebook");
		TaskList tl1 = new TaskList("Test TL1", 0);
		n.addTaskList(tl1);
		TaskList tl2 = new TaskList("Test TL2", 0);
		n.addTaskList(tl2);
		String[] tlNames = n.getTaskListsNames();
		assertEquals("Active Tasks", tlNames[0]);
		assertEquals("Test TL1", tlNames[1]);
		assertEquals("Test TL2", tlNames[2]);
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.wolf_tasks.model.notebook.Notebook#setCurrentTaskList(java.lang.String)}.
	 */
	@Test
	public void testSetCurrentTaskList() {
		Notebook n = new Notebook("Test Notebook");
		TaskList tl1 = new TaskList("Test TL1", 0);
		n.addTaskList(tl1);
		TaskList tl2 = new TaskList("Test TL2", 0);
		n.addTaskList(tl2);
		TaskList tl3 = new TaskList("Test TL3", 0);
		n.addTaskList(tl3);
		assertEquals("Test TL3", n.getCurrentTaskList().getTaskListName());
		n.setCurrentTaskList("Test TL1");
		assertEquals("Test TL1", n.getCurrentTaskList().getTaskListName());
		n.setCurrentTaskList("Test TL2");
		assertEquals("Test TL2", n.getCurrentTaskList().getTaskListName());
		n.setCurrentTaskList("Active Tasks");
		assertEquals("Active Tasks", n.getCurrentTaskList().getTaskListName());
		n.setCurrentTaskList("Test TL3");
		assertEquals("Test TL3", n.getCurrentTaskList().getTaskListName());
		
	}


	/**
	 * Test method for {@link edu.ncsu.csc216.wolf_tasks.model.notebook.Notebook#editTaskList(java.lang.String)}.
	 */
	@Test
	public void testEditTaskList() {
		Notebook n = new Notebook("Test Notebook");
		TaskList tl1 = new TaskList("Test TL1", 0);
		n.addTaskList(tl1);
		// try changing the active tasks
		n.setCurrentTaskList("Active Tasks");
		try {
			n.editTaskList("Task yo");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("The Active Tasks list may not be edited.", e.getMessage());
			assertEquals("Active Tasks", n.getCurrentTaskList().getTaskListName());
		}
		n.setCurrentTaskList("Test TL1");
		try {
			n.editTaskList("active TASKS");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid name.", e.getMessage());
			assertEquals("Test TL1", n.getCurrentTaskList().getTaskListName());
		}
		// set to exisiting name - other
		TaskList tl2 = new TaskList("Test TL2", 0);
		n.addTaskList(tl2);
		try {
			n.editTaskList("Test TL1");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid name.", e.getMessage());
			assertEquals("Test TL2", n.getCurrentTaskList().getTaskListName());
		}
		// set to existing name - same
		try {
			n.editTaskList("Test TL2");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid name.", e.getMessage());
			assertEquals("Test TL2", n.getCurrentTaskList().getTaskListName());
		}
		
		n.editTaskList("Cool Tasks");
		assertEquals("Cool Tasks", n.getCurrentTaskList().getTaskListName());
		assertTrue(n.isChanged());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.wolf_tasks.model.notebook.Notebook#removeTaskList()}.
	 */
	@Test
	public void testRemoveTaskList() {
		Notebook n = new Notebook("Test Notebook");
		TaskList tl1 = new TaskList("Test TL1", 0);
		n.addTaskList(tl1);
		TaskList tl2 = new TaskList("Test TL2", 0);
		n.addTaskList(tl2);
		TaskList tl3 = new TaskList("Test TL3", 0);
		n.addTaskList(tl3);
		n.removeTaskList();
		assertEquals("Active Tasks", n.getCurrentTaskList().getTaskListName());
		// invalid remove (Active Tasks = current)
		try {
			n.removeTaskList();
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("The Active Tasks list may not be deleted.", e.getMessage());
			assertEquals("Active Tasks", n.getCurrentTaskList().getTaskListName());
		}
		n.setCurrentTaskList("Test TL1");
		n.removeTaskList();
		assertEquals("Active Tasks", n.getCurrentTaskList().getTaskListName());
		String[] tls = n.getTaskListsNames();
		assertEquals("Active Tasks", tls[0]);
		assertEquals("Test TL2", tls[1]);
		assertEquals(2, tls.length);
		
		
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.wolf_tasks.model.notebook.Notebook#addTask(edu.ncsu.csc216.wolf_tasks.model.tasks.Task)}.
	 */
	@Test
	public void testAddTask() {
		Notebook n = new Notebook("Test Notebook");
		TaskList tl1 = new TaskList("Test TL1", 0);
		n.addTaskList(tl1);
		TaskList tl2 = new TaskList("Test TL2", 0);
		n.addTaskList(tl2);
		Task t1 = new Task("Task 1", "Test Task 1", false, false);
		Task t2 = new Task("Task 2", "Test Task 2", false, true);
		// try adding to Active Tasks (shouldn't add)
		n.setCurrentTaskList("Active Tasks");
		n.addTask(t1);
		assertEquals(0, n.getCurrentTaskList().getTasksAsArray().length);
		// try adding to valid Task List
		n.setCurrentTaskList("Test TL1");
		n.addTask(t1);
		assertEquals(1, n.getCurrentTaskList().getTasksAsArray().length);
		n.setCurrentTaskList("Test TL2");
		n.addTask(t2);
		assertEquals(1, n.getCurrentTaskList().getTasksAsArray().length);
		n.setCurrentTaskList("Active Tasks");
		assertEquals("Task 2", n.getCurrentTaskList().getTask(0).getTaskName());
		n.setCurrentTaskList("Test TL2");
		assertEquals("Task 2", n.getCurrentTaskList().getTask(0).getTaskName());
		
		
		
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.wolf_tasks.model.notebook.Notebook#editTask(int, java.lang.String, java.lang.String, boolean, boolean)}.
	 */
	@Test
	public void testEditTask() {
		fail("Not yet implemented");
	}

}
