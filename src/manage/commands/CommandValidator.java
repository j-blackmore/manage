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
    public boolean validateCommand(Command command) throws InvalidCommandException {
        switch(command.getCommand().toLowerCase()) {
            case "add":
                return validateAddCommand(command);
            case "create":
                return validateCreateCommand(command);
            case "print":
                return validatePrintCommand(command);
            default:
                throw new InvalidCommandException(command.toString());
        }
    }

    // add command format: "add [task|todo] <name> <destination1> <destination2>"
    private boolean validateAddCommand(Command command) throws InvalidAddCommandException {
        if(command.getArg(1).equalsIgnoreCase("task")) {
            if(command.numOfArgs() == 3 || command.numOfArgs() == 4) {
                return true;
            }
        } else if(command.getArg(1).equalsIgnoreCase("todo")) {
            if(command.numOfArgs() == 3) {
                return true;
            }
        }
        throw new InvalidAddCommandException(command.toString());
    }

    // create command format: "create [task|todo|collection] <name>"
    private boolean validateCreateCommand(Command command) throws InvalidCreateCommandException {
        if(command.numOfArgs() == 2) {
            if(command.getArg(1).equalsIgnoreCase("task") || command.getArg(1).equalsIgnoreCase("todo") ||
               command.getArg(1).equalsIgnoreCase("collection")) {
                return true;
            }
        }
        throw new InvalidCreateCommandException(command.toString());
    }

    // print command format: "print [tasks|todos|collections|all]"
    private boolean validatePrintCommand(Command command) throws InvalidPrintCommandException {
        if(command.numOfArgs() == 1) {
            if(command.getArg(1).equalsIgnoreCase("tasks") || command.getArg(1).equalsIgnoreCase("todos") ||
               command.getArg(1).equalsIgnoreCase("collections") || command.getArg(1).equalsIgnoreCase("all")) {
                return true;
               }
        }
        throw new InvalidPrintCommandException(command.toString());
    }

}