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
     * Add collection to this profile.
     * 
     * @param collectionToAdd the collection to add.
     */
    public void add(Collection collectionToAdd) {
        collections.add(collectionToAdd);
    }

    /**
     * Add task to this profile.
     * 
     * @param taskToAdd the task to add.
     */
    public void add(Task taskToAdd) {
        tasks.add(taskToAdd);
    }

    /**
     * Add todo to this profile.
     * 
     * @param todoToAdd the todo to add.
     */
    public void add(Todo todoToAdd) {
        todos.add(todoToAdd);
    }

    /**
     * Returns conditional String of the collection or todo for the first match that is found if 
     * the option is given, first searching collections, todos then tasks. If no option is given 
     * then normal to string is returned. If no match is found a data object exception is thrown. 
     * 
     * @param name The name of the data object to get.
     * @param option The retrieval condition.
     * @return String of the data object found, else null.
     */
    public String get(String name, String option ) throws DataObjectNotFoundException {
        Collection collection = null;
        for(int i = 0; i < collections.size(); i++) {
            if(collections.get(i).getName().equalsIgnoreCase(name)) {
                collection = collections.get(i);
                break;
            }
        }
        if(collection != null) {
            if(option != null) {
                return collection.print(option);
            } else {
                return collection.toString();
            }
        }

        Todo todo = null;
        for(int i = 0; i < todos.size(); i++) {
            if(todos.get(i).getName().equalsIgnoreCase(name)) {
                todo = todos.get(i);
                break;
            }
        }
        if(todo != null) {
            if(option != null) {
                return todo.print(option);
            } else {
                return todo.toString();
            }
        }

        throw new DataObjectNotFoundException(name);
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
     * Returns string representation of all collections, todos and tasks in the profile which match 
     * the option condition. 
     * 
     * @param option the retrieval condition.
     * @return string representation of contents in profile matching option condition.
     */
    public String getAll(String option) {
        return getCollections(option) + getTodos(option) + getTasks(option);
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
     * Returns Collection object of Collection with name collectionName if it exists and satisfies 
     * the option given, else an exception is thrown.
     * 
     * @param collectionName the collection name.
     * @param option the condition for retrieval.
     * @return conditional toString of the collection specified by collectionName satisfying option.
     * @throws CollectionNotFoundException when the collection of collectionName is not found or doesn't satisfy option.
     */
    public String getCollection(String collectionName, String option) throws CollectionNotFoundException {
        for (int i = 0; i < collections.size(); i++) {
            if(collections.get(i).getName().equalsIgnoreCase(collectionName)) {
                return collections.get(i).print(option);
            }
        }
        throw new CollectionNotFoundException(collectionName);  // more specific exception needed
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
     * Returns string representation of all collections in the profile which match the option
     * condition. Condition can be 'c' for complete or 'i' for incomplete, else empty string is 
     * returned.
     * 
     * @param option the condition for retrieval.
     * @return string representation of all collections matching option condition.
     */
    public String getCollections(String option) {
        String allCollections = "";
        for(Collection collection : collections) {
            allCollections += collection.print(option);
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
     * Returns string representation of all tasks in the profile, not in todos or collections which
     * match the option condition. Condition can be 'c' for complete or 'i' for incomplete, else 
     * empty string is returned.
     * 
     * @param option the condition for retrieval.
     * @return string representation of all tasks matching option condition.
     */
    public String getTasks(String option) {
        String allTasks = "";
        for(Task task : tasks) {
            allTasks += task.print(option);
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
     * Returns string representation of all todos in the profile, not in collections which
     * match the option condition. Condition can be 'c' for complete or 'i' for incomplete, else 
     * empty string is returned. If a todo is complete, return it all, if a todo is incomplete 
     * then return only incomplete tasks.
     * 
     * @param option the condition for retrieval.
     * @return string representation of all todos matching option condition.
     */
    public String getTodos(String option) {
        String allTodos = "";
        for(Todo todo : todos) {
            allTodos += todo.print(option);
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