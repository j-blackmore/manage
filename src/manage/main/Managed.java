// Main 
package manage.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//import manage.datatypes.*;

public class Managed {
  public static void main(String[] args) {
    
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    String inputCommand;

    //***** EXAMPLE COMMANDS *****//
    //> create todo -N the name of the todo
    //> add task -N the name of the task
    //> verb noun [Number flag of ordering] the rest will be info you pass to the command you wrote
    //*****                  *****//

    // use methods to break down input, and determine if flags exist etc

    try {
      while(inputNotQuit(inputCommand = input.readLine())) {
        isCommandValid(inputCommand);

      }
      try {input.close(); } catch(Exception e) {System.err.println(e);}
      } catch (Exception e){
      System.err.println(e);
    }
  }

  private static boolean isCommandValid(String command) {
    String firstArg = command.substring(0, command.indexOf(" "));
    boolean commandValid = false;

    switch(firstArg.toLowerCase()){
      case "":        commandValid = true;
                       break;
      case "create":  if (numOfArgs(command) >= 3) commandValid = true;
                      break;
      default:  break;
      
    }

    return commandValid;
  }

  private static boolean inputNotQuit(String command) {
    String validExit[] = {"quit", "logout", "close", "exit"};   // must be lowercase

    for (int i = 0; i < validExit.length; i++) {
      if ((command.toLowerCase().compareTo(validExit[i])) == 0)
        return false;
    }
    return true;   // input wasn't a quit message
  }

  private static int numOfArgs(String command) {
    int args = 0;
    String remainingCommand = command.trim();
    System.out.println("Original: " + remainingCommand);

    while(remainingCommand.contains(" ")) {
      args++;
      remainingCommand = remainingCommand.substring(remainingCommand.indexOf(" ")).trim();
      System.out.println("> " + remainingCommand);
    }

    // final (or 1) argument has no spaces, so while misses it
    if (remainingCommand.length() > 0) args++;

    return args;
  }
}