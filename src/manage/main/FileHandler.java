package manage.main;

import manage.main.Profile;

/**
 * File Handler for Manage. Provides methods for loading and saving a profile.
 * 
 * @author J Blackmore
 */
public class FileHandler {
    
    private String fileName = "manage-profile";

    /** Creates a FileHandler */
    public FileHandler() {

    }

    /**
     * Loads the saved profile from file into Manage, and returns the profile.
     * 
     * @return the loaded profile
     */
    public Profile load() {
        return new Profile("User");
    }

    /**
     * Overwrites the current save in file with the userProfile.
     * 
     * @param userProfile the profile to save to file
     */
    public void save(Profile userProfile) {

    }
}