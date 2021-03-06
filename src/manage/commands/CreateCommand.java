package manage.commands;

import manage.commands.exceptions.InvalidCommandException;
import manage.datatypes.*;
import manage.main.Profile;

/**
 * Create command for Manage. Overrides the completeAction method - to create the data object
 * specified by the command. For invalid commands, exception is thrown.
 * 
 * @author J Blackmore
 */
public class CreateCommand extends Command {

    /** Correct format of this command */
    private static String correctCommandFormat = 
        "\'create (task|todo|collection) <name>\'";

    /**
     * Constructs a new Create Command from the command string. First argument must be 'create',
     * the second is the data object to create and the third is it's name.
     * 
     * @param command the command string which the new command should be constructed from.
     * @throws InvalidCommandException for invalid commands.
     */
    public CreateCommand(String command) throws InvalidCommandException {
        super(command);
        setCommandType(Command.CREATE_COMMAND);
    }

    /**
     * Performs the action for the create command - create data object specified by the command.
     * For invalid commands (first arg isn't task, todo or collection) an exception is thrown.
     * 
     * @param user The profile the command is to be executed on.
     * @throws InvalidCommandException for unexpected errors in the command.
     */
    @Override
    public void completeAction(Profile user) throws InvalidCommandException {
        switch(getArg(1).toLowerCase()) {
            case "task":
                user.add(new Task(getArg(2)));
                break;
            case "todo":
                user.add(new Todo(getArg(2)));
                break;
            case "collection":
                user.add(new Collection(getArg(2)));
                break;
            default:
                throw new InvalidCommandException(this);
        }
    }

    /**
     * Returns the correct format for the create command.
     * 
     * @return correct create command format.
     */
    public static String getCorrectCommandFormat() {
        return correctCommandFormat;
    }
}