// Main 
package manage.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import manage.commands.*;
import manage.commands.exceptions.*;
import manage.datatypes.exceptions.*;

public class Manage {
    public static void main(String[] args) {
        Profile myProfile = new Profile("Joe");
        
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Command inputCommand;

        //***** EXAMPLE COMMANDS *****//
        //> create todo -N the name of the todo
        //> add task -N the name of the task
        //> verb noun [Number flag of ordering] the rest will be info you pass to the command you wrote
        //*****                  *****//

        // use methods to break down input, and determine if flags exist etc

        try {
            System.out.print("Welcome to Manage.\nUser logged in: " + myProfile.getUserName() + "\n> ");
            while((inputCommand = new Command(input.readLine())).getCommandType() != Command.EXIT_COMMAND) {
                switch(inputCommand.getCommandType()) {
                    case Command.CREATE_COMMAND:
                        inputCommand = new CreateCommand(inputCommand.toString());
                        break;
                    case Command.ADD_COMMAND:
                        inputCommand = new AddCommand(inputCommand.toString());
                        break;
                    case Command.PRINT_COMMAND:
                        inputCommand = new PrintCommand(inputCommand.toString());
                        break;
                    case Command.REMOVE_COMMAND:
                        inputCommand = new RemoveCommand(inputCommand.toString());
                        break;
                    case Command.UNKNOWN_COMMAND:
                        inputCommand = new Command(inputCommand.toString());
                        break;
                    default:
                        System.out.println("Error with command type");  //TODO: Exception
                        break;
                }

                try {
                    inputCommand.completeAction(myProfile);
                } catch (TaskNotFoundException e) {
                    if(e.getSearchLocation() != null) {
                        System.out.println("Task \'" + e.getMessage() + "\' not found in "
                            + e.getSearchLocation());
                    } else {    
                        System.out.println("Task \'" + e.getMessage() + "\' not found");
                    }
                } catch (TodoNotFoundException e) {
                    if(e.getSearchLocation() != null) {
                        System.out.println("Todo \'" + e.getMessage() + "\' not found in"
                            + e.getSearchLocation());
                    } else {
                        System.out.println("Todo \'" + e.getMessage() + "\' not found");
                    }
                } catch (CollectionNotFoundException e) {
                    System.out.println("Collection \'" + e.getMessage() + "\' not found");
                } catch (InvalidCreateCommandException e) {
                    System.out.println("Invalid create command: \'" + e.getMessage() + "\', must "
                        + "follow format: \'create [task|todo|collection] name\'");
                } catch (InvalidPrintCommandException e) {
                    System.out.println("Invalid print command: \'" + e.getMessage() + "\', must "
                        + "follow format: \'print [all|tasks|todos|collections]\'");
                } catch (InvalidAddCommandException e) {
                    System.out.println("Invalid add command: \'" + e.getMessage() + "\', must "
                        + "follow format: "
                        + "\'add [task|todo] name [destination1] (destination2)\'\n"
                        + "Second destination is for adding a task to a todo which is already "
                        + "in a collection." );
                } catch (InvalidRemoveCommandException e) {
                    System.out.println("Invalid remove command: \'" + e.getMessage() + "\', must "
                        + "follow format: "
                        + "\'remove [task|todo|collection] name [destination1] (destination2)\'\n"
                        + "Second destination is for removing a task from a todo "
                        + "which is already in a collection");
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