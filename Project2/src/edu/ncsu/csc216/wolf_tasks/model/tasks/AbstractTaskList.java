package edu.ncsu.csc216.wolf_tasks.model.tasks;

import edu.ncsu.csc216.wolf_tasks.model.util.ISwapList;

/**
 * AbstractTaskList class is an abstract class at the top of the hierarchy for
 * task lists. The AbstractTaskList knows its taskListName, the ISwapList of
 * Tasks, and the number of completed tasks. This class is to be extended by
 * ActiveTaskList and TaskList
 * 
 * @author anthonypulsone
 *
 */
public abstract class AbstractTaskList {

	/** The name of the task list */
	private String taskListName;
	/** the count of completed tasks in the task list */
	private int completedCount;
	/** ISwapList containing all the tasks in the task list */
	private ISwapList<Task> tasks;

	/**
	 * Sets the fields from the parameters and constructs a SwapList for the Tasks.
	 * An IAE is thrown with the message “Invalid name.” if the taskListName is null
	 * or empty string. An IAE is thrown with the message “Invalid completed count.”
	 * if the completedCount is less than zero.
	 * 
	 * @param name  the name of the TaskList
	 * @param count the number of completed tasks in the TaskList
	 */
	public AbstractTaskList(String name, int count) {

	}

	/**
	 * Getter to return the taskListName field
	 * 
	 * @return the name of the TaskList as a String
	 */
	public String getTaskListName() {
		return null;
	}

	/**
	 * Setter for the taskListName field.
	 * 
	 * @param name the name that the TaskList is being set to
	 */
	public void setTaskListName(String name) {

	}

	/**
	 * Getter method to return the ISwapList of Tasks for the TaskList
	 * 
	 * @return ISwapList containing all the tasks in the task list
	 */
	public ISwapList<Task> getTasks() {
		return null;

	}

	/**
	 * Getter method to return the number of completed Tasks for the TaskList
	 * 
	 * @return the count of completed tasks in the task list
	 */
	public int getCompletedCount() {
		return 0;
	}

	/**
	 * Adds the Task to the end of the list. The current instance of the TaskList
	 * adds itself to the Task (uses the keyword this).
	 * 
	 * @param task the Task being added to the TaskList
	 */
	public void addTask(Task task) {

	}

	/**
	 * Removes the Task from the list of tasks by using the and returns the removed
	 * task.
	 * 
	 * @param idx index of the Task that is to be removed
	 * @return the removed Task
	 */
	public Task removeTask(int idx) {
		return null;
	}

	/**
	 * Returns the Task at the given index.
	 * 
	 * @param idx the index of the task that is to be returned
	 * @return the Task object at the index
	 */
	public Task getTask(int idx) {
		return null;
	}

	/**
	 * Finds the given Task in the list and removes it. The completedCount is
	 * incremented. To compare Tasks use ==! In this case, we want to compare that
	 * the Tasks are the same object.
	 * 
	 * @param task the task that is to be completed
	 */
	public void completeTask(Task task) {

	}

	/**
	 * An abstract method that returns a 2D String array representation of the Tasks
	 * in the TaskList.
	 * 
	 * @return the 2D String array of the tasks in the TaskList
	 */
	public abstract String[][] getTasksAsArray();
}
