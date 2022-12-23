package view.Access;

import view.ViewUtilities;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * This class represents the view previous to login and register.
 * It is a JPanel with two buttons to login or register.
 * @author  Serge Nzodja (gsheshe13@gmail.com)
 * @version 22/5/2021
 */
public class AccessPanel extends JPanel {
    /**
     * The constant LOGIN_NAME_LABEL.
     */
    public static final String LOGIN_NAME_LABEL = "Between Us";
    /**
     * The constant LOGIN_LABEL.
     */
    public static final String LOGIN_LABEL = "LOG IN";
    /**
     * The constant REGISTER_LABEL.
     */
    public static final String REGISTER_LABEL = "REGISTER";
    /**
     * The constant BTN_LOGIN.
     */
    public static final String BTN_LOGIN = "BTN_LOGIN0";
    /**
     * The constant BTN_REGISTER.
     */
    public static final String BTN_REGISTER = "BTN_REGISTER0";

    /**
     * The Jb login.
     */
    private JButton jbLogin;
    /**
     * The Jb signup.
     */
    private JButton jbSignup;

    /**
     * Instantiates a new Access panel.
     */
    public AccessPanel() {
        // Setting the Layout
        setLayout(new BorderLayout(20,30));
        setBorder(new EmptyBorder(10, 10, 10, 10) );//adds margin to panel
        // Change background color
        setBackground(Color.white);
        JLabel jlLoginName = new JLabel(LOGIN_NAME_LABEL);
        // Put label on the middle
        jlLoginName.setHorizontalAlignment(SwingConstants.CENTER);
        jlLoginName.setFont(ViewUtilities.getBetweenUsFont(50));
        add(jlLoginName, BorderLayout.NORTH);

        // Center panel
        JPanel jpCenter = new JPanel();
        jpCenter.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0));
        jpCenter.setBackground(Color.white);
        // Login button
        jbLogin = new JButton();
        jbLogin.setBackground(ViewUtilities.blue);
        jbLogin.setForeground(Color.white);
        jbLogin.setFont(ViewUtilities.getBetweenUsFont(30));
        jbLogin.setText(LOGIN_LABEL);
        jbLogin.setActionCommand(BTN_LOGIN);
        jpCenter.add(jbLogin);

        // Register Button
        jbSignup = new JButton();
        jbSignup.setBackground(ViewUtilities.blue);
        jbSignup.setForeground(Color.white);
        jbSignup.setFont(ViewUtilities.getBetweenUsFont(30));
        jbSignup.setText(REGISTER_LABEL);
        jbSignup.setActionCommand(BTN_REGISTER);
        jpCenter.add(jbSignup);
        add(jpCenter, BorderLayout.CENTER);
    }


    /**
     * Register controller.
     *
     * @param listener the listener
     */
    public void registerController(ActionListener listener) {
        jbLogin.addActionListener(listener);
        jbSignup.addActionListener(listener);
    }
}