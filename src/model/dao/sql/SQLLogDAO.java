package model.dao.sql;

import model.dao.LogDAO;
import model.entity.Log;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that implements the methods described in the {@link LogDAO} interface.
 *
 * Specifically, it implements the log persistence in a SQL database.
 * @author  Serge Nzodja (gsheshe13@gmail.com)
 * @version 22/5/2021
 */
public class SQLLogDAO implements LogDAO {
    @Override
    public void addLog(int colorIndex, int time, String gameName, String user, String room) {
        String query = "INSERT INTO Log(colorIndex, time, gameName, user, room) VALUES (" +
                colorIndex + ", " +
                time + ", '" +
                gameName + "', '" +
                user + "', '" +
                room + "');";

        SQLConnector.getInstance().insertQuery(query);
    }

    @Override
    public Log getLog(String game, String username) {
        Log log = null;
        List<Integer> colorIndex = new ArrayList<>();
        List<Integer> time = new ArrayList<>();
        List<String> gameName = new ArrayList<>();
        List<String> user = new ArrayList<>();
        List<String> room = new ArrayList<>();

        String query = "SELECT * FROM Log WHERE user = '" + username + "' AND gameName = '" + game + "' ORDER BY time;";
        ResultSet result = SQLConnector.getInstance().selectQuery(query);

        try {
            while (result.next()) {
                colorIndex.add(result.getInt("colorIndex"));
                time.add(result.getInt("time"));
                gameName.add(result.getString("gameName"));
                user.add(result.getString("user"));
                room.add(result.getString("room"));
            }
            log = new Log(colorIndex, time, gameName, user, room);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return log;
    }
}