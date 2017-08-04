// Data object, represents a group of ToDo lists. Holds these in an ArrayList.

import java.util.ArrayList;

public class Collection {
  private ArrayList<ToDo> todos = null; // no ToDOs by default
  private String name = null; // no name by default
  private int order = 0;  // no ordering by default
  private int numOfToDos = todos.size();
  
  // name only constructor
  public Collection(String requiredName) {
    name = requiredName;
  }
  
  // ordering constructor - calls name only constructor
  public Collection(String requiredName, int requiredOrder) {
    this(requiredName);
    order = requiredOrder;
  }
  
  // adds a ToDo to the Collection
  public void addToDo(String toDoName) {
    todos.add(new ToDo(toDoName, numOfToDos));
    numOfToDos = todos.size();
  }
  
  // changes the Collection name to newName
  public void changeCollectionName(String newName) {
    name = newName;
  }
  
  // returns the name of the Collection
  public String getName() {
    return name;
  }
  
  // returns name of Collection and list of its ToDos
  public String listCollection() {
    String tempReturn = name + "\n";
    
    for (ToDo todo : todos) {
      tempReturn += todo.getName + "\n";
    }
    return tempReturn;
  }
  
  // removes ToDo specified by toDoNum
  public void removeToDo(int toDoNum) {
    if (toDoNum > numOfToDos || toDoNum < 0)
      System.out.println("ToDo number invalid, please enter a value between 1 and " + numOfToDos);
    else {
      todos.remove(toDoNum);
      numOfToDos = todos.size();
    }
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