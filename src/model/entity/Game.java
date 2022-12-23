package model.entity;

import java.util.List;

/**
 * This class represents a Game.
 * A Game has a two attributes and some functions to manage the thread.
 * @author  Serge Nzodja (gsheshe13@gmail.com)
 * @version 22/5/2021
 */
public class Game {
    /**
     * The Name.
     */
    private String name;
    /**
     * The Num characters.
     */
    private int numCharacters;
    /**
     * The Num impostors.
     */
    private int numImpostors;
    /**
     * The Player colour index.
     */
    private int playerColourIndex;
    /**
     * The Is finished.
     */
    private boolean isFinished;
    /**
     * The Pause time.
     */
    private int pauseTime;
    /**
     * The Map.
     */
    private Map map;
    /**
     * The Players.
     */
    private List<Player> players;

    /**
     * Instantiates a new Game.
     *
     * @param name              the name
     * @param numCharacters     the num characters
     * @param numImpostors      the num impostors
     * @param playerColourIndex the player colour index
     * @param isFinished        the is finished
     * @param pauseTime         the pause time
     * @param map               the map
     * @param players           the players
     */
    public Game(String name, int numCharacters, int numImpostors, int playerColourIndex, boolean isFinished, int pauseTime, Map map, List<Player> players) {
        this.name = name;
        this.numCharacters = numCharacters;
        this.numImpostors = numImpostors;
        this.playerColourIndex = playerColourIndex;
        this.isFinished = isFinished;
        this.pauseTime = pauseTime;
        this.map = map;
        this.players = players;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets num characters.
     *
     * @return the num characters
     */
    public int getNumCharacters() {
        return numCharacters;
    }

    /**
     * Gets num impostors.
     *
     * @return the num impostors
     */
    public int getNumImpostors() {
        return numImpostors;
    }

    /**
     * Gets player colour index.
     *
     * @return the player colour index
     */
    public int getPlayerColourIndex() {
        return playerColourIndex;
    }

    /**
     * Is finished boolean.
     *
     * @return the boolean
     */
    public boolean isFinished() {
        return isFinished;
    }

    /**
     * Gets pause time.
     *
     * @return the pause time
     */
    public int getPauseTime() {
        return pauseTime;
    }

    /**
     * Gets map.
     *
     * @return the map
     */
    public Map getMap() {
        return map;
    }

    /**
     * Gets players.
     *
     * @return the players
     */
    public List<Player> getPlayers() {
        return players;
    }

    /**
     * Sets players.
     *
     * @param players the players
     */
    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    /**
     * Sets finished.
     *
     * @param finished the finished
     */
    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    /**
     * Sets pause time.
     *
     * @param pauseTime the pause time
     */
    public void setPauseTime(int pauseTime) {
        this.pauseTime = pauseTime;
    }
}
