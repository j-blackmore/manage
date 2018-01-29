package manage.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
        Profile userProfile;
        try {
            String profileName = userSave.readLine().substring(2);
            userProfile = new Profile(profileName);

            String inputLine = "";
            while((inputLine = userSave.readLine()) != null) {
                switch(Integer.parseInt(inputLine.substring(0, inputLine.indexOf(":")))) {
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

        return new Profile("User");
    }

    private Collection createCollection(String input) {
        Collection newCollection = new Collection(input.substring(2, input.indexOf(";")));
        input = input.substring(input.indexOf(";") + 1);

        int numOfTodos = Integer.parseInt(input.substring(0, input.indexOf(";"))); 
        input = input.substring(input.indexOf(";") + 1);

        if(numOfTodos != 0) {
            for(int i = 1; i <= numOfTodos; i++) {
                newCollection.addTodo(createTodo(input));
                if(i < numOfTodos) {
                    input = input.substring(input.indexOf(TODO_ID + ":", 2) + 1);
                }
            }
        }

        return newCollection;
    }

    private Todo createTodo(String input) {
        Todo newTodo = new Todo(input.substring(2, input.indexOf(";")));
        input = input.substring(input.indexOf(";") + 1);

        if(Boolean.parseBoolean(input.substring(0, input.indexOf(";")))) { 
            newTodo.complete(); 
        } else { 
            newTodo.unComplete();
        }
        input = input.substring(input.indexOf(";") + 1);
        
        int numOfTasks = Integer.parseInt(input.substring(0, input.indexOf(";")));
        input = input.substring(input.indexOf(";") + 1);
        
        if(numOfTasks != 0) {
            for(int i = 1; i <= numOfTasks; i++) {
                newTodo.addTask(createTask(input));
                if(input.length() != 0) {
                    input = input.substring(input.indexOf(":") - 1);
                }
            }
        }

        return newTodo;
    }

    private Task createTask(String input) {
        Task newTask = new Task(input.substring(2, input.indexOf(";")));
        input = input.substring(input.indexOf(";") + 1);

        if(Boolean.parseBoolean(input.substring(0, input.indexOf(";")))) {
            newTask.complete();
        } else {
            newTask.unComplete();
        }
        input = input.substring(input.indexOf(";") + 1);

        return newTask;
    }

    /**
     * Overwrites the current save in file with the userProfile.
     * 
     * @param userProfile the profile to save to file
     */
    public void save(Profile userProfile) {
        // re-writes profile to file
    }
}