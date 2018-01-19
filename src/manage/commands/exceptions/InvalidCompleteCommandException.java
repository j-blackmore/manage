package manage.commands.exceptions;

import manage.commands.Command;

/**
 * Exception which is thrown when an invalid complete command is created.
 * 
 * @author J Blackmore
 */
public class InvalidCompleteCommandException extends InvalidCommandException {

    /**
     * Creates an InvalidCompleteCommandException where the message is the invalid command.
     * 
     * @param command message of the exception, the command.
     */
    public InvalidCompleteCommandException(String command) {
        super(command);
    }

    /**
     * Creates an InvalidCompleteCommandException from a command.
     * 
     * @param command the command that caused the exception.
     */
    public InvalidCompleteCommandException(Command command) {
        this(command.toString());
    }
}