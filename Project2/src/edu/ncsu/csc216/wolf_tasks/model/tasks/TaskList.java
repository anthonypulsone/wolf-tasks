/**
 * 
 */
package edu.ncsu.csc216.wolf_tasks.model.tasks;

/**
 * TaskList class is the object for user created TaskLists. Extends
 * AbstractTaskList, overrides the abstract method getTasksAsArray and
 * implements Comparable for TaskList and the compareTo to method for TaskList.
 * Constructor passes both parameters to super.
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
	 * @throws IllegalArgumentException if passed from super if name is null or
	 *                                  count less than 0
	 */
	public TaskList(String name, int count) {
		super(name, count);
	}

	/**
	 * Overrides getTasksAsArray abstract method in super. Returns a 2D String array
	 * where the first column is the priority of the Task, starting at 1, and the
	 * name of the Task.
	 */
	@Override
	public String[][] getTasksAsArray() {
		String[][] tasks2d = new String[getTasks().size()][2];
		for (int i = 0; i < getTasks().size(); i++) {
			Task rowTask = getTasks().get(i);
			tasks2d[i][0] = Integer.toString(i + 1);
			tasks2d[i][1] = rowTask.getTaskName();
		}
		return tasks2d;
	}

	/**
	 * Overrides default compareTo to provide functionality for implemented
	 * Comparable interface on TaskLists. Compares the names of the TaskLists
	 * 
	 * @return returns negative int if before, 0 if equal, and positive int if after
	 */
	@Override
	public int compareTo(TaskList list) {
		return this.getTaskListName().toLowerCase().compareTo(list.getTaskListName().toLowerCase());
	}

}
