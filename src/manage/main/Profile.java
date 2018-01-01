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