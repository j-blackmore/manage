package manage.commands;

import manage.main.Profile;

/**
 * Interface for all commands in Manage. 
 * 
 * @author J Blackmore
 */
public interface CommandInterface {

    public void completeAction(Profile user) throws Exception;
}