package manage.commands.exceptions;

/**
 * Exception which is thrown when an invalid print command is created.
 * 
 * @author J Blackmore
 */
public class InvalidPrintCommandException extends InvalidCommandException {

    /**
     * Creates an InvalidPrintCommandException where the message is the invalid command.
     * 
     * @param command message of the exception, the command.
     */
    public InvalidPrintCommandException(String command) {
        super(command);
    }
}
