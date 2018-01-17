package manage.commands.exceptions;

/**
 * Exception which is thrown when an invalid complete command is created.
 * 
 * @author J Blackmore
 */
public class InvalidCompleteCommandException extends InvalidCommandException {

    /**
     * Creates an InvalidCompleteCommandException wher the message is the invalid command.
     * 
     * @param command message of the exception, the command.
     */
    public InvalidCompleteCommandException(String command) {
        super(command);
    }
}