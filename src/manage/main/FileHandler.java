package manage.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import manage.datatypes.Collection;
import manage.datatypes.Task;
import manage.datatypes.Todo;
import manage.main.Profile;

/**
 * File Handler for Manage. Provides methods for loading and saving a profile.
 * 
 * @author J Blackmore
 */
public class FileHandler {

    private static final int NAME_ID = 0;

    private static final int TASK_ID = 1;

    private static final int TODO_ID = 2;

    private static final int COLLECTION_ID = 3;

    private static final String TASK_END = ";;";

    private static final String TODO_END = "::";
    
    /** The path for the save file */
    private String filePath = 
        System.getProperty("user.home") + File.separator + "manageApp" + File.separator;

    private String fileName = "manage_profile.m";

    /** Creates a FileHandler */
    public FileHandler() {

    }

    /**
     * Loads the saved profile from file into Manage, and returns the profile.
     * 
     * @return the loaded profile
     * @throws FileNotFoundException for invalid file open on save file.
     */
    public Profile load() throws FileNotFoundException {
        BufferedReader userSave = new BufferedReader(new FileReader(filePath + fileName));
        Profile userProfile = null;

        try {
            String inputLine = "";
            while((inputLine = userSave.readLine()) != null) {
                switch(Integer.parseInt(inputLine.substring(0, inputLine.indexOf(":")))) {
                    case NAME_ID:
                        userProfile = new Profile(inputLine.substring(2));
                        break;
                    case COLLECTION_ID:
                        Collection collectionToAdd = createCollection(inputLine);
                        userProfile.add(collectionToAdd);
                        break;
                    case TODO_ID:
                        Todo todoToAdd = createTodo(inputLine);
                        userProfile.add(todoToAdd);
                        break;
                    case TASK_ID:
                        Task taskToAdd = createTask(inputLine);
                        userProfile.add(taskToAdd);
                        break;
                }
            }
            try { userSave.close(); } catch(Exception e) { System.out.println(e.getMessage()); }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        if(userProfile == null) {
            System.out.println("No user found, new user created.");
            return new Profile("new-user");
        } else {
            return userProfile;
        }
    }

    // creates a collection from the save entry input
    private Collection createCollection(String input) {
        Collection newCollection = new Collection(input.substring(2, input.indexOf(";")));
        input = input.substring(input.indexOf(";") + 1);

        int numOfTodos = Integer.parseInt(input.substring(0, input.indexOf(";"))); 
        input = input.substring(input.indexOf(";") + 1);

        if(numOfTodos != 0) {
            for(int i = 1; i <= numOfTodos; i++) {
                newCollection.addTodo(createTodo(input));
                input = input.substring(input.indexOf(TODO_END) + 2);
            }
        }

        return newCollection;
    }

    // creates a todo for the save entry input
    private Todo createTodo(String input) {
        Todo newTodo = new Todo(input.substring(2, input.indexOf(";")));
        input = input.substring(input.indexOf(";") + 1);

        newTodo.setCompletionStatus(Boolean.parseBoolean(input.substring(0, input.indexOf(";"))));
        input = input.substring(input.indexOf(";") + 1);
        
        int numOfTasks = Integer.parseInt(input.substring(0, input.indexOf(";")));
        input = input.substring(input.indexOf(";") + 1);
        
        if(numOfTasks != 0) {
            for(int i = 1; i <= numOfTasks; i++) {
                newTodo.addTask(createTask(input));
                input = input.substring(input.indexOf(TASK_END) + 2);
            }
        }

        return newTodo;
    }

    // creates a task for the save entry input
    private Task createTask(String input) {
        Task newTask = new Task(input.substring(2, input.indexOf(";")));
        input = input.substring(input.indexOf(";") + 1);

        newTask.setCompletionStatus(Boolean.parseBoolean(input.substring(0, input.indexOf(";"))));

        return newTask;
    }

    /**
     * Overwrites the current save in file with the userProfile.
     * 
     * @param userProfile the profile to save.
     */
    public void save(Profile userProfile) {
        BufferedWriter fileSave = null; 
        
        try {
            fileSave = new BufferedWriter(new PrintWriter(filePath + fileName));
            fileSave.write("0:" + userProfile.getUserName());

            for(int i = 0; i < userProfile.collections.size(); i++) {
                fileSave.write(userProfile.collections.get(i).getSaveFormat());
            }

            for(int j =0; j < userProfile.todos.size(); j++) {
                fileSave.write(userProfile.todos.get(j).getSaveFormat());
            }

            for(int k = 0; k < userProfile.tasks.size(); k++) {
                fileSave.write(userProfile.tasks.get(k).getSaveFormat());
            }
        } catch(IOException e) {
            System.out.println("Error saving file, please try again");
        } finally {
            try {
                if(fileSave != null) {
                    fileSave.close();
                }
            } catch (IOException e) {
                System.out.println("Error saving file, please try again");
            }
        }
    }
}