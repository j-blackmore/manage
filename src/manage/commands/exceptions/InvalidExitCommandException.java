package manage.commands.exceptions;

import manage.commands.Command;
import manage.commands.ExitCommand;

/**
 * Exception which is thrown when an invalid exit command is created.
 * 
 * @author J Blackmore
 */
public class InvalidExitCommandException extends InvalidCommandException {
    
    /**
     * Creates an InvalidExitCommandException with an error message.
     * 
     * @param message error message of the exception.
     */
    public InvalidExitCommandException(String message) {
        super(message);
    }

    /**
     * Creates n InvalidExitCommandException from a command.
     * 
     * @param command the commands that caused the exception.
     */
    public InvalidExitCommandException(Command command) {
        this("Invalid exit command: \'" + command + "\', must follow format:\n" +
             ExitCommand.getCorrectCommandFormat());
    }
}