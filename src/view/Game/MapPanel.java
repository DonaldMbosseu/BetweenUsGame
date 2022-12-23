package view.Game;

import model.GameManager;
import model.UserManager;
import model.entity.Game;
import model.entity.Player;
import model.entity.Room;
import view.Access.MainFrame;
import view.ViewUtilities;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

/**
 * The class Map panel is the JPanel that contains all other JPanels of the game view.
 * About the map, it is a GridLayout stored in a JPanel. This class also has an array of cells
 * of type CellPanel, the game and some booleans to know the status of the game so that the view can
 * be updated accordingly. It also has other views and managers because it requires access to the database
 * on certain moments to write data.
 * @author  Serge Nzodja (gsheshe13@gmail.com)
 * @version 22/5/2021
 */
public class MapPanel extends JPanel {
    /**
     * The constant NOT_SUS.
     */
    private static final String NOT_SUS = "Not Sus";
    /**
     * The Jp map.
     */
    private JPanel jpMap;
    /**
     * The Cells.
     */
    private CellPanel[] cells;
    /**
     * The Game.
     */
    private Game game;
    /**
     * The Show search.
     */
    private boolean showSearch;
    /**
     * The Show check.
     */
    private boolean showCheck;
    /**
     * The Game time.
     */
    private long gameTime;
    /**
     * The Pause time.
     */
    private long pauseTime;
    /**
     * The Game paused.
     */
    private boolean gamePaused;
    /**
     * The View.
     */
    private MainFrame view;
    /**
     * The Game manager.
     */
    private GameManager gameManager;
    /**
     * The User manager.
     */
    private UserManager userManager;
    /**
     * The User.
     */
    private String user;

    /**
     * Instantiates a new Map panel.
     *
     * @param g                the g
     * @param jpEastGamePanel  the jp east game panel
     * @param jpWestGamePanel  the jp west game panel
     * @param jpSouthGamePanel the jp south game panel
     * @param view             the view
     * @param manager          the manager
     * @param username         the username
     * @param isNewGame        the is new game
     * @param userManager      the user manager
     */
    public MapPanel(Game g, EastGamePanel jpEastGamePanel, WestGamePanel jpWestGamePanel, MapPanelSouth jpSouthGamePanel, MainFrame view, GameManager manager, String username, boolean isNewGame, UserManager userManager) {
        game = g;
        gameManager = manager;
        this.userManager = userManager;
        user = username;
        showSearch = false;
        showCheck = false;
        gamePaused = false;
        this.view = view;

        setLayout(new BorderLayout(20,20));
        setBorder(new EmptyBorder(20,20,20,20));
        setOpaque(false);
        jpMap = new JPanel(new GridLayout(4, 4));
        jpMap.setSize(400,400);
        jpMap.setOpaque(false);
        jpMap.setMinimumSize(new Dimension(400,400));
        cells = new CellPanel[game.getMap().getRooms().size()];

        if (isNewGame) {
            // draw the map and characters in starting room
            for (int i = 0; i < game.getMap().getRooms().size(); i++) {
                cells[i] = new CellPanel(game.getMap().getRooms().get(i).getName());
                cells[i].setOpaque(false);
                if (game.getMap().getRooms().get(i).isStartingPoint()) {
                    JPanel jpCharacters = new JPanel();
                    jpCharacters.setLayout(new FlowLayout(FlowLayout.CENTER, -5, -3));
                    jpCharacters.setMinimumSize(new Dimension(100, 100));
                    if (game.getNumCharacters() > 8) {
                        jpCharacters.setBorder(new EmptyBorder(10, 0, 0, 0)); // top padding
                    } else if (game.getNumCharacters() > 4) {
                        jpCharacters.setBorder(new EmptyBorder(20, 0, 0, 0)); // top padding
                    } else {
                        jpCharacters.setBorder(new EmptyBorder(40, 0, 0, 0)); // top padding
                    }
                    //jpCharacters.setOpaque(false);
                    for (int j = 0; j < game.getNumCharacters(); j++) {
                        String imgName = ViewUtilities.ColorStrings[game.getPlayers().get(j).getColourIndex()];
                        JLabel character = new JLabel(new ImageIcon("images/" + imgName + ".png"));
                        jpCharacters.add(character);
                    }
                    cells[i].setPanel(jpCharacters);
                    cells[i].setPlayers(new ArrayList<>(game.getPlayers()));
                    cells[i].lightenCell();
                } else {
                    cells[i].darkenCell();
                }
                jpMap.add(cells[i]);
            }
        } else {
            // draw the map and characters in current room
            // find the players room
            String playerRoom = "";
            for (int i = 0; i < game.getPlayers().size(); i++) {
                if (game.getPlayers().get(i).isUser()) {
                    playerRoom = game.getPlayers().get(i).getCurrentRoom();
                    break;
                }
            }
            for (int i = 0; i < game.getMap().getRooms().size(); i++) {
                cells[i] = new CellPanel(game.getMap().getRooms().get(i).getName());
                cells[i].setOpaque(false);
                for (int j = 0; j < game.getPlayers().size(); j++) {
                    if (game.getPlayers().get(j).getCurrentRoom().equals(game.getMap().getRooms().get(i).getName())) {
                        cells[i].addPlayer(game.getPlayers().get(j));
                    }
                }
                if (game.getMap().getRooms().get(i).getName().equals(playerRoom)) {
                    cells[i].lightenCell();
                } else {
                    cells[i].darkenCell();
                }
                cells[i].showPlayers();
                jpMap.add(cells[i]);
            }
        }
        add(jpMap, BorderLayout.CENTER);

        // EAST
        add(jpEastGamePanel, BorderLayout.EAST);

        // WEST
        add(jpWestGamePanel, BorderLayout.WEST);

        // SOUTH
        add(jpSouthGamePanel, BorderLayout.SOUTH);
    }

