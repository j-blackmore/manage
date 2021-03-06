package manage.datatypes;

/**
 * Task data structure for manage. It contains various methods for manipulating a Task.
 * 
 * @author J Blackmore
 */
public class Task {
    private boolean complete = false; // incomplete as default
    private int order = 0;  // no ordering by default
    private String description = null;  // no item by default
    
    /**
     * Creates a task, just with a name.
     *
     * @param requiredDesc the tasks description.
     */
    public Task(String requiredDesc) {
        this.description = requiredDesc;
    }
    
    /**
     * Creates a task with a name, and an order for comparison with other tasks.
     *
     * @param requiredDesc the task's description.
     * @param requiredOrder the order amoungst other tasks.
     */
    public Task(String requiredDesc, int requiredOrder) {
        this(requiredDesc);
        this.order = requiredOrder;
    }
    
    /**
     * Sets this task's description to the given description.
     *
     * @param newTaskDesc the given description.
     */
    // TODO: Rename all changeMethods to setMethods 290698
    public void changeDesc(String newTaskDesc) {
        this.description = newTaskDesc;
    }
    
    /**
     * Sets this tasks completetion status to true.
     */
    public void complete() {
        this.complete = true;
    }

    /**
     * Gets the description of the task.
     * 
     * @return The task description.
     */
    public String getDesc() {
        return description;
    }

    /**
     * Returns the save format of this task.
     * 
     * @return save format.
     */
    public String getSaveFormat() {
        return "1:" + description + ";" + Boolean.toString(complete) + ";;";
    }

    /**
     * Returns the completion status for this task
     * 
     * @return completion status.
     */
    public boolean isComplete() {
        return complete;
    }

    /**
     * Returns the conditional toString of the task for if the option holds, else empty string.
     * 
     * @param option the condition for printing.
     * @return conditional toString of the task if the condition matches.
     */
    public String print(String option) {
        if(option.compareTo("c") == 0 && complete) {
            return toString() + "\n";
        } else if(option.compareTo("i") == 0 && !complete) {
            return toString() + "\n";
        } else {
            return "";
        }
    }

    /**
     * Sets this tasks completion status to boolean value of status.
     * 
     * @param status completion status.
     */
    public void setCompletionStatus(boolean status) {
        complete = status;
    }
    
    /**
     * Sets this tasks completetion status to false.
     */
    public void unComplete() {
        this.complete = false;
    }
    
    /**
     * Gets a string representation of this task, including its completion status. '[X]' represents complete, '[ ]' represents incomplete.
     * 
     * @return String representation of this task.
     */
    public String toString() {
        return (complete ? "[X] " : "[ ] ") + getDesc();
    }
}