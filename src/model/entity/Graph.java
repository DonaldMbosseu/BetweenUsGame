package model.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a Graph.
 * A Graph has a user and a list of booleans which represent the wins and losses.
 * It has methods to calculate the heights of the points in the graph.
 * @author  Serge Nzodja (gsheshe13@gmail.com)
 * @version 22/5/2021
 */
public class Graph {
    /**
     * The User.
     */
    private String user;
    /**
     * The Points.
     */
    private List<Boolean> points;

    /**
     * Instantiates a new Graph.
     *
     * @param user the user
     */
    public Graph(String user) {
        this.user = user;
        points = new ArrayList<>();
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * Sets points.
     *
     * @param points the points
     */
    public void setPoints(List<Boolean> points) {
        this.points = points;
    }

    /**
     * Calculate heights for every point.
     *
     * @return the list
     */
    public List<Double> calculateHeights() {
        List<Double> heights = new ArrayList<>();

        for (int i = 0; i < points.size(); i++) {
            double currentPoints = 0;
            for (int j = 0; j <= i; j++) {
                if (points.get(j)) {
                    currentPoints++;
                }
            }
            currentPoints = currentPoints/(i+1);
            heights.add(currentPoints*100);
        }

        return heights;
    }

    /**
     * Gets max height.
     *
     * @param heights the heights
     * @return the max height
     */
    public double getMaxHeight(List<Double> heights) {
        double max = 0;
        for (Double height : heights) {
            if (height > max) {
                max = height;
            }
        }
        return max;
    }

    /**
     * Gets min height.
     *
     * @param heights the heights
     * @return the min height
     */
    public double getMinHeight(List<Double> heights) {
        double min = 1;
        for (Double height : heights) {
            if (height < min) {
                min = height;
            }
        }
        return min;
    }
}
