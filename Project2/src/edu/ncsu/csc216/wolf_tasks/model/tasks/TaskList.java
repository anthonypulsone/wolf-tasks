/**
 * 
 */
package edu.ncsu.csc216.wolf_tasks.model.tasks;

/**
 * TaskList class is the object for user created TaskLists
 * 
 * @author anthonypulsone
 *
 */
public class TaskList extends AbstractTaskList implements Comparable<TaskList> {

	/**
	 * Constructor for a TaskList passes name and count to super (AbstractTaskList)
	 * for construction
	 * 
	 * @param name  the name for the TaskList
	 * @param count the count of completed Tasks
	 */
	public TaskList(String name, int count) {
		super(name, count);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Returns a 2D String array where the first column is the priority of the Task,
	 * starting at 1, and the name of the Task.
	 */
	@Override
	public String[][] getTasksAsArray() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Compares the names of the TaskLists
	 * 
	 * @return returns negative int if before, 0 if equal, and positive int if after
	 */
	@Override
	public int compareTo(TaskList list) {
		// TODO Auto-generated method stub
		return 0;
	}

}
