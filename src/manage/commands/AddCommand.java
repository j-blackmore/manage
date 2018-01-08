package manage.commands;

import manage.datatypes.Collection;
import manage.datatypes.Task;
import manage.datatypes.Todo;
import manage.main.Profile;

public class AddCommand extends Command{

    public AddCommand(String command) {
        super(command);
    }

    @Override
    public void completeAction(Profile user) {
        switch (getArg(1).toLowerCase()) {
            case "task":
                Task taskToAdd = user.getTask(getArg(2));
                if (taskToAdd == null) {
                    System.out.println("No task \'" + getArg(2) + "\' exists.");
                    break;
                }

                if (numOfArgs() == 4) {
                    Collection targetCollection = user.getCollection(getArg(4));
                    if (targetCollection == null) {
                        System.out.println("No collection \'" + getArg(4) + "\' exists.");
                        break;
                    }
                    
                    targetCollection.addTask(taskToAdd, getArg(3));
                } else if (numOfArgs() == 3) {
                    Todo targetTodo = user.getTodo(getArg(3));
                    if (targetTodo == null) {
                        System.out.println("No todo \'" + getArg(3) + "\' exists.");
                        break;
                    }

                    targetTodo.addTask(getArg(2));
                }

                user.tasks.remove(taskToAdd);
                break;
            case "todo":
                Todo todoToAdd = user.getTodo(getArg(2));
                if (todoToAdd == null) {
                    System.out.println("No todo \'" + getArg(2) + "\' exists.");
                    break;
                }

                Collection targetCollection = user.getCollection(getArg(3));
                if (targetCollection == null) {
                    System.out.println("No collection \'" + getArg(3) + "\' exists.");
                    break;
                }

                targetCollection.addTodo(todoToAdd);
                user.todos.remove(todoToAdd);
                break;
            default:
                System.out.println("Error");
                break;
        }
    }
}