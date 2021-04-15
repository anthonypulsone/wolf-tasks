/**
 * 
 */
package edu.ncsu.csc216.wolf_tasks.model.notebook;

import java.io.File;

import edu.ncsu.csc216.wolf_tasks.model.io.NotebookWriter;
import edu.ncsu.csc216.wolf_tasks.model.tasks.AbstractTaskList;
import edu.ncsu.csc216.wolf_tasks.model.tasks.ActiveTaskList;
import edu.ncsu.csc216.wolf_tasks.model.tasks.Task;
import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;
import edu.ncsu.csc216.wolf_tasks.model.util.ISortedList;
import edu.ncsu.csc216.wolf_tasks.model.util.SortedList;

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
	/** The default and permanent taskListName for active task lists */
	public static final String ACTIVE_TASKS_NAME = "Active Tasks";
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
		setNotebookName(name);
		taskLists = new SortedList<TaskList>();
		activeTaskList = new ActiveTaskList();
		currentTaskList = activeTaskList;
		isChanged = true;
	}

	/**
	 * Saves the current Notebook to the given file. Updates isChanged to false.
	 * 
	 * @param fileName the filename that you are saving to
	 */
	public void saveNotebook(File fileName) {
		NotebookWriter.writeNotebookFile(fileName, notebookName, taskLists);
		setChanged(false);
	}

	/**
	 * Getter to return the name of the Notebook
	 * 
	 * @return String containing the name of the Notebook
	 */
	public String getNotebookName() {
		return notebookName;
	}

	/**
	 * Setter method for the notebookName
	 * 
	 * @param name the notebookName
	 * @throws IllegalArgumentException if name is invalid
	 */
	private void setNotebookName(String name) {
		if (name == null || "".equals(name)
				|| name.toLowerCase().equals(ACTIVE_TASKS_NAME.toLowerCase())) {
			throw new IllegalArgumentException("Invalid name.");
		}
		this.notebookName = name.trim();
	}

	/**
	 * Returns whether the Notebook has been changed since last saved
	 * 
	 * @return boolean true if changed, false if not
	 */
	public boolean isChanged() {
		return isChanged;
	}

	/**
	 * Setter method for the changed field
	 * 
	 * @param change true or false boolean value depending on if has been changed
	 */
	public void setChanged(boolean change) {
		this.isChanged = change;
	}

	/**
	 * If the new TaskList’s name is "Active Tasks" or a duplicate of an existing
	 * TaskList (both case insensitive), then an IAE is thrown. Otherwise, the
	 * TaskList is added to the list of task lists, the current task list is updated
	 * to the new task list, and isChanged is updated to true.
	 * 
	 * @param taskList the TaskList that is being added
	 * @throws IllegalArgumentException if TaskList already exists
	 */
	public void addTaskList(TaskList taskList) {
		if (taskList.getTaskListName().toLowerCase().equals(ACTIVE_TASKS_NAME.toLowerCase())) {
			throw new IllegalArgumentException("Invalid name.");
		}
		for (int i = 0; i < taskLists.size(); i++) {
			if (taskList.getTaskListName().toLowerCase()
					.equals(taskLists.get(i).getTaskListName().toLowerCase())) {
				throw new IllegalArgumentException("Invalid name.");
			}
		}
		taskLists.add(taskList);
		currentTaskList = taskList;
		setChanged(true);
	}

	/**
	 * Returns a list of task list names. The “Active Tasks” is always listed first.
	 * 
	 * @return a String array of TaskList names in the Notebook
	 */
	public String[] getTaskListsNames() {
		String[] taskListNames = new String[taskLists.size() + 1];
		taskListNames[0] = activeTaskList.getTaskListName();
		for (int i = 0; i < taskLists.size(); i++) {
			taskListNames[i + 1] = taskLists.get(i).getTaskListName();
		}
		return taskListNames;
	}

	/**
	 * A private helper method that is useful for working with the ActiveTaskList.
	 * The order that Tasks are stored in the ActiveTask list is related to the
	 * order of the TaskList and then the order of the active Tasks in those
	 * TaskLists. First clears activeTaskList so we can rebuild it based on current
	 * activeTasks. Then loops through the tasks in each task list and adds them to
	 * the activeTaskList if they are active.
	 */
	private void getActiveTaskList() {
		activeTaskList.clearTasks();
		for (int i = 0; i < taskLists.size(); i++) {
			for (int j = 0; j < taskLists.get(i).getTasks().size(); j++) {
				if (taskLists.get(i).getTask(j).isActive()) {
					activeTaskList.addTask(taskLists.get(i).getTask(j));
				}
			}
		}
	}

	/**
	 * Sets the currentTaskList to the AbstractTaskList with the given name. If a
	 * TaskList with that name is not found, then the currentTaskList is set to the
	 * activeTaskList. First iterates and checks taskList names to see if the task
	 * list exists. If it is not found then the activeTaskList is set to the
	 * currentTaskList.
	 * 
	 * @param name the taskListName of the TaskList that is to be set as
	 *             currentTasklist
	 */
	public void setCurrentTaskList(String name) {
		boolean found = false;
		for (int i = 0; i < taskLists.size(); i++) {
			if (name.equals(taskLists.get(i).getTaskListName())) {
				currentTaskList = taskLists.get(i);
				found = true;
			}
		}
		if (!found) { // if didn't find list in the taskLists set to activeTaskList
			currentTaskList = activeTaskList;
		}

	}

	/**
	 * Getter method that returns the currentTaskList AbstractTaskList object
	 * 
	 * @return the current AbstractTaskList object
	 */
	public AbstractTaskList getCurrentTaskList() {
		return currentTaskList;
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
		if (currentTaskList == activeTaskList) {
			throw new IllegalArgumentException("The Active Tasks list may not be edited.");
		}
		if (name.toLowerCase().equals(ACTIVE_TASKS_NAME.toLowerCase())) {
			throw new IllegalArgumentException("Invalid name.");
		}
		for (int i = 0; i < taskLists.size(); i++) {
			if (name.toLowerCase().equals(taskLists.get(i).getTaskListName().toLowerCase())) {
				throw new IllegalArgumentException("Invalid name.");
			}
		}
		currentTaskList.setTaskListName(name);
		setChanged(true);

	}

	/**
	 * Removes the currentTaskList. An IAE is thrown if the currentTaskList is an
	 * ActiveTaskList. Then loops through the taskLists to find currentTaskList. The
	 * currentTasklist is removed and then set to the activeTaskList. isChanged is
	 * updated to true.
	 * 
	 * @throws IllegalArgumentException if currentTaskList is the ActiveTaskList
	 */
	public void removeTaskList() {
		if (currentTaskList == activeTaskList) {
			throw new IllegalArgumentException("The Active Tasks list may not be deleted.");
		}
		for (int i = 0; i < taskLists.size(); i++) {
			if (currentTaskList.getTaskListName().equals(taskLists.get(i).getTaskListName())) {
				taskLists.remove(i);
			}
		}
		currentTaskList = activeTaskList;
		setChanged(true);
	}

	/**
	 * Method to add a task to the currentTaskList. A Task can only be added
	 * directly to a TaskList. If the currentTaskList is not a TaskList nothing is
	 * done. If it is a TaskList then the the task is added. If the task is active
	 * the activeTaskList is updated. Lastly, isChanged is updated to true.
	 * 
	 * @param task the Task that is being added to the currentTaskList
	 */
	public void addTask(Task task) {
		if (currentTaskList instanceof TaskList) {
			currentTaskList.addTask(task);
			if (task.isActive()) {
				this.getActiveTaskList();
			}
			setChanged(true);
		}
	}

	/**
	 * Method to handle changes to a Task. A Task can only be edited if the
	 * currentTaskList is a TaskList; otherwise, the Task won't be changed. If the
	 * If a TaskList the fields are updated. Checks if the Task is active. If
	 * active, the activeTaskList is updated. isChanged is updated to true.
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
		if (currentTaskList instanceof TaskList) {
			Task task = currentTaskList.getTask(idx);
			task.setTaskName(taskName);
			task.setTaskDescription(taskDescription);
			task.setRecurring(recurring);
			task.setActive(active);
			if (task.isActive()) {
				this.getActiveTaskList();
			}
			setChanged(true);
		}
	}
}
