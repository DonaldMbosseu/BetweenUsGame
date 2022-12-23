package view.Access;

import view.HintPassField;
import view.HintTextFieldUI;
import view.ViewUtilities;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The class Login panel is a JPanel that represents the view to login.
 * It has a JTestField, a HintPassField and two JButton.
 * It also has methods to retrieve the data inserted by the user.
 * @author  Serge Nzodja (gsheshe13@gmail.com)
 * @version 22/5/2021
 */
public class LoginPanel extends JPanel {
    /**
     * The constant LOGIN_LABEL.
     */
    public static final String LOGIN_LABEL = "SIGN IN";
    /**
     * The constant USERNAME_LABEL.
     */
    public static final String USERNAME_LABEL = "Username / Email";
    /**
     * The constant PASSWORD_LABEL.
     */
    public static final String PASSWORD_LABEL = "Password";
    /**
     * The constant CANCEL_LABEL.
     */
    public static final String CANCEL_LABEL = "CANCEL";
    /**
     * The constant ENTER_NAME_MAIL_LABEL.
     */
    public static final String ENTER_NAME_MAIL_LABEL = "Enter your username or email here";
    /**
     * The constant ENTER_PASSWORD_LABEL.
     */
    public static final String ENTER_PASSWORD_LABEL = "Enter your password here";
    /**
     * The constant TEXT_FIELD_LENGTH.
     */
    public static final int TEXT_FIELD_LENGTH = 30;
    /**
     * The constant TEXT_SIZE.
     */
    public static final int TEXT_SIZE = 25;
    /**
     * The constant BTN_LOGIN.
     */
    public static final String BTN_LOGIN = "BTN_LOGIN1";
    /**
     * The constant BTN_CANCEL.
     */
    public static final String BTN_CANCEL = "BTN_CANCEL1";

    /**
     * The Jtf username.
     */
    private JTextField jtfUsername;
    /**
     * The Jpf password.
     */
    private HintPassField jpfPassword;
    /**
     * The Jb login.
     */
    private JButton jbLogin;
    /**
     * The Jb cancel.
     */
    private JButton jbCancel;

    /**
     * Instantiates a new Login panel.
     */
    public LoginPanel() {
        // Setting the Layout
        setLayout(new BorderLayout(20,20));
        setBorder(new EmptyBorder(20, 20, 20, 20) );//adds margin to panel
        // Change background color
        setBackground(Color.white);
        JLabel loginName = new JLabel(LOGIN_LABEL);
        // Put label on the middle
        loginName.setHorizontalAlignment(SwingConstants.CENTER);
        loginName.setFont(ViewUtilities.getBetweenUsFont(TEXT_SIZE*2));
        add(loginName, BorderLayout.NORTH);

        // Center panel
        JPanel center = new JPanel();
        // Setting Box layout for the center
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));

        // Top part of the center
        // Username Label
        JLabel usernameLabel = new JLabel();
        usernameLabel.setFont(ViewUtilities.getBetweenUsFont(TEXT_SIZE));
        usernameLabel.setText(USERNAME_LABEL);
        usernameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        center.add(usernameLabel);
        center.setBackground(Color.WHITE);

        // Text field
        JPanel centerTop = new JPanel();
        centerTop.setBackground(Color.WHITE);

        jtfUsername = new JTextField(TEXT_FIELD_LENGTH);
        jtfUsername.setUI(new HintTextFieldUI(ENTER_NAME_MAIL_LABEL, true));
        centerTop.add(jtfUsername);
        center.add(centerTop);

        // Bottom part of the center
        JPanel centerBottom = new JPanel();
        centerBottom.setBackground(Color.white);
        // Password Label
        JLabel passwordLabel = new JLabel();
        passwordLabel.setFont(ViewUtilities.getBetweenUsFont(TEXT_SIZE));
        passwordLabel.setText(PASSWORD_LABEL);
        passwordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        center.add(passwordLabel);

        // Text Field
        jpfPassword = new HintPassField(ENTER_PASSWORD_LABEL);

        jpfPassword.setForeground(Color.GRAY);
        jpfPassword.setColumns(TEXT_FIELD_LENGTH);
        centerBottom.add(jpfPassword);
        center.add(centerBottom);
        add(center, BorderLayout.CENTER);


        // South panel
        JPanel south = new JPanel();
        south.setLayout(new FlowLayout());
        south.setBackground(Color.white);
        // Login button
        jbLogin = new JButton();
        jbLogin.setBackground(ViewUtilities.blue);
        jbLogin.setForeground(Color.white);
        jbLogin.setFont(ViewUtilities.getBetweenUsFont(TEXT_SIZE));
        jbLogin.setText(LOGIN_LABEL);
        jbLogin.setActionCommand(BTN_LOGIN);
        south.add(jbLogin, BorderLayout.SOUTH);

        // Cancel Button
        jbCancel = new JButton();
        jbCancel.setBackground(ViewUtilities.blue);
        jbCancel.setForeground(Color.white);
        jbCancel.setFont(ViewUtilities.getBetweenUsFont(TEXT_SIZE));
        jbCancel.setText(CANCEL_LABEL);
        jbCancel.setActionCommand(BTN_CANCEL);
        south.add(jbCancel, BorderLayout.SOUTH);
        add(south, BorderLayout.SOUTH);
    }

    /**
     * Register controller.
     *
     * @param listener the listener
     */
    public void registerController(ActionListener listener){
        jbLogin.addActionListener(listener);
        jbCancel.addActionListener(listener);
    }

    /**
     * Gets username or email.
     *
     * @return the username or email
     */
    public String getUsernameOrEmail() {
        return jtfUsername.getText();
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        try {
            return String.valueOf(jpfPassword.getPassword());
        } catch (NullPointerException e) {
            return "";
        }
    }

    /**
     * Reset ui.
     */
    public void resetUI() {
        jtfUsername.setText("");
        jpfPassword.setText(ENTER_PASSWORD_LABEL);
        jpfPassword.setShowingHint(true);
    }
}