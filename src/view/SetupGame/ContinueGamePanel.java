package view.SetupGame;

import model.entity.Game;
import view.ViewUtilities;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * The class Continue game panel shows the unfinished games that the user
 * can continue to play. It has two JButtons to go back to the menu and
 * to continue and play the game. It also has a JComboBox to let the user
 * select the desired game to continue and a list of unfinished games.
 * @author  Serge Nzodja (gsheshe13@gmail.com)
 * @version 22/5/2021
 */
public class ContinueGamePanel extends JPanel {

    /**
     * The constant CONTINUE_GAME_LABEL.
     */
    public static final String CONTINUE_GAME_LABEL = "Continue Game";
    /**
     * The constant BACK_LABEL_D.
     */
    public static final String BACK_LABEL_D = "Back";

    /**
     * The constant BTN_CONTINUE_GAME.
     */
    public static final String BTN_CONTINUE_GAME = "BTN_CONTINUE_GAME";
    /**
     * The constant BTN_BACK_C.
     */
    public static final String BTN_BACK_C = "BTN_BACK_C";

    /**
     * The Jb continue game.
     */
    private JButton jbContinueGame;
    /**
     * The Jb back.
     */
    private JButton jbBack;
    /**
     * The Jcb continue game.
     */
    private JComboBox<String> jcbContinueGame;
    /**
     * The Games.
     */
    private List<Game> games;

    /**
     * Instantiates a new Continue game panel.
     */
    public ContinueGamePanel() {
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
        JLabel jlDeleteGame = new JLabel(CONTINUE_GAME_LABEL);
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

        jcbContinueGame = new JComboBox<>();
        jcbContinueGame.setBounds(50, 50, 90, 20);
        add(jcbContinueGame, BorderLayout.CENTER);


        // North panel to add Delete Game JLabel and JSeparator
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS));
        southPanel.setOpaque(false);


        // Continue Game Button
        jbContinueGame = new JButton(CONTINUE_GAME_LABEL);
        jbContinueGame.setForeground(Color.white);
        jbContinueGame.setFont(ViewUtilities.getBetweenUsFont(30));
        jbContinueGame.setBackground(Color.BLACK);
        jbContinueGame.setBorder(new CompoundBorder(lineBorder,emptyBorder));
        jbContinueGame.setMaximumSize(maxSize);
        jbContinueGame.setAlignmentX(0.5f);
        jbContinueGame.setActionCommand(BTN_CONTINUE_GAME);
        southPanel.add(jbContinueGame);

        // Creating an invisible box to set spaces between buttons
        southPanel.add(new Box.Filler(new Dimension(5, 25), new Dimension(5, 25), new Dimension(Short.MAX_VALUE, 25)));

        jbBack = new JButton(BACK_LABEL_D);
        jbBack.setForeground(Color.white);
        jbBack.setFont(ViewUtilities.getBetweenUsFont(30));
        jbBack.setBackground(Color.BLACK);
        jbBack.setBorder(new CompoundBorder(lineBorder,emptyBorder));
        jbBack.setAlignmentX(0.5f);
        jbBack.setActionCommand(BTN_BACK_C);
        southPanel.add(jbBack);

        add(southPanel, BorderLayout.SOUTH);
        games = new ArrayList<>();
    }

    /**
     * Register controller.
     *
     * @param listener the listener
     */
    public void registerController(ActionListener listener) {
        jbContinueGame.addActionListener(listener);
        jbBack.addActionListener(listener);
    }

    /**
     * Sets games.
     *
     * @param games the games
     */
    public void setGames(List<Game> games) {
        this.games = games;
        jcbContinueGame.removeAllItems();
        // Adding the unfinished games to the view
        for (Game game : games) {
            if (!game.isFinished()) {
                jcbContinueGame.addItem(game.getName());
            }
        }
        revalidate();
        repaint();
    }

    /**
     * Gets game name.
     *
     * @return the game name
     */
    public String getGameName() {
        return (String) jcbContinueGame.getSelectedItem();
    }

    /**
     * Gets selected game.
     *
     * @return the selected game
     */
    public Game getSelectedGame() {
        for (int i = 0; i < games.size(); i++) {
            if (getGameName().equals(games.get(i).getName())) {
                return games.get(i);
            }
        }
        return null;
    }

}
