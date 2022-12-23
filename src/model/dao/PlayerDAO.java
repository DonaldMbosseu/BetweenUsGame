package model.dao;

import model.entity.Player;

import java.util.List;

/**
 * Interface that abstracts the persistence of game from the rest of the code.
 *
 * In particular, it follows the Data Access Object design pattern, which is commonly used to abstract persistence
 * implementations with a set of generic operations.
 * @author  Serge Nzodja (gsheshe13@gmail.com)
 * @version 22/5/2021
 */
public interface PlayerDAO {
    /**
     * Method that saves a specific player, persisting it.
     *
     * @param player   the new player to save
     * @param gameName the game name to save
     * @param user     the user to save
     */
    void addPlayer(Player player, String gameName, String user);

    /**
     * Method that reads the persisted information, returning all stored players.
     *
     * @param gameName the game name
     * @param user     the user
     * @return a list containing all persisted players of a given game and user
     */
    List<Player> getPlayers(String gameName, String user);
}