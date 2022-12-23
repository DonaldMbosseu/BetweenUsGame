package view.SetupGame;

import view.ViewUtilities;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The class How to panel explains the user how to play the game.
 * It only has one button to go back to the main menu.
 * @author  Serge Nzodja (gsheshe13@gmail.com)
 * @version 22/5/2021
 */
public class HowToPanel extends JPanel {
    /**
     * The constant HOW_TO_LABEL.
     */
    private static final String HOW_TO_LABEL = "How to Play";
    /**
     * The constant TITLE_TEXT.
     */
    private static final String TITLE_TEXT = "Welcome to Between Us!";
    /**
     * The constant GAME_OPTIONS.
     */
    private static final String GAME_OPTIONS = "To start a game the user has the following options: ";
    /**
     * The constant NEW_GAME_TEXT.
     */
    private static final String NEW_GAME_TEXT = "    ->Start New Game: Creates a new game with the preferred user settings";
    /**
     * The constant START_GAME_TEXT.
     */
    private static final String START_GAME_TEXT = "Starting a Game:";
    /**
     * The constant LOAD_GAME_TEXT.
     */
    private static final String LOAD_GAME_TEXT = "    ->Load Game: The user can continue an unfinished game";
    /**
     * The constant CONTINUE_GAME_TEXT.
     */
    private static final String CONTINUE_GAME_TEXT = "    ->Continue Game: The user can continue the last unfinished game";
    /**
     * The constant GAME_CONTROLS.
     */
    private static final String GAME_CONTROLS = "Game controls:";
    /**
     * The constant GAME_CONTROL_OPTIONS.
     */
    private static final String GAME_CONTROL_OPTIONS = " The user has the following ingame Buttons to play the game: ";
    /**
     * The constant ARROWS_TEXT.
     */
    private static final String ARROWS_TEXT = "    ->Arrows: Control the movement of the user character around the map";
    /**
     * The constant EYE_TEXT.
     */
    private static final String EYE_TEXT = "    ->Eye: Shows a screen to see the suspicious characters of the game";
    /**
     * The constant QUIT_TEXT.
     */
    private static final String QUIT_TEXT = "    ->Quit: Button to leave the game without saving it";
    /**
     * The constant SAVE_TEXT.
     */
    private static final String SAVE_TEXT = "    ->Save: Button to save the game";
    /**
     * The constant STOP_TEXT.
     */
    private static final String STOP_TEXT = "    ->Stop: Button to stop the game";
    /**
     * The constant PLAY_TEXT.
     */
    private static final String PLAY_TEXT = "    ->Play: Button to stop pausing the game";
    /**
     * The constant BACK_BUTTON_LABEL.
     */
    private static final String BACK_BUTTON_LABEL = "Back";


    /**
     * The Jb back.
     */
    private JButton jbBack;
    /**
     * The constant BTN_BACK.
     */
    public static final String BTN_BACK = "BTN_HBCK";


