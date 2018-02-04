package manage.commands;

import manage.commands.exceptions.InvalidCommandException;
import manage.commands.exceptions.InvalidHelpCommandException;
import manage.main.Profile;

/**
 * Help command for Manage. Overrides the completeAction method - to provide general help or 
 * specific help specified by the command. For invalid commands, exception is thrown.
 * 
 * @author J Blackmore
 */
public class HelpCommand extends Command {

    /** Correct format of this command */
    private static String correctCommandFormat = "\'help [<command>]\'";

    /**
     * Constructs a new Help Command from the command string. First argument must be 'help', the 
     * following can either not exist or be another command.
     * 
     * @param command the command string which the new command should be constructed from.
     * @throws InvalidCommandException for invalid commands.
     */
    public HelpCommand(String command) throws InvalidCommandException {
        super(command);
        setCommandType(Command.HELP_COMMAND);
    }

    /**
     * Performs the action for the help command - provide general help or specific help for a 
     * specific command. For invalid commands an exception is thrown.
     * 
     * @param user The profile the command is to be executed on.
     * @throws InvalidHelpCommandException for invalid help commands.
     */
    @Override
    public void completeAction(Profile user) throws InvalidHelpCommandException {
        if(numOfArgs() == 0) {
            System.out.println("Add \t\t  |  Add a new or pre existing object to another");
            System.out.println("Close \t\t  |  Saves and closes the program");
            System.out.println("Complete \t  |  Set completion status of a data object to true");
            System.out.println("Create \t\t  |  Create a new data object");
            System.out.println("Exit \t\t  |  Saves and closes the program");
            System.out.println("Help \t\t  |  Prints list of available commands. If a command is " + 
                               "specified after, prints a detailed explanation of that command");
            System.out.println("Print \t\t  |  Prints the specified data objects, or all");
            System.out.println("Quit \t\t  |  Saves and closes the program");
            System.out.println("Remove \t\t  |  Removes a pre existing data object");
            System.out.println("Rename \t\t  |  Renames a pre existing data object");
            System.out.println("Save \t\t  |  Saves the current profile to file");
            System.out.println("Uncomplete \t  |  Set completion status of a data object to false");
        } else if(numOfArgs() == 1) {
            switch(getArg(1).toLowerCase()) {
                case "add":
                    System.out.println("Add command adds a new or pre existing data object to  another object");
                    System.out.println(AddCommand.getCorrectCommandFormat());
                    break;
                case "close":
                    System.out.println("Close command saves and closes the program");
                    System.out.println(ExitCommand.getCorrectCommandFormat());
                    break;
                case "complete":
                    System.out.println("Complete command sets completion status of a data object to true");
                    System.out.println(CompleteCommand.getCorrectCommandFormat());
                    break;
                case "create":
                    System.out.println("Create command creates a new data object");
                    System.out.println(CreateCommand.getCorrectCommandFormat());
                    break;
                case "exit":
                    System.out.println("Exit command saves and closes the program");
                    System.out.println(ExitCommand.getCorrectCommandFormat());
                    break;
                case "print":
                    System.out.println("Print command prints the specified data objects or all");
                    System.out.println(PrintCommand.getCorrectCommandFormat());
                    break;
                case "quit":
                    System.out.println("Quit command saves and closes the program");
                    System.out.println(ExitCommand.getCorrectCommandFormat());
                    break;
                case "remove":
                    System.out.println("Remove command removes a pre existing data object");
                    System.out.println(RemoveCommand.getCorrectCommandFormat());
                    break;
                case "rename":
                    System.out.println("Rename command renames a pre existing data object");
                    System.out.println(RenameCommand.getCorrectCommandFormat());
                    break;
                case "save":
                    System.out.println("Save command saves the current profile to file");
                    System.out.println(SaveCommand.getCorrectCommandFormat());
                    break;
                case "uncomplete":
                    System.out.println("Uncomplete command sets teh completion status of a data object to false");
                    System.out.println(UncompleteCommand.getCorrectCommandFormat());
                    break;
                default:
                    throw new InvalidHelpCommandException(this);
            }
        } else {
            throw new InvalidHelpCommandException(this);
        }
    }

    /**
     * Returns the correct format for the help command.
     * 
     * @return correct help command format.
     */
    public static String getCorrectCommandFormat() {
        return correctCommandFormat;
    }
}