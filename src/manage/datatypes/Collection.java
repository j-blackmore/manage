package manage.datatypes;

import java.util.ArrayList;
/**
 * Collection data structure for manage. It consists of Todos, with various methods for manipulating a Collection.
 * 
 * @author J Blackmore
 */
public class Collection {
    private ArrayList<Todo> todos = null; // no Todos by default
    private String name = null; // no name by default
    private int order = 0;  // no ordering by default
    private int numOfTodos = 0;
    
    /**
     * Creates a Collection, with just a name but no todos.
     *
     * @param requiredName the collections name.
     */
    public Collection(String requiredName) {
        this.name = requiredName;
        this.todos = new ArrayList<Todo>();
    }
    
    /**
     * Creates a Collection with a name, an ordering for comparison with other collections, but no todos.
     *
     * @param requiredName the collection's name.
     * @param requiredOrder the order amongst other collections.
     */
    public Collection(String requiredName, int requiredOrder) {
        this(requiredName);
        this.order = requiredOrder;
    }
    
    /**
     * Creates then adds a new task to an already existing todo, inside this collection.
     * 
     * @param taskDesc the description of the task.
     * @param todoNum the target todo's position in the collection.
     */
    public void addTask(String taskDesc, int todoNum) {
        if (todoNum > (numOfTodos - 1) || todoNum < 0)
            System.out.println("Todo number invalid, please enter a value between 0 and " + (numOfTodos - 1));
        else 
            todos.get(todoNum).addTask(taskDesc);
    }

    /**
     * Adds a pre-existing task object to an already existing todo, inside this collection.
     * Indexing begins at 0.
     * 
     * @param taskToAdd the task to add.
     * @param todoNum the target todo's position in the collection.
     */
    public void addTask(Task taskToAdd, int todoNum) {
        if (todoNum > (numOfTodos - 1) || todoNum < 0)
            System.out.println("Todo number invalid, please enter a value between 0 and " + (numOfTodos - 1));
        else
            todos.get(todoNum).addTask(taskToAdd);
    }

    /**
     * Adds the given task to a todo in the collection, if it exists.
     * 
     * @param taskToAdd the task to add.
     * @param todoName the target todo's name.
     */
    public void addTask(Task taskToAdd, String todoName) {
        for(int i = 0; i < todos.size(); i++) {
            if(todos.get(i).getName().equalsIgnoreCase(todoName)) {
                todos.get(i).addTask(taskToAdd);
                return;
            }
        }
        System.out.println("Todo: \'" + todoName + "\' not found.");
    }
    
    /**
     * Creates then adds a new todo to this collection.
     * 
     * @param todoName the name of the todo.
     */
    public void addTodo(String todoName) {
        todos.add(new Todo(todoName, numOfTodos));
        this.numOfTodos = todos.size();
    }

    /**
     * Adds a pre-existing todo object to this collection.
     * 
     * @param todoToAdd the todo to add.
     */
    public void addTodo(Todo todoToAdd) {
        todos.add(todoToAdd);
        this.numOfTodos = todos.size();
    }
    
    /**
     * Sets this collection's name to the given name.
     * 
     * @param newName the given name.
     */
    public void changeName(String newName) {
        this.name = newName;
    }
    
    /**
     * Sets the description of a task in a todo to the new given description. Task is specified 
     * by position in a todo, and that todo's position in this collection.
     * 
     * @param newTaskDesc the new description of the task.
     * @param todoNum the todo's position in the collection.
     * @param taskNum the target task's position in the todo.
     */
    public void changeTaskDesc(String newTaskDesc, int todoNum, int taskNum) {
        if (todoNum > (numOfTodos - 1) || todoNum < 0)
            System.out.println("Todo number invalid, please enter a value between 0 and " + (numOfTodos - 1));
        else
            todos.get(todoNum).changeTaskDesc(newTaskDesc, taskNum);
    }

    /**
     * Set's the description of a task in a todo in this collection to the new given description.
     * Task is specified by its description in a todo also specified by its name.
     * 
     * @param taskDesc the target task's description.
     * @param newTaskDesc the new description of the task.
     * @param todoName the name of the todo.
     */
    public void changeTaskDesc(String taskDesc, String newTaskDesc, String todoName) {
        for(int i = 0; i < todos.size(); i++) {
            if(todos.get(i).getName().equalsIgnoreCase(todoName)) {
                todos.get(i).changeTaskDesc(taskDesc, newTaskDesc);
                return;
            }
        }
        System.out.println("Todo: \'" + todoName + "\' not found.");    //TODO: Exception.
    }
    
    /**
     * Sets a todo's name to the new given name. Todo is specified by position in this collection.
     * Indexing begins at 0.
     * 
     * @param newTodoName the new name of the todo.
     * @param todoNum the target todo's position in the collection.
     */
    public void changeTodoName(String newTodoName, int todoNum) {
        if (todoNum > (numOfTodos - 1) || todoNum < 0)
            System.out.println("Todo number invalid, please enter a value between 0 and " + (numOfTodos - 1));
        else
            todos.get(todoNum).changeName(newTodoName);
    }

