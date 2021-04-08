package edu.ncsu.csc216.wolf_tasks.model.tasks;

import edu.ncsu.csc216.wolf_tasks.model.util.ISwapList;

/**
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
	 * @param name
	 * @param count
	 */
	public AbstractTaskList(String name, int count) {

	}

	/**
	 * @return
	 */
	public String getTaskListName() {
		return null;
	}

	/**
	 * 
	 */
	public void setTaskListName(String name) {

	}

	/**
	 * @return
	 */
	public ISwapList<Task> getTasks() {
		return null;

	}

	/**
	 * @return
	 */
	public int getCompletedCount() {
		return 0;
	}

	/**
	 * @param task
	 */
	public void addTask(Task task) {

	}

	/**
	 * @param idx
	 * @return
	 */
	public Task removeTask(int idx) {
		return null;
	}

	/**
	 * @param idx
	 * @return
	 */
	public Task getTask(int idx) {
		return null;
	}

	/**
	 * @param task
	 */
	public void completeTask(Task task) {

	}

	/**
	 * @return
	 */
	public abstract String[][] getTasksAsArray();
}
