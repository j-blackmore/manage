package manage.commands.exceptions;

import manage.commands.Command;

/**
 * Exception which is thrown when an invalid add command is created.
 * 
 * @author J Blackmore
 */
public class InvalidAddCommandException extends InvalidCommandException {

    /**
     * Creates an InvalidAddCommandException where the message is the invalid command.
     * 
     * @param command message of the exception, the command.
     */
    public InvalidAddCommandException(String command) {
        super(command);
    }

    /**
     * Creates an InvalidAddCommandException from a Command.
     * 
     * @param command the command that caused the exception.
     */
    public InvalidAddCommandException(Command command) {
        this(command.toString());
    }
}
