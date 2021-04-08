package edu.ncsu.csc216.wolf_tasks.model.tasks;

public class ActiveTaskList extends AbstractTaskList {
	
	/** The default and permanent taskListName for active task lists */
	public static final String ACTIVE_TASKS_NAME = "Active Tasks";
	
	public ActiveTaskList() {
		super(ACTIVE_TASKS_NAME, 0);
	}

	/**
	 *
	 */
	@Override
	public void addTask(Task task) {
		
	}
	
	/**
	 * 
	 * @param name
	 */
	@Override
	public void setTaskListName(String name) {
		
	}
	
	/**
	 *
	 */
	@Override
	public String[][] getTasksAsArray() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 
	 */
	public void clearTasks() {
		
	}
}
