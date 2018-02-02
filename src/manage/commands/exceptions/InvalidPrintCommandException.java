package manage.commands.exceptions;

import manage.commands.Command;
import manage.commands.PrintCommand;

/**
 * Exception which is thrown when an invalid print command is created.
 * 
 * @author J Blackmore
 */
public class InvalidPrintCommandException extends InvalidCommandException {

    /**
     * Creates an InvalidPrintCommandException with an error message.
     * 
     * @param message error message of the exception.
     */
    public InvalidPrintCommandException(String message) {
        super(message);
    }

    /**
     * Creates an InvalidPrintCommandException from a command.
     * 
     * @param command the command that caused the exception.
     */
    public InvalidPrintCommandException(Command command) {
        this("Invalid print command: \'" + command + "\', must follow format:\n" +
             PrintCommand.getCorrectCommandFormat());
    }
}
