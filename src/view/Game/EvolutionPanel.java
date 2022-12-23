package view.Game;

import model.entity.Graph;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The class Evolution panel shows a graphical representation of the wins and losses of a user.
 * It has a graph which has all the information and methods to draw the graph.
 * The paintComponent override is used to draw the evolution panel on screen using the
 * Graphics2D class of java.awt library.
 * @author  Serge Nzodja (gsheshe13@gmail.com)
 * @version 22/5/2021
 */
public class EvolutionPanel extends JPanel {
    /**
     * The constant PADDING.
     */
    private static final int PADDING = 25;
    /**
     * The Graph.
     */
    private Graph graph;

    /**
     * Instantiates a new Evolution panel.
     *
     * @param g the g
     */
    public EvolutionPanel(Graph g) {
        graph = g;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        List<Double> scores = graph.calculateHeights();
        List<Point> pointsGraph = new ArrayList<>();

        double maxScore = graph.getMaxHeight(scores);
        double minScore = graph.getMinHeight(scores);
        double scaleX = (double) (getWidth() - 3*PADDING) / (scores.size() - 1);
        double scaleY;
        if (maxScore > 0) {
            scaleY = (getHeight() - 3*PADDING) / (maxScore - minScore);
        } else {
            scaleY = (getHeight() - 3*PADDING);
        }

        for (int i = 0; i < scores.size(); i++) {
            int x = (int) (i*scaleX + 2*PADDING);
            int y;
            if (maxScore > 0) {
                y = (int) ((maxScore - scores.get(i)) * scaleY + PADDING);
            } else {
                y = (int) scaleY;
            }
            pointsGraph.add(new Point(x, y));
        }

        // white background
        g2.setColor(Color.white);
        g2.fillRect(0, 0, getWidth(), getHeight());

        // grid lines for heights in y axis
        if (scores.size() > 1 && maxScore > 0) {
            int numDivisions = (int) maxScore/10;
            for (int i = 0; i < numDivisions+1; i++) {
                int y = getHeight() - ((i * (getHeight() - 3*PADDING)) / numDivisions + 2*PADDING);
                g2.setColor(Color.gray);
                g2.drawLine(2*PADDING, y, getWidth()-PADDING, y);
                g2.setColor(Color.black);
                String yString = i*10 + "%";
                FontMetrics metrics = g2.getFontMetrics();
                int stringWidth = metrics.stringWidth(yString);
                g2.drawString(yString, 2*PADDING - stringWidth - 5, y + (metrics.getHeight() / 2) - 3);
            }
        }

        for (int i = 0; i < scores.size(); i++) {
            if (scores.size() > 1) {
                int x = i * (int) scaleX + 2*PADDING;
                int y = getHeight() - PADDING*2;
                g2.setColor(Color.BLACK);
                String xString = i+1 + "";
                FontMetrics metrics = g2.getFontMetrics();
                int labelWidth = metrics.stringWidth(xString);
                g2.drawString(xString, x - labelWidth / 2, y + metrics.getHeight() + 3);
            }
        }

        if (scores.size() > 1) {
            g2.setColor(Color.blue);
            g2.setStroke(new BasicStroke(2f));
            for (int i = 0; i < pointsGraph.size() - 1; i++) {
                int x1 = pointsGraph.get(i).x;
                int y1 = pointsGraph.get(i).y;
                int x2 = pointsGraph.get(i + 1).x;
                int y2 = pointsGraph.get(i + 1).y;
                g2.drawLine(x1, y1, x2, y2);
            }
        }
    }
}
