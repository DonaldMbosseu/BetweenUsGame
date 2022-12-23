package model.dao.sql;

import model.dao.UserDAO;
import model.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class that implements the methods described in the {@link UserDAO} interface.
 *
 * Specifically, it implements the user persistence in a SQL database.
 * @author  Serge Nzodja (gsheshe13@gmail.com)
 * @version 22/5/2021
 */
public class SQLUserDAO implements UserDAO {
    @Override
    public void addUser(User user) {
        String query = "INSERT INTO User(username, email, password, totalWins) VALUES ('" +
                user.getUsername() + "', '" +
                user.getEmail() + "', '" +
                user.getPassword() + "', '" +
                user.getTotalWins() + "');";

        SQLConnector.getInstance().insertQuery(query);
    }

    @Override
    public boolean usernameExists(String username) {
        String query = "SELECT userName FROM User WHERE userName = '" + username + "';";
        ResultSet result = SQLConnector.getInstance().selectQuery(query);

        try {
            return result.next(); // checks if there is any row
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean emailExists(String email) {
        String query = "SELECT email FROM User WHERE email = '" + email + "';";
        ResultSet result = SQLConnector.getInstance().selectQuery(query);

        try {
            return result.next(); // checks if there is any row
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean isPasswordValid(String username, String password, boolean isUsername) {
        String query = "SELECT password FROM User WHERE userName = '" + username + "';";
        if (!isUsername) {
            query = "SELECT password FROM User WHERE email = '" + username + "';";
        }
        ResultSet result = SQLConnector.getInstance().selectQuery(query);

        try {
            if (result.next()) {
                return result.getString("password").equals(password);
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public User getUser(String username) {
        String query = "SELECT * FROM User WHERE userName = '" + username + "';";
        if (!usernameExists(username)) {
            query = "SELECT * FROM User WHERE email = '" + username + "';";
        }
        ResultSet result = SQLConnector.getInstance().selectQuery(query);

        try {
            if (result.next()) {
                String user = result.getString("userName");
                String email = result.getString("email");
                String password = result.getString("password");
                int totalWins = result.getInt("totalWins");

                return new User(user, email, password, totalWins);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void deleteUser(String username) {
        String query = "";
        if (usernameExists(username)) {
            query = "DELETE FROM Log WHERE user = '" + username + "';";
            SQLConnector.getInstance().deleteQuery(query);
            query = "DELETE FROM Player WHERE user = '" + username + "';";
            SQLConnector.getInstance().deleteQuery(query);
            query = "DELETE FROM Game WHERE user = '" + username + "';";
            SQLConnector.getInstance().deleteQuery(query);
            query = "DELETE FROM Graph WHERE userName = '" + username + "';";
            SQLConnector.getInstance().deleteQuery(query);
            query = "DELETE FROM User WHERE userName = '" + username + "';";
            SQLConnector.getInstance().deleteQuery(query);
            return;
        }

        if (emailExists(username)) {
            query = "SELECT * FROM User WHERE email = '" + username + "';";
            ResultSet result = SQLConnector.getInstance().selectQuery(query);

            try {
                if (result.next()) { // checks if there is any row
                    String user = result.getString("userName");
                    query = "DELETE FROM Log WHERE user = '" + user + "';";
                    SQLConnector.getInstance().deleteQuery(query);
                    query = "DELETE FROM Player WHERE user = '" + user + "';";
                    SQLConnector.getInstance().deleteQuery(query);
                    query = "DELETE FROM Game WHERE user = '" + user + "';";
                    SQLConnector.getInstance().deleteQuery(query);
                    query = "DELETE FROM Graph WHERE userName = '" + user + "';";
                    SQLConnector.getInstance().deleteQuery(query);
                    query = "DELETE FROM User WHERE userName = '" + user + "';";
                    SQLConnector.getInstance().deleteQuery(query);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
