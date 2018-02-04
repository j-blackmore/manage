package manage.commands.exceptions;

import manage.commands.Command;
import manage.commands.HelpCommand;

/**
 * Exception which is thrown when an invalid help command is created.
 * 
 * @author J Blackmore
 */
public class InvalidHelpCommandException extends InvalidCommandException {

    /**
     * Creates an InvalidHelpCommandException with an error message.
     * 
     * @param message error message of the exception.
     */
    public InvalidHelpCommandException(String message) {
        super(message);
    }

    /**
     * Creates an InvalidHelpCommandException from a Command.
     * 
     * @param command the command that caused the exception.
     */
    public InvalidHelpCommandException(Command command) {
        this("Invalid help command: \'" + command + "\', must follow format:\n" +
             HelpCommand.getCorrectCommandFormat());
    }
}