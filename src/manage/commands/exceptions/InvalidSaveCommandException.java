package manage.commands.exceptions;

import manage.commands.SaveCommand;

/**
 * Exception which is thrown when an invalid save command is created.
 * 
 * @author J Blackmore
 */
public class InvalidSaveCommandException extends InvalidCommandException {

    /**
     * Creates an InvalidSaveCommandException with an error message.
     * 
     * @param message error message of the exception.
     */
    public InvalidSaveCommandException(String message) {
        super(message);
    }

    /**
     * Creates an InvalidSaveCommandException from a command.
     * 
     * @param command the command that caused the exception.
     */
    public InvalidSaveCommandException(SaveCommand command) {
        this("Invalid save command: \'" + command + "\', must follow format:\n" +
             command.getCorrectCommandFormat());
    }
}