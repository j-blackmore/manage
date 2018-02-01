// Main 
package manage.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.ArrayList;

import manage.commands.*;
import manage.commands.exceptions.*;
import manage.datatypes.exceptions.*;

public class Manage {

    private static Profile userProfile = null;

    private static BufferedReader input = null;

    public static void main(String[] args) {
        initializeManage();
        Command inputCommand = new Command();

        do {
            try {
                System.out.print("> ");
                inputCommand = new Command(input.readLine());
                inputCommand = reclassifyCommand(inputCommand);

                inputCommand.completeAction(userProfile);
            } catch (InvalidCommandException e) {
                System.err.println(e.getMessage());
            } catch (TaskNotFoundException e) {
                if(e.getSearchLocation() != null) {
                    System.err.println("Task \'" + e.getMessage() + "\' not found in "
                        + e.getSearchLocation());
                } else {    
                    System.err.println("Task \'" + e.getMessage() + "\' not found");
                }
            } catch (TodoNotFoundException e) {
                if(e.getSearchLocation() != null) {
                    System.err.println("Todo \'" + e.getMessage() + "\' not found in "
                        + e.getSearchLocation());
                } else {
                    System.err.println("Todo \'" + e.getMessage() + "\' not found");
                }
            } catch (CollectionNotFoundException e) {
                System.err.println("Collection \'" + e.getMessage() + "\' not found");
            } catch (Exception e) {
                System.err.println("Unexpected error occurred - seek administrator help");
                System.err.println(e);
                e.printStackTrace();

            }
        } while (inputCommand.getCommandType() != Command.EXIT_COMMAND);

        try { input.close(); } catch(Exception e) { System.err.println(e); }
    }

    // welcomes and loads the profile from file
    private static void initializeManage() {
        System.out.println("Manage. Version 1.0. Author J Blackmore.");
        FileHandler fileHandler;
        
        try {
            fileHandler = new FileHandler();
            userProfile = fileHandler.load();
            System.out.println(userProfile.getUserName() + "'s profile loaded.");

            input = new BufferedReader(new InputStreamReader(System.in));
        } catch (Exception e) {
            System.err.println("Unexpected error, program restart advised");
        }
    }

    // returns new command object for the specific command
    private static Command reclassifyCommand(Command command) throws InvalidCommandException {
        switch(command.getCommandType()) {
            case Command.ADD_COMMAND:
                return new AddCommand(command.toString());
            case Command.COMPLETE_COMMAND:
                return new CompleteCommand(command.toString());
            case Command.CREATE_COMMAND:
                return new CreateCommand(command.toString());
            case Command.PRINT_COMMAND:
                return new PrintCommand(command.toString());
            case Command.REMOVE_COMMAND:
                return new RemoveCommand(command.toString());
            case Command.RENAME_COMMAND:
                return new RenameCommand(command.toString());
            case Command.SAVE_COMMAND:
                return new SaveCommand(command.toString());
            case Command.UNCOMPLETE_COMMAND:
                return new UncompleteCommand(command.toString());
            case Command.UNKNOWN_COMMAND:
                return new Command(command.toString());
            default:
                throw new InvalidCommandException(command);
        }
    }
}