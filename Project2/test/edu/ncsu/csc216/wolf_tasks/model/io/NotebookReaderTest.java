/**
 * 
 */
package edu.ncsu.csc216.wolf_tasks.model.io;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import edu.ncsu.csc216.wolf_tasks.model.notebook.Notebook;

/**
 * Test class for Notebook Reader
 * 
 * @author anthonypulsone
 *
 */
public class NotebookReaderTest {

	/**
	 * Test method for {@link edu.ncsu.csc216.wolf_tasks.model.io.NotebookReader#readNodebookFile(java.io.File)}.
	 */
	@Test
	public void testReadNodebookFile() {
		Notebook n = NotebookReader.readNodebookFile(new File("test-files/notebook1.txt"));
		
		assertEquals("School", n.getNotebookName());
		assertEquals(4, n.getTaskListsNames().length);
		
		n.setCurrentTaskList("CSC 216");
		
		assertEquals("CSC 216", n.getCurrentTaskList().getTaskListName());
		
		n.setCurrentTaskList("CSC 226");
		
		assertEquals("CSC 226", n.getCurrentTaskList().getTaskListName());
		
		n.setCurrentTaskList("CSC 226");
		
		assertEquals("CSC 226", n.getCurrentTaskList().getTaskListName());

	}

}
