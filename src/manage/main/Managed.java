// Main 
package manage.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//import manage.datatypes.*;

public class Managed {
  public static void main(String[] args) {
    
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    String inputCommand;
    String storedData;

    //***** EXAMPLE COMMANDS *****//
    //> create todo -N the name of the todo
    //> add task -N the name of the task
    //> verb noun [Number flag of ordering] the rest will be info you pass to the command you wrote
    //*****                  *****//

    // use methods to break down input, and determine if flags exist etc

    try {
      while((inputCommand = input.readLine().toUpperCase()).compareTo("QUIT") != 0){
        switch(inputCommand.toUpperCase()) {
          case "SAVE": storedData = "save";
                       System.out.println("save stored");
                       break;
        }
      }
      try {input.close(); } catch(Exception e) {System.err.println(e);}
      } catch (Exception e){
      System.err.println(e);
    }
  }
}

// TODO:
// > Finish testing Collection
// > Add Doc comments to data structures
// > Restructure the file system 290698

// package 'filepath within src'

// then in classes that use other classes, import 'file.path.javaClass'

//  Doc Comment Structure: Function
//  /**
//   * Function description of what the 
//   * function does.
//   *
//   * @param paramName <nounOfParamType> description of the parameter  #Noun is not compuslory
//   *
//   * @return description of what is returned #omit for void and constructor methods
//   *
//   * @throws ExceptionName exception description
//   */
//
//
