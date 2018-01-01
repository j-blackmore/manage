package manage.commands;

import manage.datatypes.*;
import manage.main.Profile;

public class CreateCommand extends Command {

    public CreateCommand(String command) {
        super(command);
    }

    @Override
    public void completeAction(Profile user) {
        switch(getArg(1).toLowerCase()) {
            case "task":
                user.tasks.add(new Task(getArg(2)));
                break;
            case "todo":
                user.todos.add(new Todo(getArg(2)));
                break;
            case "collection":
                user.collections.add(new Collection(getArg(2)));
                break;
            default:
                System.out.print("Invalid create command, must be in format: ");
                System.out.print("'create [task|todo|collection] name'.\n");
                break;
        }
    }
}