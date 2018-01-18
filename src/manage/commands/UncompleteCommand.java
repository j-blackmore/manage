package manage.commands;

import manage.commands.exceptions.InvalidUncompleteCommandException;
import manage.datatypes.*;
import manage.datatypes.exceptions.*;
import manage.main.Profile;

/**
 * Uncomplete Command for Manage. Overrides the completeAction method - to change completion status
 * of the data object specified by the command. For invalid commands, exception is thrown.
 * 
 * @author J Blackmore 
 */
public class UncompleteCommand extends Command {

    /**
     * Constructs a new Uncomplete Command from the command string. First argument must be 
     * 'uncomplete', the second must be the data object type to uncomplete, the third its name and 
     * the subsequent arguments are the location of the object.
     * 
     * @param command the command string which the new command should be constructed from.
     */
    public UncompleteCommand(String command) {
        super(command);
    }

    /**
     * Performs the action for the uncomplete command - uncomplete the data object specified by 
     * the command. For invalid commands (non-existing objects) an exception is thrown.
     * 
     * @param user The profile the command is to be executed on.
     * @throws
     */
    @Override
    public void completeAction(Profile user) throws TaskNotFoundException, TodoNotFoundException, 
                                CollectionNotFoundException, InvalidUncompleteCommandException {
        switch (getArg(1).toLowerCase()) {
            case "task":
                if(numOfArgs() == 4) {
                    Collection targetCollection = user.getCollection(getArg(4));
                    targetCollection.unCompleteTask(getArg(2), getArg(3));
                    break;
                } else if(numOfArgs() == 3) {
                    Todo targetTodo = user.getTodo(getArg(3));
                    targetTodo.unCompleteTask(getArg(2));
                    break;
                } else {
                    Task taskToUncomplete = user.getTask(getArg(2));
                    taskToUncomplete.unComplete();
                    break;
                }
            case "todo":
                if(numOfArgs() == 3) {
                    Collection targetCollection = user.getCollection(getArg(3));
                    targetCollection.unCompleteTodo(getArg(2));
                    break;
                } else if(numOfArgs() == 2) {
                    Todo todoToUncomplete = user.getTodo(getArg(2));
                    todoToUncomplete.unComplete();
                    break; 
                } else {
                    throw new InvalidUncompleteCommandException(this.toString());
                }
            default:
                throw new InvalidUncompleteCommandException(this.toString());
        }
    }
}