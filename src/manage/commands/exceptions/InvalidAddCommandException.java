package manage.commands.exceptions;

import manage.commands.AddCommand;

/**
 * Exception which is thrown when an invalid add command is created.
 * 
 * @author J Blackmore
 */
public class InvalidAddCommandException extends InvalidCommandException {

    /**
     * Creates an InvalidAddCommandException with an error message.
     * 
     * @param message error message of the exception.
     */
    public InvalidAddCommandException(String message) {
        super(message);
    }

    /**
     * Creates an InvalidAddCommandException from a Command.
     * 
     * @param command the command that caused the exception.
     */
    public InvalidAddCommandException(AddCommand command) {
        this("Invalid add command: \'" + command + "\', must follow format:\n" + 
             command.getCorrectCommandFormat());
    }
}
