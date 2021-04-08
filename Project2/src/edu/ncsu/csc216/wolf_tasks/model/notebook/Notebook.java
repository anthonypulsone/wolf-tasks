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
 * Class that represents the Notebook for the system. A Notebook knows its
 * activeTaskList, currentTaskList (the currently selected TaskList), and
 * taskLists(collection of task lists in the notebook). Has constructor and
 * methods handle changes such as add/remove/edits to TaskLists and the Tasks
 * within them.
 * 
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
	 * Constructs a Notebook with the given name. The taskLists field is constructed
	 * as a SortedList and the activeTaskList is constructed and is set to the
	 * currentTaskList. isChanged is initialized to true. An IAE is thrown if the
	 * notebookName is null, empty, or matches ACTIVE_TASKS_NAME.
	 * 
	 * @param name the name for the Notebook
	 * @throws IllegalArgumentException if
	 */
	public Notebook(String name) {

	}

	/**
	 * Saves the current Notebook to the given file. Updates isChanged to false.
	 * 
	 * @param fileName the filename that you are saving to
	 */
	public void saveNotebook(File fileName) {

	}

	/**
	 * Getter to return the name of the Notebook
	 * 
	 * @return String containing the name of the Notebook
	 */
	public String getNotebookName() {
		return null;
	}

	/**
	 * Setter method for the notebookName
	 * 
	 * @param name the notebookName
	 */
	private void setNotebookName(String name) {

	}

	/**
	 * Returns whether the Notebook has been changed since last saved
	 * 
	 * @return boolean true if changed, false if not
	 */
	public boolean isChanged() {
		return false;
	}

	/**
	 * Setter method for the changed field
	 * 
	 * @param changed true or false boolean value depending on if has been changed
	 */
	public void setChanged(boolean changed) {

	}

	/**
	 * If the new TaskList’s name is "Active Tasks" or a duplicate of an existing
	 * TaskList (both case insensitive), then an IAE is thrown with message “Invalid
	 * name.”. Otherwise, the TaskList is added to the list of task lists, the
	 * current task list is updated to the new task list, and isChanged is updated
	 * to true.
	 * 
	 * @param taskList the TaskList that is being added
	 * @throws IllegalArgumentException if TaskList already exists
	 */
	public void addTaskList(TaskList taskList) {

	}

	/**
	 * Returns a list of task list names. The “Active Tasks” is always listed first.
	 * 
	 * @return a String array of TaskList names in the Notebook
	 */
	public String[] getTaskListsNames() {
		return null;
	}

	/**
	 * A private helper method that is useful for working with the ActiveTaskList.
	 * The order that Tasks are stored in the ActiveTask list is related to the
	 * order of the TaskList and then the order of the active Tasks in those
	 * TaskLists.
	 */
	private void getActiveTaskList() {

	}

	/**
	 * Sets the currentTaskList to the AbstractTaskList with the given name. If a
	 * TaskList with that name is not found, then the currentTaskList is set to the
	 * activeTaskList.
	 * 
	 * @param name the taskListName of the TaskList that is to be set as
	 *             currentTasklist
	 */
	public void setCurrentTaskList(String name) {

	}

	/**
	 * Getter method that returns the currentTaskList AbstractTaskList object
	 * 
	 * @return the current AbstractTaskList object
	 */
	public AbstractTaskList getCurrentTaskList() {
		return null;
	}

	/**
	 * Method to edit a TaskList. An IAE is thrown if the currentTaskList is an
	 * ActiveTaskList, if the new name matches “Active Tasks” (case insensitive), or
	 * is a duplicate of the name of another TaskList (case insensitive and
	 * including if the name is the same as the list that will be renamed).
	 * isChanged is updated to true.
	 * 
	 * @param name the name of that TaskList that is going to be edited
	 * @throws IllegalArgumentException if TaskList already exists
	 */
	public void editTaskList(String name) {

	}

	/**
	 * Removes the currentTaskList. An IAE is thrown if the currentTaskList is an
	 * ActiveTaskList with the message “The Active Tasks list may not be deleted.”.
	 * Otherwise, the currentTaskList is removed and then set to the activeTaskList.
	 * isChanged is updated to true.
	 * 
	 * @throws IllegalArgumentException if currentTaskList is the ActiveTaskList
	 */
	public void removeTaskList() {

	}

	/**
	 * Method to add a task to the currentTaskList. A Task can only be added
	 * directly to a TaskList. If the currentTaskList is not a TaskList do nothing
	 * with the Task. If the currentTaskList is a TaskList, then add the task and
	 * check if the Task is active. If so, then you can update the activeTaskList
	 * isChanged is updated to true.
	 * 
	 * @param task the Task that is being added to the currentTaskList
	 */
	public void addTask(Task task) {

	}

	/**
	 * Method to handle changes to a Task. A Task can only be edited if the
	 * currentTaskList is a TaskList; otherwise, the Task won't be changed. If the
	 * Task can be edited, update the fields of the Task at the specified index.
	 * Checks if the Task is active. If so, then you can update the activeTaskList.
	 * This is a place where the helper method getActiveTaskList() can be helpful.
	 * isChanged is updated to true.
	 * 
	 * @param idx             the index of the Task that is being edited
	 * @param taskName        String containing the name of the task
	 * @param taskDescription String containing the description of the task
	 * @param recurring       boolean representing whether or not the task is
	 *                        recurring
	 * @param active          boolean representing whether the task is currently
	 *                        active
	 */
	public void editTask(int idx, String taskName, String taskDescription, boolean recurring,
			boolean active) {

	}
}
