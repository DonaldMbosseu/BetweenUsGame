package view.SetupGame;
import view.ViewUtilities;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The class Settings panel shows two options for the user to log out and
 * to delete their account from the database. These are stored in two buttons
 * that are managed in the controller and automatically update the view after clicking them.
 * @author  Serge Nzodja (gsheshe13@gmail.com)
 * @version 22/5/2021
 */
public class SettingsPanel extends JPanel {
    /**
     * The constant LOGOUT_LABEL.
     */
    public static final String LOGOUT_LABEL = "Log Out";
    /**
     * The constant DELETE_ACC_LABEL.
     */
    public static final String DELETE_ACC_LABEL = "Delete Account";
    /**
     * The constant BACK_LABEL.
     */
    public static final String BACK_LABEL = "Back";

    /**
     * The constant BTN_LOGOUT.
     */
    public static final String BTN_LOGOUT = "BTN_LOGOUT";
    /**
     * The constant BTN_DELETE_ACCOUNT.
     */
    public static final String BTN_DELETE_ACCOUNT = "BTN_DELETE_ACCOUNT";
    /**
     * The constant BTN_BACK_S.
     */
    public static final String BTN_BACK_S = "BTN_BACK_S";
    /**
     * The constant SETTINGS.
     */
    private static final String SETTINGS = "Settings";
    /**
     * The constant VOLUME.
     */
    private static final String VOLUME = "Volume";

    /**
     * The Jb log out.
     */
    private JButton jbLogOut;
    /**
     * The Jb delete account.
     */
    private JButton jbDeleteAccount;
    /**
     * The Jb back.
     */
    private JButton jbBack;
    /**
     * The Previous.
     */
    private JPanel previous;


