// Data object, represents a ToDo list of tasks. Holds these tasks in an ArrayList.

// TODO: Test the class. Check taskNum - 1 is correct index. //

import java.util.ArrayList;

public class ToDo {
  private ArrayList<Task> tasks;  // no tasks by default
  private String name = null; // no name by default
  private int order = 0;  // no ordering by default
  private boolean complete = false; // incomplete as default
  private int numOfTasks = 0;
  
  // name only constructor
  public ToDo(String requiredName) {
    name = requiredName;
    tasks = new ArrayList<Task>();
  }
  
  // ordering constructor - calls name only constructor
  public ToDo(String requiredName, int requiredOrder) {
    this(requiredName);
    order = requiredOrder;
  }
  
  // adds a Task to the ToDo
  public void addTask(String taskDesc) {
    tasks.add(new Task(taskDesc, numOfTasks));
    numOfTasks = tasks.size();
  }
  
  // calls change desc method of the Task specified by taskNum
  public void changeTaskDesc(int taskNum, String newTaskDesc) {
    if (taskNum > numOfTasks || taskNum < 1)
      System.out.println("Task number invalid, please enter a value between 1 and " + numOfTasks);
    else
      tasks.get(taskNum - 1).changeTaskDesc(newTaskDesc);
  }
  
  // changes the ToDo name to newName
  public void changeToDoName(String newName) {
    name = newName;
  }
  
  // calls complete method of the Task specified by taskNum
  public void completeTask(int taskNum) {
    if (taskNum > numOfTasks || taskNum < 1)
      System.out.println("Task number invalid, please enter a value between 1 and " + numOfTasks);
    else
      tasks.get(taskNum - 1).completeTask();
  }
  
  // change completion status to true
  public void completeToDo() {
    complete = true;
  }
  
  // returns the name of the ToDo
  public String getName() {
    return name;
  }
  
  // returns string of the Task specified by taskNumber (the index in the list of tasks)
  public String getTask(int taskNum) {
    if (taskNum > numOfTasks || taskNum < 1)
      return "Task number invalid, please enter a value between 1 and " + numOfTasks;
    else
      return tasks.get(taskNum - 1).toString();
  }
  
  // returns string representation of all the tasks in the To-Do
  public String getTasks() {
    String tempReturn = "";
    
    for (Task task : tasks) {
      tempReturn += task.toString() + "\n";
    }
    return tempReturn;
  }
  
  // removes Task specified by taskNum
  public void removeTask(int taskNum) {
    if (taskNum > numOfTasks || taskNum < 1)
      System.out.println("Task number invalid, please enter a value between 1 and " + numOfTasks);
    else {
      tasks.remove(taskNum - 1);
      numOfTasks = tasks.size();
    }
  }
  
  // calls uncomplete method of the Task specified by taskNum
  public void unCompleteTask(int taskNum) {
    if (taskNum > numOfTasks || taskNum < 1)
      System.out.println("Task number invalid, please enter a value between 1 and " + numOfTasks);
    else
      tasks.get(taskNum - 1).unCompleteTask(); 
  }
  
  // change completion status to false
  public void unCompleteToDo() {
    complete = false;
  }
  
  // returns string representation of a ToDo with all its Tasks
  public String toString() {
    String tempReturn = (complete ? "[COMPLETE] " : "") + getName() + ": \n";
    
    for (Task task : tasks) {
      tempReturn += task + "\n"; 
    }
    return tempReturn;
  }
}