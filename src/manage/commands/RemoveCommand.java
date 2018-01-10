package manage.commands;

import manage.datatypes.*;
import manage.main.Profile;

public class RemoveCommand extends Command {

    public RemoveCommand(String command) {
        super(command);
    }

    @Override
    public void completeAction(Profile user) {
        switch(getArg(1).toLowerCase()) {
            case "task":
                if(numOfArgs() == 4) {
                    Collection targetCollection = user.getCollection(getArg(4));
                    if(targetCollection == null) {
                        System.out.println("No collection \'" + getArg(4) + "\' exists.");
                        break;
                    }

                    targetCollection.removeTask(getArg(2), getArg(3));
                    break;
                } else if(numOfArgs() == 3) {
                    Todo targetTodo = user.getTodo(getArg(3));
                    if(targetTodo == null) {
                        System.out.println("No todo \'" + getArg(3) + "\' exists.");
                        break;
                    }

                    targetTodo.removeTask(getArg(2));
                    break;
                } else {
                    Task taskToRemove = user.getTask(getArg(2));
                    if(taskToRemove == null) {
                        System.out.println("No task \'" + getArg(2) + "\' exists.");
                        break;
                    }

                    user.tasks.remove(taskToRemove);
                    break;
                }
            case "todo":
                if(numOfArgs() == 3) {
                    Collection targetCollection = user.getCollection(getArg(3));
                    if(targetCollection == null) {
                        System.out.println("No collection \'" + getArg(3) + "\' exists.");
                        break;
                    }

                    targetCollection.removeTodo(getArg(2));
                    break;
                } else if(numOfArgs() == 2) {
                    Todo todoToRemove = user.getTodo(getArg(2));
                    if(todoToRemove == null) {
                        System.out.println("No todo \'" + getArg(2) + "\' exists.");
                        break;
                    }

                    user.todos.remove(todoToRemove);
                    break;
                } else {
                    System.out.println("Invalid remove command");    //TODO: Exception.
                    break;
                }
            case "collection":
                if(numOfArgs() == 2) {
                    Collection collectionToRemove = user.getCollection(getArg(2));
                    if(collectionToRemove == null) {
                        System.out.println("No collection \'" + getArg(2) + "\' exists.");
                        break;
                    }

                    user.collections.remove(collectionToRemove);
                    break;
                } else {
                    System.out.println("Invalid remove command");    //TODO: Exception.
                    break;
                }
            default:
                System.out.print("Invalid remove command");     //TODO: Exception. 
                break;
        }
    }
}