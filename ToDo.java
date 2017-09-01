// Data object, represents a ToDo list of tasks. Holds these tasks in an ArrayList.

import java.util.ArrayList;

public class ToDo {
  private ArrayList<Task> tasks;  // no tasks by default
  private String name = null; // no name by default
  private int order = 0;  // no ordering by default
  private boolean complete = false; // incomplete as default
  private int numOfTasks = 0;
  
  // name only constructor
  public ToDo(String requiredName) {
    this.name = requiredName;
    this.tasks = new ArrayList<Task>();
  }
  
  // ordering constructor - calls name only constructor
  public ToDo(String requiredName, int requiredOrder) {
    this(requiredName);
    this.order = requiredOrder;
  }
  
  // adds a Task to the ToDo
  public void addTask(String taskDesc) {
    tasks.add(new Task(taskDesc, numOfTasks));
    this.numOfTasks = tasks.size();
  }
  
  // calls change desc method of the Task specified by taskNum
  public void changeTaskDesc(String newTaskDesc, int taskNum) {
    if (taskNum > numOfTasks || taskNum < 1)
      System.out.println("Task number invalid, please enter a value between 1 and " + numOfTasks);
    else
      tasks.get(taskNum - 1).changeDesc(newTaskDesc);
  }
  
  // changes the ToDo name to newName
  public void changeName(String newName) {
    this.name = newName;
  }
  
  // calls complete method of the Task specified by taskNum
  public void completeTask(int taskNum) {
    if (taskNum > numOfTasks || taskNum < 1)
      System.out.println("Task number invalid, please enter a value between 1 and " + numOfTasks);
    else
      tasks.get(taskNum - 1).complete();
  }
  
  // change completion status to true
  public void complete() {
    this.complete = true;
  }
  
  // returns the name of the ToDo
  public String getName() {
    return name;
  }
  
  // returns Task specified by taskNumber (the index in the list of tasks)
  public Task getTask(int taskNum) {
    if (taskNum > numOfTasks || taskNum < 1) {
      System.out.println("Task number invalid, please enter a value between 1 and " + numOfTasks);
      return null;
    } else
      return tasks.get(taskNum - 1);
  }
  
  // returns task description specified by taskNum
  public String getTaskDesc(int taskNum) {
    if (taskNum > numOfTasks || taskNum < 1)
      return "Task number invalid, please enter a value between 1 and " + numOfTasks;
    else
      return tasks.get(taskNum - 1).getDesc();
  }
  
  // returns string representation of all the tasks in the To-Do
  public String printTasks() {
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
      tasks.get(taskNum - 1).unComplete(); 
  }
  
  // change completion status to false
  public void unComplete() {
    this.complete = false;
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