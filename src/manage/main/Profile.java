package manage.main;

import java.util.ArrayList;

import manage.datatypes.*;
import manage.datatypes.exceptions.*;

/**
 * A users Profile for manage. Contains list of collections, todos and tasks and various methods 
 * to access them.
 * 
 * @author J Blackmore
 */
public class Profile {
    public ArrayList<Collection> collections;
    public ArrayList<Todo> todos;
    public ArrayList<Task> tasks;

    private String userName;

    /**
     * Creates a profile with a user name of userName.
     * 
     * @param userName the user name.
     */
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
     * @throws CollectionNotFoundException when the collection of collectionName could not be found.
     */
    public Collection getCollection(String collectionName) throws CollectionNotFoundException {
        for (int i = 0; i < collections.size(); i++) {
            if (collections.get(i).getName().equalsIgnoreCase(collectionName)) {
                return collections.get(i);
            }
        }
        throw new CollectionNotFoundException(collectionName);
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
     * Returns Task object of Task with description of taskDesc if it exists, else null.
     * 
     * @param taskDesc String of Task description.
     * @return Task with description of taskDesc.
     * @throws TaskNotFoundException when the task of taskDesc could not be found.
     */
    public Task getTask(String taskDesc) throws TaskNotFoundException {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getDesc().equalsIgnoreCase(taskDesc))
                return tasks.get(i); 
        }
        throw new TaskNotFoundException(taskDesc);
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
     * @throws TodoNotFoundException when the todo with todoName could not be found.
     */
    public Todo getTodo(String todoName) throws TodoNotFoundException {
        for (int i = 0; i < todos.size(); i++) {
            if (todos.get(i).getName().equalsIgnoreCase(todoName)) {
                return todos.get(i);
            }
        }
        throw new TodoNotFoundException(todoName);
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

    /**
     * Returns the user name of this profile.
     * 
     * @return the user name.
     */
    public String getUserName() {
        return userName;
    }
}