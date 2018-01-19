package manage.commands.exceptions;

import manage.commands.Command;

/**
 * Exception which is thrown when an invalid create command is created.
 * 
 * @author J Blackmore
 */
public class InvalidCreateCommandException extends InvalidCommandException {

    /**
     * Creates an InvalidCreateCommandException where the message is the invalid command.
     * 
     * @param command message of the exception, the command.
     */
    public InvalidCreateCommandException(String command) {
        super(command);
    }

    /**
     * Creates an InvalidCreateCommandException from a command.
     * 
     * @param command the command that caused the exception.
     */
    public InvalidCreateCommandException(Command command) {
        this(command.toString());
    }
}
