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
  
  }
  
  public static void testCollection() {
    
  }
}