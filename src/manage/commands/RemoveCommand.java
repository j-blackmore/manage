package manage.commands;

import manage.commands.exceptions.InvalidCommandException;
import manage.commands.exceptions.InvalidRemoveCommandException;
import manage.datatypes.*;
import manage.datatypes.exceptions.*;
import manage.main.Profile;

/**
 * Remove command for Manage. Overrides the completeAction method - to remove the data object
 * and its contents specified by the command. For invalid commands, exception is thrown.
 * 
 * @author J Blackmore
 */
public class RemoveCommand extends Command {

    /** Correct format of this command */
    private String correctCommandFormat =
        "\'remove [task|todo|collection] <name>\'\n" +
        "\'remove [task|todo] <name> <destination1>\'\n" +
        "\'remove [task] <name> <destination1> <destination2>\'";

    /**
     * Constructs a new Remove Command from the command string. First argument must be 'remove', 
     * the second must be the data object type to remove, the third its name and the subsequent
     * arguments are the destination of where the object should be removed from.
     * 
     * @param command the command string which the new command should be constructed from.
     * @throws InvalidCommandException for invalid commands.
     */
    public RemoveCommand(String command) throws InvalidCommandException {
        super(command);
    }

    /**
     * Performs the action for the remove command - remove the data object from one specified 
     * by the command. For invalid commands (non-existing objects) an exception is thrown.
     * 
     * @param user THe profile the command is to be executed on.
     * @throws TaskNotFoundException when the task to be removed was not found.
     * @throws TodoNotFoundException when the todo to be removed or removed from was not found.
     * @throws CollectionNotFoundException when the collection to be removed or removed from was not found.
     * @throws InvalidRemoveCommandException for invalid remove commands.
     */
    @Override
    public void completeAction(Profile user) throws TaskNotFoundException, TodoNotFoundException,
                                        CollectionNotFoundException, InvalidRemoveCommandException {
        switch(getArg(1).toLowerCase()) {
            case "task":
                if(numOfArgs() == 4) {
                    Collection targetCollection = user.getCollection(getArg(4));
                    targetCollection.removeTask(getArg(2), getArg(3));
                    break;
                } else if(numOfArgs() == 3) {
                    Todo targetTodo = user.getTodo(getArg(3));
                    targetTodo.removeTask(getArg(2));
                    break;
                } else {
                    Task taskToRemove = user.getTask(getArg(2));
                    user.tasks.remove(taskToRemove);
                    break;
                }
            case "todo":
                if(numOfArgs() == 3) {
                    Collection targetCollection = user.getCollection(getArg(3));
                    targetCollection.removeTodo(getArg(2));
                    break;
                } else if(numOfArgs() == 2) {
                    Todo todoToRemove = user.getTodo(getArg(2));
                    user.todos.remove(todoToRemove);
                    break;
                } else {
                    throw new InvalidRemoveCommandException(this);
                }
            case "collection":
                if(numOfArgs() == 2) {
                    Collection collectionToRemove = user.getCollection(getArg(2));
                    user.collections.remove(collectionToRemove);
                    break;
                } else {
                    throw new InvalidRemoveCommandException(this);
                }
            default:
                throw new InvalidRemoveCommandException(this);
        }
    }

    /**
     * Returns the correct format for this command.
     * 
     * @return correct remove command format.
     */
    public String getCorrectCommandFormat() {
        return correctCommandFormat;
    }
}