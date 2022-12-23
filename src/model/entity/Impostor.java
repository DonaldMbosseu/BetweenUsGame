package model.entity;

import view.ViewUtilities;

import java.util.ArrayList;
import java.util.Random;

/**
 * This class represents a Impostor, which is an inheritance from {@link Player}
 * A Impostor has a two attributes and some functions to manage the thread.
 * @author  Serge Nzodja (gsheshe13@gmail.com)
 * @see Player
 */
public class Impostor extends Player implements Runnable {
    /**
     * The constant COOLDOWN_TIME.
     */
    private static final int COOLDOWN_TIME = 25;

    /**
     * The constant SUS.
     */
    private static final String SUS = "Sus";
    /**
     * The constant NOT_SUS.
     */
    private static final String NOT_SUS = "Not Sus";

    /**
     * Instantiates a new Impostor.
     *
     * @param currentRoom the current room
     * @param lastRoom    the last room
     * @param role        the role
     * @param colourIndex the colour index
     * @param isAlive     the is alive
     * @param isUser      the is user
     * @param isCooldown  the is cooldown
     */
    public Impostor(String currentRoom, String lastRoom, String role, int colourIndex, boolean isAlive, boolean isUser, boolean isCooldown) {
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
    /**
     * The Start cooldown attribute to store it and know how much time is remaining.
     */
    private double startCooldown;

    @Override
    public String getType() {
        return SUS;
    }

    @Override
    public void run() {
        go = true;
        stop = false;
        while (go) {
            while (stop) {
                Thread.onSpinWait();
            }
            // wait a random interval (between 6 and 8 seconds)
            int randomTime = new Random().nextInt(2001);
            randomTime += 6000;

            double start = System.currentTimeMillis();
            double finish = System.currentTimeMillis();
            double timeElapsed = (finish - start);

            while (timeElapsed < randomTime && !stop) {
                // check if they are in cooldown
                if (isCooldown()) {
                    updateCooldown();
                } else {
                    // check if the impostor can kill
                    synchronized (Player.class) {
                        // get the players in the room
                        ArrayList<Player> playersInRoom = getMap().findPlayersInRoom(getCurrentRoom());
                        // check that there are at least 2 people in the room
                        if (playersInRoom.size() >= 2) {
                            // check that there is only one crewmate
                            int numOfCrewmates = 0;
                            Player crewmate = null;
                            for (int i = 0; i < playersInRoom.size(); i++) {
                                if (playersInRoom.get(i).getType().equals(NOT_SUS)) {
                                    numOfCrewmates++;
                                    crewmate = playersInRoom.get(i);
                                }
                            }

                            if (numOfCrewmates == 1 && crewmate.isAlive() && !stop) {
                                kill(crewmate);
                                setCooldown(true);
                                startCooldown = System.currentTimeMillis();
                                leaveRoom();
                                // check if the game finished
                                checkGameStatus(crewmate);
                            }
                        }
                    }
                }
                // update elapsed time
                finish = System.currentTimeMillis();
                timeElapsed = (finish - start);
            }

            // get the chance to move
            int randomChance = new Random().nextInt(100);
            // 45% chance
            if (randomChance >= 55 && !stop) {
                synchronized (Player.class) {
                    // change room
                    setLastRoom(getCurrentRoom());
                    // check if there is a ventilation conduct
                    String ventRoom = getMap().ventRoomIn(getCurrentRoom());
                    boolean ventUsed = false;
                    if (!ventRoom.equals("-")) {
                        // check if there are crewmates in the current room
                        ArrayList<Player> playersInRoom = getMap().findPlayersInRoom(getCurrentRoom());
                        boolean noCrewmates = true;
                        for (int i = 0; i < playersInRoom.size(); i++) {
                            if (playersInRoom.get(i).getType().equals(NOT_SUS) && playersInRoom.get(i).isAlive()) {
                                noCrewmates = false;
                                break;
                            }
                        }
                        if (noCrewmates) {
                            // check for crewmates in the destination room
                            playersInRoom = getMap().findPlayersInRoom(ventRoom);
                            int numOfCrewmates = 0;
                            for (int i = 0; i < playersInRoom.size(); i++) {
                                if (playersInRoom.get(i).getType().equals(NOT_SUS) && playersInRoom.get(i).isAlive()) {
                                    noCrewmates = false;
                                    numOfCrewmates++;
                                }
                            }
                            if (noCrewmates || (numOfCrewmates == 1 && !isCooldown())) {
                                // get the chance to move
                                randomChance = new Random().nextInt(100);
                                // 50% chance
                                if (randomChance >= 50) {
                                    setCurrentRoom(ventRoom);
                                    ventUsed = true;
                                    // update view
                                    getMap().refreshView(getColourIndex());
                                }
                            }
                        }
                    }
                    if (!ventUsed) {
                        String[] connectedRooms = getMap().findConnectedRooms(getCurrentRoom());
                        if (connectedRooms != null) {
                            int randomRoom = new Random().nextInt(connectedRooms.length);
                            setCurrentRoom(connectedRooms[randomRoom]);
                            // update view
                            getMap().refreshView(getColourIndex());
                        }
                    }
                }
            }
        }
    }

    /**
     * Updates the cooldown time.
     */
    private void updateCooldown() {
        double endCooldown = System.currentTimeMillis();
        if ((endCooldown - startCooldown) / 1000 >= COOLDOWN_TIME) {
            setCooldown(false);
        }
    }

    /**
     * Kills a crewmate.
     *
     * @param player the player
     */
    private void kill(Player player) {
        player.setAlive(false);
        getMap().killPlayer(player);
        // terminate the thread so that they don't move anymore
        player.close();
    }

    /**
     * Used for the impostor to leave a room after killing a crewmate.
     */
    private void leaveRoom() {
        setLastRoom(getCurrentRoom());
        String[] connectedRooms = getMap().findConnectedRooms(getCurrentRoom());
        if (connectedRooms != null) {
            setCurrentRoom(connectedRooms[0]);
            // update view
            getMap().refreshView(getColourIndex());
        }
    }

    /**
     * Check game status if it is finished or not.
     *
     * @param player the player
     */
    private void checkGameStatus(Player player) {
        if (player.isUser() || getMap().equalNumberOfImpostors()) {
            getMap().gameFinished(false);
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
