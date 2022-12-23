package view.Game;

import view.ViewUtilities;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * The class Win panel represents the view when the player wins the game.
 * It has a BufferedImage to store the background image and two JButton
 * to quit and play a new game and a method to register the controller.
 * @author  Serge Nzodja (gsheshe13@gmail.com)
 * @version 22/5/2021
 */
public class WinPanel extends JPanel {
    /**
     * The constant VICTORY_LABEL.
     */
    public static final String VICTORY_LABEL = "Victory";

    /**
     * The constant BTN_QUIT_W.
     */
    public static final String BTN_QUIT_W = "BTN_QUIT_W";
    /**
     * The constant BTN_PLAY_AGAIN_W.
     */
    public static final String BTN_PLAY_AGAIN_W = "BTN_PLAY_AGAIN_W";
    private static final String ERROR_READING = "Error reading image";

    /**
     * The Jb quit.
     */
    private JButton jbQuit;
    /**
     * The Jb play again.
     */
    private JButton jbPlayAgain;

    /**
     * The Bi image.
     */
    private BufferedImage biImage;

    /**
     * Instantiates a new Win panel.
     */
    public WinPanel() {
        JPanel jpWin = new JPanel();
        // Setting the layout
        jpWin.setLayout(new BorderLayout(20, 30));
        jpWin.setBorder(new EmptyBorder(10, 10, 10, 10) );
        // To put the Center panel transparent
        jpWin.setOpaque(false);

        // Victory JLabel
        JLabel jlVictory = new JLabel(VICTORY_LABEL);
        // Put the desired font
        jlVictory.setFont(ViewUtilities.getBetweenUsFont(110));
        jlVictory.setForeground(Color.blue);
        // Put the font centered in the middle
        jlVictory.setHorizontalAlignment(SwingConstants.CENTER);
        jpWin.add(jlVictory, BorderLayout.NORTH);

        // South panel to add Quit and PlayAgain JButton
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BorderLayout());
        southPanel.setOpaque(false);

        // Quit JButton
        jbQuit = new JButton(new ImageIcon("images/quitButtonR.png"));
        jbQuit.setBorder(BorderFactory.createEmptyBorder());
        jbQuit.setContentAreaFilled(false);
        jbQuit.setActionCommand(BTN_QUIT_W);

        southPanel.add(jbQuit, BorderLayout.WEST);

        // Play Again JButton
        jbPlayAgain = new JButton(new ImageIcon("images/playAgainButton.png"));
        jbPlayAgain.setBorder(BorderFactory.createEmptyBorder());
        jbPlayAgain.setContentAreaFilled(false);
        jbPlayAgain.setActionCommand(BTN_PLAY_AGAIN_W);

        southPanel.add(jbPlayAgain, BorderLayout.EAST);
        jpWin.add(southPanel, BorderLayout.SOUTH);

        int size2 = 300;
        jpWin.add(new Box.Filler(new Dimension(size2 * 3, size2), new Dimension(size2 * 3, size2), new Dimension(size2 * 3, size2)), BorderLayout.CENTER);


        try {
            biImage = ImageIO.read(new File("images/victoryPane.png"));
            setLayout(new GridBagLayout());
            jpWin.setPreferredSize(new Dimension(1000, 800));
            add(jpWin);
        } catch (IOException e) {
            System.out.println(ERROR_READING);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(biImage, 0, 0, this);
    }

    /**
     * Register controller.
     *
     * @param listener the listener
     */
    public void registerController(ActionListener listener) {
        jbQuit.addActionListener(listener);
        jbPlayAgain.addActionListener(listener);
    }
}