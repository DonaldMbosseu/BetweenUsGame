package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * The class Background panel represents the panel which holds the
 * background image and the current panel on top of it. The changePanel
 * method allows to remove the current panel and add a new one. The
 * background image is the same at all times.
 * @author  Serge Nzodja (gsheshe13@gmail.com)
 * @version 22/5/2021
 */
public class BackgroundPanel extends JPanel {
    /**
     * The background image.
     */
    private BufferedImage biImage;
    /**
     * The constant READING_ERROR.
     */
    private static final String READING_ERROR = "Error reading background image";

    /**
     * Instantiates a new Background panel.
     *
     * @param panel the panel
     */
    public BackgroundPanel(JPanel panel) {
        try {
            biImage = ImageIO.read(new File("images/space.jpg"));
            setLayout(new GridBagLayout());
            panel.setPreferredSize(new Dimension(1000, 800));
            add(panel);
        } catch (IOException e) {
            System.out.println(READING_ERROR);
        }
    }

    /**
     * Changes the current panel.
     *
     * @param oldPanel the old panel
     * @param newPanel the new panel
     */
    public void changePanel(JPanel oldPanel, JPanel newPanel) {
        remove(oldPanel);
        revalidate();
        repaint();
        add(newPanel);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(biImage, 0, 0, this);
    }

}