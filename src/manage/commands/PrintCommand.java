package manage.commands;

import manage.commands.exceptions.InvalidCommandException;
import manage.commands.exceptions.InvalidPrintCommandException;
import manage.main.Profile;

/**
 * Print command for Manage. Overrides the completeAction method - to print what is specified
 * by the command. For invalid commands, exception is thrown.
 * 
 * @author J Blackmore
 */
public class PrintCommand extends Command {

    /** Correct format of this command */
    private static String correctCommandFormat = 
        "\'print (all|tasks|todos|collections)\'";

    /** Valid options for this command */
    private static String[] validOptions = {"i", "c"};

    /** 
     * Constructs a new Print Command from the command string. First argument must be 'print', 
     * the subsequent one is what to print.
     * 
     * @param command the command string which the new command should be constructed from.
     * @throws InvalidCommandException for invalid commands.
     */
    public PrintCommand(String command) throws InvalidCommandException {
        super(command);
        setCommandType(Command.PRINT_COMMAND);
    }

    /**
     * Performs the action for the print command - print what is specified by the commands first
     * argument. For invalid comamnds (unknown first argument) an exception is thrown.
     * 
     * @param user The profile the command is to be executed on.
     * @throws InvalidPrintCommandException for invalid print commands.
     */
    @Override
    public void completeAction(Profile user) throws InvalidPrintCommandException {
        switch(getArg(1).toLowerCase()) {
            case "all":
                if(getOptions() == null) {
                    System.out.println(user.getAll());
                } else {
                    System.out.println(user.getAll(getOption(1)));
                }
                break;
            case "tasks":
                if(getOptions() == null) {
                    System.out.println(user.getTasks());
                } else {
                    System.out.println(user.getTasks(getOption(1)));
                }
                break;
            case "todos":
                if(getOptions() == null) {
                    System.out.println(user.getTodos());
                } else {
                    System.out.println(user.getTodos(getOption(1)));
                }
                break;
            case "collections":
                if(getOptions() == null) {
                    System.out.println(user.getCollections());
                } else {
                    System.out.println(user.getCollections(getOption(1)));
                }
                break;
            default:
                throw new InvalidPrintCommandException(this);
        }
    }

    /**
     * Returns the correct format for the print command.
     * 
     * @return correct print command format.
     */
    public static String getCorrectCommandFormat() {
        return correctCommandFormat;
    }

    /**
     * Returns true if the option specified is valid for the print command, false otherwise.
     * 
     * @return boolean for if the option is valid.
     */
    public static boolean isOptionValid(String option) {
        for (int i = 0; i < validOptions.length; i++) {
            if(option.compareTo(validOptions[i]) == 0) {
                return true;
            }
        }
        return false;
    }
}