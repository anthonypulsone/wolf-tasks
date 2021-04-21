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
	 * @throws IllegalArgumentException if the task is not active
	 */
	@Override
	public void addTask(Task task) {
		if (!task.isActive()) {
			throw new IllegalArgumentException("Cannot add task to Active Tasks.");
		}
		super.addTask(task);
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
		if (name != ACTIVE_TASKS_NAME) {
			throw new IllegalArgumentException("The Active Tasks list may not be edited.");
		}
		super.setTaskListName(name);
	}

	/**
	 * Returns a 2D String array where the first column is the name of the TaskList
	 * that the Task belongs to (or at least the TaskList at index 0) and the name
	 * of the Task.
	 * 
	 * @return 2D Array of active Tasks in the ActiveTaskList
	 */
	@Override
	public String[][] getTasksAsArray() {
		String[][] tasks2d = new String[getTasks().size()][2];
		for (int i = 0; i < getTasks().size(); i++) {
			Task rowTask = getTasks().get(i);
			tasks2d[i][0] = rowTask.getTaskListName();
			tasks2d[i][1] = rowTask.getTaskName();
		}
		return tasks2d;
	}

	/**
	 * Clears the ActiveTaskList of all Tasks. Iterates through the tasks in the
	 * list and removes them.
	 */
	public void clearTasks() {
		int size = getTasks().size();
		for (int i = 0; i < size; i++) {
			getTasks().remove(0);
		}
	}
}
