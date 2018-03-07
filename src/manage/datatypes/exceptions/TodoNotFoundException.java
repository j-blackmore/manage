package manage.datatypes.exceptions;

/**
 * Exception which is thrown when todo with a name could be found.
 * 
 * @author J Blackmore
 */
public class TodoNotFoundException extends DataObjectNotFoundException {

    /** location where the todo was trying to be located. */
    private String searchLocation = null;

    /**
     * Creates a TodoNotFoundException where the message is the todo name.
     * 
     * @param todoName message of the exception, the task description.
     */
    public TodoNotFoundException(String todoName) {
        super(todoName);
    }

    /**
     * Creates a TodoNotFoundException where the message is the todo name.
     * 
     * @param todoName message of the exception, the todo name.
     * @param searchLocation the location the task was searched for.
     */
    public TodoNotFoundException(String todoName, String searchLocation) {
        this(todoName);
        this.searchLocation = searchLocation;
    }

    /**
     * Returns the location of where the todo that couldn't be found was searched for, 
     * null if no location.
     * 
     * @return location where task was searched for.
     */
    public String getSearchLocation() {
        return searchLocation;
    }
}
