package view.Game;

import model.entity.Player;
import view.ViewUtilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * The class Map panel south is used for the user to make their guess on who are the
 * impostors and crewmates.
 * It has a list of players and a matrix of JPanels to store all the panels
 * of the grid.
 * @author  Serge Nzodja (gsheshe13@gmail.com)
 * @version 22/5/2021
 */
public class MapPanelSouth extends JPanel {
    /**
     * The constant SOUTH_COLUMNS.
     */
    private static final int SOUTH_COLUMNS = 3;
    /**
     * The constant SOUTH_ROWS.
     */
    private static final int SOUTH_ROWS = 9;
    /**
     * The constant borderWidth.
     */
    private static final int borderWidth = 2;
    /**
     * The constant topLabels.
     */
    private static final String[] topLabels = {"Unknown", "Sus", "Not Sus"};

    /**
     * The Jp players.
     */
    private JPanel jpPlayers;
    /**
     * The Player list.
     */
    private List<Player> playerList;
    /**
     * The Panel holder.
     */
    private JPanel[][] panelHolder;
    /**
     * The Player panels.
     */
    private PlayerPanel[] playerPanels;

    /**
     * Instantiates a new Map panel south.
     */
    public MapPanelSouth() {
        playerList = new ArrayList<>();
        // add demo players
        for (int i = 0; i < SOUTH_ROWS; i++) {
            playerList.add(new Player("", "", "", 0, false, false, false));
        }

        setLayout(new BorderLayout());

        JPanel titles = new JPanel(new GridLayout(1, 3));
        //unknown label
        JLabel jlUnknown = new JLabel(topLabels[0]);
        jlUnknown.setFont(ViewUtilities.getBetweenUsFont(18));
        jlUnknown.setVerticalAlignment(JLabel.CENTER);
        jlUnknown.setHorizontalAlignment(JLabel.CENTER);
        jlUnknown.setBorder(BorderFactory.createMatteBorder(borderWidth, borderWidth, borderWidth, borderWidth, Color.GRAY));
        titles.add(jlUnknown);

        //sus label
        JLabel jlSus = new JLabel(topLabels[1]);
        jlSus.setFont(ViewUtilities.getBetweenUsFont(18));
        jlSus.setVerticalAlignment(JLabel.CENTER);
        jlSus.setHorizontalAlignment(JLabel.CENTER);
        jlSus.setBorder(BorderFactory.createMatteBorder(borderWidth,0, borderWidth, borderWidth, Color.GRAY));
        titles.add(jlSus);

        //Not sus label
        JLabel jlNotSus = new JLabel(topLabels[2]);
        jlNotSus.setFont(ViewUtilities.getBetweenUsFont(18));
        jlNotSus.setVerticalAlignment(JLabel.CENTER);
        jlNotSus.setHorizontalAlignment(JLabel.CENTER);
        jlNotSus.setBorder(BorderFactory.createMatteBorder(borderWidth,0, borderWidth, borderWidth, Color.GRAY));
        titles.add(jlNotSus);

        jpPlayers = new JPanel(new GridLayout(SOUTH_ROWS, SOUTH_COLUMNS));

        // create the grid
        panelHolder = new JPanel[SOUTH_ROWS][SOUTH_COLUMNS];
        for (int row = 0; row < SOUTH_ROWS; row++) {
            for (int col = 0; col < SOUTH_COLUMNS; col++) {
                panelHolder[row][col] = new JPanel(new BorderLayout());
                // Bottom left corner
                if (col == 0 && row == SOUTH_ROWS-1) {
                    panelHolder[row][col].setBorder(BorderFactory.createMatteBorder(0, borderWidth, borderWidth, borderWidth, Color.GRAY));
                } else if (col == 0) {  // Left column
                    panelHolder[row][col].setBorder(BorderFactory.createMatteBorder(0, borderWidth, 0, borderWidth, Color.GRAY));
                } else if (row == SOUTH_ROWS-1) { // Bottom row
                    panelHolder[row][col].setBorder(BorderFactory.createMatteBorder(0, 0, borderWidth, borderWidth, Color.GRAY));
                } else { // Other columns
                    panelHolder[row][col].setBorder(BorderFactory.createMatteBorder(0, 0, 0, borderWidth, Color.GRAY));
                }
                jpPlayers.add(panelHolder[row][col]);
            }
        }

        // Add the players
        playerPanels = new PlayerPanel[SOUTH_ROWS];
        for (int i = 0; i < playerList.size(); i++) {
            PlayerPanel player = new PlayerPanel(playerList.get(i), i);
            playerPanels[i] = player;
            player.setPosX(0);
            player.setPosY(i);
            panelHolder[i][0].add(player, BorderLayout.CENTER);
        }

        add(titles, BorderLayout.NORTH);
        add(jpPlayers, BorderLayout.CENTER);
    }

    /**
     * Removes the user from the player list.
     */
    private void removeUser() {
        for (int i = 0; i < playerList.size(); i++) {
            if (playerList.get(i).isUser()) {
                playerList.remove(i);
                break;
            }
        }
    }

    /**
     * Register controller.
     *
     * @param listener the listener
     */
    public void registerController(ActionListener listener) {
        for (int i = 0; i < SOUTH_ROWS; i++) {
            playerPanels[i].registerController(listener);
        }
    }

    /**
     * Sets player list.
     *
     * @param players the players
     */
    public void setPlayerList(List<Player> players) {
        playerList = new ArrayList<>(players);
        removeUser();

        // remove previous players
        for (int i = 0; i < SOUTH_ROWS; i++) {
            for (int j = 0; j < SOUTH_COLUMNS; j++) {
                panelHolder[i][j].removeAll();
            }
        }
        // add new players
        for (int i = 0; i < playerList.size(); i++) {
            playerPanels[i].setPanel(playerList.get(i));
            if (playerList.get(i).getRole().equals(topLabels[1])) {
                playerPanels[i].setPosX(1);
            } else if (playerList.get(i).getRole().equals(topLabels[2])) {
                playerPanels[i].setPosX(2);
            }
            panelHolder[i][playerPanels[i].getPosX()].add(playerPanels[i], BorderLayout.CENTER);
        }

        revalidate();
        repaint();
    }

    /**
     * Moves a player given a row in the table and a direction.
     *
     * @param row       the row
     * @param direction the direction
     */
    public void movePlayer(int row, String direction) {
        int column = playerPanels[row].getPosX();
        panelHolder[row][column].removeAll();

        switch (column) {
            case 0 -> column = (direction.equals(PlayerPanel.LEFT_LABEL)) ? 2 : 1;
            case 1 -> column = (direction.equals(PlayerPanel.LEFT_LABEL)) ? 0 : 2;
            case 2 -> column = (direction.equals(PlayerPanel.LEFT_LABEL)) ? 1 : 0;
        }

        playerList.get(row).setRole(topLabels[column]);

        playerPanels[row].setPosX(column);
        panelHolder[row][column].add(playerPanels[row], BorderLayout.CENTER);

        revalidate();
        repaint();
    }

    /**
     * Gets player list.
     *
     * @return the player list
     */
    public List<Player> getPlayerList() {
        return playerList;
    }
}
