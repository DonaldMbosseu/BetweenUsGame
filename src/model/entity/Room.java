package model.entity;

/**
 * This class represents a Room.
 * A Room has several attributes to store the name, the position on the grid,
 * and booleans to know if it is a starting point, if it is the room where the user
 * can check the classification, if it can see the log, if it should register the log.
 * It also has a list of connected rooms and if there is a vent room it has the name stored.
 * @author  Serge Nzodja (gsheshe13@gmail.com)
 * @version 22/5/2021
 */
public class Room {
    /**
     * The Name.
     */
    private String name;
    /**
     * The Grid x.
     */
    private int gridX;
    /**
     * The Grid y.
     */
    private int gridY;
    /**
     * The Is starting point.
     */
    private boolean isStartingPoint;
    /**
     * The Is classification.
     */
    private boolean isClassification;
    /**
     * The Is log system.
     */
    private boolean isLogSystem;
    /**
     * The Is register log.
     */
    private boolean isRegisterLog;
    /**
     * The Connected rooms.
     */
    private String[] connectedRooms;
    /**
     * The Vent room.
     */
    private String ventRoom;

    /**
     * Instantiates a new Room.
     *
     * @param name             the name
     * @param gridX            the grid x
     * @param gridY            the grid y
     * @param isStartingPoint  the is starting point
     * @param isClassification the is classification
     * @param isLogSystem      the is log system
     * @param isRegisterLog    the is register log
     * @param connectedRooms   the connected rooms
     * @param ventRoom         the vent room
     */
    public Room(String name, int gridX, int gridY, boolean isStartingPoint, boolean isClassification, boolean isLogSystem, boolean isRegisterLog, String[] connectedRooms, String ventRoom) {
        this.name = name;
        this.gridX = gridX;
        this.gridY = gridY;
        this.isStartingPoint = isStartingPoint;
        this.isClassification = isClassification;
        this.isLogSystem = isLogSystem;
        this.isRegisterLog = isRegisterLog;
        this.connectedRooms = connectedRooms;
        this.ventRoom = ventRoom;
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
     * Gets grid x.
     *
     * @return the grid x
     */
    public int getGridX() {
        return gridX;
    }

    /**
     * Gets grid y.
     *
     * @return the grid y
     */
    public int getGridY() {
        return gridY;
    }

    /**
     * Is starting point boolean.
     *
     * @return the boolean
     */
    public boolean isStartingPoint() {
        return isStartingPoint;
    }

    /**
     * Is classification boolean.
     *
     * @return the boolean
     */
    public boolean isClassification() {
        return isClassification;
    }

    /**
     * Is log system boolean.
     *
     * @return the boolean
     */
    public boolean isLogSystem() {
        return isLogSystem;
    }

    /**
     * Is register log boolean.
     *
     * @return the boolean
     */
    public boolean isRegisterLog() {
        return isRegisterLog;
    }

    /**
     * Get connected rooms string [ ].
     *
     * @return the string [ ]
     */
    public String[] getConnectedRooms() {
        return connectedRooms;
    }

    /**
     * Gets vent room.
     *
     * @return the vent room
     */
    public String getVentRoom() {
        return ventRoom;
    }
}
