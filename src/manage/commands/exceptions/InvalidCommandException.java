package manage.commands.exceptions;

/**
 * Exception which is thrown when an invalid/unknown command is created.
 * 
 * @author J Blackmore
 */
public class InvalidCommandException extends Exception {

    /**
     * Creates an InvalidCommandException where the message is the invalid command.
     * 
     * @param command message of the exception, the command.
     */
    public InvalidCommandException(String command) {
        super(command);
    }
}
