package manage.commands;

import manage.commands.exceptions.InvalidCommandException;
import manage.datatypes.*;
import manage.datatypes.exceptions.*;
import manage.main.Profile;

/**
 * Rename command for Manage. Overrides the completeAction method - to rename the data object 
 * specified by the commands. For invalid commands, exception is thrown.
 * 
 * @author J Blackmore
 */
public class RenameCommand extends Command {

    /** Correct format of this command */
    private static String correctCommandFormat = 
        "\'rename (task|todo|collection) <newname> <oldname>\'" +
        "\'rename (task|todo) <newname> <oldname> <destination1>\'\n" +
        "\'rename task <newname> <oldname> <destination1> <destination2>\'\n";

    /**
     * Constructs a new Rename Command from the command string. First argument must be 'rename', 
     * the second must be the data object type to rename, the third it's new name and the fourth its 
     * old name. Subsequent arguments are the destination of where the object to be renamed is.
     * 
     * @param command the command string which the new command should be constructed from.
     * @throws InvalidCommandException for invalid commands.
     */
    public RenameCommand(String command) throws InvalidCommandException {
        super(command);
        setCommandType(Command.RENAME_COMMAND);
    }

    /**
     * Performs the action for the rename command - rename the data object specified by the command.
     * For invalid commands (non-existing objects) an exception is thrown.
     * 
     * @param user The profile the command is to be executed on.
     * @throws TaskNotFoundException when the task to be renamed was not found.
     * @throws TodoNotFoundException when the todo to be renamed or accessed from was not found.
     * @throws CollectionNotFoundException when the collection to be renamed or accessed from was not found.
     * @throws InvalidCommandException for unexpected errors in the command.
     */
    @Override
    public void completeAction(Profile user) throws TaskNotFoundException, TodoNotFoundException, 
                                    CollectionNotFoundException, InvalidCommandException {
        switch(getArg(1).toLowerCase()) {
            case "task":
                if(numOfArgs() == 5) {
                    Collection targetCollection = user.getCollection(getArg(5));
                    targetCollection.changeTaskDesc(getArg(3), getArg(2), getArg(4));
                    break;
                } else if(numOfArgs() == 4) {
                    Todo targetTodo = user.getTodo(getArg(4));
                    targetTodo.changeTaskDesc(getArg(3), getArg(2));
                    break;
                } else if(numOfArgs() == 3) {
                    Task taskToRename = user.getTask(getArg(3));
                    taskToRename.changeDesc(getArg(2));
                    break;
                } else {
                    throw new InvalidCommandException(this);
                }
            case "todo":
                if(numOfArgs() == 4) {
                    Collection targetCollection = user.getCollection(getArg(4));
                    targetCollection.changeTodoName(getArg(3), getArg(2));
                    break;
                } else if(numOfArgs() == 3) {
                    Todo todoToRename = user.getTodo(getArg(3));
                    todoToRename.changeName(getArg(2));
                    break;
                } else {
                    throw new InvalidCommandException(this);
                }
            case "collection":
                if(numOfArgs() == 3) {
                    Collection collectionToRename = user.getCollection(getArg(3));
                    collectionToRename.changeName(getArg(2));
                    break;
                } else {
                    throw new InvalidCommandException(this);
                }
            default:
                throw new InvalidCommandException(this);
        }
    }

    /**
     * Returns the correct format for the rename command.
     * 
     * @return correct rename command format.
     */
    public static String getCorrectCommandFormat() {
        return correctCommandFormat;
    }
}