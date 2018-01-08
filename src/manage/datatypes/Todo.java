package manage.datatypes;

import java.util.ArrayList;

/**
 * Todo data structure for manage. It consists of Tasks, with various methods for manipulating a Todo.
 * 
 * @author J Blackmore
 */
public class Todo {
    private ArrayList<Task> tasks;  // no tasks by default
    private String name = null; // no name by default
    private int order = 0;  // no ordering by default
    private boolean complete = false; // incomplete as default
    private int numOfTasks = 0;
    
    /**
     * Creates a Todo, with just a name but no tasks.
     * 
     * @param requiredName the todos name.
     */
    public Todo(String requiredName) {
        this.name = requiredName;
        this.tasks = new ArrayList<Task>();
    }
    
    /**
     * Creates a Todo with a name, an ordering for comparison with other todos, but no tasks.
     * 
     * @param requiredName the todo's name.
     * @param requiredOrder the order amoungst other todos.
     */
    public Todo(String requiredName, int requiredOrder) {
        this(requiredName);
        this.order = requiredOrder;
    }
    
    /**
     * Creates then adds a new task to this todo.
     * 
     * @param taskDesc the description of the task.
     */
    public void addTask(String taskDesc) {
        tasks.add(new Task(taskDesc, numOfTasks));
        this.numOfTasks = tasks.size();
    }

    /**
     * Adds a pre-existing task object to this todo.
     * 
     * @param taskToAdd the task to add.
     */
    public void addTask(Task taskToAdd) {
        tasks.add(taskToAdd);
        this.numOfTasks = tasks.size();
    }
    
    /**
     * Sets a task's description to the new given description. Task is specified by position in todo.
     * 
     * @param newTaskDesc the new description of the task.
     * @param taskNum the target task's position in the todo.
     */
    public void changeTaskDesc(String newTaskDesc, int taskNum) {
        if (taskNum > (numOfTasks - 1) || taskNum < 0)
            System.out.println("Task number invalid, please enter a value between 0 and " + (numOfTasks - 1));
        else
            tasks.get(taskNum).changeDesc(newTaskDesc);
    }

    /**
     * Sets a task's description to the new given description. Task is specified by its name.
     * 
     * @param taskDesc the target task's description.
     * @param newTaskDesc the new description of the task.
     */
    public void changeTaskDesc(String taskDesc, String newTaskDesc) {
        for(int i = 0; i < tasks.size(); i++) {
            if(tasks.get(i).getDesc().equalsIgnoreCase(newTaskDesc)) {
                tasks.get(i).changeDesc(newTaskDesc);
                break;
            }
        }
        System.out.println("Task: \'" + taskDesc + "\' not found.");    //TODO: Exception.
    }
    
    /**
     * Sets this todo's name to the given name.
     * 
     * @param newName the given name.
     */
    public void changeName(String newName) {
        this.name = newName;
    }
    
    /**
     * Sets a task's completion status to true. Task is specified by position in the todo.
     * 
     * @param taskNum the target task's position in the todo.
     */
    public void completeTask(int taskNum) {
        if (taskNum > (numOfTasks - 1) || taskNum < 0)
            System.out.println("Task number invalid, please enter a value between 0 and " + (numOfTasks - 1));
        else
            tasks.get(taskNum).complete();
    }

    /**
     * Set's a task's completion status to true. Task is specified by its description.
     * 
     * @param taskDesc the description of the todo.
     */
    public void completeTask(String taskDesc) {
        for(int i = 0; i < tasks.size(); i++) {
            if(tasks.get(i).getDesc().equalsIgnoreCase(taskDesc)) {
                tasks.get(i).complete();
                return;
            }
        }
        System.out.println("Task: \'" + taskDesc + "\' not found.");    //TODO: Exception
    }
    
    /**
     * Sets this todo's completion status to true.
     */
    public void complete() {
        this.complete = true;
    }
    
    /**
     * Gets the name of this todo.
     * 
     * @return The todo name.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Gets the task object specified by its position in the todo.
     * 
     * @param taskNum the target task's position in the todo.
     * @return Task object.
     */
    public Task getTask(int taskNum) {
        if (taskNum > (numOfTasks - 1) || taskNum < 0) {
            System.out.println("Task number invalid, please enter a value between 0 and " + (numOfTasks - 1));
            return null;
        } else
            return tasks.get(taskNum);
    }
    
    /**
     * Gets the description of the task specified by its position in the todo.
     * 
     * @param taskNum the target task's position in the todo.
     * @return The description of the task.
     */
    public String getTaskDesc(int taskNum) {
        if (taskNum > (numOfTasks - 1) || taskNum < 0)
            return "Task number invalid, please enter a value between 0 and " + (numOfTasks - 1);
        else
            return tasks.get(taskNum).getDesc();
    }
    
    /**
     * Gets a string representation of all the tasks in this todo. Each list is on a new line.
     * 
     * @return String representation of the tasks in this todo.
     */
    public String printTasks() {
        String tempReturn = "";
        
        // add all but one task with newline character, (adds none if there is only 1 task)
        for (int i = 0; i < numOfTasks - 1; i++){
            tempReturn += tasks.get(i).toString() + "\n";
        }
        
        // add final task without new line character, only if there is atleast 1 task
        if (numOfTasks > 0)
            tempReturn += tasks.get(numOfTasks - 1).toString();
        
        return tempReturn;
    }
    
    /**
     * Removes a task specified by its position in the todo, from the todo.
     * 
     * @param taskNum the target task's position in the todo.
     */
    public void removeTask(int taskNum) {
        if (taskNum > (numOfTasks - 1)|| taskNum < 0)
            System.out.println("Task number invalid, please enter a value between 0 and " + (numOfTasks - 1));
        else {
            tasks.remove(taskNum);
            numOfTasks = tasks.size();
        }
    }
    
    /**
     * Sets a task's completion status to false. The task is specified by the position in the todo.
     * 
     * @param taskNum the target task's position in the todo.
     */
    public void unCompleteTask(int taskNum) {
        if (taskNum > (numOfTasks - 1) || taskNum < 0)
            System.out.println("Task number invalid, please enter a value between 0 and " + (numOfTasks - 1));
        else
            tasks.get(taskNum).unComplete(); 
    }
    
    /**
     * Sets this todo's completion status to false.
     */
    public void unComplete() {
        this.complete = false;
    }
    
    /**
     * Gets a string representation of this todo, including its completion status as well as the tasks completion status.
     * 
     * @return String representation of this todo.
     */
    public String toString() {
        String tempReturn = getName() + (complete ? "[COMPLETE]" : "") + ":";
        
        for (Task task : tasks) {
            tempReturn += "\n  " + task; 
        }
        return tempReturn;
    }
}
