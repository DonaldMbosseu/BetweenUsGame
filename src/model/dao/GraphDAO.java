package model.dao;

import model.entity.Graph;

/**
 * Interface that abstracts the persistence of game from the rest of the code.
 * @author  Serge Nzodja (gsheshe13@gmail.com)
 * @version 22/5/2021
 */
public interface GraphDAO {
    /**
     * Method that saves a specific graph data of a completed game, persisting it.
     *
     * @param user    the user to save
     * @param userWon the user won
     */
    void addGame(String user, boolean userWon);

    /**
     * Method that reads the persisted information, returning all stored graph data related to games.
     *
     * @param user the user
     * @return a {@link Graph} containing all persisted graph data of a given user
     */
    Graph getGames(String user);
}
