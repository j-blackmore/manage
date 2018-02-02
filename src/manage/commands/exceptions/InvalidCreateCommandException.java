package manage.commands.exceptions;

import manage.commands.Command;
import manage.commands.CreateCommand;

/**
 * Exception which is thrown when an invalid create command is created.
 * 
 * @author J Blackmore
 */
public class InvalidCreateCommandException extends InvalidCommandException {

    /**
     * Creates an InvalidCreateCommandException with an error message.
     * 
     * @param message error message of the exception.
     */
    public InvalidCreateCommandException(String message) {
        super(message);
    }

    /**
     * Creates an InvalidCreateCommandException from a command.
     * 
     * @param command the command that caused the exception.
     */
    public InvalidCreateCommandException(Command command) {
        this("Invalid create command: \'" + command + "\', must follow format:\n" + 
             CreateCommand.getCorrectCommandFormat());
    }
}
