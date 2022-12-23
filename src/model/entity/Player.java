package model.entity;

import view.Game.MapPanel;

/**
 * This class represents a Player.
 * A Player has several attributes to store the current room, last room, the role, the color index, the map
 * and other attributes to manage crewmates and impostors.
 * @author  Serge Nzodja (gsheshe13@gmail.com)
 * @version 22/5/2021
 */
public class Player implements Runnable {
    /**
     * The constant SUS.
     */
    private static final String SUS = "Sus";
    /**
     * The Current room.
     */
    private String currentRoom;
    /**
     * The Last room.
     */
    private String lastRoom;
    /**
     * The Role.
     */
    private String role;
    /**
     * The Colour index.
     */
    private int colourIndex;
    /**
     * The Map panel to have a reference to update the view.
     */
    private MapPanel map;
    /**
     * The Is alive attribute for the crewmate.
     */
    private boolean isAlive;
    /**
     * The Is user attribute.
     */
    private boolean isUser;
    /**
     * The Is cooldown attribute for the impostor.
     */
    private boolean isCooldown;

    /**
     * Instantiates a new Player.
     *
     * @param currentRoom the current room
     * @param lastRoom    the last room
     * @param role        the role
     * @param colourIndex the colour index
     * @param isAlive     the is alive
     * @param isUser      the is user
     * @param isCooldown  the is cooldown
     */
    public Player(String currentRoom, String lastRoom, String role, int colourIndex, boolean isAlive, boolean isUser, boolean isCooldown) {
        this.currentRoom = currentRoom;
        this.lastRoom = lastRoom;
        this.role = role;
        this.colourIndex = colourIndex;
        this.isAlive = isAlive;
        this.isUser = isUser;
        this.isCooldown = isCooldown;
    }

    /**
     * Gets type. This method is implemented in the {@link Crewmate} and {@link Impostor} classes.
     *
     * @return the type
     */
    public String getType() {
        return "";
    }


    /**
     * Gets the role guessed by the user.
     *
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * Gets colour index.
     *
     * @return the colour index
     */
    public int getColourIndex() {
        return colourIndex;
    }

    /**
     * Is alive boolean.
     *
     * @return the boolean
     */
    public boolean isAlive() {
        return isAlive;
    }

    /**
     * Is user boolean.
     *
     * @return the boolean
     */
    public boolean isUser() {
        return isUser;
    }

    /**
     * Is cooldown boolean.
     *
     * @return the boolean
     */
    public boolean isCooldown() {
        return isCooldown;
    }

    /**
     * Gets current room.
     *
     * @return the current room
     */
    public String getCurrentRoom() {
        return currentRoom;
    }

    /**
     * Sets current room.
     *
     * @param currentRoom the current room
     */
    public void setCurrentRoom(String currentRoom) {
        this.currentRoom = currentRoom;
    }

    /**
     * Sets last room.
     *
     * @param lastRoom the last room
     */
    public void setLastRoom(String lastRoom) {
        this.lastRoom = lastRoom;
    }

    /**
     * Gets last room.
     *
     * @return the last room
     */
    public String getLastRoom() {
        return lastRoom;
    }

    /**
     * Is impostor boolean.
     *
     * @return the boolean
     */
    public boolean isImpostor() {
        return getType().equals(SUS);
    }

    /**
     * Sets role.
     *
     * @param role the role
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Gets map.
     *
     * @return the map
     */
    public MapPanel getMap() {
        return map;
    }

    /**
     * Sets map.
     *
     * @param map the map
     */
    public void setMap(MapPanel map) {
        this.map = map;
    }

    /**
     * Sets alive.
     *
     * @param alive the alive
     */
    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(boolean user) {
        isUser = user;
    }

    /**
     * Sets cooldown.
     *
     * @param cooldown the cooldown
     */
    public void setCooldown(boolean cooldown) {
        isCooldown = cooldown;
    }

    @Override
    public void run() {

    }

    /**
     * Close method to end a thread. Implemented in the {@link Crewmate} and {@link Impostor} classes.
     */
    public void close() {

    }

    /**
     * Pause method to pause a thread. Implemented in the {@link Crewmate} and {@link Impostor} classes.
     */
    public void pause() {

    }

    /**
     * Resume method to resume a thread. Implemented in the {@link Crewmate} and {@link Impostor} classes.
     */
    public void resume() {

    }
}
