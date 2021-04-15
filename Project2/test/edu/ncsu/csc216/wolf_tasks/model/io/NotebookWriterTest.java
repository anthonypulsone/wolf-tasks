/**
 * 
 */
package edu.ncsu.csc216.wolf_tasks.model.io;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;

import edu.ncsu.csc216.wolf_tasks.model.notebook.Notebook;
import edu.ncsu.csc216.wolf_tasks.model.tasks.Task;
import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;

/**
 * Test class for NotebookWriter
 * 
 * @author anthonypulsone
 *
 */
public class NotebookWriterTest {

	/**
	 * Test method for {@link edu.ncsu.csc216.wolf_tasks.model.io.NotebookWriter#writeNotebookFile(java.io.File, java.lang.String, edu.ncsu.csc216.wolf_tasks.model.util.ISortedList)}.
	 */
	@Test
	public void testWriteNotebookFile() {
		Notebook n = new Notebook("Test Notebook");
		TaskList tl1 = new TaskList("Test TL1", 0);
		n.addTaskList(tl1);
		TaskList tl2 = new TaskList("Test TL2", 0);
		n.addTaskList(tl2);
		Task t1 = new Task("Task 1", "description\nblababadfsdf ", true, true);
		Task t2 = new Task("Task 2", "descrip fdsfsadfa", false, true);
		Task t3 = new Task("Task 3", "- adfssdf\nasdfasdf", false, true);
		n.addTask(t2);
		n.addTask(t3);
		n.setCurrentTaskList("Test TL1");
		n.addTask(t1);
		n.saveNotebook(new File("test-files/ActualWriteNotebookTest.txt"));
		assertFalse(n.isChanged());
		checkFiles("test-files/ExpectedWriteNotebookTest.txt", "test-files/ActualWriteNotebookTest.txt");
	}
	
	/**
	 * Helper method to compare two files for the same contents
	 * 
	 * @param expFile expected output
	 * @param actFile actual output
	 */
	private void checkFiles(String expFile, String actFile) {
		try (Scanner expScanner = new Scanner(new FileInputStream(expFile));
				Scanner actScanner = new Scanner(new FileInputStream(actFile));) {

			while (expScanner.hasNextLine()) {
				assertEquals(expScanner.nextLine(), actScanner.nextLine());
			}

			expScanner.close();
			actScanner.close();
		} catch (IOException e) {
			fail("Error reading files.");
		}
	}
}
