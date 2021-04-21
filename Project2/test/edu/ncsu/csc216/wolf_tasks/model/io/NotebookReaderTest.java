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
		
		NotebookReader reader = new NotebookReader();
		
		assertNotNull(reader);
		
		Notebook n = NotebookReader.readNodebookFile(new File("test-files/notebook1.txt"));
		
		assertEquals("School", n.getNotebookName());
		assertEquals(4, n.getTaskListsNames().length);
		
		n.setCurrentTaskList("CSC 216");
		
		assertEquals("CSC 216", n.getCurrentTaskList().getTaskListName());
		
		n.setCurrentTaskList("CSC 226");
		
		assertEquals("CSC 226", n.getCurrentTaskList().getTaskListName());
		
		n.setCurrentTaskList("CSC 226");
		
		assertEquals("CSC 226", n.getCurrentTaskList().getTaskListName());

		Notebook n2 = NotebookReader.readNodebookFile(new File("test-files/notebook0.txt"));
		
		assertEquals("Summer Plans", n2.getNotebookName());
		assertEquals(1, n2.getTaskListsNames().length);
		Notebook n3 = null;
		try {
			n3 = NotebookReader.readNodebookFile(new File("test-files/notavalidfile90adje.txt"));
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Unable to load file.", e.getMessage());
			assertNull(n3);
		}
	}

}
