package manage.commands.exceptions;

/**
 * Exception which is thrown when an invalid add command is created.
 * 
 * @author J Blackmore
 */
public class InvalidAddCommandException extends InvalidCommandException {

    /**
     * Creates an InvalidAddCommandException where the message is the invalid command.
     * 
     * @param command message of the exception, the command.
     */
    public InvalidAddCommandException(String command) {
        super(command);
    }
}
