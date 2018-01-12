package manage.commands.exceptions;

/**
 * Exception which is thrown when an invalid remove command is created.
 * 
 * @author J Blackmore
 */
public class InvalidRemoveCommandException extends InvalidCommandException {

    /**
     * Creates an InvalidRemoveCommandException where the message is the invalid command.
     * 
     * @param command message of the exception, the command.
     */
    public InvalidRemoveCommandException(String command) {
        super(command);
    }
}
