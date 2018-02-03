package manage.commands;

import manage.commands.exceptions.*;

/**
 * Command Validator for checking commands inputted by users in Manage, are valid.
 * 
 * @author J Blackmore
 */
public class CommandValidator {

    /**
     * Validates a command by calling the respective method given the type of command. Returns true 
     * for a valid command, exception is thrown for invalid commands.
     * 
     * @param command the command to be validated.
     * @return true for valid commands, false otherwise.
     * @throws InvalidCommandException for invalid commands, more specific InvalidCommandExceptions 
     * are thrown for known commands.
     */
    public static boolean validateCommand(Command command) throws InvalidCommandException {
        switch(command.getCommand().toLowerCase()) {
            case "add":
                return isAddCommandValid(command);
            case "complete":
                return isCompleteCommandValid(command);
            case "create":
                return isCreateCommandValid(command);
            case "print":
                return isPrintCommandValid(command);
            case "remove":
                return isRemoveCommandValid(command);
            case "rename":
                return isRenameCommandValid(command);
            case "save":
                return isSaveCommandValid(command);
            case "uncomplete":
                return isUncompleteCommandValid(command);
            case "exit": case "quit": case "close":
                return isExitCommandValid(command);
            default:
                throw new InvalidCommandException(command);
        }
    }

    // add command format: "add [task|todo] <name> <destination1> <destination2>"
    private static boolean isAddCommandValid(Command command) throws InvalidAddCommandException {
        if(command.numOfArgs() == 3) {
            String firstArg = command.getArg(1);
            if(firstArg.equalsIgnoreCase("task") || firstArg.equalsIgnoreCase("todo")) {
                return true;
            }
        } else if(command.numOfArgs() == 4) {
            if(command.getArg(1).equalsIgnoreCase("task")) {
                return true;
            } else if(command.getArg(1).equalsIgnoreCase("new") && command.getArg(2).equalsIgnoreCase("todo")) {
                return true;
            }
        } else if(command.numOfArgs() == 5) {
            if(command.getArg(1).equalsIgnoreCase("new") && command.getArg(2).equalsIgnoreCase("task")) {
                return true;
            }
        }

        throw new InvalidAddCommandException(command);
    }

    // complete command format: "complete [task|todo] <name> <location1> <location2>"
    private static boolean isCompleteCommandValid(Command command) throws InvalidCompleteCommandException {
        if(command.numOfArgs() == 2 || command.numOfArgs() == 3) {
            String firstArg = command.getArg(1);
            if(firstArg.equalsIgnoreCase("task") || firstArg.equalsIgnoreCase("todo")) {
                return true;
            }
        } else if(command.numOfArgs() == 4) {
            if(command.getArg(1).equalsIgnoreCase("task")) {
                return true;
            }
        }

        throw new InvalidCompleteCommandException(command);
    }

    // create command format: "create [task|todo|collection] <name>"
    private static boolean isCreateCommandValid(Command command) throws InvalidCreateCommandException {
        if(command.numOfArgs() == 2) {
            if(command.getArg(1).equalsIgnoreCase("task") || command.getArg(1).equalsIgnoreCase("todo") ||
               command.getArg(1).equalsIgnoreCase("collection")) {
                return true;
            }
        }
        throw new InvalidCreateCommandException(command);
    }

    private static boolean isExitCommandValid(Command command) throws InvalidExitCommandException {
        if(command.numOfArgs() == 0) {
            return true;
        }
        throw new InvalidExitCommandException(command);
    }

    // print command format: "print [tasks|todos|collections|all]"
    private static boolean isPrintCommandValid(Command command) throws InvalidPrintCommandException {
        if(command.numOfArgs() == 1) {
            if(command.getArg(1).equalsIgnoreCase("tasks") || command.getArg(1).equalsIgnoreCase("todos") ||
               command.getArg(1).equalsIgnoreCase("collections") || command.getArg(1).equalsIgnoreCase("all")) {
                return true;
               }
        }
        throw new InvalidPrintCommandException(command);
    }

    // remove command format: "remove [task|todo|collection] <name> <destination1> <destination2>"
    private static boolean isRemoveCommandValid(Command command) throws InvalidRemoveCommandException {
        if(command.numOfArgs() == 2 || command.numOfArgs() == 3 ) {
            String firstArg = command.getArg(1);
            if(firstArg.equalsIgnoreCase("task") || firstArg.equalsIgnoreCase("todo")) {
                return true;
            } else if(firstArg.equalsIgnoreCase("collection") && command.numOfArgs() == 2) {
                return true;
            }
        } else if(command.numOfArgs() == 4) {
            if(command.getArg(1).equalsIgnoreCase("task")) {
                return true;
            }
        }

        throw new InvalidRemoveCommandException(command);
    }

    // rename command format: "rename [task|todo|collection] <newname> <oldname> <destination1> <destination2>"
    private static boolean isRenameCommandValid(Command command) throws InvalidRenameCommandException {
        if(command.numOfArgs() == 3 || command.numOfArgs() == 4) {
            String firstArg = command.getArg(1);
            if(firstArg.equalsIgnoreCase("task") || firstArg.equalsIgnoreCase("todo")) {
                return true;
            } else if(firstArg.equalsIgnoreCase("collection") && command.numOfArgs() == 3) {
                return true;
            }
        } else if(command.numOfArgs() == 5) {
            if(command.getArg(1).equalsIgnoreCase("task")) {
                return true;
            }
        }

        throw new InvalidRenameCommandException(command);
    }

    // save command format: "save"
    private static boolean isSaveCommandValid(Command command) throws InvalidSaveCommandException {
        if(command.numOfArgs() == 0) {
            return true;
        }
        throw new InvalidSaveCommandException(command);
    }

    // uncomplete command format: "uncomplete [task|todo] <name> <destination1> <destination2>"
    private static boolean isUncompleteCommandValid(Command command) throws InvalidUncompleteCommandException {
        if(command.numOfArgs() == 2 || command.numOfArgs() == 3) {
            String firstArg = command.getArg(1);
            if(firstArg.equalsIgnoreCase("task") || firstArg.equalsIgnoreCase("todo")) {
                return true;
            }
        } else if(command.numOfArgs() == 4) {
            if(command.getArg(1).equalsIgnoreCase("task")) {
                return true;
            }
        }

        throw new InvalidUncompleteCommandException(command);
    }

}