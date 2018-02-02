package manage.commands.exceptions;

import manage.commands.Command;

/**
 * Exception which is thrown when an invalid/unknown command is created.
 * 
 * @author J Blackmore
 */
public class InvalidCommandException extends Exception {

    /**
     * Creates an InvalidCommandException where the message is the invalid command.
     * 
     * @param command message of the exception, the command.
     */
    public InvalidCommandException(String command) {
        super(command);
    }

    /**
     * Creates an InvalidCommandException from a command.
     * 
     * @param command the command that caused the exception.
     */
    public InvalidCommandException(Command command) {
        this("Invalid command: \'" + command + "\', type 'help' for a list of commands");
    }
}
