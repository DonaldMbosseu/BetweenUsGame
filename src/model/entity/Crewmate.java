package model.entity;

import java.util.Random;

/**
 * This class represents a Crewmate, which is an inheritance from {@link Player}
 * A Crewmate has a two attributes and some functions to manage the thread.
 * @author  Serge Nzodja (gsheshe13@gmail.com)
 * @see Player
 */
public class Crewmate extends Player implements Runnable {
    /**
     * The constant NOT_SUS.
     */
    private static final String NOT_SUS = "Not Sus";
    /**
     * Instantiates a new Crewmate.
     *
     * @param currentRoom the current room
     * @param lastRoom    the last room
     * @param role        the role
     * @param colourIndex the colour index
     * @param isAlive     the is alive
     * @param isUser      the is user
     * @param isCooldown  the is cooldown
     */
    public Crewmate(String currentRoom, String lastRoom, String role, int colourIndex, boolean isAlive, boolean isUser, boolean isCooldown) {
        super(currentRoom, lastRoom, role, colourIndex, isAlive, isUser, isCooldown);
    }

    /**
     * The Go attribute for the thread.
     */
    private boolean go;
    /**
     * The Stop attribute to pause the thread.
     */
    private boolean stop;

    @Override
    public String getType() {
        return NOT_SUS;
    }

    @Override
    public void run() {
        go = true;
        stop = false;
        while (go) {
            while (stop) {
                Thread.onSpinWait();
            }
            // wait a random interval (between 5 and 10 seconds or 5000 and 10000 milliseconds)
            int randomTime = new Random().nextInt(5001);
            randomTime += 5000;
            try {
                Thread.sleep(randomTime);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            // get the chance to move
            int randomChance = new Random().nextInt(100);
            // 55% chance
            if (randomChance >= 45 && !stop) {
                synchronized (Player.class) {
                    // change room
                    if (isAlive()) {
                        String[] connectedRooms = getMap().findConnectedRooms(getCurrentRoom());
                        if (connectedRooms != null) {
                            int randomRoom = new Random().nextInt(connectedRooms.length);
                            String newRoom = connectedRooms[randomRoom];
                            if (newRoom.equals(getLastRoom())) {
                                randomRoom = new Random().nextInt(connectedRooms.length);
                            }
                            setLastRoom(getCurrentRoom());
                            setCurrentRoom(connectedRooms[randomRoom]);

                            // update view
                            getMap().refreshView(getColourIndex());
                        }
                    }
                }
            }
        }
    }

    @Override
    public void close() {
        go = false;
        stop = false;
    }

    @Override
    public void pause() {
        stop = true;
    }

    @Override
    public void resume() {
        stop = false;
    }
}