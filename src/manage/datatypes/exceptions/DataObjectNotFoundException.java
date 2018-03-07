package manage.datatypes.exceptions;

/**
 * Exception which is thrown when data object with a name could not be found.
 * 
 * @author J Blackmore
 */
public class DataObjectNotFoundException extends Exception {

    /**
     * Creates a DataObjectNotFoundException where the message is the name.
     * 
     * @param name message of the exception, the object name.
     */
    public DataObjectNotFoundException(String objectName) {
        super(objectName);
    }
}