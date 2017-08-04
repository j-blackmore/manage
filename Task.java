// Data object, represents a task in a To-Do list

public class Task {
  private boolean complete = false; // incomplete as default
  private int order = 0;  // no ordering by default
  private String description = null;  // no item by default
  
  // description only constructor
  public Task(String requiredDesc) {
    description = requiredDesc;
  }
  
  // ordering constructor - calls description only constructor
  public Task(String requiredDesc, int requiredOrder) {
    this(requiredDesc);
    order = requiredOrder;
  }
  
  // change the task description
  public void changeTaskDesc(String newTaskDesc) {
    description = newTaskDesc;
  }
  
  // change completion status to true
  public void completeTask() {
    complete = true;
  }
  
  // returns just the task description
  public String getDesc() {
    return description;
  }
  
  // change completetion status to false
  public void unCompleteTask() {
    complete = false;
  }
  
  // returns string representation of a task - format: "[X] task description"
  public String toString() {
    return (complete ? "[X] " : "[ ] ") + getDesc(); // '[X]' for complete, '[ ]' for incomplete
  }
}