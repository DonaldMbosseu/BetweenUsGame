package view.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The class East game panel is used in the map panel to allow the
 * user to move around the map. It has 4 JButton that are arrows.
 * It also has other buttons that appear in special rooms only.
 * It has methods to hide or show those special buttons and a
 * method to register the controller.
 * @author  Serge Nzodja (gsheshe13@gmail.com)
 * @version 22/5/2021
 */
public class EastGamePanel extends JPanel {
    /**
     * The constant BTN_ARROW_UP.
     */
    public static final String BTN_ARROW_UP = "BTN_ARROW_UP";
    /**
     * The constant BTN_ARROW_DOWN.
     */
    public static final String BTN_ARROW_DOWN = "BTN_ARROW_DOWN";
    /**
     * The constant BTN_ARROW_LEFT.
     */
    public static final String BTN_ARROW_LEFT = "BTN_ARROW_LEFT";
    /**
     * The constant BTN_ARROW_RIGHT.
     */
    public static final String BTN_ARROW_RIGHT = "BTN_ARROW_RIGHT";
    /**
     * The constant BTN_VIEW.
     */
    public static final String BTN_VIEW = "BTN_VIEW";
    /**
     * The constant BTN_SEARCH.
     */
    public static final String BTN_SEARCH = "BTN_SEARCH";
    /**
     * The constant BTN_CHECK.
     */
    public static final String BTN_CHECK = "BTN_CHECK";

    /**
     * The Jb arrow up.
     */
    private JButton jbArrowUp;
    /**
     * The Jb arrow down.
     */
    private JButton jbArrowDown;
    /**
     * The Jb arrow left.
     */
    private JButton jbArrowLeft;
    /**
     * The Jb arrow right.
     */
    private JButton jbArrowRight;
    /**
     * The Jb view.
     */
    private JButton jbView;
    /**
     * The Jb search.
     */
    private JButton jbSearch;
    /**
     * The Jb check.
     */
    private JButton jbCheck;
    /**
     * The Jp east north.
     */
    private JPanel jpEastNorth;


    /**
     * Instantiates a new East game panel.
     */
    public EastGamePanel() {
        setLayout(new BorderLayout());
        setOpaque(false);

        jpEastNorth = new JPanel();
        jpEastNorth.setLayout(new BorderLayout());
        jpEastNorth.setOpaque(false);

        jbView = new JButton(new ImageIcon("images/View.png"));
        jbView.setBorder(BorderFactory.createEmptyBorder());
        jbView.setContentAreaFilled(false);
        jbView.setActionCommand(BTN_VIEW);

        jbSearch = new JButton(new ImageIcon("images/Search.png"));
        jbSearch.setBorder(BorderFactory.createEmptyBorder());
        jbSearch.setContentAreaFilled(false);
        jbSearch.setActionCommand(BTN_SEARCH);

        jbCheck = new JButton(new ImageIcon("images/check classification.png"));
        jbCheck.setBorder(BorderFactory.createEmptyBorder());
        jbCheck.setContentAreaFilled(false);
        jbCheck.setActionCommand(BTN_CHECK);

        jpEastNorth.add(jbView, BorderLayout.EAST);
        add(jpEastNorth, BorderLayout.NORTH);

        JPanel east_south = new JPanel();
        east_south.setLayout(new BorderLayout());
        east_south.setOpaque(false);

        jbArrowUp = new JButton(new ImageIcon("images/arrow-up.png"));
        jbArrowUp.setBorder(BorderFactory.createEmptyBorder());
        jbArrowUp.setContentAreaFilled(false);
        jbArrowUp.setActionCommand(BTN_ARROW_UP);

        jbArrowDown = new JButton(new ImageIcon("images/arrow-down.png"));
        jbArrowDown.setBorder(BorderFactory.createEmptyBorder());
        jbArrowDown.setContentAreaFilled(false);
        jbArrowDown.setActionCommand(BTN_ARROW_DOWN);

        jbArrowLeft = new JButton(new ImageIcon("images/arrow-left.png"));
        jbArrowLeft.setBorder(BorderFactory.createEmptyBorder());
        jbArrowLeft.setContentAreaFilled(false);
        jbArrowLeft.setActionCommand(BTN_ARROW_LEFT);

        jbArrowRight = new JButton(new ImageIcon("images/arrow-right.png"));
        jbArrowRight.setBorder(BorderFactory.createEmptyBorder());
        jbArrowRight.setContentAreaFilled(false);
        jbArrowRight.setActionCommand(BTN_ARROW_RIGHT);

        east_south.add(jbArrowUp, BorderLayout.NORTH);
        east_south.add(jbArrowDown, BorderLayout.SOUTH);
        east_south.add(jbArrowLeft, BorderLayout.WEST);
        east_south.add(jbArrowRight, BorderLayout.EAST);
        east_south.add(new Box.Filler(new Dimension(50,50), new Dimension(50,50), new Dimension(50,50)), BorderLayout.CENTER);
        add(east_south, BorderLayout.SOUTH);
        add(new Box.Filler(new Dimension(50,120), new Dimension(50,120), new Dimension(50,120)), BorderLayout.CENTER);
    }

    /**
     * Register controller.
     *
     * @param listener the listener
     */
    public void registerController(ActionListener listener) {
        jbArrowUp.addActionListener(listener);
        jbArrowDown.addActionListener(listener);
        jbArrowLeft.addActionListener(listener);
        jbArrowRight.addActionListener(listener);
        jbView.addActionListener(listener);
        jbSearch.addActionListener(listener);
        jbCheck.addActionListener(listener);
    }

    /**
     * Show search button.
     */
    public void showSearchButton() {
        jpEastNorth.removeAll();
        jpEastNorth.add(jbView, BorderLayout.EAST);
        jpEastNorth.add(jbSearch, BorderLayout.WEST);
        revalidate();
        repaint();
    }

    /**
     * Show check button.
     */
    public void showCheckButton() {
        jpEastNorth.removeAll();
        jpEastNorth.add(jbView, BorderLayout.EAST);
        jpEastNorth.add(jbCheck, BorderLayout.WEST);
        revalidate();
        repaint();
    }

    /**
     * Remove buttons.
     */
    public void removeButtons() {
        jpEastNorth.removeAll();
        jpEastNorth.add(jbView, BorderLayout.EAST);
        revalidate();
        repaint();
    }
}
