package manage.commands;

import manage.commands.exceptions.InvalidAddCommandException;
import manage.commands.exceptions.InvalidCommandException;
import manage.datatypes.*;
import manage.datatypes.exceptions.*;
import manage.main.Profile;

/**
 * Add command for Manage. Overrides the completeAction method - to add the data object 
 * specified by the command. For invalid commands, exception is thrown.
 * 
 * @author J Blackmore
 */
public class AddCommand extends Command{

    /** Correct format of this command */
    private static String correctCommandFormat = 
        "\'add [new] (task|todo) <name> <destination1>\'\n" + 
        "\'add [new] task <name> <destination1> <destination2>\'";

    /**
     * Constructs a new Add Command from the command string. First argument must be 'add', the 
     * second must be the data object type to add, the third its name and the subsequent arguments 
     * are the destination of where the data object should be added to.
     * 
     * @param command the command string which the new command should be constructed from.
     * @throws InvalidCommandException for invalid commands.
     */
    public AddCommand(String command) throws InvalidCommandException {
        super(command);
        setCommandType(Command.ADD_COMMAND);
    }

    /**
     * Performs the action for the add command - add data object to another, both specified by 
     * the command. For invalid commands (non-existing objects) an exception is thrown, unless new 
     * is specified before data object, then a new object is created and added.
     * 
     * @param user The profile the command is to be executed on.
     * @throws TaskNotFoundException when the task to be added was not found.
     * @throws TodoNotFoundException when the todo to be added or added to was not found.
     * @throws CollectionNotFoundException when the collection to be added to was not found.
     * @throws InvalidAddCommandException for invalid add commands.
     */
    @Override
    public void completeAction(Profile user) throws TaskNotFoundException, TodoNotFoundException, 
                                           CollectionNotFoundException, InvalidAddCommandException {

        Collection targetCollection;
        Todo targetTodo, todoToAdd;
        Task taskToAdd;

        switch (getArg(1).toLowerCase()) {
            case "task":
                taskToAdd = user.getTask(getArg(2));

                if (numOfArgs() == 4) {
                    targetCollection = user.getCollection(getArg(4));
                    targetCollection.addTask(taskToAdd, getArg(3));
                } else if (numOfArgs() == 3) {
                    targetTodo = user.getTodo(getArg(3));
                    targetTodo.addTask(getArg(2));
                }

                user.tasks.remove(taskToAdd);
                break;
            case "todo":
                todoToAdd = user.getTodo(getArg(2));
                targetCollection = user.getCollection(getArg(3));

                targetCollection.addTodo(todoToAdd);
                user.todos.remove(todoToAdd);
                break;
            case "new":
                if(getArg(2).toLowerCase().equalsIgnoreCase("task")) {
                    taskToAdd = new Task(getArg(3));

                    if(numOfArgs() == 5) {
                        targetCollection = user.getCollection(getArg(5));
                        targetCollection.addTask(taskToAdd, getArg(4));
                    } else if(numOfArgs() == 4) {
                        targetTodo = user.getTodo(getArg(4));
                        targetTodo.addTask(taskToAdd);
                    }
                    break;
                } else if(getArg(2).toLowerCase().equalsIgnoreCase("todo")) {
                    todoToAdd = new Todo(getArg(3));
                    targetCollection = user.getCollection(getArg(4));

                    targetCollection.addTodo(todoToAdd);
                    break;
                } else {
                    throw new InvalidAddCommandException(this);
                }
            default:
                throw new InvalidAddCommandException(this);
        }
    }

    /**
     * Returns the correct format for the add command.
     * 
     * @return correct add command format.
     */
    public static String getCorrectCommandFormat() {
        return correctCommandFormat;
    }
}