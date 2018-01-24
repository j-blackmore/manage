package manage.commands.exceptions;

import manage.commands.RemoveCommand;

/**
 * Exception which is thrown when an invalid remove command is created.
 * 
 * @author J Blackmore
 */
public class InvalidRemoveCommandException extends InvalidCommandException {

    /**
     * Creates an InvalidRemoveCommandException with an error message.
     * 
     * @param message error message of the exception.
     */
    public InvalidRemoveCommandException(String message) {
        super(message);
    }

    /**
     * Creates an InvalidRemoveCommandException from a command.
     * 
     * @param command the command that caused the exception.
     */
    public InvalidRemoveCommandException(RemoveCommand command) {
        this("Invalid remove command :\'" + command + "\', must follow format:\n" +
             command.getCorrectCommandFormat());
    }
}
