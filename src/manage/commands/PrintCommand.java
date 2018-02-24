package manage.commands;

import manage.datatypes.exceptions.CollectionNotFoundException;
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
        "\'print [option] (all|tasks|todos|collections|<collection>)\'";

    /** Valid options for this command */
    private static String validOptions = 
        "  -i\t Print only incomplete tasks and todos.\n" + 
        "  -c\t Print only complete tasks and todos.";

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
     * @throws CollectionNotFoundException for trying to print collections which don't exist.
     */
    @Override
    public void completeAction(Profile user) throws InvalidPrintCommandException, 
                                                                    CollectionNotFoundException {
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
            default:    // assumes arg was a data object to print, attempts to print that
                if(getOptions() != null) {
                    System.out.println(user.getCollection(getArg(1), getOption(1)));
                } else {
                    System.out.println(user.getCollection(getArg(1)));
                }
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
     * Returns the valid options and information about them for the print command.
     * 
     * @return valid options.
     */
    public static String getValidOptions() {
        return validOptions;
    }
}