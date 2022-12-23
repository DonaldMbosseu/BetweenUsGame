package model.dao;

import model.entity.Log;

/**
 * Interface that abstracts the persistence of game from the rest of the code.
 *
 * In particular, it follows the Data Access Object design pattern, which is commonly used to abstract persistence
 * implementations with a set of generic operations.
 * @author  Serge Nzodja (gsheshe13@gmail.com)
 * @version 22/5/2021
 */
public interface LogDAO {
    /**
     * Method that saves a specific log, persisting it.
     *
     * @param colorIndex the color index to save
     * @param time       the time to save
     * @param gameName   the game name to save
     * @param user       the user to save
     * @param room       the room to save
     */
    void addLog(int colorIndex, int time, String gameName, String user, String room);

    /**
     * Method that reads the persisted information, returning all stored log.
     *
     * @param game     the game
     * @param username the username
     * @return a {@link Log} containing all persisted information of a given user and game
     */
    Log getLog(String game, String username);
}