package edu.ncsu.csc216.wolf_tasks.model.tasks;

import edu.ncsu.csc216.wolf_tasks.model.util.ISwapList;
import edu.ncsu.csc216.wolf_tasks.model.util.SwapList;

/**
 * AbstractTaskList class is an abstract class at the top of the hierarchy for
 * task lists. The AbstractTaskList knows its taskListName, the ISwapList of
 * Tasks, and the number of completed tasks. This class is to be extended by
 * ActiveTaskList and TaskList.
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
	 * @throws IllegalArgumentException if count is less than 0 or taskListName is
	 *                                  null or empty
	 */
	public AbstractTaskList(String name, int count) {
		setTaskListName(name);
		if (count < 0) {
			throw new IllegalArgumentException("Invalid completed count.");
		}
		this.completedCount = count;
		tasks = new SwapList<Task>();
	}

	/**
	 * Getter to return the taskListName field
	 * 
	 * @return the name of the TaskList as a String
	 */
	public String getTaskListName() {
		return taskListName;
	}

	/**
	 * Setter for the taskListName field.
	 * 
	 * @param name the name that the TaskList is being set to
	 * @throws IllegalArgumentException if null or empty String is passed
	 */
	public void setTaskListName(String name) {
		if (name == null || "".equals(name)) {
			throw new IllegalArgumentException("Invalid name.");
		}
		this.taskListName = name.trim();
	}

	/**
	 * Getter method to return the ISwapList of Tasks for the TaskList
	 * 
	 * @return ISwapList containing all the tasks in the task list
	 */
	public ISwapList<Task> getTasks() {
		return tasks;

	}

	/**
	 * Getter method to return the number of completed Tasks for the TaskList
	 * 
	 * @return the count of completed tasks in the task list
	 */
	public int getCompletedCount() {
		return completedCount;
	}

	/**
	 * Adds the Task to the end of the list. The current instance of the TaskList
	 * adds itself to the Task.
	 * 
	 * @param task the Task being added to the TaskList
	 * @throws IllegalArgumentException if thrown by Task.addTaskList if task list
	 *                                  is null
	 * @throws NullPointerException     if thrown by task passed to Task.add is null
	 */
	public void addTask(Task task) {
		tasks.add(task);
		task.addTaskList(this);

	}

	/**
	 * Removes the Task from the list of tasks by using the and returns the removed
	 * task.
	 * 
	 * @param idx index of the Task that is to be removed
	 * @return the removed Task
	 * @throws IndexOutOfBoundsException if thrown by call to SwapList.remove()
	 */
	public Task removeTask(int idx) {
		return tasks.remove(idx);
	}

	/**
	 * Returns the Task at the given index.
	 * 
	 * @param idx the index of the task that is to be returned
	 * @return the Task object at the index
	 * @throws IndexOutOfBoundsException if thrown by call to SwapList.remove()
	 */
	public Task getTask(int idx) {
		return tasks.get(idx);
	}

	/**
	 * Finds the given Task in the list and removes it. The completedCount is
	 * then incremented.
	 * 
	 * @param task the task that is to be completed
	 */
	public void completeTask(Task task) {
		for (int i = 0; i < tasks.size(); i++) { 
			if (tasks.get(i) == task) {
				tasks.remove(i);
				completedCount++;
			}
		}
	}

	/**
	 * An abstract method that returns a 2D String array representation of the Tasks
	 * in the TaskList.
	 * 
	 * @return the 2D String array of the tasks in the TaskList
	 */
	public abstract String[][] getTasksAsArray();
}
