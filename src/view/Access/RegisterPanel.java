package view.Access;

import view.HintPassField;
import view.HintTextFieldUI;
import view.ViewUtilities;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The class Register panel is a JPanel that represents the view to login.
 * It has two JTestField, two HintPassField and two JButton.
 * It also has methods to retrieve the data inserted by the user.
 * @author  Serge Nzodja (gsheshe13@gmail.com)
 * @version 22/5/2021
 */
public class RegisterPanel extends JPanel {
    /**
     * The constant REGISTER_LABEL.
     */
    public static final String REGISTER_LABEL = "Sign Up";
    /**
     * The constant USERNAME_LABEL.
     */
    public static final String USERNAME_LABEL = "Username";
    /**
     * The constant Email_LABEL.
     */
    public static final String Email_LABEL = "Email";
    /**
     * The constant PASSWORD_LABEL.
     */
    public static final String PASSWORD_LABEL = "Password";
    /**
     * The constant CONFIRM_PASSWORD_LABEL.
     */
    public static final String CONFIRM_PASSWORD_LABEL = "Confirm Password";
    /**
     * The constant ENTER_USERNAME_LABEL.
     */
    public static final String ENTER_USERNAME_LABEL = "Enter a username here";
    /**
     * The constant ENTER_EMAIL_LABEL.
     */
    public static final String ENTER_EMAIL_LABEL = "Enter an email here";
    /**
     * The constant ENTER_PASSWORD_LABEL.
     */
    public static final String ENTER_PASSWORD_LABEL = "Enter a password here";
    /**
     * The constant ENTER_CONF_PASSWORD_LABEL.
     */
    public static final String ENTER_CONF_PASSWORD_LABEL = "Confirm the password here";
    /**
     * The constant REGISTER_BTN_LABEL.
     */
    public static final String REGISTER_BTN_LABEL = "REGISTER";
    /**
     * The constant CANCEL_LABEL.
     */
    public static final String CANCEL_LABEL = "CANCEL";
    /**
     * The constant TEXT_FIELD_LENGTH.
     */
    public static final int TEXT_FIELD_LENGTH = 30;
    /**
     * The constant TEXT_SIZE.
     */
    public static final int TEXT_SIZE = 25;
    /**
     * The constant BTN_REGISTER.
     */
    public static final String BTN_REGISTER = "BTN_REGISTER2";
    /**
     * The constant BTN_CANCEL.
     */
    public static final String BTN_CANCEL = "BTN_CANCEL2";

    /**
     * The Jtf username.
     */
    private JTextField jtfUsername;
    /**
     * The Jtf email.
     */
    private JTextField jtfEmail;
    /**
     * The Jpf password.
     */
    private HintPassField jpfPassword;
    /**
     * The Jpf repeat password.
     */
    private HintPassField jpfRepeatPassword;
    /**
     * The Jb register.
     */
    private JButton jbRegister;
    /**
     * The Jb cancel.
     */
    private JButton jbCancel;