    /**
     * Set's a todo's name to the new given name. Todo is specified by its name.
     * 
     * @param todoName the name of the todo.
     * @param newTodoName the new name of the todo.
     */
    public void changeTodoName(String todoName, String newTodoName) {
        for(int i = 0; i < todos.size(); i++) {
            if(todos.get(i).getName().equalsIgnoreCase(newTodoName)) {
                todos.get(i).changeName(newTodoName);
                return;
            }
        }
        System.out.println("Todo: \'" + todoName + "\' not found.");    //TODO: Exception.
    }
    
    /**
     * Sets a task's completion status to true. Task is specified by position in a todo, 
     * and that todo's position in this collection. Indexing begins at 0.
     * 
     * @param todoNum the todo's position in the collection.
     * @param taskNum the target task's position in the todo.
     */
    public void completeTask(int todoNum, int taskNum) {
        if (todoNum > (numOfTodos - 1) || todoNum < 0)
            System.out.println("Todo number invalid, please enter a value between 0 and " + (numOfTodos - 1));
        else
            todos.get(todoNum).completeTask(taskNum);
    }

    /**
     * Set's task's completion status to true. Task is specified by its name in a todo,
     * which is also specified by its name in the collection.
     * 
     * @param taskDesc the description of the task.
     * @param todoName the name of the todo.
     */
    public void completeTask(String taskDesc, String todoName) {
        for(int i = 0; i < todos.size(); i++) {
            if(todos.get(i).getName().equalsIgnoreCase(todoName)) {
                todos.get(i).completeTask(taskDesc);
                return;
            }
        }
        System.out.println("Todo: \'" + todoName + "\' not found.");    //TODO: Exception
    }
    
    /**
     * Sets a todo's completion status to true. Todo is specified by position in this collection.
     * 
     * @param todoNum the target todo's position in the collection.
     */
    public void completeTodo(int todoNum) {
        if (todoNum > (numOfTodos - 1)|| todoNum < 0) 
            System.out.println("Todo number invalid, please enter a value between 0 and " + (numOfTodos - 1));
        else
            todos.get(todoNum).complete();
    }

    /**
     * Sets a todo's completion status to true. Todo is specified by its name.
     * 
     * @param todoName the name of the todo.
     */
    public void completeTodo(String todoName) {
        for(int i = 0; i < todos.size(); i++) {
            if(todos.get(i).getName().equalsIgnoreCase(todoName)) {
                todos.get(i).complete();
                return;
            }
        }
        System.out.println("Todo: \'" + todoName + "\' not found.");    //TODO: Exception.
    }

    /**
     * Returns index of todo specified by todoName if it exists, else -1.
     * 
     * @param todoName String of the Todo name.
     * @return Index of the Todo's position in List.
     */
    public int getIndexOfTodo(String todoName) {
        for (int i = 0; i < todos.size(); i++) {
            if (todos.get(i).getName().equalsIgnoreCase(todoName))
                return i;
        }
        return -1;
    }
    
    /**
     * Gets the name of this collection.
     * 
     * @return The collection name.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Gets the task object specified by its position in a todo, and that todo's  position 
     * in this collection. Indexing begins at 0.
     * 
     * @param todoNum the todo's position in the collection.
     * @param taskNum the target task's position in the todo.
     * @return Task object.
     */
    public Task getTask(int todoNum, int taskNum) {
        if (todoNum > (numOfTodos - 1)|| todoNum < 0){
            System.out.println("Todo number invalid, please enter a number between 0 and " + (numOfTodos - 1));
            return null;
        } else
            return todos.get(todoNum).getTask(taskNum);
    }

    /**
     * Gets the task object specified by its description in a todo which is also specified by
     * its name in this collection.
     * 
     * @param taskDesc the description of the desired task.
     * @param todoName the name of the todo.
     * @return Task object.
     */
    public Task getTask(String taskDesc, String todoName) {
        for(int i = 0; i < todos.size(); i++) {
            if(todos.get(i).getName().equalsIgnoreCase(todoName)) {
                todos.get(i).getTask(taskDesc);
            }
        }
        System.out.println("Todo: \'" + todoName + "\' not found.");
        return null;
    }
    
    /**
     * Get the description of the task specified by its position in a todo, and that todo's position in this collection.
     * 
     * @param todoNum the todo's position in the collection.
     * @param taskNum the target task's position in the todo.
     * @return The description of the task.
     */
    public String getTaskDesc(int todoNum, int taskNum) {
        if (todoNum > (numOfTodos - 1)|| todoNum < 0)
            return "Todo number invalid, please enter a number between 0 and " + (numOfTodos - 1);
        else
            return todos.get(todoNum).getTaskDesc(taskNum);
    }
    
