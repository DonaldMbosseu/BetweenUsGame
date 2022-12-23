package model.entity;

import java.util.List;

/**
 * This class represents a Log.
 * A Log has several attributes to store the color index, the time, the game name, the user and the room.
 * @author  Serge Nzodja (gsheshe13@gmail.com)
 * @version 22/5/2021
 */
public class Log {
    /**
     * The Color index.
     */
    private List<Integer> colorIndex;
    /**
     * The Time.
     */
    private List<Integer> time;
    /**
     * The Game name.
     */
    private List<String> gameName;
    /**
     * The User.
     */
    private List<String> user;
    /**
     * The Room.
     */
    private List<String> room;

    /**
     * Instantiates a new Log.
     *
     * @param colorIndex the color index
     * @param time       the time
     * @param gameName   the game name
     * @param user       the user
     * @param room       the room
     */
    public Log(List<Integer> colorIndex, List<Integer> time, List<String> gameName, List<String> user, List<String> room) {
        this.colorIndex = colorIndex;
        this.time = time;
        this.gameName = gameName;
        this.user = user;
        this.room = room;
    }

    /**
     * Gets color index.
     *
     * @return the color index
     */
    public List<Integer> getColorIndex() {
        return colorIndex;
    }

    /**
     * Gets time.
     *
     * @return the time
     */
    public List<Integer> getTime() {
        return time;
    }

    /**
     * Gets game name.
     *
     * @return the game name
     */
    public List<String> getGameName() {
        return gameName;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public List<String> getUser() {
        return user;
    }

    /**
     * Gets room.
     *
     * @return the room
     */
    public List<String> getRoom() {
        return room;
    }
}
