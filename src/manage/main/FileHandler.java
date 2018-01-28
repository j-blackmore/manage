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
                        Collection collectionToAdd = new Collection(inputLine.substring(2, inputLine.indexOf(";")));
                        inputLine = inputLine.substring(inputLine.indexOf(";") + 1);

                        int numOfTodos = Integer.parseInt(inputLine.substring(0, inputLine.indexOf(";"))); 
                        inputLine = inputLine.substring(inputLine.indexOf(";") + 1);

                        if(numOfTodos != 0) {
                            for(int i = 1; i <= numOfTodos; i++) {
                                Todo todoToAdd = new Todo(inputLine.substring(2, inputLine.indexOf(";")));
                                inputLine = inputLine.substring(inputLine.indexOf(";") + 1);
        
                                if(Boolean.parseBoolean(inputLine.substring(0, inputLine.indexOf(";")))) { 
                                    todoToAdd.complete(); 
                                } else { 
                                    todoToAdd.unComplete();
                                }
                                inputLine = inputLine.substring(inputLine.indexOf(";") + 1);
                                
                                int numOfTasks = Integer.parseInt(inputLine.substring(0, inputLine.indexOf(";")));
                                inputLine = inputLine.substring(inputLine.indexOf(";") + 1);
                                
                                if(numOfTasks == 0)
                                    break;
                                else {
                                    for(int j = 1; j <= numOfTasks; j++) {
                                        Task taskToAdd = new Task(inputLine.substring(2, inputLine.indexOf(";")));
                                        inputLine = inputLine.substring(inputLine.indexOf(";") + 1);
        
                                        if(Boolean.parseBoolean(inputLine.substring(0, inputLine.indexOf(";")))) {
                                            taskToAdd.complete();
                                        } else {
                                            taskToAdd.unComplete();
                                        }
                                        inputLine = inputLine.substring(inputLine.indexOf(";") + 1);
                                        
                                        todoToAdd.addTask(taskToAdd);
                                    }
                                }
                                collectionToAdd.addTodo(todoToAdd);
                            }
                        }
                        userProfile.add(collectionToAdd);
                        break;
                    case TODO_ID:
                        Todo todoToAdd = new Todo(inputLine.substring(2, inputLine.indexOf(";")));
                        inputLine = inputLine.substring(inputLine.indexOf(";") + 1);

                        if(Boolean.parseBoolean(inputLine.substring(0, inputLine.indexOf(";")))) { 
                            todoToAdd.complete(); 
                        } else { 
                            todoToAdd.unComplete();
                        }
                        inputLine = inputLine.substring(inputLine.indexOf(";") + 1);
                        
                        int numOfTasks = Integer.parseInt(inputLine.substring(0, inputLine.indexOf(";")));
                        inputLine = inputLine.substring(inputLine.indexOf(";") + 1);
                        
                        if(numOfTasks != 0) {
                            for(int i = 1; i <= numOfTasks; i++) {
                                Task taskToAdd = new Task(inputLine.substring(2, inputLine.indexOf(";")));
                                inputLine = inputLine.substring(inputLine.indexOf(";") + 1);

                                if(Boolean.parseBoolean(inputLine.substring(0, inputLine.indexOf(";")))) {
                                    taskToAdd.complete();
                                } else {
                                    taskToAdd.unComplete();
                                }
                                inputLine = inputLine.substring(inputLine.indexOf(";") + 1);
                                
                                todoToAdd.addTask(taskToAdd);
                            }
                        }

                        userProfile.add(todoToAdd);
                        break;
                    case TASK_ID:
                        Task taskToAdd = new Task(inputLine.substring(2, inputLine.indexOf(";")));
                        inputLine = inputLine.substring(inputLine.indexOf(";") + 1);

                        if(Boolean.parseBoolean(inputLine.substring(0, inputLine.indexOf(";")))) {
                            taskToAdd.complete();
                        } else {
                            taskToAdd.unComplete();
                        }
                        inputLine = inputLine.substring(inputLine.indexOf(";") + 1);
                        
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

    /**
     * Overwrites the current save in file with the userProfile.
     * 
     * @param userProfile the profile to save to file
     */
    public void save(Profile userProfile) {
        // re-writes profile to file
    }
}