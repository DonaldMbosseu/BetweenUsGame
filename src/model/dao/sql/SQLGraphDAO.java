package model.dao.sql;

import model.dao.GraphDAO;
import model.entity.Graph;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that implements the methods described in the {@link GraphDAO} interface.
 *
 * Specifically, it implements the evolution graph data persistence in a SQL database.
 * @author  Serge Nzodja (gsheshe13@gmail.com)
 * @version 22/5/2021
 */
public class SQLGraphDAO implements GraphDAO {
    @Override
    public void addGame(String user, boolean userWon) {
        String query = "INSERT INTO Graph(userName, userWon) VALUES ('" +
                user + "', " + userWon + ");";

        SQLConnector.getInstance().insertQuery(query);
    }

    @Override
    public Graph getGames(String user) {
        Graph graph = new Graph(user);
        String query = "SELECT * FROM Graph WHERE userName = '" + user + "';";
        ResultSet result = SQLConnector.getInstance().selectQuery(query);
        List<Boolean> points = new ArrayList<>();

        try {
            while (result.next()) {
                points.add(result.getBoolean("userWon"));
            }
            graph.setPoints(points);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return graph;
    }
}
