package model.dao.sql;

import org.json.JSONObject;
import org.json.JSONTokener;
import java.io.InputStream;
import java.sql.*;

/**
 * The class Sql connector.
 * @author  Serge Nzodja (gsheshe13@gmail.com)
 * @version 22/5/2021
 */
public class SQLConnector {
    /**
     * The constant USERNAME_KEY.
     */
    private static final String USERNAME_KEY = "username";
    /**
     * The constant PASSWORD_KEY.
     */
    private static final String PASSWORD_KEY = "password";
    /**
     * The constant IP_KEY.
     */
    private static final String IP_KEY = "IP";
    /**
     * The constant PORT_KEY.
     */
    private static final String PORT_KEY = "port";
    /**
     * The constant DATABASE_KEY.
     */
    private static final String DATABASE_KEY = "database";
    /**
     * The static attribute to implement the singleton design pattern.
     */
    private static SQLConnector instance = null;


    /**
     * Static method that returns the shared instance managed by the singleton.
     *
     * @return The shared SQLConnector instance.
     */
    public static SQLConnector getInstance(){
        if (instance == null ) {
            String resourceName = "config.json";
            InputStream input = SQLConnector.class.getResourceAsStream(resourceName);
            if (input == null) {
                throw new NullPointerException("Cannot find resource file " + resourceName);
            }

            JSONTokener tokener = new JSONTokener(input);
            JSONObject object = new JSONObject(tokener);
            instance = new SQLConnector(object.getString(USERNAME_KEY), object.getString(PASSWORD_KEY), object.getString(IP_KEY), object.getInt(PORT_KEY), object.getString(DATABASE_KEY));
            instance.connect();
        }
        return instance;
    }

    /**
     * The Username attribute to connect to the database.
     */
    private final String username;
    /**
     * The Password attribute to connect to the database.
     */
    private final String password;
    /**
     * The Url attribute to connect to the database.
     */
    private final String url;
    /**
     * The Conn attribute to connect to the database.
     */
    private Connection conn;

    /**
     * Instantiates a new Sql connector.
     *
     * @param username the username
     * @param password the password
     * @param ip       the ip
     * @param port     the port
     * @param database the database
     */
    private SQLConnector(String username, String password, String ip, int port, String database) {
        this.username = username;
        this.password = password;
        this.url = "jdbc:mysql://" + ip + ":" + port + "/" + database;
    }


    /**
     * Method that starts the inner connection to the database.
     */
    public void connect() {
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch(SQLException e) {
            System.err.println("Couldn't connect to --> " + url + " (" + e.getMessage() + ")");
        }
    }


    /**
     * Method that executes an insertion query to the connected database.
     *
     * @param query String representation of the query to execute.
     */
    public void insertQuery(String query){
        try {
            Statement s = conn.createStatement();
            s.executeUpdate(query);
        } catch (SQLException e) {
            System.err.println(query);
            System.err.println("Problem when inserting --> " + e.getSQLState() + " (" + e.getMessage() + ")");
        }
    }


    /**
     * Method that executes an update query to the connected database.
     *
     * @param query String representation of the query to execute.
     */
    public void updateQuery(String query){
        try {
            Statement s = conn.createStatement();
            s.executeUpdate(query);
        } catch (SQLException e) {
            System.err.println(query);
            System.err.println("Problem when updating --> " + e.getSQLState() + " (" + e.getMessage() + ")");
        }
    }


    /**
     * Method that executes a deletion query to the connected database.
     *
     * @param query String representation of the query to execute.
     */
    public void deleteQuery(String query){
        try {
            Statement s = conn.createStatement();
            s.executeUpdate(query);
        } catch (SQLException e) {
            System.err.println(query);
            System.err.println("Problem when deleting --> " + e.getSQLState() + " (" + e.getMessage() + ")");
        }

    }


    /**
     * Method that executes a selection query to the connected database.
     *
     * @param query String representation of the query to execute.
     * @return The results of the selection.
     */
    public ResultSet selectQuery(String query){
        ResultSet rs = null;
        try {
            Statement s = conn.createStatement();
            rs = s.executeQuery(query);
        } catch (SQLException e) {
            System.err.println(query);
            System.err.println("Problem when selecting data --> " + e.getSQLState() + " (" + e.getMessage() + ")");
        }
        return rs;
    }


    /**
     * Method that closes the inner connection to the database.
     */
    public void disconnect(){
        try {
            conn.close();
        } catch (SQLException e) {
            System.err.println("Problem when closing the connection --> " + e.getSQLState() + " (" + e.getMessage() + ")");
        }
    }
}
