package manage.commands.exceptions;

import manage.commands.Command;
import manage.commands.RenameCommand;

/**
 * Exception which is thrown when an invalid rename command is created
 * 
 * @author J Blackmore
 */
public class InvalidRenameCommandException extends InvalidCommandException {
    
    /**
     * Creates an InvalidRenameCommandException with an error message.
     * 
     * @param message error message of the exception.
     */
    public InvalidRenameCommandException(String message) {
        super(message);
    }

    /**
     * Creates an InvalidRenameCommandException from a Command.
     * 
     * @param command the command that caused the exception.
     */
    public InvalidRenameCommandException(Command command) {
        this("Invalid rename command: \'" + command + "\', must follow format:\n" +
             RenameCommand.getCorrectCommandFormat());
    }
    
}