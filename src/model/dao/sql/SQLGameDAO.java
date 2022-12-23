package model.dao.sql;

import model.dao.GameDAO;
import model.entity.Game;
import model.entity.Map;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that implements the methods described in the {@link GameDAO} interface.
 *
 * Specifically, it implements the game persistence in a SQL database.
 * @author  Serge Nzodja (gsheshe13@gmail.com)
 * @version 22/5/2021
 */
public class SQLGameDAO implements GameDAO {
    @Override
    public void addGame(Game game, String user) {
        String query = "INSERT INTO Game(name, user, numCharacters, numImpostors, isFinished, pauseTime, userColorIndex, map) VALUES ('" +
                game.getName() + "', '" +
                user + "', '" +
                game.getNumCharacters() + "', '" +
                game.getNumImpostors() + "', " +
                game.isFinished() + ", '" +
                game.getPauseTime() + "', '" +
                game.getPlayerColourIndex() + "', '" +
                game.getMap().getName() + "');";

        SQLConnector.getInstance().insertQuery(query);
    }

    @Override
    public void updateGame(Game game, String user) {
        String query = "UPDATE Game SET isFinished = " + game.isFinished() + ", pauseTime = " + game.getPauseTime() + " WHERE name = '" + game.getName() + "' AND user = '" + user + "';";

        SQLConnector.getInstance().updateQuery(query);
    }

    @Override
    public void deleteGame(String name, String user) {
        String query1 = "DELETE FROM Log WHERE gameName = '" + name + "' AND user = '" + user + "';";
        SQLConnector.getInstance().deleteQuery(query1);
        String query2 = "DELETE FROM Player WHERE gameName = '" + name + "';";
        SQLConnector.getInstance().deleteQuery(query2);
        String query3 = "DELETE FROM Game WHERE name = '" + name + "' AND user = '" + user + "';";
        SQLConnector.getInstance().deleteQuery(query3);
    }

    @Override
    public boolean nameExists(String name) {
        String query = "SELECT name FROM Game WHERE name = '" + name + "';";
        ResultSet result = SQLConnector.getInstance().selectQuery(query);

        try {
            return result.next(); // Checks if there is any row
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Game> getGames(String user) {
        List<Game> games = new ArrayList<>();

        String query = "SELECT * FROM Game WHERE user = '" + user + "';";
        ResultSet result = SQLConnector.getInstance().selectQuery(query);

        try {
            while (result.next()) {
                Game game = new Game(result.getString("name"), result.getInt("numCharacters"), result.getInt("numImpostors"), result.getInt("userColorIndex"), result.getBoolean("isFinished"), result.getInt("pauseTime"), Map.readMap(result.getString("map")), null);
                games.add(game);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return games;
    }
}