    /**
     * Instantiates a new How to panel.
     */
    public HowToPanel() {
        // Setting the main panel layout
        setLayout(new BorderLayout(50, 50));
        setBorder(new EmptyBorder(20, 20, 20, 20));
        // To put the Center panel transparent
        setOpaque(false);

        LineBorder lineBorder = new LineBorder(Color.WHITE,4,true);
        EmptyBorder emptyBorder = new EmptyBorder(10, 10, 10, 10);

        // Creating an invisible box dimensions to set spaces between buttons
        Dimension minSize = new Dimension(5, 5);
        Dimension prefSize = new Dimension(5, 5);
        Dimension maxSize = new Dimension(Short.MAX_VALUE, 5);

        // Second invisible box dimensions for spacings
        Dimension minSize1 = new Dimension(12, 12);
        Dimension prefSize1 = new Dimension(12, 12);
        Dimension maxSize1 = new Dimension(Short.MAX_VALUE, 12);

        // Third invisible box dimensions for spacings
        Dimension minSize2 = new Dimension(5, 12);
        Dimension prefSize2 = new Dimension(5, 12);
        Dimension maxSize2 = new Dimension(Short.MAX_VALUE, 12);

        // Main panel of the view
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        //Settings Jlabel
        JLabel jlSettings = new JLabel();
        jlSettings.setText(HOW_TO_LABEL);
        jlSettings.setFont(ViewUtilities.getBetweenUsFont(50));
        jlSettings.setForeground(Color.white);
        jlSettings.setAlignmentX(0.5f);
        centerPanel.add(jlSettings);

        // JSeparator after the title of the panel
        JSeparator jSeparator = new JSeparator();
        jSeparator.setForeground(Color.white);
        centerPanel.add(jSeparator);

        //Invisible box to add spacing
        centerPanel.setOpaque(false);
        centerPanel.add(new Box.Filler(minSize2,prefSize2,maxSize2));

        // Middle panel where the text will be placed
        JPanel textPanel = new JPanel();
        textPanel.setAlignmentX(0.5f);
        textPanel.setLayout(new BoxLayout(textPanel,BoxLayout.Y_AXIS));
        textPanel.setBorder(new CompoundBorder(lineBorder, emptyBorder));
        textPanel.setBackground(Color.black);

        // Add "Welcome to Between US!"
        textPanel.add(ViewUtilities.newCustomTextLabel(TITLE_TEXT,25));
        textPanel.add(new Box.Filler(minSize1,prefSize1,maxSize1));

        // Add "Starting a game"
        textPanel.add(ViewUtilities.newCustomTextLabel(START_GAME_TEXT,20));
        textPanel.add(new Box.Filler(minSize,prefSize,maxSize));

        // Add starting a game paragraph
        textPanel.add(ViewUtilities.newCustomTextLabel(GAME_OPTIONS,16));
        textPanel.add(new Box.Filler(minSize,prefSize,maxSize));
        textPanel.add(ViewUtilities.newCustomTextLabel(NEW_GAME_TEXT,16));
        textPanel.add(new Box.Filler(minSize,prefSize,maxSize));
        textPanel.add(ViewUtilities.newCustomTextLabel(LOAD_GAME_TEXT,16));
        textPanel.add(new Box.Filler(minSize,prefSize,maxSize));
        textPanel.add(ViewUtilities.newCustomTextLabel(CONTINUE_GAME_TEXT,16));
        textPanel.add(new Box.Filler(minSize1,prefSize1,maxSize1));


        // Add "Game Controls"
        textPanel.add(ViewUtilities.newCustomTextLabel(GAME_CONTROLS,20));
        textPanel.add(new Box.Filler(minSize,prefSize,maxSize));

        // Add starting a game paragraph
        textPanel.add(ViewUtilities.newCustomTextLabel(GAME_CONTROL_OPTIONS,16));
        textPanel.add(new Box.Filler(minSize,prefSize,maxSize));
        textPanel.add(ViewUtilities.newCustomTextLabel(ARROWS_TEXT,16));
        textPanel.add(new Box.Filler(minSize,prefSize,maxSize));
        textPanel.add(ViewUtilities.newCustomTextLabel(EYE_TEXT,16));
        textPanel.add(new Box.Filler(minSize,prefSize,maxSize));
        textPanel.add(ViewUtilities.newCustomTextLabel(QUIT_TEXT,16));
        textPanel.add(new Box.Filler(minSize,prefSize,maxSize));
        textPanel.add(ViewUtilities.newCustomTextLabel(LOAD_GAME_TEXT,16));
        textPanel.add(new Box.Filler(minSize,prefSize,maxSize));
        textPanel.add(ViewUtilities.newCustomTextLabel(PLAY_TEXT,16));
        textPanel.add(new Box.Filler(minSize,prefSize,maxSize));
        textPanel.add(ViewUtilities.newCustomTextLabel(STOP_TEXT,16));
        textPanel.add(new Box.Filler(minSize,prefSize,maxSize));
        textPanel.add(ViewUtilities.newCustomTextLabel(SAVE_TEXT,16));

        // Adding the text to the center panel
        centerPanel.add(textPanel);

        //Invisible box to add spacing
        centerPanel.setOpaque(false);
        centerPanel.add(new Box.Filler(minSize2,prefSize2,maxSize2));

        // Back button
        jbBack = new JButton();
        jbBack.setForeground(Color.white);
        jbBack.setText(BACK_BUTTON_LABEL);
        jbBack.setAlignmentX(0.5f);
        jbBack.setFont(ViewUtilities.getBetweenUsFont(30));
        jbBack.setBackground(Color.BLACK);
        jbBack.setBorder(new CompoundBorder(lineBorder,emptyBorder));
        jbBack.setActionCommand(BTN_BACK);
        centerPanel.add(jbBack);

        // Adding the center panel to the main panel
        add(centerPanel);
    }


    /**
     * Register controller.
     *
     * @param listener the listener
     */
    public void registerController(ActionListener listener) {
        jbBack.addActionListener(listener);
    }
}

