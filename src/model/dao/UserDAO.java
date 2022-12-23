package model.dao;

import model.entity.User;

/**
 * Interface that abstracts the persistence of game from the rest of the code.
 *
 * In particular, it follows the Data Access Object design pattern, which is commonly used to abstract persistence
 * implementations with a set of generic operations.
 * @author  Serge Nzodja (gsheshe13@gmail.com)
 * @version 22/5/2021
 */
public interface UserDAO {
    /**
     * Method that saves a specific user, persisting it.
     *
     * @param user the new user to save
     */
    void addUser(User user);

    /**
     * Method that returns if a username exists in the database.
     *
     * @param username the username
     * @return the boolean
     */
    boolean usernameExists(String username);

    /**
     * Method that returns if an email exists in the database.
     *
     * @param email the email
     * @return the boolean
     */
    boolean emailExists(String email);

    /**
     * Method that returns if a password exists in the database.
     *
     * @param username   the username
     * @param password   the password
     * @param isUsername the is username
     * @return the boolean
     */
    boolean isPasswordValid(String username, String password, boolean isUsername);

    /**
     * Method that reads the persisted information, returning all stored users.
     *
     * @param username the username
     * @return the {@link User}
     */
    User getUser(String username);

    /**
     * Method that deletes a persisted user, by its username.
     * It also deletes all the information about this user from the database.
     *
     * @param username the username
     */
    void deleteUser(String username);
}
