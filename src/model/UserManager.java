package model;

import model.dao.GraphDAO;
import model.dao.UserDAO;
import model.dao.sql.SQLGraphDAO;
import model.dao.sql.SQLUserDAO;
import model.entity.Graph;
import model.entity.User;

/**
 * This class represents the User Manager.
 * The User Manager has several attributes and methods storing any implementation of the DAOs.
 * @author  Serge Nzodja (gsheshe13@gmail.com)
 * @version 22/5/2021
 */
public class UserManager {
    /**
     * The User dao.
     */
    private final UserDAO userDAO;
    /**
     * The Graph dao.
     */
    private final GraphDAO graphDAO;
    /**
     * The Username.
     */
    private String username;

    /**
     * Instantiates a new User manager.
     */
    public UserManager() {
        userDAO = new SQLUserDAO();
        graphDAO = new SQLGraphDAO();
        username = "";
    }

    /**
     * Add user using the userDAO.
     *
     * @param user the user
     */
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    /**
     * Username exists boolean using the userDAO.
     *
     * @param username the username
     * @return the boolean
     */
    public boolean usernameExists(String username) {
        return userDAO.usernameExists(username);
    }

    /**
     * Email exists boolean using the userDAO.
     *
     * @param email the email
     * @return the boolean
     */
    public boolean emailExists(String email) {
        return userDAO.emailExists(email);
    }

    /**
     * Is password valid boolean using the userDAO.
     *
     * @param username   the username
     * @param password   the password
     * @param isUsername the is username
     * @return the boolean
     */
    public boolean isPasswordValid(String username, String password, boolean isUsername) {
        return userDAO.isPasswordValid(username, password, isUsername);
    }

    /**
     * Gets user using the userDAO.
     *
     * @param username the username
     * @return the user
     */
    public User getUser(String username) {
        return userDAO.getUser(username);
    }

    /**
     * Delete user using the userDAO.
     *
     * @param username the username
     */
    public void deleteUser(String username) {
        userDAO.deleteUser(username);
    }

    /**
     * Add game using the graphDAO.
     *
     * @param user    the user
     * @param userWon the user won
     */
    public void addGame(String user, boolean userWon) {
        graphDAO.addGame(user, userWon);
    }

    /**
     * Gets games using the graphDAO.
     *
     * @param user the user
     * @return the games
     */
    public Graph getGames(String user) {
        return graphDAO.getGames(user);
    }

    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets username.
     *
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }
}
