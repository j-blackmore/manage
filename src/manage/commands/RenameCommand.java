package manage.commands;

import manage.commands.exceptions.InvalidRenameCommandException;
import manage.commands.exceptions.InvalidCommandException;
import manage.main.Profile;

/**
 * Rename command for Manage. Overrides the completeAction method - to rename the data object 
 * specified by the commands. For invalid commands, exception is thrown.
 * 
 * @author J Blackmore
 */
public class RenameCommand extends Command {

    /** Correct format of this command */
    private String correctCommandFormat = "";

    /**
     * Constructs a new Rename Command from the command string. First argument must be 'rename', 
     * the second must be the data object type to rename....
     * 
     * @param command the command string which the new command should be constructed from.
     * @throws InvalidCommandException for invalid commands.
     */
    public RenameCommand(String command) throws InvalidCommandException {
        super(command);
    }

    /**
     * Complete action stub.
     */
    @Override
    public void completeAction(Profile user) {

    }

    /**
     * Returns the correct format for this command.
     * 
     * @return correct rename command format.
     */
    public String getCorrectCommandFormat() {
        return correctCommandFormat;
    }
}