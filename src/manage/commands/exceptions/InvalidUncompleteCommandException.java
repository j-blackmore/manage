package manage.commands.exceptions;

import manage.commands.Command;

/**
 * Exception which is thrown when an invalid uncomplete command is created.
 * 
 * @author J Blackmore
 */
public class InvalidUncompleteCommandException extends InvalidCommandException {
    
    /**
     * Creates an InvalidUncompleteCommandException when the message is the invalid command.
     * 
     * @param command message of the exception, the command.
     */
    public InvalidUncompleteCommandException(String command) {
        super(command);
    }

    /**
     * Creates an InvalidUncompleteCommandException from a command.
     * 
     * @param command the command that caused the exception.
     */
    public InvalidUncompleteCommandException(Command command) {
        this(command.toString());
    }
}