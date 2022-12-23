package view.SetupGame;

import model.entity.Game;
import view.ViewUtilities;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * The class Delete game panel show a list of completed games that can be deleted from the system.
 * Once deleted they are deleted from the database. It has two JButtons to go back to the menu and
 * to delete a game. It also has a JComboBox to let the user select the desired game.
 * @author  Serge Nzodja (gsheshe13@gmail.com)
 * @version 22/5/2021
 */
public class DeleteGamePanel extends JPanel {
    /**
     * The constant DELETE_GAME_LABEL.
     */
    public static final String DELETE_GAME_LABEL = "Delete Game";
    /**
     * The constant BACK_LABEL_D.
     */
    public static final String BACK_LABEL_D = "Back";

    /**
     * The constant BTN_DELETE_GAME.
     */
    public static final String BTN_DELETE_GAME = "BTN_DELETE_GAME";
    /**
     * The constant BTN_BACK_D.
     */
    public static final String BTN_BACK_D = "BTN_BACK_D";

    /**
     * The Jb delete game.
     */
    private JButton jbDeleteGame;
    /**
     * The Jb back.
     */
    private JButton jbBack;
    /**
     * The Jcb delete game.
     */
    private JComboBox<String> jcbDeleteGame;

    /**
     * Instantiates a new Delete game panel.
     */
    public DeleteGamePanel() {
        // Setting the Layout
        setLayout(new BorderLayout(20,30));
        setBorder(new EmptyBorder(10, 10, 10, 10) );//adds margin to panel
        // To put the Center panel transparent
        setOpaque(false);

        LineBorder lineBorder = new LineBorder(Color.WHITE,4,true);
        EmptyBorder emptyBorder = new EmptyBorder(10, 50, 10, 50);
        Dimension maxSize = new Dimension(Short.MAX_VALUE, 100);


        // North panel to add Delete Game JLabel and JSeparator
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
        northPanel.setOpaque(false);

        // Delete Game JLabel
        JLabel jlDeleteGame = new JLabel(DELETE_GAME_LABEL);
        // Put the desired font
        jlDeleteGame.setFont(ViewUtilities.getBetweenUsFont(50));
        jlDeleteGame.setForeground(Color.white);
        northPanel.add(jlDeleteGame);

        // JSeparator under Delete Game JLabel
        JSeparator jSeparator = new JSeparator();
        jSeparator.setForeground(Color.white);
        northPanel.add(jSeparator);

        // Adding the northPanel to the main Panel
        add(northPanel, BorderLayout.NORTH);

        jcbDeleteGame = new JComboBox<>();
        jcbDeleteGame.setBounds(50, 50, 90, 20);
        add(jcbDeleteGame, BorderLayout.CENTER);


        // North panel to add Delete Game JLabel and JSeparator
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS));
        southPanel.setOpaque(false);


        // Delete Game Button
        jbDeleteGame = new JButton(DELETE_GAME_LABEL);
        jbDeleteGame.setForeground(Color.white);
        jbDeleteGame.setFont(ViewUtilities.getBetweenUsFont(30));
        jbDeleteGame.setBackground(Color.BLACK);
        jbDeleteGame.setBorder(new CompoundBorder(lineBorder,emptyBorder));
        jbDeleteGame.setMaximumSize(maxSize);
        jbDeleteGame.setAlignmentX(0.5f);
        jbDeleteGame.setActionCommand(BTN_DELETE_GAME);
        southPanel.add(jbDeleteGame);

        // Creating an invisible box to set spaces between buttons
        southPanel.add(new Box.Filler(new Dimension(5, 25), new Dimension(5, 25), new Dimension(Short.MAX_VALUE, 25)));

        jbBack = new JButton(BACK_LABEL_D);
        jbBack.setForeground(Color.white);
        jbBack.setFont(ViewUtilities.getBetweenUsFont(30));
        jbBack.setBackground(Color.BLACK);
        jbBack.setBorder(new CompoundBorder(lineBorder,emptyBorder));
        jbBack.setAlignmentX(0.5f);
        jbBack.setActionCommand(BTN_BACK_D);
        southPanel.add(jbBack);

        add(southPanel, BorderLayout.SOUTH);
    }

    /**
     * Register controller.
     *
     * @param listener the listener
     */
    public void registerController(ActionListener listener) {
        jbDeleteGame.addActionListener(listener);
        jbBack.addActionListener(listener);
    }

    /**
     * Gets game name.
     *
     * @return the game name
     */
    public String getGameName() {
        return (String)jcbDeleteGame.getSelectedItem();
    }

    /**
     * Sets games.
     *
     * @param games the games
     */
    public void setGames(List<Game> games) {
        jcbDeleteGame.removeAllItems();
        for (Game game : games) {
            jcbDeleteGame.addItem(game.getName());
        }
        revalidate();
        repaint();
    }
}