package edu.ncsu.csc216.wolf_tasks.model.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;


import edu.ncsu.csc216.wolf_tasks.model.notebook.Notebook;
import edu.ncsu.csc216.wolf_tasks.model.tasks.AbstractTaskList;
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
	 * Reads in file to a Scanner, breaks apart lines using delimiter, returns a
	 * valid notebook object if file was able to read with no errors.
	 * 
	 * @param file the Notebook file that is to be read in
	 * @return a Notebook object containing the TaskGroups and tasks from the file
	 */
	public static Notebook readNodebookFile(File file) {
		Scanner fileReader;
	
		try {
			fileReader = new Scanner(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("Unable to load file.");
		}
		String firstLine = fileReader.nextLine();
		if(firstLine.charAt(0) != '!'){
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
				System.out.println(taskListString);
				System.out.println();
				notebook.addTaskList(processTaskList(taskListString));
			} catch (IllegalArgumentException | NoSuchElementException e) {
				fileReader.close();
				throw new IllegalArgumentException("Unable to load file.");
			}
		}
		fileReader.close();
		return notebook;
	}
	
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
			taskList.addTask(processTask(taskList, taskListScanner.next()));
		}
		taskListScanner.close();
		return taskList;
	}
	
	private static Task processTask(AbstractTaskList taskList, String taskString) {
		Scanner taskScanner = new Scanner(taskString);
		Scanner taskInfo = new Scanner(taskScanner.nextLine().trim());
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
				taskDescription += taskScanner.nextLine() + "/n";
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
