package view.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The class West game panel is used to pause the game or to open the settings.
 * It has 4 buttons and a JPanel to update the view of pause and play depending
 * on the buttons. This view is updated from the controller.
 * @author  Serge Nzodja (gsheshe13@gmail.com)
 * @version 22/5/2021
 */
public class WestGamePanel extends JPanel {
    /**
     * The constant BTN_SETTINGS.
     */
    public static final String BTN_SETTINGS = "BTN_STTG";
    /**
     * The constant BTN_STOP.
     */
    public static final String BTN_STOP = "BTN_STOP";
    /**
     * The constant BTN_RESUME.
     */
    public static final String BTN_RESUME = "BTN_RESUME";
    /**
     * The constant BTN_QUIT.
     */
    public static final String BTN_QUIT = "BTN_QUIT";

    /**
     * The Jb settings.
     */
    private JButton jbSettings;
    /**
     * The Jb stop.
     */
    private JButton jbStop;
    /**
     * The Jb resume.
     */
    private JButton jbResume;
    /**
     * The Jb quit.
     */
    private JButton jbQuit;
    /**
     * The Jp play stop.
     */
    private JPanel jpPlayStop;
    /**
     * The Game stopped.
     */
    private boolean gameStopped;

    /**
     * Instantiates a new West game panel.
     */
    public WestGamePanel() {
        // Setting the layout
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setOpaque(false);
        gameStopped = false;

        // Creating the buttons
        // Settings button
        jbSettings = new JButton(new ImageIcon("images/setts.png"));
        jbSettings.setOpaque(false);
        jbSettings.setBorder(BorderFactory.createEmptyBorder());
        jbSettings.setContentAreaFilled(false);
        jbSettings.setActionCommand(BTN_SETTINGS);
        jbSettings.setAlignmentX(LEFT_ALIGNMENT);
        add(jbSettings);
        // Add invisible box for spacing
        add(new Box.Filler(new Dimension(40,40), new Dimension(40,40), new Dimension(40,40)));

        jpPlayStop = new JPanel();
        jpPlayStop.setOpaque(false);
        // Invisible box for spacing
        jpPlayStop.add(new Box.Filler(new Dimension(5,10), new Dimension(5,10), new Dimension(5,10)));

        // Stop Button
        jbStop = new JButton(new ImageIcon("images/pauseButton.png"));
        jbStop.setContentAreaFilled(false);
        jbStop.setBorder(BorderFactory.createEmptyBorder());
        jbStop.setActionCommand(BTN_STOP);
        jbStop.setOpaque(false);
        jpPlayStop.add(jbStop);

        // Resume Button
        jbResume = new JButton(new ImageIcon("images/playButton.png"));
        jbResume.setContentAreaFilled(false);
        jbResume.setBorder(BorderFactory.createEmptyBorder());
        jbResume.setOpaque(false);
        jbResume.setActionCommand(BTN_RESUME);
        //jpPlayStop.add(jbResume);
        jpPlayStop.setAlignmentX(LEFT_ALIGNMENT);
        add(jpPlayStop);

        // Add invisible box for spacing
        add(new Box.Filler(new Dimension(40,100), new Dimension(40,100), new Dimension(40,100)));

        // Quit button
        jbQuit = new JButton(new ImageIcon("images/quitButtonR.png"));
        jbQuit.setContentAreaFilled(false);
        jbQuit.setBorder(BorderFactory.createEmptyBorder());
        jbQuit.setOpaque(false);
        jbQuit.setActionCommand(BTN_QUIT);
        jbQuit.setAlignmentX(LEFT_ALIGNMENT);
        add(jbQuit);
    }

    /**
     * Register controller.
     *
     * @param listener the listener
     */
    public void registerController(ActionListener listener) {
        jbSettings.addActionListener(listener);
        jbStop.addActionListener(listener);
        jbResume.addActionListener(listener);
        jbQuit.addActionListener(listener);
    }

    /**
     * Pause pressed.
     */
    public void pausePressed() {
        jpPlayStop.removeAll();
        jpPlayStop.add(jbResume);
        revalidate();
        repaint();
        gameStopped = true;
    }

    /**
     * Resume pressed.
     */
    public void resumePressed() {
        jpPlayStop.removeAll();
        jpPlayStop.add(jbStop);
        revalidate();
        repaint();
        gameStopped = false;
    }

    /**
     * Is game stopped boolean.
     *
     * @return the boolean
     */
    public boolean isGameStopped() {
        return gameStopped;
    }
}


