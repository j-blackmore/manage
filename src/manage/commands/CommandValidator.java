package manage.commands;

import manage.commands.exceptions.*;

/**
 * Command Validator for checking commands inputted by users in Manage, are valid.
 * 
 * @author J Blackmore
 */
public class CommandValidator {

    /**
     * Creates a CommandValidator.
     */
    public CommandValidator() {
    }

    /**
     * Validates a command by calling the respective method given the type of command. Returns true 
     * for a valid command, exception is thrown for invalid commands.
     * 
     * @param command the command to be validated.
     * @return true for valid commands, false otherwise.
     * @throws InvalidCommandException for invalid commands, more specific InvalidCommandExceptions 
     * are thrown for known commands.
     */
    public int validateCommand(Command command) throws InvalidCommandException {
        switch(command.getCommand().toLowerCase()) {
            case "add":
                if(isAddCommandValid(command)) return Command.ADD_COMMAND;
                else throw new InvalidAddCommandException((AddCommand)command);
            case "complete":
                if(isCompleteCommandValid(command)) return Command.COMPLETE_COMMAND;
                else throw new InvalidCompleteCommandException((CompleteCommand)command);
            case "create":
                if(isCreateCommandValid(command)) return Command.CREATE_COMMAND;
                else throw new InvalidCreateCommandException((CreateCommand)command);
            case "print":
                if(isPrintCommandValid(command)) return Command.PRINT_COMMAND;
                else throw new InvalidPrintCommandException((PrintCommand)command);
            case "remove":
                if(isRemoveCommandValid(command)) return Command.REMOVE_COMMAND;
                else throw new InvalidRemoveCommandException((RemoveCommand)command);
            case "rename":
                if(isRenameCommandValid(command)) return Command.RENAME_COMMAND;
                else throw new InvalidRenameCommandException((RenameCommand)command);
            case "uncomplete":
                if(isUncompleteCommandValid(command)) return Command.UNCOMPLETE_COMMAND;
                else throw new InvalidUncompleteCommandException((UncompleteCommand)command);
            case "exit": case "quit": case "close":
                return Command.EXIT_COMMAND;
            default:
                throw new InvalidCommandException(command.toString());
        }
    }

    // add command format: "add [task|todo] <name> <destination1> <destination2>"
    private boolean isAddCommandValid(Command command) throws InvalidAddCommandException {
        if(command.getArg(1).equalsIgnoreCase("task")) {
            if(command.numOfArgs() == 3 || command.numOfArgs() == 4) {
                return true;
            }
        } else if(command.getArg(1).equalsIgnoreCase("todo")) {
            if(command.numOfArgs() == 3) {
                return true;
            }
        }
        throw new InvalidAddCommandException((AddCommand)command);
    }

    // complete command format: "complete [task|todo] <name> <location1> <location2>"
    private boolean isCompleteCommandValid(Command command) throws InvalidCompleteCommandException {
        if(command.getArg(1).equalsIgnoreCase("task")) {
            if(command.numOfArgs() == 2 || command.numOfArgs() == 3 || command.numOfArgs() == 4) {
                return true;
            }
        } else if(command.getArg(1).equalsIgnoreCase("todo")) {
            if(command.numOfArgs() == 2 || command.numOfArgs() == 3) {
                return true;
            }
        }
        throw new InvalidCompleteCommandException((CompleteCommand)command);
    }

    // create command format: "create [task|todo|collection] <name>"
    private boolean isCreateCommandValid(Command command) throws InvalidCreateCommandException {
        if(command.numOfArgs() == 2) {
            if(command.getArg(1).equalsIgnoreCase("task") || command.getArg(1).equalsIgnoreCase("todo") ||
               command.getArg(1).equalsIgnoreCase("collection")) {
                return true;
            }
        }
        throw new InvalidCreateCommandException((CreateCommand)command);
    }

    // print command format: "print [tasks|todos|collections|all]"
    private boolean isPrintCommandValid(Command command) throws InvalidPrintCommandException {
        if(command.numOfArgs() == 1) {
            if(command.getArg(1).equalsIgnoreCase("tasks") || command.getArg(1).equalsIgnoreCase("todos") ||
               command.getArg(1).equalsIgnoreCase("collections") || command.getArg(1).equalsIgnoreCase("all")) {
                return true;
               }
        }
        throw new InvalidPrintCommandException((PrintCommand)command);
    }

    // remove command format: "remove [task|todo|collection] <name> <destination1> <destination2>"
    private boolean isRemoveCommandValid(Command command) throws InvalidRemoveCommandException {
        if(command.getArg(1).equalsIgnoreCase("task")) {
            if(command.numOfArgs() == 2 || command.numOfArgs() == 3 || command.numOfArgs() == 4) {
                return true;
            }
        } else if(command.getArg(1).equalsIgnoreCase("todo")) {
            if(command.numOfArgs() == 2 || command.numOfArgs() == 3) {
                return true;
            }
        } else if(command.getArg(1).equalsIgnoreCase("collection")) {
            if(command.numOfArgs() == 2) {
                return true;
            }
        }
        throw new InvalidRemoveCommandException((RemoveCommand)command);
    }

    // rename command format: "rename [task|todo|collection] <newname> <oldname> <destination1> <destination2>"
    private boolean isRenameCommandValid(Command command) throws InvalidRenameCommandException {
        if(command.getArg(1).equalsIgnoreCase("task")) {
            if(command.numOfArgs() == 3 || command.numOfArgs() == 4 || command.numOfArgs() == 5) {
                return true;
            }
        } else if(command.getArg(1).equalsIgnoreCase("todo")) {
            if(command.numOfArgs() == 3 || command.numOfArgs() == 4) {
                return true;
            }
        } else if(command.getArg(1).equalsIgnoreCase("collection")) {
            if(command.numOfArgs() == 3) {
                return true;
            }
        }
        throw new InvalidRenameCommandException((RenameCommand)command);
    }

    // uncomplete command format: "uncomplete [task|todo] <name> <destination1> <destination2>"
    private boolean isUncompleteCommandValid(Command command) throws InvalidUncompleteCommandException {
        if(command.getArg(1).equalsIgnoreCase("task")) {
            if(command.numOfArgs() == 2 || command.numOfArgs() == 3 || command.numOfArgs() == 4) {
                return true;
            }
        } else if(command.getArg(1).equalsIgnoreCase("todo")) {
            if(command.numOfArgs() == 2 || command.numOfArgs() == 3) {
                return true;
            }
        }
        throw new InvalidUncompleteCommandException((UncompleteCommand)command);
    }

}