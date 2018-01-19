package manage.commands.exceptions;

import manage.commands.Command;

/**
 * Exception which is thrown when an invalid print command is created.
 * 
 * @author J Blackmore
 */
public class InvalidPrintCommandException extends InvalidCommandException {

    /**
     * Creates an InvalidPrintCommandException where the message is the invalid command.
     * 
     * @param command message of the exception, the command.
     */
    public InvalidPrintCommandException(String command) {
        super(command);
    }

    /**
     * Creates an InvalidPrintCommandException from a command.
     * 
     * @param command the command that caused the exception.
     */
    public InvalidPrintCommandException(Command command) {
        this(command.toString());
    }
}
