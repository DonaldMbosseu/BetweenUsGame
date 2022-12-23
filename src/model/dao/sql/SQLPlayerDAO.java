package model.dao.sql;

import model.dao.PlayerDAO;
import model.entity.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that implements the methods described in the {@link PlayerDAO} interface.
 *
 * Specifically, it implements the players persistence in a SQL database.
 * @author  Serge Nzodja (gsheshe13@gmail.com)
 * @version 22/5/2021
 */
public class SQLPlayerDAO implements PlayerDAO {
    @Override
    public void addPlayer(Player player, String gameName, String user) {
        // delete the same player if it was already inserted in that game (so that it can be updated)
        String query1 = "DELETE FROM Player WHERE gameName = '" + gameName + "' AND colorIndex = '" + player.getColourIndex() + "' AND user = '" + user + "';";
        SQLConnector.getInstance().deleteQuery(query1);

        String query2 = "INSERT INTO Player(colorIndex, gameName, user, lastRoom, currentRoom, role, isAlive, isUser, isCooldown, isImpostor) VALUES ('" +
                player.getColourIndex() + "', '" +
                gameName + "', '" +
                user + "', '" +
                player.getLastRoom() + "', '" +
                player.getCurrentRoom() + "', '" +
                player.getRole() + "', " +
                player.isAlive() + ", " +
                player.isUser() + ", " +
                player.isCooldown() + ", " +
                player.isImpostor() + ");";

        SQLConnector.getInstance().insertQuery(query2);
    }

    @Override
    public List<Player> getPlayers(String gameName, String user) {
        List<Player> players = new ArrayList<>();

        String query = "SELECT * FROM Player WHERE user = '" + user + "' AND gameName = '" + gameName + "';";
        ResultSet result = SQLConnector.getInstance().selectQuery(query);

        try {
            while (result.next()) {
                Player player;
                if (result.getBoolean("isImpostor")) {
                    player = new Impostor(result.getString("currentRoom"), result.getString("lastRoom"), result.getString("role"), result.getInt("colorIndex"), result.getBoolean("isAlive"), result.getBoolean("isUser"), result.getBoolean("isCooldown"));
                } else {
                    player = new Crewmate(result.getString("currentRoom"), result.getString("lastRoom"), result.getString("role"), result.getInt("colorIndex"), result.getBoolean("isAlive"), result.getBoolean("isUser"), result.getBoolean("isCooldown"));
                }
                players.add(player);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return players;
    }
}