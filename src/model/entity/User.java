package model.entity;

/**
 * This class represents a User.
 * A User has several attributes to store the username, email, password and total wins.
 * @author  Serge Nzodja (gsheshe13@gmail.com)
 * @version 22/5/2021
 */
public class User {
    /**
     * The Username.
     */
    private String username;
    /**
     * The Email.
     */
    private String email;
    /**
     * The Password.
     */
    private String password;
    /**
     * The Total wins.
     */
    private int totalWins;

    /**
     * Instantiates a new User.
     *
     * @param username  the username
     * @param email     the email
     * @param password  the password
     * @param totalWins the total wins
     */
    public User(String username, String email, String password, int totalWins) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.totalWins = totalWins;
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
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets total wins.
     *
     * @return the total wins
     */
    public int getTotalWins() {
        return totalWins;
    }
}
