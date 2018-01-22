package manage.commands.exceptions;

import manage.commands.CompleteCommand;

/**
 * Exception which is thrown when an invalid complete command is created.
 * 
 * @author J Blackmore
 */
public class InvalidCompleteCommandException extends InvalidCommandException {

    /**
     * Creates an InvalidCompleteCommandException with an error message.
     * 
     * @param message error message of the exception.
     */
    public InvalidCompleteCommandException(String message) {
        super(message);
    }

    /**
     * Creates an InvalidCompleteCommandException from a command.
     * 
     * @param command the command that caused the exception.
     */
    public InvalidCompleteCommandException(CompleteCommand command) {
        this("Invalid complete command: \'" + command + "\', must follow format:\n" + 
             command.getCorrectCommandFormat());
    }
}