    /**
     * Moves the user to another cell given a direction.
     *
     * @param direction the direction
     */
    public void moveUser(String direction) {
        String usersRoom = "";

        for (int i = 0; i < game.getPlayers().size(); i++) {
            // find the user
            if (game.getPlayers().get(i).isUser()) {
                usersRoom = game.getPlayers().get(i).getCurrentRoom();
                for (int j = 0; j < game.getMap().getRooms().size(); j++) {
                    // find the user's room
                    if (game.getMap().getRooms().get(j).getName().equals(usersRoom)) {
                        // find destination room
                        int roomIndex = j;
                        switch (direction) {
                            case "UP" -> roomIndex -= 4;
                            case "DOWN" -> roomIndex += 4;
                            case "LEFT" -> roomIndex--;
                            case "RIGHT" -> roomIndex++;
                        }
                        // check if it is a valid room
                        if (roomIndex < 0 || roomIndex > 15) {
                            // invalid room
                            return;
                        }
                        // check if the destination room is connected to the origin room
                        String destination = game.getMap().getRooms().get(roomIndex).getName();
                        boolean isValid = false;
                        for (int k = 0; k < game.getMap().getRooms().get(j).getConnectedRooms().length; k++) {
                            if (game.getMap().getRooms().get(j).getConnectedRooms()[k].equals(destination)) {
                                isValid = true;
                                break;
                            }
                        }
                        if (!isValid) return;
                        // update the current and last room
                        game.getPlayers().get(i).setLastRoom(game.getPlayers().get(i).getCurrentRoom());
                        game.getPlayers().get(i).setCurrentRoom(destination);
                        // move the player
                        cells[j].removePlayer(game.getPlayers().get(i).getColourIndex());
                        cells[roomIndex].addPlayer(game.getPlayers().get(i));
                        updateRoomState(game.getMap().getRooms().get(roomIndex));
                        hidePlayers();
                        return;
                    }
                }
            }
        }
    }

    /**
     * Starts the game.
     */
    public void startGame() {
        // create threads for the players
        for (int i = 0; i < game.getPlayers().size(); i++) {
            if (!game.getPlayers().get(i).isUser() && game.getPlayers().get(i).isAlive()) {
                new Thread(game.getPlayers().get(i)).start();
            }
        }
        gameTime = (System.currentTimeMillis()/1000);
    }

