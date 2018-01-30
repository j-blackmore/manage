// Main 
package manage.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import manage.commands.*;
import manage.commands.exceptions.*;
import manage.datatypes.exceptions.*;

public class Manage {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Welcome to Manage.");
        FileHandler fileHandler = new FileHandler();
        Profile userProfile = fileHandler.load();

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Command inputCommand;

        try {
            System.out.print("User logged in: " + userProfile.getUserName() + "\n> ");
            while((inputCommand = new Command(input.readLine())).getCommandType() != Command.EXIT_COMMAND) {
                switch(inputCommand.getCommandType()) {
                    case Command.ADD_COMMAND:
                        inputCommand = new AddCommand(inputCommand.toString());
                        break;
                    case Command.COMPLETE_COMMAND:
                        inputCommand = new CompleteCommand(inputCommand.toString());
                        break;
                    case Command.CREATE_COMMAND:
                        inputCommand = new CreateCommand(inputCommand.toString());
                        break;
                    case Command.PRINT_COMMAND:
                        inputCommand = new PrintCommand(inputCommand.toString());
                        break;
                    case Command.REMOVE_COMMAND:
                        inputCommand = new RemoveCommand(inputCommand.toString());
                        break;
                    case Command.RENAME_COMMAND:
                        inputCommand = new RenameCommand(inputCommand.toString());
                        break;
                    case Command.UNCOMPLETE_COMMAND:
                        inputCommand = new UncompleteCommand(inputCommand.toString());
                        break;
                    case Command.UNKNOWN_COMMAND:
                        inputCommand = new Command(inputCommand.toString());
                        break;
                    default:
                        throw new InvalidCommandException(inputCommand);
                }

                try {
                    inputCommand.completeAction(userProfile);
                } catch (TaskNotFoundException e) {
                    if(e.getSearchLocation() != null) {
                        System.out.println("Task \'" + e.getMessage() + "\' not found in "
                            + e.getSearchLocation());
                    } else {    
                        System.out.println("Task \'" + e.getMessage() + "\' not found");
                    }
                } catch (TodoNotFoundException e) {
                    if(e.getSearchLocation() != null) {
                        System.out.println("Todo \'" + e.getMessage() + "\' not found in "
                            + e.getSearchLocation());
                    } else {
                        System.out.println("Todo \'" + e.getMessage() + "\' not found");
                    }
                } catch (CollectionNotFoundException e) {
                    System.out.println("Collection \'" + e.getMessage() + "\' not found");
                } catch (InvalidAddCommandException e) {
                    System.out.println(e.getMessage());
                } catch (InvalidCompleteCommandException e) {
                    System.out.println(e.getMessage());
                } catch (InvalidCreateCommandException e) {
                    System.out.println(e.getMessage());
                } catch (InvalidPrintCommandException e) {
                    System.out.println(e.getMessage());
                } catch (InvalidRemoveCommandException e) {
                    System.out.println(e.getMessage());
                } catch (InvalidRenameCommandException e) {
                    System.out.println(e.getMessage());
                } catch (InvalidUncompleteCommandException e) {
                    System.out.println(e.getMessage());
                } finally {
                    System.out.print("> ");
                }
            }
            try { input.close(); } catch(Exception e) { System.err.println(e); }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}