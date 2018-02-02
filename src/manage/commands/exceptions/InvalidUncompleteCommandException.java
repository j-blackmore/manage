package manage.commands.exceptions;

import manage.commands.Command;
import manage.commands.UncompleteCommand;

/**
 * Exception which is thrown when an invalid uncomplete command is created.
 * 
 * @author J Blackmore
 */
public class InvalidUncompleteCommandException extends InvalidCommandException {
    
    /**
     * Creates an InvalidUncompleteCommandException with an error message.
     * 
     * @param message error message fo the exception.
     */
    public InvalidUncompleteCommandException(String message) {
        super(message);
    }

    /**
     * Creates an InvalidUncompleteCommandException from a command.
     * 
     * @param command the command that caused the exception.
     */
    public InvalidUncompleteCommandException(Command command) {
        this("Invalid uncomplete command: \'" + command + "\', must follow format:\n" +
             UncompleteCommand.getCorrectCommandFormat());
    }
}