    /**
     * Used to find an update in the game that should be reflected in the view.
     *
     * @param colorIndex the color index
     */
    public void refreshView(int colorIndex) {
        for (int i = 0; i < game.getPlayers().size(); i++) {
            // find the player
            if (game.getPlayers().get(i).getColourIndex() == colorIndex) {
                String currentRoom = game.getPlayers().get(i).getCurrentRoom();
                String lastRoom = game.getPlayers().get(i).getLastRoom();
                // find the player's room
                for (int j = 0; j < game.getMap().getRooms().size(); j++) {
                    // find the player's room
                    if (game.getMap().getRooms().get(j).getName().equals(lastRoom)) {
                        // remove the player
                        cells[j].removePlayer(game.getPlayers().get(i).getColourIndex());
                    }
                    if (game.getMap().getRooms().get(j).getName().equals(currentRoom)) {
                        // add the player
                        cells[j].addPlayer(game.getPlayers().get(i));
                        if (game.getMap().getRooms().get(j).isRegisterLog()) {
                            gameManager.addLog(game.getPlayers().get(i).getColourIndex(), getGameTime(), game.getName(), user, game.getMap().getRooms().get(j).getName());
                            if (view.getTableFrame() != null) {
                                view.getTableFrame().refreshView();
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Finds connected rooms to a given room.
     *
     * @param room the room
     * @return the string array
     */
    public String[] findConnectedRooms(String room) {
        for (int i = 0; i < game.getMap().getRooms().size(); i++) {
            if (game.getMap().getRooms().get(i).getName().equals(room)) {
                return game.getMap().getRooms().get(i).getConnectedRooms();
            }
        }
        return null;
    }

    /**
     * Finds players in a room.
     *
     * @param room the room
     * @return the array list
     */
    public ArrayList<Player> findPlayersInRoom(String room) {
        ArrayList<Player> players = new ArrayList<>();
        for (int i = 0; i < game.getPlayers().size(); i++) {
            if (game.getPlayers().get(i).getCurrentRoom().equals(room)) {
                players.add(game.getPlayers().get(i));
            }
        }

        return players;
    }

    /**
     * Kills a player.
     *
     * @param player the player
     */
    public void killPlayer(Player player) {
        for (int i = 0; i < game.getMap().getRooms().size(); i++) {
            if (game.getMap().getRooms().get(i).getName().equals(player.getCurrentRoom())) {
                // Swap player with dead player image
                cells[i].updateCell();
            }
        }
    }

    /**
     * Method that runs when the game is finished so the view is updated.
     *
     * @param userWon the user won
     */
    public void gameFinished(boolean userWon) {
        game.setFinished(true);
        // close all threads of the players
        for (int i = 0; i < game.getPlayers().size(); i++) {
            if (!game.getPlayers().get(i).isUser()) {
                game.getPlayers().get(i).close();
            }
        }
        if (userWon) {
            view.updateView(view.getMapPanel(), view.getWinPanel());
        } else {
            view.updateView(view.getMapPanel(), view.getLosePanel());
        }
        userManager.addGame(user, userWon);
    }

    /**
     * Returns if there are the same number of crewmates than impostors.
     *
     * @return the boolean
     */
    public boolean equalNumberOfImpostors() {
        int aliveCrewmates = 0;
        for (int i = 0; i < game.getPlayers().size(); i++) {
            if (game.getPlayers().get(i).getType().equals(NOT_SUS) && game.getPlayers().get(i).isAlive()) {
                aliveCrewmates++;
            }
        }
        return game.getNumImpostors() == aliveCrewmates;
    }

    /**
     * Searches for a vent room in a given room.
     *
     * @param room the room
     * @return the string
     */
    public String ventRoomIn(String room) {
        for (int i = 0; i < game.getMap().getRooms().size(); i++) {
            if (game.getMap().getRooms().get(i).getName().equals(room)) {
                return game.getMap().getRooms().get(i).getVentRoom();
            }
        }
        return "-";
    }

    /**
     * Pauses the game.
     */
    public void pauseGame() {
        for (int i = 0; i < game.getPlayers().size(); i++) {
            if (!game.getPlayers().get(i).isUser()) {
                game.getPlayers().get(i).pause();
            }
        }
        pauseTime = (System.currentTimeMillis()/1000);
        gamePaused = true;
    }

    /**
     * Resumes the game.
     */
    public void resumeGame() {
        for (int i = 0; i < game.getPlayers().size(); i++) {
            if (!game.getPlayers().get(i).isUser()) {
                game.getPlayers().get(i).resume();
            }
        }
        gameTime = gameTime - (System.currentTimeMillis()/1000 - pauseTime);
        gamePaused = false;
    }

    /**
     * Updates room state.
     *
     * @param room the room
     */
    private void updateRoomState(Room room) {
        showCheck = false;
        showSearch = false;
        if (room.isClassification()) {
            showCheck = true;
        } else if (room.isLogSystem()) {
            showSearch = true;
        }
    }

    /**
     * Hides the players to the user.
     */
    public void hidePlayers() {
        for (int i = 0; i < game.getMap().getRooms().size(); i++) {
            cells[i].hidePlayers();
        }
    }

    /**
     * Shows the players to the user.
     */
    public void showPlayers() {
        for (int i = 0; i < game.getMap().getRooms().size(); i++) {
            cells[i].showPlayers();
        }
    }

    /**
     * Gets the game time.
     *
     * @return the game time
     */
    public int getGameTime() {
        return (int) ((System.currentTimeMillis()/1000) - gameTime);
    }

    /**
     * Boolean used to know if a button is showed or not.
     *
     * @return the boolean
     */
    public boolean isShowSearch() {
        return showSearch;
    }

    /**
     * Boolean used to know if a button is showed or not.
     *
     * @return the boolean
     */
    public boolean isShowCheck() {
        return showCheck;
    }

    /**
     * Gets the game.
     *
     * @return the game
     */
    public Game getGame() {
        return game;
    }

    /**
     * Is game paused boolean.
     *
     * @return the boolean
     */
    public boolean isGamePaused() {
        return gamePaused;
    }
}
