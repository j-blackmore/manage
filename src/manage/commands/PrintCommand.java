package manage.commands;

import manage.main.Profile;

public class PrintCommand extends Command {

    public PrintCommand(String command) {
        super(command);
    }

    @Override
    public void completeAction(Profile user) {
        switch(getArg(1).toLowerCase()) {
            case "all":
                System.out.println(user.getAll());
                break;
            case "tasks":
                System.out.println(user.getTasks());
                break;
            case "todos":
                System.out.println(user.getTodos());
                break;
            case "collections":
                System.out.println(user.getCollections());
                break;
            default:
                System.out.print("Invalid print command, must be in format: ");
                System.out.print("'print [all|tasks|todos|collections]'.\n");
                break;
        }
    }
}