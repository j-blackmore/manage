// Data object, represents a task in a To-Do list

public class Task {
  private boolean complete = false; // incomplete as default
  private int order = 0;  // no ordering by default
  private String description = null;  // no item by default
  
  // description only constructor
  public Task(String requiredDesc) {
    this.description = requiredDesc;
  }
  
  // ordering constructor - calls description only constructor
  public Task(String requiredDesc, int requiredOrder) {
    this(requiredDesc);
    this.order = requiredOrder;
  }
  
  // change the task description
  public void changeDesc(String newTaskDesc) {
    this.description = newTaskDesc;
  }
  
  // change completion status to true
  public void complete() {
    this.complete = true;
  }
  
  // returns just the task description
  public String getDesc() {
    return description;
  }
  
  // change completetion status to false
  public void unComplete() {
    this.complete = false;
  }
  
  // returns string representation of a task - format: "[X] task description"
  public String toString() {
    return (complete ? "[X] " : "[ ] ") + getDesc(); // '[X]' for complete, '[ ]' for incomplete
  }
}