package view.Game;

import model.entity.Player;
import view.ViewUtilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The class Player panel represents a cell of the MapPanelSouth panel.
 * It has two buttons to move the player left and right and a JLabel
 * to display the player's color.
 * @author  Serge Nzodja (gsheshe13@gmail.com)
 * @version 22/5/2021
 */
public class PlayerPanel extends JPanel {
    /**
     * The constant LEFT_LABEL.
     */
    public static final String LEFT_LABEL = "<";
    /**
     * The constant RIGHT_LABEL.
     */
    public static final String RIGHT_LABEL = ">";
    /**
     * The constant YELLOW.
     */
    private static final String YELLOW = "yellow";
    /**
     * The constant WHITE.
     */
    private static final String WHITE = "white";
    /**
     * The constant CYAN.
     */
    private static final String CYAN = "cyan";
    /**
     * The constant LIME.
     */
    private static final String LIME = "lime";
    /**
     * The Pos x.
     */
    private int posX;
    /**
     * The Pos y.
     */
    private int posY;

    /**
     * The Jb left move.
     */
    private JButton jbLeftMove;
    /**
     * The Jb right move.
     */
    private JButton jbRightMove;
    /**
     * The Jl player.
     */
    private JLabel jlPlayer;

    /**
     * Instantiates a new Player panel.
     *
     * @param player the player
     * @param index  the index
     */
    public PlayerPanel(Player player, int index) {
        setLayout(new BorderLayout());

        setBackground(ViewUtilities.COLORS[player.getColourIndex()]);

        //go left
        jbLeftMove = new JButton(LEFT_LABEL);
        jbLeftMove.setActionCommand(LEFT_LABEL+index);
        add(jbLeftMove, BorderLayout.WEST);

        //Player
        jlPlayer = new JLabel();
        jlPlayer.setHorizontalAlignment(JLabel.CENTER);
        jlPlayer.setVerticalAlignment(JLabel.CENTER);
        jlPlayer.setText(ViewUtilities.ColorStrings[player.getColourIndex()]);
        jlPlayer.setFont(new Font("Courier", Font.PLAIN, 16));
        if (!ViewUtilities.ColorStrings[player.getColourIndex()].equals(YELLOW) &&
            !ViewUtilities.ColorStrings[player.getColourIndex()].equals(WHITE) &&
            !ViewUtilities.ColorStrings[player.getColourIndex()].equals(CYAN) &&
            !ViewUtilities.ColorStrings[player.getColourIndex()].equals(LIME)) {
            jlPlayer.setForeground(Color.white);
        }

        add(jlPlayer, BorderLayout.CENTER);

        //go right
        jbRightMove = new JButton(RIGHT_LABEL);
        jbRightMove.setActionCommand(RIGHT_LABEL+index);
        add(jbRightMove, BorderLayout.EAST);
    }

    /**
     * Gets pos x.
     *
     * @return the pos x
     */
    public int getPosX() {
        return posX;
    }

    /**
     * Sets pos x.
     *
     * @param posX the pos x
     */
    public void setPosX(int posX) {
        this.posX = posX;
    }

    /**
     * Gets pos y.
     *
     * @return the pos y
     */
    public int getPosY() {
        return posY;
    }

    /**
     * Sets pos y.
     *
     * @param posY the pos y
     */
    public void setPosY(int posY) {
        this.posY = posY;
    }

    /**
     * Sets panel.
     *
     * @param player the player
     */
    public void setPanel(Player player) {
        //Background
        setBackground(ViewUtilities.COLORS[player.getColourIndex()]);

        //Player
        JLabel jlPlayerNew = new JLabel();
        jlPlayerNew.setHorizontalAlignment(JLabel.CENTER);
        jlPlayerNew.setVerticalAlignment(JLabel.CENTER);
        jlPlayerNew.setText(ViewUtilities.ColorStrings[player.getColourIndex()]);
        jlPlayerNew.setFont(new Font("Courier", Font.PLAIN, 16));
        if (!ViewUtilities.ColorStrings[player.getColourIndex()].equals(YELLOW) &&
                !ViewUtilities.ColorStrings[player.getColourIndex()].equals(WHITE) &&
                !ViewUtilities.ColorStrings[player.getColourIndex()].equals(CYAN) &&
                !ViewUtilities.ColorStrings[player.getColourIndex()].equals(LIME)) {
            jlPlayerNew.setForeground(Color.white);
        }
        remove(jlPlayer);
        add(jlPlayerNew, BorderLayout.CENTER);
        jlPlayer = jlPlayerNew;
        posX = 0;

        revalidate();
        repaint();
    }

    /**
     * Register controller.
     *
     * @param listener the listener
     */
    public void registerController(ActionListener listener) {
        jbLeftMove.addActionListener(listener);
        jbRightMove.addActionListener(listener);
    }
}
