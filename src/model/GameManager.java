package model;

import model.dao.GameDAO;
import model.dao.LogDAO;
import model.dao.PlayerDAO;
import model.dao.sql.SQLGameDAO;
import model.dao.sql.SQLLogDAO;
import model.dao.sql.SQLPlayerDAO;
import model.entity.Game;
import model.entity.Log;
import model.entity.Player;

import java.util.List;

/**
 * This class represents the Game Manager.
 * The Game Manager has several attributes and methods storing any implementation of the DAOs.
 * @author  Serge Nzodja (gsheshe13@gmail.com)
 * @version 22/5/2021
 */
public class GameManager {
    /**
     * The Game dao.
     */
    private final GameDAO gameDAO;
    /**
     * The Player dao.
     */
    private final PlayerDAO playerDAO;
    /**
     * The Log dao.
     */
    private final LogDAO logDAO;

    /**
     * Instantiates a new Game manager.
     */
    public GameManager() {
        gameDAO = new SQLGameDAO();
        playerDAO = new SQLPlayerDAO();
        logDAO = new SQLLogDAO();
    }

    /**
     * Add game using the gameDAO.
     *
     * @param game the game
     * @param user the user
     */
    public void addGame(Game game, String user) {
        gameDAO.addGame(game, user);
    }

    /**
     * Update game using the gameDAO.
     *
     * @param game the game
     * @param user the user
     */
    public void updateGame(Game game, String user) {
        gameDAO.updateGame(game, user);
    }

    /**
     * Delete game using the gameDAO.
     *
     * @param name the name
     * @param user the user
     */
    public void deleteGame(String name, String user) {
        gameDAO.deleteGame(name, user);
    }

    /**
     * Name exists boolean using the gameDAO.
     *
     * @param name the name
     * @return the boolean
     */
    public boolean nameExists(String name) {
        return gameDAO.nameExists(name);
    }

    /**
     * Add player using the playerDAO.
     *
     * @param player   the player
     * @param gameName the game name
     * @param user     the user
     */
    public void addPlayer(Player player, String gameName, String user) {
        playerDAO.addPlayer(player, gameName, user);
    }

    /**
     * Gets players using the playerDAO.
     *
     * @param gameName the game name
     * @param user     the user
     * @return the players
     */
    public List<Player> getPlayers(String gameName, String user) {
        return playerDAO.getPlayers(gameName, user);
    }

    /**
     * Add log using the logDAO.
     *
     * @param colorIndex the color index
     * @param time       the time
     * @param gameName   the game name
     * @param user       the user
     * @param room       the room
     */
    public void addLog(int colorIndex, int time, String gameName, String user, String room) {
        logDAO.addLog(colorIndex, time, gameName, user, room);
    }

    /**
     * Gets log using the logDAO.
     *
     * @param game     the game
     * @param username the username
     * @return the log
     */
    public Log getLog(String game, String username) {
        return logDAO.getLog(game, username);
    }

    /**
     * Gets games using the gameDAO.
     *
     * @param name the name
     * @return the games
     */
    public List<Game> getGames(String name) {
        return gameDAO.getGames(name);
    }
}