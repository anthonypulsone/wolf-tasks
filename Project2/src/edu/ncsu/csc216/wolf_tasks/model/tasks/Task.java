package edu.ncsu.csc216.wolf_tasks.model.tasks;

import edu.ncsu.csc216.wolf_tasks.model.util.ISwapList;
import edu.ncsu.csc216.wolf_tasks.model.util.SwapList;

/**
 * Class representing a Task object. A task object has a name, description, and
 * can be recurring and active.
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
	 * @return
	 */
	public String getTaskName() {
		return null;
	}

	/**
	 * 
	 */
	public void setTaskName() {

	}

	/**
	 * @return
	 */
	public String getTaskDescription() {
		return null;
	}

	/**
	 * 
	 */
	public void setTaskDescription() {

	}

	/**
	 * @return
	 */
	public boolean isRecurring() {
		return false;
	}

	/**
	 * @param recurring
	 */
	public void setRecurring(boolean recurring) {

	}

	/**
	 * @return
	 */
	public boolean isActive() {
		return false;
	}

	/**
	 * @param active
	 */
	public void setActive(boolean active) {

	}

	/**
	 * @return
	 */
	public String getTaskListName() {
		return null;
	}
	
	/**
	 * @param taskLists
	 */
	public void addTaskList(AbstractTaskList taskLists) {
		
	}
	
	/**
	 * 
	 */
	public void completeTask() {
		
	}
	
	/**
	 *
	 */
	public Object clone() throws CloneNotSupportedException {
		return null;
	}
	
	/**
	 *
	 */
	public String toString() {
		return null;
	}

}
