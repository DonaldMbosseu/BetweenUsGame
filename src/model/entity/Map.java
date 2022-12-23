package model.entity;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class represents a Map.
 * A Map has the name and the list of rooms.
 * It also has a static function to read the map since you can't have
 * a Map object before reading a map configuration file.
 * @author  Serge Nzodja (gsheshe13@gmail.com)
 * @version 22/5/2021
 */
public class Map {
    /**
     * The Name.
     */
    private String name;
    /**
     * The Rooms.
     */
    private ArrayList<Room> rooms;

    /**
     * Instantiates a new Map.
     *
     * @param name  the name
     * @param rooms the rooms
     */
    public Map(String name, ArrayList<Room> rooms) {
        this.name = name;
        this.rooms = rooms;
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
     * Gets rooms.
     *
     * @return the rooms
     */
    public ArrayList<Room> getRooms() {
        return rooms;
    }

    /**
     * Sets rooms.
     *
     * @param rooms the rooms
     */
    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    /**
     * Reads a map file and returns an instance of a Map.
     *
     * @param fileName the file name
     * @return the map
     */
    public static Map readMap(String fileName) {
        String name = "";
        ArrayList<Room> rooms = new ArrayList<>();

        try {
            File file = new File("maps/"+ fileName);
            Scanner myReader = new Scanner(file);

            name = myReader.nextLine();

            while (myReader.hasNextLine()) {
                String roomName = myReader.nextLine();
                int gridX = Integer.parseInt(myReader.nextLine());
                int gridY = Integer.parseInt(myReader.nextLine());
                boolean isStartingPoint = Boolean.parseBoolean(myReader.nextLine());
                boolean isClassification = Boolean.parseBoolean(myReader.nextLine());
                boolean isLogSystem = Boolean.parseBoolean(myReader.nextLine());
                boolean isRegisterLog = Boolean.parseBoolean(myReader.nextLine());
                String[] connectedRooms = myReader.nextLine().split(",");
                String ventRoom = myReader.nextLine();

                rooms.add(new Room(roomName, gridX, gridY, isStartingPoint, isClassification, isLogSystem, isRegisterLog, connectedRooms, ventRoom));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return new Map(name, rooms);
    }
}
