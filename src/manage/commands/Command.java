package manage.commands;

import java.util.ArrayList;

import manage.main.Profile;

public class Command {

    /** Unknown Command */
    public static final int UNKNOWN_COMMAND = 0;

    /** Exit Command */
    public static final int EXIT_COMMAND = 1;

    /** Create Command */
    public static final int CREATE_COMMAND = 2;

    /** The command without it's arguments */
    private String command;

    /** The commands type */
    private int commandType;

    /** Command's arguments */
    private ArrayList<String> args;

    public Command(String command) {
        this.command = command.trim().substring(0, command.indexOf(" "));
        args = splitArgs(command);
        commandType = classifyCommand(this);
    }

    // returns the type of the command. returns unknown if cannot be classified.
    private static int classifyCommand(Command command) {
        switch(command.getCommand().toLowerCase()) {
            case "create": if (command.numOfArgs() == 2) { return CREATE_COMMAND; }
            case "exit": case "quit": case "close": return EXIT_COMMAND;
            default: return UNKNOWN_COMMAND;
        }
    }

    /**
     * Executes the action for this command. Default action is for unknown Commands.
     * Method must be overwritten in subclasses.
     * 
     * @param user Profile of the user
     */
    public void completeAction(Profile user) {
        System.out.println("Unknown Command, type 'help' for a list of commands");
    }
    
    /**
     * Returns a string representation of the argument specified by arg. Indexing begins at 1.
     * Arguments are distinguished by spaces or quotes. Quotes are not returned if they are used.
     * 
     * @param arg the specified argument
     * @throws IndexOutOfBoundsException 290698
     * @return argument specified by arg
     */
    public String getArg(int arg) throws IndexOutOfBoundsException {
        if(arg > args.size()) {
            throw new IndexOutOfBoundsException("Command has no argument: " + arg);
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
     * Returns the number of arguments in this command. Arguments are distinguished by spaces or quotes.
     * Excess white space before, between and after arguments is ignored.

     * @return number of arguments
     */
    public int numOfArgs() {
        return args.size();
    }

    // splits the command into its arguments and returns array list of arguments.
    private static ArrayList<String> splitArgs(String command) {
        ArrayList<String> args = new ArrayList<String>();
        String remainingCommand = command.trim();
        remainingCommand = remainingCommand.substring(remainingCommand.indexOf(" ")).trim();

        while(remainingCommand.contains(" ")) {
            if(Character.compare(remainingCommand.charAt(0), '\"') == 0) {
                args.add(remainingCommand.substring(0, remainingCommand.indexOf('"', 1)));
                remainingCommand = remainingCommand.substring(remainingCommand.indexOf('"', 1));
            } else if(Character.compare(remainingCommand.charAt(0), '\'') == 0) {
                args.add(remainingCommand.substring(0, remainingCommand.indexOf("'", 1)));
                remainingCommand = remainingCommand.substring(remainingCommand.indexOf("'", 1));
            } else {
                args.add(remainingCommand.substring(0, remainingCommand.indexOf(" ", 1)));
                remainingCommand = remainingCommand.substring(remainingCommand.indexOf(" ", 1));
            }

            remainingCommand = remainingCommand.trim();
        }

        // add final argument, if it exists
        if(remainingCommand.length() != 0) {
            args.add(remainingCommand);
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