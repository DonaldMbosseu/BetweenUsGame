package model.dao;

import model.entity.Game;

import java.util.List;

/**
 * Interface that abstracts the persistence of game from the rest of the code.
 * @author  Serge Nzodja (gsheshe13@gmail.com)
 * @version 22/5/2021
 */
public interface GameDAO {
    /**
     * Method that saves a specific game, persisting it.
     *
     * @param game the new game to save
     * @param user the user to save
     */
    void addGame(Game game, String user);

    /**
     * Method that deletes a persisted game, by its name and user.
     *
     * @param name the name
     * @param user the user
     */
    void deleteGame(String name, String user);

    /**
     * Method that updates a persisted game.
     *
     * @param game the game
     * @param user the user
     */
    void updateGame(Game game, String user);

    /**
     * Method that returns if a game name exists in the database.
     *
     * @param name the name
     * @return the boolean
     */
    boolean nameExists(String name);

    /**
     * Method that reads the persisted information, returning all stored games.
     *
     * @param user the user
     * @return a list containing all persisted games of a given user
     */
    List<Game> getGames(String user);
}