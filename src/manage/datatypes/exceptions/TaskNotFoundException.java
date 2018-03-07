package manage.datatypes.exceptions;

/**
 * Exception which is thrown when task with a description could be found.
 * 
 * @author J Blackmore
 */
public class TaskNotFoundException extends DataObjectNotFoundException {

    /** location where the task was trying to be located. */
    private String searchLocation = null;

    /**
     * Creates a TaskNotFoundException where the message is the task description.
     * 
     * @param taskDesc message of the exception, the task description.
     */
    public TaskNotFoundException(String taskDesc) {
        super(taskDesc);
    }

    /**
     * Creates a TaskNotFoundException where the message is the task description.
     * 
     * @param taskDesc message of the exception, the task description.
     * @param searchLocation the location the task was searched for.
     */
    public TaskNotFoundException(String taskDesc, String searchLocation) {
        this(taskDesc);
        this.searchLocation = searchLocation;
    }

    /**
     * Returns the location of where the task that couldn't be found was searched for, 
     * null if no location.
     * 
     * @return location where task was searched for.
     */
    public String getSearchLocation() {
        return searchLocation;
    }
}
