package manage.commands;

import manage.commands.exceptions.InvalidCommandException;
import manage.main.Profile;

/**
 * Exit command for Manage. Overrides the completeAction method - saves then exits. For invalid 
 * commands, exception is thrown.
 * 
 * @author J Blackmore
 */
public class ExitCommand extends Command {

    /** Correct format of this command */
    private static String correctCommandFormat = "\'(exit|close|quit)\'";

    /**
     * Constructs a new Exit Command from the command string. First argument must be either 'exit', 
     * 'quit' or 'close'. 
     * 
     * @param command the command string which the new command should be constructed from/
     * @throws InvalidCommandException for invalid commands.
     */
    public ExitCommand(String command) throws InvalidCommandException {
        super(command);
        setCommandType(Command.EXIT_COMMAND);
    }

    /**
     * Performs the action for the exit command - calls save and gets ready for exit.
     * 
     * @param user The profile the command is to be executed on.
     * @throws Exception for errors occurring when saving.
     */
    @Override
    public void completeAction(Profile user) throws Exception {
        Command saveCommand = new SaveCommand("save");
        saveCommand.completeAction(user);
        System.out.println("Exiting manage... Goodbye.");
    }

    /**
     * Returns the correct format for the exit command.
     * 
     * @return correct exit command format.
     */
    public static String getCorrectCommandFormat() {
        return correctCommandFormat;
    }
}