    /**
     * Instantiates a new Register panel.
     */
    public RegisterPanel() {
        // Setting the Layout
        setLayout(new BorderLayout(20,20));
        setBorder(new EmptyBorder(20, 20, 20, 20));//adds margin to panel
        // Change background color
        setBackground(Color.white);
        JLabel loginName = new JLabel(REGISTER_LABEL);
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
        JPanel usernamePanel = new JPanel();
        usernamePanel.setBackground(Color.WHITE);
        jtfUsername = new JTextField(TEXT_FIELD_LENGTH);
        jtfUsername.setUI(new HintTextFieldUI(ENTER_USERNAME_LABEL, true));

        usernamePanel.add(jtfUsername);
        center.add(usernamePanel);


        // Email
        JPanel emailPanel = new JPanel();
        emailPanel.setBackground(Color.white);
        // Email Label
        JLabel emailLabel = new JLabel();
        emailLabel.setFont(ViewUtilities.getBetweenUsFont(TEXT_SIZE));
        emailLabel.setText(Email_LABEL);
        emailLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        center.add(emailLabel);
        // Text Field
        jtfEmail = new JTextField(TEXT_FIELD_LENGTH);
        jtfEmail.setUI(new HintTextFieldUI(ENTER_EMAIL_LABEL, true));

        emailPanel.add(jtfEmail);
        center.add(emailPanel);
        add(center, BorderLayout.CENTER);


        // Password
        JPanel passwordPanel = new JPanel();
        passwordPanel.setBackground(Color.white);
        // Password Label
        JLabel passwordLabel = new JLabel();
        passwordLabel.setFont(ViewUtilities.getBetweenUsFont(TEXT_SIZE));
        passwordLabel.setText(PASSWORD_LABEL);
        passwordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        center.add(passwordLabel);
        // Personalized Password field Field
        jpfPassword = new HintPassField(ENTER_PASSWORD_LABEL);
        jpfPassword.setForeground(Color.GRAY);
        jpfPassword.setColumns(TEXT_FIELD_LENGTH);

        passwordPanel.add(jpfPassword);
        center.add(passwordPanel);
        add(center, BorderLayout.CENTER);


        // Confirm Password
        JPanel confirmPasswordPanel = new JPanel();
        confirmPasswordPanel.setBackground(Color.white);
        // Confirm Password Label
        JLabel confirmPasswordLabel = new JLabel();
        confirmPasswordLabel.setFont(ViewUtilities.getBetweenUsFont(TEXT_SIZE));
        confirmPasswordLabel.setText(CONFIRM_PASSWORD_LABEL);
        confirmPasswordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        center.add(confirmPasswordLabel);
        // Text Field
        jpfRepeatPassword = new HintPassField(ENTER_CONF_PASSWORD_LABEL);
        jpfRepeatPassword.setForeground(Color.GRAY);
        jpfRepeatPassword.setColumns(TEXT_FIELD_LENGTH);
        confirmPasswordPanel.add(jpfRepeatPassword);
        center.add(confirmPasswordPanel);
        add(center, BorderLayout.CENTER);


        // South panel
        JPanel south = new JPanel();
        south.setLayout(new FlowLayout());
        south.setBackground(Color.white);
        // Login button
        jbRegister = new JButton();
        jbRegister.setBackground(ViewUtilities.blue);
        jbRegister.setForeground(Color.white);
        jbRegister.setFont(ViewUtilities.getBetweenUsFont(TEXT_SIZE));
        jbRegister.setText(REGISTER_BTN_LABEL);
        jbRegister.setActionCommand(BTN_REGISTER);
        south.add(jbRegister, BorderLayout.SOUTH);

        // Cancel Button
        jbCancel = new JButton();
        jbCancel.setBackground(ViewUtilities.blue);
        jbCancel.setForeground(Color.white);
        jbCancel.setFont(ViewUtilities.getBetweenUsFont(TEXT_SIZE));
        jbCancel.setText(CANCEL_LABEL);
        jbCancel.setActionCommand(BTN_CANCEL);
        south.add(jbCancel, BorderLayout.SOUTH);
        add(south,BorderLayout.SOUTH);
    }

    /**
     * Register controller.
     *
     * @param listener the listener
     */
    public void registerController(ActionListener listener){
        jbRegister.addActionListener(listener);
        jbCancel.addActionListener(listener);
    }

    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUsername() {
        return jtfUsername.getText();
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return jtfEmail.getText();
    }

    /**
     * Gets password 1.
     *
     * @return the password 1
     */
    public String getPassword1() {
        try {
            return String.valueOf(jpfPassword.getPassword());
        } catch (NullPointerException e) {
            return "";
        }
    }

    /**
     * Gets password 2.
     *
     * @return the password 2
     */
    public String getPassword2() {
        try {
            return String.valueOf(jpfRepeatPassword.getPassword());
        } catch (NullPointerException e) {
            return "";
        }
    }

    /**
     * Reset ui.
     */
    public void resetUI() {
        jtfEmail.setText("");
        jtfUsername.setText("");
        jpfPassword.setText(ENTER_PASSWORD_LABEL);
        jpfPassword.setShowingHint(true);
        jpfRepeatPassword.setText(ENTER_CONF_PASSWORD_LABEL);
        jpfRepeatPassword.setShowingHint(true);
    }
}

