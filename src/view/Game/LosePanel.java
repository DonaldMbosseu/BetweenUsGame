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
 * The class Lose panel represents the view when the player loses the game.
 * It has a BufferedImage to store the background image and two JButton
 * to quit and play a new game and a method to register the controller.
 * @author  Serge Nzodja (gsheshe13@gmail.com)
 * @version 22/5/2021
 */
public class LosePanel extends JPanel {
    /**
     * The constant DEFEAT_LABEL.
     */
    public static final String DEFEAT_LABEL = "Defeat";

    /**
     * The constant BTN_QUIT_L.
     */
    public static final String BTN_QUIT_L = "BTN_QUIT_L";
    /**
     * The constant BTN_PLAY_AGAIN_L.
     */
    public static final String BTN_PLAY_AGAIN_L = "BTN_PLAY_AGAIN_L";
    /**
     * The constant READING_ERROR.
     */
    private static final String READING_ERROR = "Error reading image";

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
     * Instantiates a new Lose panel.
     */
    public LosePanel() {
        JPanel jpLose = new JPanel();
        // Setting the layout
        jpLose.setLayout(new BorderLayout(20, 30));
        jpLose.setBorder(new EmptyBorder(10, 10, 10, 10) );
        // To put the Center panel transparent
        jpLose.setOpaque(false);

        // Defeat JLabel
        JLabel jlDefeat = new JLabel(DEFEAT_LABEL);
        // Put the desired font
        jlDefeat.setFont(ViewUtilities.getBetweenUsFont(110));
        jlDefeat.setForeground(Color.red);
        jlDefeat.setHorizontalAlignment(SwingConstants.CENTER);
        jpLose.add(jlDefeat, BorderLayout.NORTH);

        // South panel to add Quit and PlayAgain JButton
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BorderLayout());
        southPanel.setOpaque(false);

        // Quit JButton
        jbQuit = new JButton(new ImageIcon("images/quitButtonR.png"));
        jbQuit.setBorder(BorderFactory.createEmptyBorder());
        jbQuit.setContentAreaFilled(false);
        jbQuit.setActionCommand(BTN_QUIT_L);

        southPanel.add(jbQuit, BorderLayout.WEST);

        // Play Again JButton
        jbPlayAgain = new JButton(new ImageIcon("images/playAgainButton.png"));
        jbPlayAgain.setBorder(BorderFactory.createEmptyBorder());
        jbPlayAgain.setContentAreaFilled(false);
        jbPlayAgain.setActionCommand(BTN_PLAY_AGAIN_L);

        southPanel.add(jbPlayAgain, BorderLayout.EAST);
        jpLose.add(southPanel, BorderLayout.SOUTH);

        int size2 = 300;
        jpLose.add(new Box.Filler(new Dimension(size2 * 3, size2), new Dimension(size2 * 3, size2), new Dimension(size2 * 3, size2)), BorderLayout.CENTER);


        try {
            biImage = ImageIO.read(new File("images/defeatPane.png"));
            setLayout(new GridBagLayout());
            jpLose.setPreferredSize(new Dimension(1000, 800));
            add(jpLose);
        } catch (IOException e) {
            System.out.println(READING_ERROR);
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