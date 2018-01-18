package manage.commands.exceptions;

/**
 * Exception which is thrown when an invalid uncomplete command is created.
 * 
 * @author J Blackmore
 */
public class InvalidUncompleteCommandException extends InvalidCommandException {
    
    /**
     * Creates an InvalidUncompleteCommandException when the message is the invalid command.
     * 
     * @param command message of the exception, the command.
     */
    public InvalidUncompleteCommandException(String command) {
        super(command);
    }
}