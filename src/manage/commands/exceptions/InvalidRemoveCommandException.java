package manage.commands.exceptions;

import manage.commands.Command;

/**
 * Exception which is thrown when an invalid remove command is created.
 * 
 * @author J Blackmore
 */
public class InvalidRemoveCommandException extends InvalidCommandException {

    /**
     * Creates an InvalidRemoveCommandException where the message is the invalid command.
     * 
     * @param command message of the exception, the command.
     */
    public InvalidRemoveCommandException(String command) {
        super(command);
    }

    /**
     * Creates an InvalidRemoveCommandException from a command.
     * 
     * @param command the command that caused the exception.
     */
    public InvalidRemoveCommandException(Command command) {
        this(command.toString());
    }
}
