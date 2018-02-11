package manage.commands;

import java.util.ArrayList;

import manage.commands.exceptions.InvalidCommandException;
import manage.main.Profile;

/**
 * Default Command for Manage, contains static info about all Commands.
 * Created whenever a command is entered in Manage.
 * 
 * @author J Blackmore
 */
public class Command {

    /** Unknown Command */
    public static final int UNKNOWN_COMMAND = 0;

    /** Exit Command */
    public static final int EXIT_COMMAND = 1;

    /** Create Command */
    public static final int CREATE_COMMAND = 2;

    /** Add Command */
    public static final int ADD_COMMAND = 3;

    /** Remove Command */
    public static final int REMOVE_COMMAND = 4;

    /** Complete Command */
    public static final int COMPLETE_COMMAND = 5;

    /** Uncomplete Command */
    public static final int UNCOMPLETE_COMMAND = 6;

    /** Rename Command */
    public static final int RENAME_COMMAND = 7;

    /** Save Command */
    public static final int SAVE_COMMAND = 8;

    /** Help Command */
    public static final int HELP_COMMAND = 9;

    /** Print Command */
    public static final int PRINT_COMMAND = 10;

    /** The command without it's arguments */
    private String command;

    /** The commands type, default is unknown command */
    private int commandType = UNKNOWN_COMMAND;

    /** Command's arguments */
    private ArrayList<String> args;

    /** Command's options */
    private ArrayList<String> options;

    /**
     * Constructs a new command from the command string. First argument is the command,
     * the subsequent ones are it's arguments.
     * 
     * @param command the command string which the new command should be constructed from.
     * @throws InvalidCommandException when the command created is an unknown command.
     */
    public Command(String command) throws InvalidCommandException {
        if(command.contains(" "))
            this.command = command.trim().substring(0, command.indexOf(" "));
        else
            this.command = command;

        args = splitArgs(command);
        options = extractOptions(command);
    }

    /**
     * Constructs a new blank unknown command. 
     */
    public Command() {
        command = null;
        args = null;
        options = null;
    }

    /**
     * Executes the action for this command. Default action is do nothing.
     * Method must be overwritten in subclasses.
     * 
     * @param user Profile of the user
     * @throws Exception for any error caused when trying to execute the command action.
     */
    public void completeAction(Profile user) throws Exception {
    
    }

    private static ArrayList<String> extractOptions(String command) {
        ArrayList<String> options = null;
        if(!command.contains(" ")) {
            return options;
        }

        String remainingCommand = command.substring(command.indexOf(" ") + 1).trim();

        if(Character.compare(remainingCommand.charAt(0), '-') == 0) {
            options = new ArrayList<String>();
            remainingCommand = remainingCommand.substring(1, remainingCommand.indexOf(" "));
            for(int i = 0; i < remainingCommand.length(); i++) {
                options.add(i, remainingCommand.substring(0, 1));
                remainingCommand = remainingCommand.substring(1);
            }
        }

        return options;
    }
    
    /**
     * Returns a string representation of the argument specified by arg. Indexing begins at 1.
     * Arguments are distinguished by spaces or quotes. Quotes are not returned if they are used.
     * Returns null if arg exceeds the number of arguments this command has.
     * 
     * @param arg the specified argument
     * @return argument specified by arg
     */
    public String getArg(int arg) {
        if(arg > args.size()) {
            return null;
        }
        return args.get(arg-1);
    }

    /**
     * Returns just the command (without arguments).
     * 
     * @return the command
     */
    public String getCommand() {
        return command;
    }

    /**
     * Returns the command type.
     * 
     * @return command type
     */
    public int getCommandType() {
        return commandType;
    }

    /**
     * Returns the string of the option specified by option. Indexing begins at 1. Null is returned 
     * for option value out of bounds. Options are signified by a '-' preceeding them, and are 
     * currently only 1 character long.
     * 
     * @param option the specified option.
     * @return option specified by option.
     */
    public String getOption(int option) {
        if(option > options.size()) {
            return null;
        }
        return options.get(option-1);
    }

    /**
     * Returns the ArrayList of all options for this command.
     * 
     * @return list of options.
     */
    public ArrayList<String> getOptions() {
        return options;
    }

    /**
     * Returns the string representation of all options, null if none exist.
     * 
     * @return string representation of all options.
     */
    public String getOptionsString() {
        if(this.options == null) {
            return null;
        }

        String options = "";
        for(int i = 0; i < this.options.size(); i++) {
            options += this.options.get(i);
        }
        return options;
    }

    /**
     * Returns the number of arguments in this command. Arguments are distinguished by spaces or quotes.
     * Excess white space before, between and after arguments is ignored.

     * @return number of arguments
     */
    public int numOfArgs() {
        return args.size();
    }

    /**
     * Sets the commands command type to the given commandType
     * 
     * @param commandType the command type
     */
    public void setCommandType(int commandType) {
        this.commandType = commandType;
    }

    // splits the command into its arguments and returns array list of arguments.
    private static ArrayList<String> splitArgs(String command) {
        ArrayList<String> args = new ArrayList<String>();
        String remainingCommand = command.trim();

        // avoids StringIndexOutOfBounds if no spaces in command
        if(remainingCommand.contains(" ")) {
            remainingCommand = remainingCommand.substring(remainingCommand.indexOf(" ") + 1).trim();

            while(remainingCommand.contains(" ")) {
                if(Character.compare(remainingCommand.charAt(0), '\"') == 0) {
                    args.add(remainingCommand.substring(1, remainingCommand.indexOf('\"', 1)));
                    remainingCommand = remainingCommand.substring(remainingCommand.indexOf('\"', 1) + 1);
                } else if(Character.compare(remainingCommand.charAt(0), '\'') == 0) {
                    args.add(remainingCommand.substring(1, remainingCommand.indexOf("\'", 1)));
                    remainingCommand = remainingCommand.substring(remainingCommand.indexOf("\'", 1) + 1);
                } else if(Character.compare(remainingCommand.charAt(0), '-') == 0) {
                    // if an option, skip it - options are extracted else where
                    remainingCommand = remainingCommand.substring(remainingCommand.indexOf(" ") + 1);
                } else {
                    args.add(remainingCommand.substring(0, remainingCommand.indexOf(" ", 1)));
                    remainingCommand = remainingCommand.substring(remainingCommand.indexOf(" ", 1) + 1);
                }

                remainingCommand = remainingCommand.trim();
            }

            // add final argument, if it exists
            if(remainingCommand.length() != 0) {
                if(Character.compare(remainingCommand.charAt(0), '\"') == 0 ||
                   Character.compare(remainingCommand.charAt(0), '\'') == 0) {
                    args.add(remainingCommand.substring(1, remainingCommand.length() - 1));
                } else {
                    args.add(remainingCommand);
                }
            }
        }

        return args;
    }

    /**
     * Returns string representation of the command, with arguments.
     * 
     * @return the full command
     */
    public String toString() {
        String commandToReturn = command;
        for(int i = 0; i < args.size(); i++) {
            if (args.get(i).contains(" "))
                commandToReturn += " \"" + args.get(i) + "\"";
            else 
                commandToReturn += " " + args.get(i);
        }

        return commandToReturn;
    }
}