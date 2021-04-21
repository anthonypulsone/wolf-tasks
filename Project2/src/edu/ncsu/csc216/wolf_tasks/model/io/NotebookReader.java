package edu.ncsu.csc216.wolf_tasks.model.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import edu.ncsu.csc216.wolf_tasks.model.notebook.Notebook;
import edu.ncsu.csc216.wolf_tasks.model.tasks.AbstractTaskList;
import edu.ncsu.csc216.wolf_tasks.model.tasks.ActiveTaskList;
import edu.ncsu.csc216.wolf_tasks.model.tasks.Task;
import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;

/**
 * NotebookReader class reads in Notebook file
 * 
 * @author anthonypulsone
 *
 */
public class NotebookReader {

	/**
	 * Reads in file to a Scanner, constructs a new Notebook, breaks apart TaskList
	 * lines using delimiter and passes them to helper method for TaskList and Task
	 * construction, returns a valid notebook object if file was able to read with
	 * no errors.
	 * 
	 * @param file the Notebook file that is to be read in
	 * @return a Notebook object containing the TaskGroups and tasks from the file
	 * @throws IllegalArgumentException if file is unable to be loaded
	 */
	public static Notebook readNodebookFile(File file) {
		Scanner fileReader;

		try {
			fileReader = new Scanner(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("Unable to load file.");
		}
		String firstLine = fileReader.nextLine();
		if (firstLine.charAt(0) != '!') {
			throw new IllegalArgumentException("Unable to load file.");
		}
		Notebook notebook = null;
		String notebookName = firstLine.substring(2).trim();
		try {
			notebook = new Notebook(notebookName);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Unable to load file.");
		}

		fileReader.useDelimiter("\\r?\\n?[#]");

		while (fileReader.hasNext()) {
			try {
				String taskListString = fileReader.next();
				notebook.addTaskList(processTaskList(taskListString));
			} catch (IllegalArgumentException | NoSuchElementException e) {
				// nothing
			}
		}
		fileReader.close();
		notebook.setCurrentTaskList(ActiveTaskList.ACTIVE_TASKS_NAME);
		return notebook;
	}

	/**
	 * Helper method to process the TaskList tokens. Scanners break apart the lines
	 * to pass the correct parameters to construct a TaskList. The following String
	 * is tokenized with the proper delimiter for Tasks and passes them to the
	 * processTask method to construct the Tasks that can then be added to the
	 * TaskList. Returns the constructed TaskList
	 * 
	 * @param taskListString the
	 * @return constructed TaskList with a state and Tasks added to it
	 * @throws IllegalArgumentException passed from TaskList constructor if TaskList
	 *                                  is invalid and can't be constructed
	 */
	private static TaskList processTaskList(String taskListString) {
		Scanner taskListScanner = new Scanner(taskListString);
		String firstLine = "";
		if (taskListScanner.hasNext()) {
			firstLine = taskListScanner.nextLine();
		}

		Scanner firstLineScanner = new Scanner(firstLine);
		firstLineScanner.useDelimiter(",");
		String taskListName = firstLineScanner.next().trim();
		int completedCount = firstLineScanner.nextInt();
		firstLineScanner.close();

		TaskList taskList = new TaskList(taskListName, completedCount);

		taskListScanner.useDelimiter("\\r?\\n?[*]");
		while (taskListScanner.hasNext()) {
			try {
				taskList.addTask(processTask(taskList, taskListScanner.next()));
			} catch (IllegalArgumentException e) {
				// nothing
			}
		}
		taskListScanner.close();
		return taskList;
	}

	/**
	 * Takes the passed taskString and creates Scanners to read in the task data to
	 * construct the Task object. The Tasks TaskList is also passed so that the TL
	 * can be assigned to the Task.
	 * 
	 * @param taskList   the taskList for the Task that will be constructed
	 * @param taskString the String of information for the Task
	 * @return the constructed Task
	 * @throws IllegalArgumentException if Task is invalid or can't be constructed
	 */
	private static Task processTask(AbstractTaskList taskList, String taskString) {
		Scanner taskScanner = new Scanner(taskString);
		Scanner taskInfo = new Scanner(taskScanner.nextLine());
		taskInfo.useDelimiter(",");
		Task task = null;
		try {
			String taskName = taskInfo.next().trim();
			String token2 = "";
			String token3 = "";
			boolean recurring = false;
			boolean active = false;
			if (taskInfo.hasNext()) {
				token2 = taskInfo.next().trim().toLowerCase();
				if ("recurring".equals(token2)) {
					recurring = true;
				} else if ("active".equals(token2)) {
					active = true;
				} else {
					taskScanner.close();
					throw new IllegalArgumentException();
				}
			}
			if (taskInfo.hasNext()) {
				token3 = taskInfo.next().trim().toLowerCase();
				if ("recurring".equals(token3) && recurring) {
					taskScanner.close();
					throw new IllegalArgumentException();
				} else if ("recurring".equals(token3)) {
					recurring = true;
				} else if ("active".equals(token3) && active) {
					taskScanner.close();
					throw new IllegalArgumentException();
				} else if ("active".equals(token3)) {
					active = true;
				} else {
					taskScanner.close();
					throw new IllegalArgumentException();
				}
			}
			String taskDescription = "";
			while (taskScanner.hasNext()) {
				taskDescription += taskScanner.nextLine() + "\n";
			}
			task = new Task(taskName, taskDescription, recurring, active);
			task.addTaskList(taskList);
			taskScanner.close();
			taskInfo.close();
			return task;
		} catch (InputMismatchException e) {
			throw new IllegalArgumentException();
		}
	}
}
