package manage.main;

import java.util.ArrayList;

import manage.datatypes.*;

public class Profile {
    public ArrayList<Collection> collections;
    public ArrayList<Todo> todos;
    public ArrayList<Task> tasks;

    private String userName;

    public Profile(String userName) {
        this.userName = userName;

        collections = new ArrayList<Collection>();
        todos = new ArrayList<Todo>();
        tasks = new ArrayList<Task>();
    }

    /**
     * Returns string representation of all collections, todos and tasks in the profile.
     * 
     * @return String of contents in profile
     */
    public String getAll() {
        return getCollections() + getTodos() + getTasks();
    }

    /**
     * Returns Collection object of Collection with name of collectionName if it exists, else null.
     * 
     * @param collectionName String of Collection name.
     * @return Collection with name of collectionName.
     */
    public Collection getCollection(String collectionName) {
        for (int i = 0; i < collections.size(); i++) {
            if (collections.get(i).getName() == collectionName) {
                return collections.get(i);
            }
        }
        return null;
    }

    /**
     * Returns string representation of all Collections in the profile.
     * 
     * @return String of all collections.
     */
    public String getCollections() {
        String allCollections = "";
        for (Collection collection : collections){
            allCollections += collection.toString() + "\n";
        }
        return allCollections;
    }

    /**
     * Returns index in List of Collections of Collection specified by collectionName if it exists,
     * else -1.
     * 
     * @param collectionName String of the Collection name.
     * @return Index of the Collection's position in List.
     */
    public int getIndexOfCollection(String collectionName) {
        for (int i = 0; i < tasks.size(); i++) {
            if (collections.get(i).getName() == collectionName)
                return i;
        }
        return -1;
    }

    /**
     * Returns index in List of Tasks of Task specified by taskDesc if it exists, else -1.
     * 
     * @param taskDesc String of the Task description.
     * @return Index of the Task's position in List.
     */
    public int getIndexOfTask(String taskDesc) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getDesc() == taskDesc)
                return i;
        }
        return -1;
    }

    /**
     * Returns index in List of Todos of Todo's specified by todoName if it exists, else -1.
     * 
     * @param todoName String of the Todo name.
     * @return Index of the Todo's position in List.
     */
    public int getIndexOfTodo(String todoName) {
        for (int i = 0; i < todos.size(); i++) {
            if (todos.get(i).getName() == todoName)
                return i;
        }
        return -1;
    }

    /**
     * Returns Task object of Task with description of taskDesc if it exists, else null.
     * 
     * @param tasDesc String of Task description.
     * @return Task with description of taskDesc.
     */
    public Task getTask(String taskDesc) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getDesc() == taskDesc)
                return tasks.get(i); 
        }
        return null;
    }

    /**
     * Returns string representation of all Tasks in the profile, not in todos or collections.
     * 
     * @return String of all Tasks.
     */
    public String getTasks() {
        String allTasks = "";
        for (Task task : tasks) {
            allTasks += task.toString() + "\n";
        }
        return allTasks;
    }

    /**
     * Returns Todo object of Todo with name of todoName if it exists, else null.
     * 
     * @param todoName String of Todo name.
     * @return Todo with name of todoName.
     */
    public Todo getTodo(String todoName) {
        for (int i = 0; i < todos.size(); i++) {
            if (todos.get(i).getName() == todoName) {
                return todos.get(i);
            }
        }
        return null;
    }

    /**
     * Returns string representation of all Todos in the profile, not in collections.
     * 
     * @return String of all Todos.
     */
    public String getTodos() {
        String allTodos = "";
        for (Todo todo : todos) {
            allTodos += todo.toString() + "\n";
        }
        return allTodos;
    }

    public String getUserName() {
        return userName;
    }
}