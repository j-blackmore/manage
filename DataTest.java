// test class for testing the data structures

public class DataTest {
  public static void main(String[] args) {
    switch (args[0].toUpperCase()) {
      case "TASK":  testTask();
                    break;
      case "TODO":  testToDo();
                    break;
      case "COLLECTION":  testCollection();
                          break;
    }
  }
  
  public static void testTask() {
    Task t1 = new Task("complete homework");
    Task t2 = new Task("laundry");
    Task t3 = new Task("go shopping");
    
    // prints just descriptions of all
    System.out.println(t1.getDesc());
    System.out.println(t2.getDesc());
    System.out.println(t3.getDesc());
    
    // prints status and desc of all - all incomplete 
    System.out.println(t1);
    System.out.println(t2);
    System.out.println(t3);
    
    System.out.println(t1); // print status and desc
    t1.completeTask();
    System.out.println(t1); // print complete status and desc
    t1.unCompleteTask();
    System.out.println(t1); // prints incomplete and desc
    
    t2.completeTask();
    t3.unCompleteTask();
    
    // incomplete, complete and incomplete
    System.out.println(t1);
    System.out.println(t2);
    System.out.println(t3);
    
    t1.changeTaskDesc("java lab");
    System.out.println(t1);
    t1.completeTask();
    System.out.println(t1);
  }
  
  public static void testToDo() {
    ToDo td1 = new ToDo("Homework", 0);
    ToDo td2 = new ToDo("Chores", 1);
    
    // prints whole empty todos
    System.out.println(td1);
    System.out.println(td2);
    
    // add tasks to dos and visualise them
    td1.addTask("maths examples");
    td1.addTask("java lab");
    td1.addTask("computer networks exam");
    td2.addTask("washing up");
    td2.addTask("tidy room");
    td2.addTask("laundry");
    td2.addTask("clean house");
    System.out.println(td1);
    System.out.println(td2);
    
    td1.changeTaskDesc(3, "distributed sys exam");
    System.out.println(td1.getTask(3)); // prints new desc
    td1.completeTask(3);
    System.out.println(td1);  // prints todo with task 3 complete
    td1.completeTask(1);
    System.out.println(td1);  // prints todo with tasks 1, 3 complete
    td1.unCompleteTask(3);
    System.out.println(td1);  // prints todo with task 1 complete
    
    System.out.println(td1.getTasks()); // prints only tasks in todo
    td1.removeTask(2);
    System.out.println(td1);  // prints with just two tasks
    td1.changeToDoName("Homework tasks");
    td1.completeToDo();
    System.out.println(td1);  // prints completed ToDo with new name
    td1.unCompleteToDo();
    System.out.println(td1);  // prints incomplete ToDo
  }
  
  public static void testCollection() {
    
  }
}