    /**
     * Instantiates a new Settings panel.
     */
    public SettingsPanel() {
        // Setting the main panel layout
        setLayout(new BorderLayout(50, 50));
        setBorder(new EmptyBorder(20, 20, 20, 20));
        // To put the Center panel transparent
        setOpaque(false);

        LineBorder lineBorder = new LineBorder(Color.WHITE,4,true);
        EmptyBorder emptyBorder = new EmptyBorder(10, 10, 10, 10);
        EmptyBorder emptyBorder1 = new EmptyBorder(10, 50, 10, 50);

        // Creating an invisible box to set spaces between buttons
        Dimension minSize = new Dimension(5, 50);
        Dimension prefSize = new Dimension(5, 50);
        Dimension maxSize = new Dimension(Short.MAX_VALUE, 50);

        Dimension minSize1 = new Dimension(5, 25);
        Dimension prefSize1 = new Dimension(5, 25);
        Dimension maxSize1 = new Dimension(Short.MAX_VALUE, 25);

        Dimension minSize2 = new Dimension(5, 12);
        Dimension prefSize2 = new Dimension(5, 12);
        Dimension maxSize2 = new Dimension(Short.MAX_VALUE, 12);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        //Settings Jlabel
        JLabel jlSettings = new JLabel();
        jlSettings.setText(SETTINGS);
        jlSettings.setFont(ViewUtilities.getBetweenUsFont(50));
        jlSettings.setForeground(Color.white);
        jlSettings.setAlignmentX(0.5f);
        centerPanel.add(jlSettings);

        JSeparator jSeparator = new JSeparator();
        jSeparator.setForeground(Color.white);
        centerPanel.add(jSeparator);

        centerPanel.setOpaque(false);
        centerPanel.add(new Box.Filler(minSize2,prefSize2,maxSize2));

        //Volume Jlabel
        JLabel jlVolume = new JLabel();
        jlVolume.setText(VOLUME);
        jlVolume.setFont(ViewUtilities.getBetweenUsFont(30));
        jlVolume.setForeground(Color.white);
        jlVolume.setAlignmentX(0.5f);

        centerPanel.add(jlVolume);

        //invisible box
        centerPanel.setOpaque(false);
        centerPanel.add(new Box.Filler(minSize2,prefSize2,maxSize2));

        JSlider jSlider = new JSlider();
        jSlider.setBackground(Color.black);
        jSlider.setBorder(new CompoundBorder(lineBorder, emptyBorder));
        centerPanel.add(jSlider);

        // Getting the size of the biggest button to the other button
        Dimension maximumSize = jSlider.getMaximumSize();

        //invisible box
        centerPanel.setOpaque(false);
        centerPanel.add(new Box.Filler(minSize1,prefSize1,maxSize1));


        //SFX Jlabel
        JLabel jlSfx = new JLabel();
        jlSfx.setText("SFX");
        jlSfx.setFont(ViewUtilities.getBetweenUsFont(30));
        jlSfx.setForeground(Color.white);
        jlSfx.setAlignmentX(0.5f);
        centerPanel.add(jlSfx);

        //invisible box
        centerPanel.setOpaque(false);
        centerPanel.add(new Box.Filler(minSize2,prefSize2,maxSize2));


        JSlider jSlider1 = new JSlider();
        jSlider1.setBackground(Color.black);
        jSlider1.setBorder(new CompoundBorder(lineBorder, emptyBorder));
        centerPanel.add(jSlider1);


        //Creating an invisible box to set spaces between buttons
        centerPanel.setOpaque(false);
        centerPanel.add(new Box.Filler(minSize1,prefSize1,maxSize1));

        //Creating an invisible box to set spaces between buttons
        centerPanel.setOpaque(false);
        centerPanel.add(new Box.Filler(minSize,prefSize,maxSize));

        //delete account button
        jbDeleteAccount = new JButton(DELETE_ACC_LABEL);
        jbDeleteAccount.setForeground(Color.white);
        jbDeleteAccount.setFont(ViewUtilities.getBetweenUsFont(30));
        jbDeleteAccount.setBackground(Color.BLACK);
        jbDeleteAccount.setBorder(new CompoundBorder(lineBorder,emptyBorder1));
        jbDeleteAccount.setMaximumSize(maximumSize);
        jbDeleteAccount.setAlignmentX(0.5f);
        jbDeleteAccount.setActionCommand(BTN_DELETE_ACCOUNT);

        centerPanel.add(jbDeleteAccount);

        //Creating an invisible box to set spaces between buttons
        centerPanel.setOpaque(false);
        centerPanel.add(new Box.Filler(minSize1,prefSize1,maxSize1));


        // log out button
        jbLogOut = new JButton(LOGOUT_LABEL);
        jbLogOut.setForeground(Color.white);
        jbLogOut.setFont(ViewUtilities.getBetweenUsFont(30));
        jbLogOut.setBackground(Color.BLACK);
        jbLogOut.setBorder(new CompoundBorder(lineBorder,emptyBorder1));
        jbLogOut.setMaximumSize(maximumSize);
        jbLogOut.setAlignmentX(0.5f);
        jbLogOut.setActionCommand(BTN_LOGOUT);
        centerPanel.add(jbLogOut);

        //Creating an invisible box to set spaces between buttons
        centerPanel.setOpaque(false);
        centerPanel.add(new Box.Filler(minSize1,prefSize1,maxSize1));

        jbBack = new JButton(BACK_LABEL);
        jbBack.setForeground(Color.white);
        jbBack.setFont(ViewUtilities.getBetweenUsFont(30));
        jbBack.setBackground(Color.BLACK);
        jbBack.setBorder(new CompoundBorder(lineBorder,emptyBorder1));
        jbBack.setAlignmentX(0.5f);
        jbBack.setActionCommand(BTN_BACK_S);
        centerPanel.add(jbBack);


        add(centerPanel);
    }

    /**
     * Register controller.
     *
     * @param listener the listener
     */
    public void registerController(ActionListener listener) {
        jbLogOut.addActionListener(listener);
        jbDeleteAccount.addActionListener(listener);
        jbBack.addActionListener(listener);
    }

    /**
     * Gets previous.
     *
     * @return the previous
     */
    public JPanel getPrevious() {
        return previous;
    }

    /**
     * Sets previous.
     *
     * @param previous the previous
     */
    public void setPrevious(JPanel previous) {
        this.previous = previous;
    }
}

