package view.Game;

import model.entity.Player;
import view.ViewUtilities;

import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * The class Cell panel represents the view for one cell of the grid of the map.
 * It has a BufferedImage to store the background image, the name of the image,
 * the list of players in that cell and a boolean to know if the players are
 * visible to the user.
 * @author  Serge Nzodja (gsheshe13@gmail.com)
 * @version 22 /5/2021
 */
public class CellPanel extends JPanel {
    /**
     * The constant READING_ERROR.
     */
    private static final String READING_ERROR = "Error reading image: ";
    /**
     * The constant BLACK.
     */
    private static final String BLACK = "black";
    /**
     * The background image.
     */
    private BufferedImage biImage;
    /**
     * The background image name.
     */
    private String biName;
    /**
     * The Players list.
     */
    private List<Player> players;
    /**
     * The Players hidden boolean.
     */
    private boolean playersHidden;

    /**
     * Instantiates a new Cell panel.
     *
     * @param imageName the image name
     */
    public CellPanel(String imageName) {
        try {
            players = new ArrayList<>();
            playersHidden = true;
            biName = imageName;
            biImage = ImageIO.read(new File("images/" + imageName + ".png"));
            setLayout(new GridBagLayout());
            setMinimumSize(new Dimension(100, 100));
        } catch (IOException e) {
            System.out.println(READING_ERROR + imageName);
        }
    }

    /**
     * Sets panel removing the previous one and adding a new one.
     *
     * @param jPanel the j panel
     */
    public void setPanel(JPanel jPanel) {
        removeAll();
        jPanel.setPreferredSize(new Dimension(100, 100));
        jPanel.setMinimumSize(new Dimension(100, 100));
        jPanel.setOpaque(false);
        add(jPanel);
        revalidate();
        repaint();

        // check if the user is in this room
        for (Player player : players) {
            if (player.isUser()) {
                lightenCell();
                return;
            }
        }
        darkenCell();
    }

    /**
     * Removes a player from the list.
     *
     * @param colorIndex the color index
     */
    public void removePlayer(int colorIndex) {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getColourIndex() == colorIndex) {
                players.remove(i);
                break;
            }
        }
        updateCell();
    }

    /**
     * Adds a player to the list.
     *
     * @param player the player
     */
    public void addPlayer(Player player) {
        players.add(player);
        updateCell();
    }

    /**
     * Updates the cell view y reloading all the characters,
     * removing the previous panel and inserting a new one.
     */
    public void updateCell() {
        boolean hasUser = false;
        for (Player player : players) {
            if (player.isUser()) {
                hasUser = true;
                break;
            }
        }
        JPanel jpCharacters = new JPanel();
        jpCharacters.setLayout(new FlowLayout(FlowLayout.CENTER, -5, -3));
        if (players.size() > 8) {
            jpCharacters.setBorder(new EmptyBorder(10, 0, 0, 0)); // top padding
        } else if (players.size() > 4) {
            jpCharacters.setBorder(new EmptyBorder(20, 0, 0, 0)); // top padding
        } else {
            jpCharacters.setBorder(new EmptyBorder(40, 0, 0, 0)); // top padding
        }
        for (int i = 0; i < players.size(); i++) {
            String imgName = ViewUtilities.ColorStrings[players.get(i).getColourIndex()];
            if (!players.get(i).isAlive()) {
                imgName += "Ded";
            }
            JLabel character = new JLabel(new ImageIcon("images/" + imgName + ".png"));
            character.setVisible(hasUser || !playersHidden);
            jpCharacters.add(character);
        }
        setPanel(jpCharacters);
    }

    /**
     * Darkens the cell by changing the background image.
     */
    public void darkenCell() {
        if (biName.equals(BLACK)) return;
        try {
            biImage = ImageIO.read(new File("images/" + biName + "dark.png"));
            revalidate();
            repaint();
        } catch (IOException e) {
            System.out.println(READING_ERROR + biName);
        }
    }

    /**
     * Lighten the cell by changing the background image.
     */
    public void lightenCell() {
        if (biName.equals(BLACK)) return;
        try {
            biImage = ImageIO.read(new File("images/" + biName + ".png"));
            revalidate();
            repaint();
        } catch (IOException e) {
            System.out.println(READING_ERROR + biName);
        }
    }

    /**
     * Show players to the user.
     */
    public void showPlayers() {
        playersHidden = false;
        updateCell();
    }

    /**
     * Hides players to the user.
     */
    public void hidePlayers() {
        playersHidden = true;
        updateCell();
    }

    /**
     * Sets players.
     *
     * @param players the players
     */
    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!biName.equals(BLACK)) {
            g.drawImage(biImage, 0, 0, this);
        }
    }
}
