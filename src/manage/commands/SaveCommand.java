package manage.commands;

import manage.commands.exceptions.InvalidCommandException;
import manage.commands.exceptions.InvalidSaveCommandException;
import manage.main.FileHandler;
import manage.main.Profile;

/**
 * Save command for Manage. Overrides the completeAction method - saves the current profile. For 
 * invalid commands, exception is thrown.
 * 
 * @author J Blackmore 
 */
public class SaveCommand extends Command {

    /** Correct format of this command */
    private String correctCommandFormat = "\'save\'";

    /**
     * Constructs a new Save Command from the command string. First argument must be 'save' and it 
     * must not have any subsequent arguments.
     * 
     * @param command the command string which the new command should be constructed from.
     * @throws InvalidCommandException for invalid commands.
     */
    public SaveCommand(String command) throws InvalidCommandException {
        super(command);
    }

    /**
     * Performs the action for the save command - saves the current profile to file
     * 
     * @param user The profile the command is to be executed on.
     */
    @Override
    public void completeAction(Profile user) {
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(user);
    }

    /**
     * Returns the correct format for this command.
     * 
     * @return correct save command format.
     */
    public String getCorrectCommandFormat() {
        return correctCommandFormat;
    }
}