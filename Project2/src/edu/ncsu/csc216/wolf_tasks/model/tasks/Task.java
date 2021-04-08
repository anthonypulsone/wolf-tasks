package edu.ncsu.csc216.wolf_tasks.model.tasks;

import edu.ncsu.csc216.wolf_tasks.model.util.ISwapList;

/**
 * Class representing a Task object. A task object has a name, description, and
 * can be recurring and active. A POJO style object that has getters,
 * 
 * @author anthonypulsone
 *
 */
public class Task implements Cloneable {

	/** String containing the name of the task */
	private String taskName;
	/** String containing the description of the task */
	private String taskDescription;
	/** boolean representing whether or not the task is recurring */
	private boolean recurring;
	/** boolean representing whether the task is currently active */
	private boolean active;
	/** The SwapList of AbstractTaskLists that the task is a part of */
	private ISwapList<AbstractTaskList> taskLists;

	/**
	 * The constructor for Task. Constructs the Task with the given parameters. The
	 * taskLists field is constructed to an empty SwapList of AbstractTaskLists.
	 * 
	 * @param taskName    String containing the name of the task
	 * @param taskDetails String containing the description of the task
	 * @param recurring   boolean representing whether or not the task is recurring
	 * @param active      boolean representing whether the task is currently active
	 */
	public Task(String taskName, String taskDetails, boolean recurring, boolean active) {

	}

	/**
	 * Getter method to return the name of the Task
	 * 
	 * @return the Task name String
	 */
	public String getTaskName() {
		return null;
	}

	/**
	 * Setter method to set the Task name
	 * 
	 * @param name the name that you are setting the task to
	 */
	public void setTaskName(String name) {

	}

	/**
	 * Getter method to return the description of the task
	 * 
	 * @return the String description of the Task
	 */
	public String getTaskDescription() {
		return null;
	}

	/**
	 * Setter method to set the Task description
	 * 
	 * @param description the description of the Task
	 */
	public void setTaskDescription(String description) {

	}

	/**
	 * Getter for whether a task is recurring or not
	 * 
	 * @return boolean true or false depending whether recurring or not
	 */
	public boolean isRecurring() {
		return false;
	}

	/**
	 * Setter method for whether the Task is recurring or not
	 * 
	 * @param recurring true or false boolean value depending on whether recurring
	 *                  or not
	 */
	public void setRecurring(boolean recurring) {

	}

	/**
	 * Getter for whether a Task is active or not
	 * 
	 * @return true or false boolean value depending on whether Task is active or
	 *         not
	 */
	public boolean isActive() {
		return false;
	}

	/**
	 * Setter method for whether a Task is active or not
	 * 
	 * @param active true or false boolean value depending on whether Task is active
	 *               or not
	 */
	public void setActive(boolean active) {

	}

	/**
	 * Returns the name of the AbstractTaskList at index 0. If the taskLists field
	 * is null or empty, an empty string is returned. There could be multiple
	 * AbstractTaskLists in the taskLists field; if so, the name of the first
	 * AbstractTaskList is returned.
	 * 
	 * @return the TaskList name as a String
	 */
	public String getTaskListName() {
		return null;
	}

	/**
	 * If the AbstractTaskList is NOT already registered with the Task the
	 * AbstractTaskList is added to the end of the taskLists field. If the parameter
	 * is null an IAE is thrown with message “Incomplete task information.”
	 * 
	 * @param taskLists the TaskList to register the Task to
	 * @throws IllegalArgumentException if parameter is null
	 */
	public void addTaskList(AbstractTaskList taskLists) {

	}

	/**
	 * This method will complete the Task and notify the taskLists by sharing the
	 * current Task instance via the TaskList.completeTask(Task) method. If the Task
	 * is recurring, the Task is cloned and the cloned Task is added to each
	 * registered AbstractTaskList.
	 */
	public void completeTask() {

	}

	/**
	 * Returns a copy of the Task. If there are no AbstractTaskLists registered with
	 * the Task then a CloneNotSupportedException is thrown with the message “Cannot
	 * clone.”. Otherwise, a new Task is created with copies of all the fields. Note
	 * that when copying the taskLists field, that you need to make a new SwapList
	 * but you want to keep the references to the same AbstractTaskList objects;
	 * don’t clone the AbstractTaskLists
	 * 
	 * @return the copied object
	 * @throws CloneNotSupportedException is thrown if there are not
	 *                                    AbstractTaskLists registered with the Task
	 */
	public Object clone() throws CloneNotSupportedException {
		return null;
	}

	/**
	 * Returns a string representation of the Task for printing to a file. To
	 * support testing, please print the “recurring” string before “active” if both
	 * recurring and active are true.
	 * 
	 * @return String representation of the Task
	 */
	public String toString() {
		return null;
	}

}
