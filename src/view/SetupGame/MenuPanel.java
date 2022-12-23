package view.SetupGame;

import view.ViewUtilities;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The class Menu panel shows the main menu that appears after the login.
 * It has several options, all of them represented by JButtons and
 * managed in the controller.
 * @author  Serge Nzodja (gsheshe13@gmail.com)
 * @version 22/5/2021
 */
public class MenuPanel extends JPanel {
    /**
     * The constant BTN_START_NEW_GAME.
     */
    public static final String BTN_START_NEW_GAME = "BTN_SNG";
    /**
     * The constant BTN_LOAD_GAME.
     */
    public static final String BTN_LOAD_GAME = "BTN_LG";
    /**
     * The constant BTN_CONTINUE_GAME.
     */
    public static final String BTN_CONTINUE_GAME = "BTN_CG";
    /**
     * The constant BTN_DELETE_GAME.
     */
    public static final String BTN_DELETE_GAME = "BTN_DG";
    /**
     * The constant BTN_EVOLUTION.
     */
    public static final String BTN_EVOLUTION = "BTN_EV";
    /**
     * The constant BTN_HOWTO.
     */
    public static final String BTN_HOWTO = "BTN_HT";
    /**
     * The constant BTN_CREDITS.
     */
    public static final String BTN_CREDITS = "BTN_CR";
    /**
     * The constant BTN_SETTINGS.
     */
    public static final String BTN_SETTINGS = "BTN_STGG";

    /**
     * The constant START_LABEL.
     */
    public static final String START_LABEL = " Start New Game ";
    /**
     * The constant LOAD_LABEL.
     */
    public static final String LOAD_LABEL = "Load Game";
    /**
     * The constant CONTINUE_LABEL.
     */
    public static final String CONTINUE_LABEL = "Continue Game";
    /**
     * The constant DELETE_LABEL.
     */
    public static final String DELETE_LABEL = "Delete Game";
    /**
     * The constant EVOLUTION_LABEL.
     */
    public static final String EVOLUTION_LABEL = "User Evolution";
    /**
     * The constant HOWTO_LABEL.
     */
    public static final String HOWTO_LABEL = "How to play";
    /**
     * The constant CREDITS_LABEL.
     */
    public static final String CREDITS_LABEL = "Credits";
    /**
     * The constant FONT_SIZE.
     */
    public static final int FONT_SIZE = 21;

    /**
     * The Jb start new game.
     */
    private JButton jbStartNewGame;
    /**
     * The Jb load game.
     */
    private JButton jbLoadGame;
    /**
     * The Jb continue game.
     */
    private JButton jbContinueGame;
    /**
     * The Jb delete game.
     */
    private JButton jbDeleteGame;
    /**
     * The Jb evolution.
     */
    private JButton jbEvolution;
    /**
     * The Jb how to.
     */
    private JButton jbHowTo;
    /**
     * The Jb credits.
     */
    private JButton jbCredits;
    /**
     * The Jb settings.
     */
    private JButton jbSettings;

