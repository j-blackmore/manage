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
    
    // final line to show end of output
    System.out.println("------------------");
  }
  
  public static void testTask() {
    Task t1 = new Task("maths homework");
    Task t2 = new Task("laundry", 1);
    Task t3 = new Task("java", 2);
    
    System.out.println(t1);
    t1.changeDesc("COMP11120 examples");
    System.out.println(t1.getDesc());
    System.out.println(t1);
    t1.complete();
    System.out.println(t1);
    t2.complete();
    t2.unComplete();
    System.out.println(t2);
    t2.complete();
    System.out.println(t2.getDesc());
    System.out.println(t2);
  }
  
  public static void testToDo() {
    ToDo td1 = new ToDo("Homework");
    System.out.println(td1);
    
    td1.changeName("Personal");
    System.out.println(td1.getName());
    td1.complete();
    System.out.println(td1);
    td1.unComplete();
    System.out.println(td1);
    System.out.println(td1.printTasks());
    td1.addTask("java lab");
    System.out.println(td1);
    td1.addTask("sort spotify");
    System.out.println(td1);
    td1.completeTask(1);
    System.out.println(td1);
    td1.changeTaskDesc("complete manage",1);
    System.out.println(td1);
    td1.unCompleteTask(2);
    td1.completeTask(1);
    td1.completeTask(2);
    td1.complete();
    td1.unCompleteTask(1);
    System.out.println(td1);
    
    td1.addTask("tidy room");
    td1.addTask("go shopping");
    td1.completeTask(3);
    System.out.println(td1.printTasks());
    ToDo td2 = new ToDo("Fun tings");
    System.out.println(td2);
    System.out.println(td2.printTasks());
    System.out.println(td1.getTaskDesc(3));
    System.out.println(td1.getTask(6));
    td1.changeTaskDesc("laundry", 4);
    System.out.println(td1);
    
    System.out.println("---------------------------------------");
  }
  
  public static void testCollection() {
    // test empty collections
    /*
    Collection c1 = new Collection("uni work");
    Collection c2 = new Collection("personal projects", 34343);
    System.out.println(c1);
    System.out.println(c2);
    c1.changeName("uni tasks");
    System.out.println(c1.getName());
    */
    
    // test with empty todos
    Collection c = new Collection("Uni work");
    c.addToDo("Maths");
    c.addToDo("Java");
    c.addToDo("soft. eng.");
    System.out.println(c);
    
    // test with todos and tasks
  }
}