    /**
     * Gets the todo specified by its position in this collection.
     * 
     * @param todoNum the target todo's position in the collection.
     * @return Todo object.
     */
    public Todo getTodo(int todoNum) {
        if (todoNum > (numOfTodos - 1) || todoNum < 0) {
            System.out.println("Todo number invalid, please enter a number between 0 and " + (numOfTodos - 1));
            return null;
        } else
            return todos.get(todoNum);
    }

    /**
     * Gets the todo specified by its name.
     * 
     * @param todoName the name of the todo.
     * @return Todo object.
     */
    public Todo getTodo(String todoName) {
        for(int i = 0; i < todos.size(); i++) {
            if(todos.get(i).getName().equalsIgnoreCase(todoName)) {
                return todos.get(i);
            }
        }
        System.out.println("Todo: \'" + todoName + "\' not found.");
        return null;
    }
    
    /**
     * Gets the name of the todo specified by its position in this collection.
     * 
     * @param todoNum the target todo's position in the collection.
     * @return The name of the todo.
     */
    public String getTodoName(int todoNum) {
        if (todoNum > (numOfTodos - 1)|| todoNum < 0) 
            return "Todo number invalid, please enter a number between 0 and " + (numOfTodos- 1);
        else
            return todos.get(todoNum).getName();
    }
    
    /**
     * Gets a string representation of this collection and just the names of the todos it has.
     * 
     * @return String representation of the name of this collection and the names of its todos.
     */
    public String listCollection() {
        String tempReturn = name + ":";
        
        for (Todo todo : todos) {
            tempReturn += "\n  " + todo.getName() ;
        }
        return tempReturn;
    }
    
    /**
     * Gets a string representation of all the tasks in a todo specified by its position in this collection.
     * 
     * @param todoNum the target todo's position in this collection.
     * @return String representation of the tasks in a todo.
     */
    public String printTasks(int todoNum) {
        if (todoNum > (numOfTodos - 1)|| todoNum < 0)
            return "Todo number invalid, please enter a number between 0 and " + (numOfTodos - 1);
        else
            return todos.get(todoNum).printTasks();
    }
    
    /**
     * Gets a string representation of the list of names of the todos in this collection.
     * 
     * @return String representation of a list of todo names.
     */
    public String printTodos() {
        String tempReturn = "";

        // add all but one todo with newline character, (adds none if there is only 1 todo)
        for (int i = 0; i < numOfTodos - 1; i++) {
            tempReturn += todos.get(i).toString() + "\n";
        }
        
        // add final task without new line character, only if there is atleast 1 todo
        if (numOfTodos > 0)
            tempReturn += todos.get(numOfTodos - 1).toString();
        
        return tempReturn;
    }
    
    /**
     * Removes a task specified by its position in the todo, and that todo's position in this collection, from the todo.
     * 
     * @param todoNum the todo's position in this collection.
     * @param taskNum the target task's position in the todo.
     */
    public void removeTask(int todoNum, int taskNum) {
        if (todoNum > (numOfTodos - 1) || todoNum < 0)
            System.out.println("Todo number invalid, please enter a value between 0 and " + (numOfTodos - 1));
        else
            todos.get(todoNum).removeTask(taskNum);
    }
    
    /**
     * Removes a todo specified by its position in this collection, from the collection - as well as all its tasks.
     * 
     * @param todoNum the target todo's position in this collection.
     */
    public void removeTodo(int todoNum) {
        if (todoNum > (numOfTodos - 1) || todoNum < 0)
            System.out.println("Todo number invalid, please enter a value between 0 and " + (numOfTodos - 1));
        else {
            todos.remove(todoNum);
            numOfTodos = todos.size();
        }
    }
    
    /**
     * Sets the completion status for a task specified by its position in a todo, and that todo's position in this collection, to false.
     * 
     * @param todoNum the todo's position in this collection.
     * @param taskNum the target task's position in the todo.
     */
    public void unCompleteTask(int todoNum, int taskNum) {
        if (todoNum > (numOfTodos - 1) || todoNum < 0)
            System.out.println("Todo number invalid, please enter a value between 0 and " + (numOfTodos - 1));
        else
            todos.get(todoNum).unCompleteTask(taskNum);
    }
    
    /**
     * Sets the completion status for a todo specified by its position in this collection, to false.
     * 
     * @param todoNum the target todo's position in this collection.
     */
    public void unCompleteTodo(int todoNum) {
        if (todoNum > (numOfTodos - 1)|| todoNum < 0)
            System.out.println("Todo number invalid, please enter a value between 0 and " + (numOfTodos- 1));
        else
            todos.get(todoNum).unComplete();
    }
    
    /**
     * Gets a string representation of this collection, including all its todo's, their completion status, all its tasks and their completion status'.
     * 
     * @return String representation of this collection.
     */
    public String toString() {
        String tempReturn = name  + ":";
        
        for (Todo todo: todos) {
            tempReturn += "\n  " + todo ;
        }
        return tempReturn;
    }
}