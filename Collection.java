// Data object, represents a group of ToDo lists. Holds these in an ArrayList.

import java.util.ArrayList;

public class Collection {
  private ArrayList<ToDo> todos = null; // no ToDos by default
  private String name = null; // no name by default
  private int order = 0;  // no ordering by default
  private int numOfToDos = 0;
  
  // name only constructor
  public Collection(String requiredName) {
    this.name = requiredName;
    this.todos = new ArrayList<ToDo>();
  }
  
  // ordering constructor - calls name only constructor
  public Collection(String requiredName, int requiredOrder) {
    this(requiredName);
    this.order = requiredOrder;
  }
  
  // adds a Task to the ToDo specified by todoNum
  public void addTask(String taskDesc, int todoNum) {
    if (todoNum > numOfToDos || todoNum < 1)
      System.out.println("ToDo Number invalid, please enter a value between 1 and " + numOfToDos);
    else
      todos.get(todoNum - 1).addTask(taskDesc);
  }
  
  // adds a ToDo to the Collection
  public void addToDo(String toDoName) {
    todos.add(new ToDo(toDoName, numOfToDos));
    this.numOfToDos = todos.size();
  }
  
  // changes the Collection name to newName
  public void changeName(String newName) {
    this.name = newName;
  }
  
  // calls method to change taskdesc of task specified by taskNum in a ToDo specified by todoNum
  public void changeTaskDesc(String newTaskDesc, int todoNum, int taskNum) {
    if (todoNum > numOfToDos || todoNum < 1)
      System.out.println("ToDo number invalid, please enter a value between 1 and " + numOfToDos);
    else
      todos.get(todoNum - 1).changeTaskDesc(newTaskDesc, taskNum);
  }
  
  // calls method to change name of a ToDo specified by todoNum
  public void changeToDoName(String newToDoName, int todoNum) {
    if (todoNum > numOfToDos || todoNum < 1)
      System.out.println("ToDo number invalid, please enter a value between 1 and " + numOfToDos);
    else
      todos.get(todoNum - 1).changeName(newToDoName);
  }
  
  // calls complete method of the Task in a ToDo specified by taskNum and todoNum
  public void completeTask(int todoNum, int taskNum) {
    if (todoNum > numOfToDos || todoNum < 1)
      System.out.println("ToDo number invalid, please enter a value between 1 and " + numOfToDos);
    else
      todos.get(todoNum - 1).completeTask(taskNum);
  }
  
  // calls complete method of the ToDo specified by todoNum
  public void completeToDo(int todoNum) {
    if (todoNum > numOfToDos || todoNum < 1) 
      System.out.println("ToDo number invalid, please enter a value between 1 and " + numOfToDos);
    else
      todos.get(todoNum - 1).complete();
  }
  
  // returns the name of the Collection
  public String getName() {
    return name;
  }
  
  // returns a task from a todo specified by todoNum and taskNum
  public Task getTask(int todoNum, int taskNum) {
    if (todoNum > numOfToDos || todoNum < 0){
      System.out.println("ToDo number invalid, please enter a number between 1 and " + numOfToDos);
      return null;
    } else
      return todos.get(todoNum - 1).getTask(taskNum);
  }
  
  // returns the task desc from a ToDo specified by todoNum and taskNum
  public String getTaskDesc(int todoNum, int taskNum) {
    if (todoNum > numOfToDos || todoNum < 1)
      return "ToDo number invalid, please enter a number between 1 and " + numOfToDos;
    else
      return todos.get(todoNum -1).getTaskDesc(taskNum);
  }
  
  // returns a to-do specified by todoNum (index in the list)
  public ToDo getToDo(int todoNum) {
    if (todoNum > numOfToDos || todoNum < 0) {
      System.out.println("ToDo number invalid, please enter a number between 1 and " + numOfToDos);
      return null;
    } else
      return todos.get(todoNum -1);
  }
  
  // returns the name of the ToDo specified by todoNum 
  public String getToDoName(int todoNum) {
    if (todoNum > numOfToDos || todoNum < 1) 
      return "ToDo number invalid, please enter a number between 1 and " + numOfToDos;
    else
      return todos.get(todoNum - 1).getName();
  }
  
  // returns name of Collection and list of its ToDos
  public String listCollection() {
    String tempReturn = name + "\n";
    
    for (ToDo todo : todos) {
      tempReturn += todo.getName() + "\n";
    }
    return tempReturn;
  }
  
  // returns string representation of all the tasks in a ToDo specified by todoNum
  public String printTasks(int todoNum) {
    if (todoNum > numOfToDos || todoNum < 1)
      return "ToDo number invalid, please enter a number between 1 and " + numOfToDos;
    else
      return todos.get(todoNum -1).printTasks();
  }
  
  // returns string representation of all the To-Dos in the collection
  public String printToDos() {
    String tempReturn = "";
    
    for (ToDo todo : todos) {
      tempReturn += todo.toString() + "\n";
    }
    return tempReturn;
  }
  
  // removes Task from a ToDo specified by todoNum and taskNum
  public void removeTask(int todoNum, int taskNum) {
    if (todoNum > numOfToDos || todoNum < 0)
      System.out.println("ToDo number invalid, please enter a value between 1 and " + numOfToDos);
    else
      todos.get(todoNum - 1).removeTask(taskNum);
  }
  
  // removes ToDo specified by todoNum
  public void removeToDo(int todoNum) {
    if (todoNum > numOfToDos || todoNum < 0)
      System.out.println("ToDo number invalid, please enter a value between 1 and " + numOfToDos);
    else {
      todos.remove(todoNum);
      numOfToDos = todos.size();
    }
  }
  
  // calls uncompleteTask with the task specified by taskNum, of the ToDo specified by todoNum
  public void unCompleteTask(int todoNum, int taskNum) {
    if (todoNum > numOfToDos || todoNum < 1)
      System.out.println("ToDo number invalid, please enter a value between 1 and " + numOfToDos);
    else
      todos.get(todoNum - 1).unCompleteTask(taskNum);
  }
  
  // calls uncomplete method of the ToDo specified by todoNum
  public void unCompleteToDo(int todoNum) {
    if (todoNum > numOfToDos || todoNum < 1)
      System.out.println("ToDo number invalid, please enter a value between 1 and " + numOfToDos);
    else
      todos.get(todoNum - 1).unComplete();
  }
  
  // returns a string representation of a Collection with all its ToDos and their Tasks
  public String toString() {
    String tempReturn = name + "\n";
    
    for (ToDo todo: todos) {
      tempReturn += todo + "\n" + "\n";
    }
    return tempReturn;
  }
}