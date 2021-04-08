package edu.ncsu.csc216.wolf_tasks.model.tasks;

/**
 * The ActiveTaskList is the list of all Tasks that are marked as active in the
 * Notebook. It extends abstract TaskList and has multiple differences in
 * functionality from a regular TaskList.
 * 
 * @author anthonypulsone
 *
 */
public class ActiveTaskList extends AbstractTaskList {

	/** The default and permanent taskListName for active task lists */
	public static final String ACTIVE_TASKS_NAME = "Active Tasks";

	/**
	 * The constructor for an ActiveTaskList calls the super method with the name
	 * "Active Tasks" and 0 for the completed count.
	 */
	public ActiveTaskList() {
		super(ACTIVE_TASKS_NAME, 0);
	}

	/**
	 * Overrides the method to check that the Task is active before adding to the
	 * end of the ISwapList. If the Task is not active, an IAE is thrown with the
	 * message “Cannot add task to Active Tasks.”
	 * 
	 * @param task the Task that is being added
	 */
	@Override
	public void addTask(Task task) {

	}

	/**
	 * Overrides the method to ensure that the paramter value matches the expected
	 * name ("Active Tasks"). If so, the name is set. If not, an IAE is thrown with
	 * the message “The Active Tasks list may not be edited.”
	 * 
	 * @param name the name that taskListName is attempting to be changed to
	 * @throws IllegalArgumentException if name is other than "Active Tasks"
	 */
	@Override
	public void setTaskListName(String name) {

	}

	/**
	 * Returns a 2D String array where the first column is the name of the TaskList
	 * that the Task belongs to (or at least the TaskList at index 0) and the name
	 * of the Task.
	 * 
	 * @returns 2D Array of active Tasks in the ActiveTaskList
	 */
	@Override
	public String[][] getTasksAsArray() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Clears the ActiveTaskList of all Tasks.
	 */
	public void clearTasks() {

	}
}
