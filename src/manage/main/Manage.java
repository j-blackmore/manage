package manage.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.ArrayList;

import manage.commands.*;
import manage.commands.exceptions.*;
import manage.datatypes.exceptions.*;

/**
 * 'manage' a command line command-driven management program where the user can create, customise 
 * and organise hierarchical 'to-do lists' in the form of Collections, Todos and Tasks.
 * 
 * @author J Blackmore
 * @version 1.10
 * @since 24-02-2018
 */
public class Manage {

    private static Profile userProfile = null;

    private static BufferedReader input = null;

    /**
     * Main manage program loop, continually requests user input until an exit command is entered. 
     * For all valid commands, they are executed on the current profile; for any invalid ones an 
     * exception is thrown and caught, where it is reported to the user. 
     * 
     * @param args the program arguments - unused.
     */
    public static void main(String[] args) {

        initializeManage();
        Command inputCommand = new Command();

        // main program loop
        do {
            try {
                System.out.print("> ");
                inputCommand = classifyCommand(input.readLine().trim());

                boolean commandIsValid = CommandValidator.validateCommand(inputCommand);

                if(commandIsValid) { inputCommand.completeAction(userProfile); }
                else { System.out.println("Invalid command: \'" + inputCommand + "\'"); }

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
            } catch (DataObjectNotFoundException e) {
                System.err.println("Data object \'" + e.getMessage() + "\' not found");
            } catch (Exception e) {
                System.err.println("Unexpected error occurred - seek administrator help");
            }
        } while (inputCommand.getCommandType() != Command.EXIT_COMMAND);

        try { input.close(); } catch(Exception e) { System.err.println(e); }
    }

    // welcomes and loads the profile from file
    private static void initializeManage() {
        System.out.println("Manage. Version 1.10. Author J Blackmore.");
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
    private static Command classifyCommand(String command) throws InvalidCommandException {
        String commandToCheck = command;
        
        if(command.contains(" ")) {
            commandToCheck = command.substring(0, command.indexOf(" "));
        }
        
        switch(commandToCheck.toLowerCase()) {
            case "add":
                return new AddCommand(command);
            case "complete":
                return new CompleteCommand(command);
            case "create":
                return new CreateCommand(command);
            case "help":
                return new HelpCommand(command);
            case "print":
                return new PrintCommand(command);
            case "remove":
                return new RemoveCommand(command);
            case "rename":
                return new RenameCommand(command);
            case "save":
                return new SaveCommand(command);
            case "uncomplete":
                return new UncompleteCommand(command);
            case "exit": case "quit": case "close":
                return new ExitCommand(command);
            default:
                throw new InvalidCommandException("Unknown command, type help for more commands");
        }
    }
}