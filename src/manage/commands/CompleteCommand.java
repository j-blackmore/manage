package manage.commands;

import manage.commands.exceptions.InvalidCommandException;
import manage.commands.exceptions.InvalidCompleteCommandException;
import manage.datatypes.*;
import manage.datatypes.exceptions.*;
import manage.main.Profile;

/**
 * Complete Command for Manage. Overrides the completeAction method - to change completion status 
 * of the data object specified by the command. For invalid commands, exception is thrown.
 * 
 * @author J Blackmore
 */
public class CompleteCommand extends Command {

    /** Correct format of this command */
    private static String correctCommandFormat = 
        "\'complete [task|todo] <name> <destination1>\'\n" +
        "\'complete [task] <name> <destination1> <destination2>\'";

    /**
     * Constructs a new Complete Command from the command string. First argument must be 'complete',
     * the second must be the data object type to complete, the third its name and the subsequent 
     * arguments are the location of the object.
     * 
     * @param command the command string which the new command should be constructed from.
     * @throws InvalidCommandException for invalid commands..
     */
    public CompleteCommand(String command) throws InvalidCommandException {
        super(command);
        setCommandType(Command.COMPLETE_COMMAND);
    }

    /**
     * Performs the action for the complete command - complete the data object specified by the 
     * command. For invalid commands (non-existing objects) an exception is thrown.
     * 
     * @param user The profile the command is to be executed on.
     * @throws TaskNotFoundException when the task to be completed was not found.
     * @throws TodoNotFoundException when the todo to completed or accessed was not found.
     * @throws CollectionNotFoundException when the collection to be accessed was not found.
     * @throws InvalidCompleteCommandException for invalid complete commands.
     */
    @Override
    public void completeAction(Profile user) throws TaskNotFoundException, TodoNotFoundException,
                                    CollectionNotFoundException, InvalidCompleteCommandException {
        switch(getArg(1).toLowerCase()) {
            case "task":
                if(numOfArgs() == 4) {
                    Collection targetCollection = user.getCollection(getArg(4));
                    targetCollection.completeTask(getArg(2), getArg(3));
                    break;
                } else if(numOfArgs() == 3) {
                    Todo targetTodo = user.getTodo(getArg(3));
                    targetTodo.completeTask(getArg(2));
                    break;
                } else {
                    Task taskToComplete = user.getTask(getArg(2));
                    taskToComplete.complete();
                    break;
                }
            case "todo":
                if(numOfArgs() == 3) {
                    Collection targetCollection = user.getCollection(getArg(3));
                    targetCollection.completeTodo(getArg(2));
                    break;
                } else if(numOfArgs() == 2) {
                    Todo todoToComplete = user.getTodo(getArg(2));
                    todoToComplete.complete();
                    break;
                } else {
                    throw new InvalidCompleteCommandException(this);
                }
            default:
                throw new InvalidCompleteCommandException(this);
        }
    }

    /**
     * Returns the correct format for the complete command.
     * 
     * @return correct add command format.
     */
    public static String getCorrectCommandFormat() {
        return correctCommandFormat;
    }
}