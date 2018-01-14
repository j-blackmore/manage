package manage.commands;

import manage.commands.exceptions.InvalidAddCommandException;
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

    /**
     * Constructs a new Add Command from the command string. First argument must be 'add', the 
     * second must be the data object type to add, the third its name and the subsequent arguments 
     * are the destination of where the data object should be added to.
     * 
     * @param command the command string which the new command should be constructed from.
     */
    public AddCommand(String command) {
        super(command);
    }

    /**
     * Performs the action for the add command - add data object to another, both specified by 
     * the command. For invalid commands (non-existing objects) an exception is thrown.
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
        switch (getArg(1).toLowerCase()) {
            case "task":
                Task taskToAdd = user.getTask(getArg(2));
                if (taskToAdd == null) {
                    throw new TaskNotFoundException(getArg(2));
                }

                if (numOfArgs() == 4) {
                    Collection targetCollection = user.getCollection(getArg(4));
                    if (targetCollection == null) {
                        throw new CollectionNotFoundException(getArg(4));
                    }
                    
                    targetCollection.addTask(taskToAdd, getArg(3));
                } else if (numOfArgs() == 3) {
                    Todo targetTodo = user.getTodo(getArg(3));
                    if (targetTodo == null) {
                        throw new TodoNotFoundException(getArg(3));
                    }

                    targetTodo.addTask(getArg(2));
                }

                user.tasks.remove(taskToAdd);
                break;
            case "todo":
                Todo todoToAdd = user.getTodo(getArg(2));
                if (todoToAdd == null) {
                    throw new TodoNotFoundException(getArg(2));
                }

                Collection targetCollection = user.getCollection(getArg(3));
                if (targetCollection == null) {
                    throw new CollectionNotFoundException(getArg(3));
                }

                targetCollection.addTodo(todoToAdd);
                user.todos.remove(todoToAdd);
                break;
            default:
                throw new InvalidAddCommandException(this.toString());
        }
    }
}