    /**
     * Instantiates a new Menu panel.
     */
    public MenuPanel() {
        // Setting the main panel layout
        setLayout(new BorderLayout(20,20));
        setBorder(new EmptyBorder(20, 20, 20, 20) );
        // To put the Center panel transparent
        setOpaque(false);

        // Creating an invisible box to set spaces between buttons
        Dimension minSize = new Dimension(5, 20);
        Dimension prefSize = new Dimension(5, 20);
        Dimension maxSize = new Dimension(Short.MAX_VALUE, 20);

        // Creating  borders for the buttons
        LineBorder lineBorder = new LineBorder(Color.WHITE,4,true);
        EmptyBorder emptyBorder = new EmptyBorder(10, 10, 10, 10);

        // Buttons on the center of the panel in a box layout
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        // Start game button
        jbStartNewGame = new JButton(START_LABEL);
        jbStartNewGame.setForeground(Color.white);
        jbStartNewGame.setFont(ViewUtilities.getBetweenUsFont(FONT_SIZE));
        jbStartNewGame.setBackground(Color.BLACK);
        //jbStartNewGame.setAlignmentX(0.5f);
        jbStartNewGame.setBorder(new CompoundBorder(lineBorder,emptyBorder));
        jbStartNewGame.setActionCommand(BTN_START_NEW_GAME);
        centerPanel.add(jbStartNewGame, BorderLayout.CENTER);

        // Putting the box to set space between buttons
        centerPanel.setOpaque(false);
        centerPanel.add(new Box.Filler(minSize,prefSize,maxSize));

        // Load game button
        jbLoadGame = new JButton(LOAD_LABEL);
        jbLoadGame.setForeground(Color.white);
        jbLoadGame.setFont(ViewUtilities.getBetweenUsFont(FONT_SIZE));
        jbLoadGame.setBackground(Color.BLACK);
        jbLoadGame.setBorder(new CompoundBorder(lineBorder,emptyBorder));
        // Getting the size of the biggest button to the other button
        Dimension maximumSize = jbStartNewGame.getMaximumSize();
        jbLoadGame.setMaximumSize(maximumSize);
        jbLoadGame.setActionCommand(BTN_LOAD_GAME);
        centerPanel.add(jbLoadGame, BorderLayout.CENTER);

        // Putting the box to set space between buttons
        centerPanel.setOpaque(false);
        centerPanel.add(new Box.Filler(minSize,prefSize,maxSize));

        // Continue game button
        jbContinueGame = new JButton(CONTINUE_LABEL);
        jbContinueGame.setForeground(Color.white);
        jbContinueGame.setFont(ViewUtilities.getBetweenUsFont(FONT_SIZE));
        jbContinueGame.setBackground(Color.BLACK);
        jbContinueGame.setBorder(new CompoundBorder(lineBorder,emptyBorder));
        // Getting the size of the biggest button to the other button
        jbContinueGame.setMaximumSize(maximumSize);
        jbContinueGame.setActionCommand(BTN_CONTINUE_GAME);
        centerPanel.add(jbContinueGame, BorderLayout.CENTER);

        // Putting the box to set space between buttons
        centerPanel.setOpaque(false);
        centerPanel.add(new Box.Filler(minSize,prefSize,maxSize));


        // Delete game button
        jbDeleteGame = new JButton(DELETE_LABEL);
        // Changing button size
        jbDeleteGame.setBorder(new CompoundBorder(lineBorder,emptyBorder));
        jbDeleteGame.setForeground(Color.white);
        jbDeleteGame.setFont(ViewUtilities.getBetweenUsFont(FONT_SIZE));
        jbDeleteGame.setBackground(Color.BLACK);

        // Getting the size of the biggest button to the other button
        jbDeleteGame.setMaximumSize(maximumSize);
        jbDeleteGame.setActionCommand(BTN_DELETE_GAME);
        centerPanel.add(jbDeleteGame, BorderLayout.CENTER);

        // Putting the box to set space between buttons
        centerPanel.setOpaque(false);
        centerPanel.add(new Box.Filler(minSize,prefSize,maxSize));


        // Delete game button
        jbEvolution = new JButton(EVOLUTION_LABEL);
        jbEvolution.setBorder(new LineBorder(Color.WHITE));
        jbEvolution.setForeground(Color.white);
        jbEvolution.setFont(ViewUtilities.getBetweenUsFont(FONT_SIZE));
        jbEvolution.setBackground(Color.BLACK);
        jbEvolution.setBorder(new CompoundBorder(lineBorder,emptyBorder));
        // Getting the size of the biggest button to the other button
        jbEvolution.setMaximumSize(maximumSize);
        jbEvolution.setActionCommand(BTN_EVOLUTION);
        centerPanel.add(jbEvolution, BorderLayout.CENTER);
        // Put the box layout with the buttons to center



        // JPanel for the two smaller buttons
        JPanel lastButtonPane = new JPanel();
        lastButtonPane.setLayout(new FlowLayout());
        lastButtonPane.setOpaque(false);

        // How to Play button
        jbHowTo = new JButton(HOWTO_LABEL);
        jbHowTo.setBorder(new LineBorder(Color.WHITE));
        jbHowTo.setForeground(Color.white);
        jbHowTo.setFont(ViewUtilities.getBetweenUsFont(12));
        jbHowTo.setPreferredSize(new Dimension(110,45));
        jbHowTo.setBackground(Color.BLACK);
        jbHowTo.setBorder(new CompoundBorder(lineBorder,emptyBorder));
        jbHowTo.setActionCommand(BTN_HOWTO);
        lastButtonPane.add(jbHowTo);

        // Credits button
        jbCredits = new JButton(CREDITS_LABEL);
        jbCredits.setBorder(new LineBorder(Color.WHITE));
        jbCredits.setForeground(Color.white);
        jbCredits.setFont(ViewUtilities.getBetweenUsFont(12));
        jbCredits.setBackground(Color.BLACK);
        jbCredits.setPreferredSize(new Dimension(110, 45));
        jbCredits.setBorder(new CompoundBorder(lineBorder,emptyBorder));
        jbCredits.setActionCommand(BTN_CREDITS);
        lastButtonPane.add(jbCredits);


        // Adding the buttons to the south
        add(lastButtonPane, BorderLayout.SOUTH);
        // centerPanel.add(lastButtonPane);


        // Panel for the top settings left button
        JPanel west = new JPanel();

        west.setPreferredSize(new Dimension(200, 10));
        west.setLayout(new BoxLayout(west, BoxLayout.Y_AXIS));
        west.setOpaque(false);
        west.setAlignmentX(0f);


        // Settings button
        jbSettings = new JButton(new ImageIcon("images/setts.png"));
        jbSettings.setBorder(BorderFactory.createEmptyBorder());
        jbSettings.setContentAreaFilled(false);
        jbSettings.setActionCommand(BTN_SETTINGS);

        west.add(jbSettings);
        add(west, BorderLayout.WEST);
        // Invisible east panel to align buttons
        JPanel east = new JPanel();
        east.setOpaque(false);
        east.setPreferredSize(new Dimension(200, 10));
        add(east, BorderLayout.EAST);
        JPanel north = new JPanel();
        north.setOpaque(false);
        add(north, BorderLayout.NORTH);


        add(centerPanel, BorderLayout.CENTER);
    }

    /**
     * Register controller.
     *
     * @param listener the listener
     */
    public void registerController(ActionListener listener) {
        jbStartNewGame.addActionListener(listener);
        jbLoadGame.addActionListener(listener);
        jbContinueGame.addActionListener(listener);
        jbDeleteGame.addActionListener(listener);
        jbEvolution.addActionListener(listener);
        jbHowTo.addActionListener(listener);
        jbCredits.addActionListener(listener);
        jbSettings.addActionListener(listener);
    }
}
