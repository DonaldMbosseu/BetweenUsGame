package controller;

import model.UserManager;
import model.entity.User;
import view.Access.MainFrame;
import view.Access.AccessPanel;
import view.Access.LoginPanel;
import view.Access.RegisterPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type Access controller.
 * This class controls the relationship between the logic and the UI.
 * It has the {@link MainFrame} and the {@link UserManager} that are
 * never changed in the program.
 * @author  Serge Nzodja (gsheshe13@gmail.com)
 * @version 22/5/2021
 */
public class AccessController implements ActionListener {
    /**
     * The constant INITIAL_WINS.
     */
    public static int INITIAL_WINS = 0;
    /**
     * The constant ACCOUNT_NOT_FOUND.
     */
    private static final String ACCOUNT_NOT_FOUND = "Account not found";
    /**
     * The constant ERROR.
     */
    private static final String ERROR = "Error";
    /**
     * The constant INVALID_PASSWORD.
     */
    private static final String INVALID_PASSWORD = "Invalid password";
    /**
     * The constant INVALID_USERNAME.
     */
    private static final String INVALID_USERNAME = "Invalid username";
    /**
     * The constant INVALID_EMAIL.
     */
    private static final String INVALID_EMAIL = "Invalid email";

    /**
     * The View.
     */
    private MainFrame view;
    /**
     * The Model.
     */
    private UserManager model;

    /**
     * Instantiates a new Access controller.
     *
     * @param view  the view
     * @param model the model
     */
    public AccessController(MainFrame view, UserManager model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case AccessPanel.BTN_LOGIN:
                view.getLoginPanel().resetUI();
                view.updateView(view.getAccessPanel(), view.getLoginPanel());
                break;
            case AccessPanel.BTN_REGISTER:
                view.getRegisterPanel().resetUI();
                view.updateView(view.getAccessPanel(), view.getRegisterPanel());
                break;
            case LoginPanel.BTN_LOGIN:
                if (login()) {
                    view.updateView(view.getLoginPanel(), view.getMenuPanel());
                }
                break;
            case LoginPanel.BTN_CANCEL:
                view.updateView(view.getLoginPanel(), view.getAccessPanel());
                break;
            case RegisterPanel.BTN_REGISTER:
                if (register()) {
                    view.updateView(view.getRegisterPanel(), view.getMenuPanel());
                }
                break;
            case RegisterPanel.BTN_CANCEL:
                view.updateView(view.getRegisterPanel(), view.getAccessPanel());
                break;
        }
    }

    /**
     * Login boolean.
     *
     * @return true if the login information is valid, false otherwise
     */
    private boolean login() {
        String username = view.getLoginPanel().getUsernameOrEmail();
        String password = view.getLoginPanel().getPassword();
        boolean isUsername = true;

        if (username.isEmpty()) {
            JOptionPane.showMessageDialog(null, ACCOUNT_NOT_FOUND, ERROR, JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!model.usernameExists(username)) {
            isUsername = false;
            if (!model.emailExists(username)) {
                JOptionPane.showMessageDialog(null, ACCOUNT_NOT_FOUND, ERROR, JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }

        if (!model.isPasswordValid(username, password, isUsername)) {
            JOptionPane.showMessageDialog(null, INVALID_PASSWORD, ERROR, JOptionPane.ERROR_MESSAGE);
            return false;
        }

        model.setUsername(username);
        if (!isUsername) {
            User user = model.getUser(username);
            model.setUsername(user.getUsername());
        }

        return true;
    }

    /**
     * Register boolean.
     *
     * @return true if the register information is valid, false otherwise
     */
    private boolean register() {
        String username = view.getRegisterPanel().getUsername();
        String email = view.getRegisterPanel().getEmail();
        String password1 = view.getRegisterPanel().getPassword1();
        String password2 = view.getRegisterPanel().getPassword2();

        if (username.isEmpty()) {
            JOptionPane.showMessageDialog(null, INVALID_USERNAME, ERROR, JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (model.usernameExists(username)) {
            JOptionPane.showMessageDialog(null, INVALID_USERNAME, ERROR, JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!isValidEmailAddress(email) || model.emailExists(email)) {
            JOptionPane.showMessageDialog(null, INVALID_EMAIL, ERROR, JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!isValidPassword(password1) || !password1.equals(password2)) {
            JOptionPane.showMessageDialog(null, INVALID_PASSWORD, ERROR, JOptionPane.ERROR_MESSAGE);
            return false;
        }

        model.addUser(new User(username, email, password1, INITIAL_WINS));
        model.setUsername(username);

        return true;
    }

    /**
     * Is valid email address boolean.
     *
     * @param email the email
     * @return true if the email is valid, false otherwise
     */
    private boolean isValidEmailAddress(String email) {
        String regex = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    /**
     * Is valid password boolean.
     *
     * @param password the password
     * @return true if the password is valid, false otherwise.
     */
    private boolean isValidPassword(String password) {
        String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
