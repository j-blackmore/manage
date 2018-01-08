// Main 
package manage.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import manage.commands.*;

public class Managed {
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
                    case Command.UNKNOWN_COMMAND:
                        inputCommand = new Command(inputCommand.toString());
                        break;
                    default:
                        System.out.println("Error with command type");  //TODO: Exception
                        break;
                }

                inputCommand.completeAction(myProfile);
                System.out.print("> ");
            }
            try { input.close(); } catch(Exception e) { System.err.println(e); }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}