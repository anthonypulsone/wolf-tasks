/**
 * 
 */
package edu.ncsu.csc216.wolf_tasks.model.io;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import edu.ncsu.csc216.wolf_tasks.model.tasks.AbstractTaskList;
import edu.ncsu.csc216.wolf_tasks.model.tasks.Task;
import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;
import edu.ncsu.csc216.wolf_tasks.model.util.ISortedList;
import edu.ncsu.csc216.wolf_tasks.model.util.ISwapList;


/**
 * Class to write the Notebook to a txt file. Contains one method,
 * writeNotebookFile().
 * 
 * @author anthonypulsone
 *
 */
public class NotebookWriter {

	/**
	 * Receives a File with the file name to write to, the name of the notebook, and
	 * a ISortedList of TaskLists to write to file. NotebookWriter uses Task’s
	 * toString() method to create the properly formatted output for a Task. If
	 * there are any errors or exceptions, an IllegalArgumentException is thrown
	 * with the message “Unable to save file.”
	 * 
	 * @param file         the file that is being written to
	 * @param notebookName the name of the Notebook
	 * @param taskLists    the list of TaskLists in the Notebook to be Written
	 * @throws IllegalArgumentException if there are errors
	 */
	public static void writeNotebookFile(File file, String notebookName,
			ISortedList<TaskList> taskLists) {
		try {
			PrintStream fileWriter = new PrintStream(file);
			fileWriter.println("! " + notebookName);
				for (int i = 0; i < taskLists.size(); i++) {
					AbstractTaskList current = taskLists.get(i);
					ISwapList<Task> currentTasks = current.getTasks();
				
					fileWriter.println("# " + current.getTaskListName() + "," + current.getCompletedCount());
					
					for (int j = 0; j < currentTasks.size(); j++)
					fileWriter.println(currentTasks.get(j).toString());
				}
			fileWriter.close();
		} catch (IOException e) {
			throw new IllegalArgumentException("Unable to save file.");
		}
	}
}
