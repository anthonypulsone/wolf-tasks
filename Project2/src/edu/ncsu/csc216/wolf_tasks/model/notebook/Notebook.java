/**
 * 
 */
package edu.ncsu.csc216.wolf_tasks.model.notebook;

import java.io.File;

import edu.ncsu.csc216.wolf_tasks.model.tasks.AbstractTaskList;
import edu.ncsu.csc216.wolf_tasks.model.tasks.ActiveTaskList;
import edu.ncsu.csc216.wolf_tasks.model.tasks.Task;
import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;
import edu.ncsu.csc216.wolf_tasks.model.util.ISortedList;

/**
 * @author anthonypulsone
 *
 */
public class Notebook {
	/** the ActiveTaskList for the Notebook */
	private ActiveTaskList activeTaskList;
	/** the current TaskList for the system */
	private AbstractTaskList currentTaskList;
	/** the ISortedList of all TaskLists in the notebook */
	private ISortedList<TaskList> taskLists;
	/** the notebook name */
	private String notebookName;
	/** whether the notebook has been changed since it was last saved */
	private boolean isChanged;
	
	/**
	 * @param name
	 */
	public Notebook(String name) {
		
	}
	
	/**
	 * @param fileName
	 */
	public void saveNoteBook(File fileName) {
		
	}
	
	/**
	 * @return
	 */
	public String getNotebookName() {
		return null;
	}
	
	/**
	 * @param name
	 */
	private void setNotebookName(String name) {
		
	}
	
	/**
	 * @return
	 */
	public boolean isChanged() {
		return false;
	}
	
	/**
	 * @param changed
	 */
	public void setChanged(boolean changed) {
		
	}
	
	/**
	 * @param taskList
	 */
	public void addTaskList(TaskList taskList) {
		
	}
	
	/**
	 * @return
	 */
	public String[] getTaskListsNames() {
		return null;
	}
	
	/**
	 * 
	 */
	private void getActiveTaskList() {
		
	}
	
	/**
	 * @param name
	 */
	public void setCurrentTaskList(String name) {
		
	}
	
	/**
	 * @return
	 */
	public AbstractTaskList getCurrentTaskList() {
		return null;
	}
	
	/**
	 * @param name
	 */
	public void editTaskList(String name) {
		
	}
	
	/**
	 * 
	 */
	public void removeTaskList() {
		
	}
	
	/**
	 * @param task
	 */
	public void addTask(Task task) {
		
	}
	
	/**
	 * @param idx
	 * @param taskName
	 * @param taskDescription
	 * @param recurring
	 * @param active
	 */
	public void editTask(int idx, String taskName, String taskDescription, boolean recurring, boolean active) {
		
	}
}
