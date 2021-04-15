package edu.ncsu.csc216.wolf_tasks.model.tasks;

import edu.ncsu.csc216.wolf_tasks.model.util.ISwapList;
import edu.ncsu.csc216.wolf_tasks.model.util.SwapList;

/**
 * Class representing a Task object that will be a part of a TaskList
 * collection. A task object has a name, description, and can be recurring and
 * active. A POJO style object that has getters, and setters. Implements
 * Cloneable and has a clone method to clone a Task object. Has a toString
 * method to return String for file output and NotebookWriter class.
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
		setTaskName(taskName);
		setTaskDescription(taskDetails);
		setRecurring(recurring);
		setActive(active);
		taskLists = new SwapList<AbstractTaskList>();
	}

	/**
	 * Getter method to return the name of the Task
	 * 
	 * @return the Task name String
	 */
	public String getTaskName() {
		return taskName;
	}

	/**
	 * Setter method to set the Task name
	 * 
	 * @param name the name that you are setting the task to
	 * @throws IllegalArgumentException if parameter is null or empty
	 */
	public void setTaskName(String name) {
		if (name == null || "".equals(name)) {
			throw new IllegalArgumentException("Incomplete task information.");
		}
		this.taskName = name;
	}

	/**
	 * Getter method to return the description of the task
	 * 
	 * @return the String description of the Task
	 */
	public String getTaskDescription() {
		return taskDescription;
	}

	/**
	 * Setter method to set the Task description
	 * 
	 * @param description the description of the Task
	 */
	public void setTaskDescription(String description) {
		if (description == null || "".equals(description)) {
			throw new IllegalArgumentException("Incomplete task information.");
		}
		this.taskDescription = description;
	}

	/**
	 * Getter for whether a task is recurring or not
	 * 
	 * @return boolean true or false depending whether recurring or not
	 */
	public boolean isRecurring() {
		return recurring;
	}

	/**
	 * Setter method for whether the Task is recurring or not
	 * 
	 * @param recurring true or false boolean value depending on whether recurring
	 *                  or not
	 */
	public void setRecurring(boolean recurring) {
		this.recurring = recurring;
	}

	/**
	 * Getter for whether a Task is active or not
	 * 
	 * @return true or false boolean value depending on whether Task is active or
	 *         not
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * Setter method for whether a Task is active or not
	 * 
	 * @param active true or false boolean value depending on whether Task is active
	 *               or not
	 */
	public void setActive(boolean active) {
		this.active = active;
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
		String rtn; // if there is a IOOBE passed through taskList.get(0) it must be null so ""
		// empty string is passed
		try {
			rtn = taskLists.get(0).getTaskListName();
		} catch (IndexOutOfBoundsException e) {
			rtn = "";
		}
		return rtn;
	}

	/**
	 * If the AbstractTaskList is not already registered with the Task the
	 * AbstractTaskList is added to the end of the taskLists field. If the parameter
	 * is null an IAE is thrown with message “Incomplete task information.”
	 * 
	 * @param taskList the TaskList to register the Task to
	 * @throws IllegalArgumentException if parameter is null
	 */
	public void addTaskList(AbstractTaskList taskList) {
		if (taskList == null) {
			throw new IllegalArgumentException();
		}
		boolean alreadyAdded = false;
		for (int i = 0; i < taskLists.size(); i++) {
			if (taskLists.get(i).getTaskListName().equals(taskList.getTaskListName())) {
				alreadyAdded = true;
			}
		}
		if (!alreadyAdded) {
			taskLists.add(taskList);
		}
	}

	/**
	 * This method will complete the Task and notify the taskLists by sharing the
	 * current Task instance via the TaskList.completeTask(Task) method. If the Task
	 * is recurring, the Task is cloned and the cloned Task is added to each
	 * registered AbstractTaskList.
	 */
	public void completeTask() {
		for (int i = 0; i < taskLists.size(); i++) {
			try {
				taskLists.get(i).completeTask((Task) clone());
				if (isRecurring()) {
					taskLists.get(i).addTask((Task) clone());
				}
			} catch (CloneNotSupportedException e) {
				// do nothing
			}
		}
	}

	/**
	 * Returns a copy of the Task. If there are no AbstractTaskLists registered with
	 * the Task then a CloneNotSupportedException is thrown with the message “Cannot
	 * clone.”. Otherwise, a new Task is created with copies of all the fields. The
	 * TaskLists from the current instance are added to the clones taskLists
	 * 
	 * @return the cloned Task
	 * @throws CloneNotSupportedException is thrown if there are not
	 *                                    AbstractTaskLists registered with the Task
	 */
	public Object clone() throws CloneNotSupportedException {
		try {
			taskLists.get(0);
		} catch (IndexOutOfBoundsException e) {
			throw new CloneNotSupportedException("Cannot clone.");
		}
		Task clone = new Task(taskName, taskDescription, recurring, active);
		for (int i = 0; i < taskLists.size(); i++) {
			clone.addTaskList(taskLists.get(i));
		}
		return clone;
	}

	/**
	 * Returns a string representation of the Task for printing to a file. To
	 * support testing, please print the “recurring” string before “active” if both
	 * recurring and active are true.
	 * 
	 * @return String representation of the Task
	 */
	public String toString() {
		String rtn = "* " + getTaskName();
		if (isRecurring() || isActive()) {
			rtn += ",";
		}
		if (isRecurring()) {
			rtn += "recurring";
		}
		if(isRecurring() && isActive()) {
			rtn += ",";
		}
		if (isActive()) {
			rtn += "active";
		}
		rtn += "\n" + getTaskDescription();
		return rtn;
	}

}
