package view.SetupGame;

import model.entity.*;
import view.ViewUtilities;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * The class New game panel shows the view to create a new game.
 * It is a BorderLayout with several components including JComboBox, JPanel,
 * JButton, JTextField. The view will use the controller to register all user
 * inputs.
 * @author  Serge Nzodja (gsheshe13@gmail.com)
 * @version 22/5/2021
 */
public class NewGamePanel extends JPanel implements StartGame {
    /**
     * The constant BTN_MAPS.
     */
    public static final String BTN_MAPS = "BTN_MAPS";
    /**
     * The constant BTN_START.
     */
    public static final String BTN_START = "BTN_START_NEW";
    /**
     * The constant BTN_COLOR.
     */
    public static final String BTN_COLOR = "BTN_COLOR_";
    /**
     * The constant BTN_SETTINGS.
     */
    public static final String BTN_SETTINGS = "BTN_SETTINGS";
    /**
     * The constant BTN_BACK.
     */
    public static final String BTN_BACK = "BTN_BACK";

    /**
     * The constant GAME_NAME_LABEL.
     */
    public static final String GAME_NAME_LABEL = "GAME NAME:  ";
    /**
     * The constant CHARACTERS_LABEL.
     */
    public static final String CHARACTERS_LABEL = "CHARACTERS: ";
    /**
     * The constant IMPOSTORS_LABEL.
     */
    public static final String IMPOSTORS_LABEL = "IMPOSTORS:  ";
    /**
     * The constant COLOR_LABEL.
     */
    public static final String COLOR_LABEL = "     COLOR:  ";
    /**
     * The constant MAPS_LABEL.
     */
    public static final String MAPS_LABEL = "MAP:  ";
    /**
     * The constant MAPS_LABEL_DEMO.
     */
    public static final String MAPS_LABEL_DEMO = "Click to select a map";
    /**
     * The constant FONT_SIZE.
     */
    public static final int FONT_SIZE = 25;
    /**
     * The constant PALETTE_LENGTH.
     */
    public static final int PALETTE_LENGTH = 12;
    /**
     * The constant UNKNOWN_LABEL.
     */
    private static final String UNKNOWN_LABEL = "Unknown";

    /**
     * The Jtf name.
     */
    private JTextField jtfName;
    /**
     * The Jcb characters.
     */
    private JComboBox<String> jcbCharacters;
    /**
     * The Jcb impostors.
     */
    private JComboBox<String> jcbImpostors;
    /**
     * The Jb colors.
     */
    private JButton[] jbColors;
    /**
     * The Jb map.
     */
    private JButton jbMap;
    /**
     * The Jb start.
     */
    private JButton jbStart;
    /**
     * The Jp colors grid.
     */
    private JPanel jpColorsGrid;
    /**
     * The Jb settings.
     */
    private JButton jbSettings;
    /**
     * The Jb back.
     */
    private JButton jbBack;
    /**
     * The Jl chosen map.
     */
    private JLabel jlChosenMap;
    /**
     * The Selected colour.
     */
    private int selectedColour;

    /**
     * Instantiates a new New game panel.
     */
    public NewGamePanel() {
        // Setting the main panel layout
        setLayout(new BorderLayout(20,20));
        setBorder(new EmptyBorder(20, 20, 20, 20));
        // To put the Center panel transparent
        setOpaque(false);

        // Creating an invisible box to set spaces between buttons
        Dimension minSize = new Dimension(200, 25);
        Dimension prefSize = new Dimension(200, 25);
        Dimension maxSize = new Dimension(Short.MAX_VALUE, 25);

        // Buttons on the center of the panel in a box layout
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setOpaque(false);
        // Game name
        JPanel jpGameName = new JPanel();
        jpGameName.setOpaque(false);
        jpGameName.setLayout(new BoxLayout(jpGameName, BoxLayout.X_AXIS));

        jpGameName.add(new Box.Filler(minSize,prefSize,maxSize));

        JLabel jlGameName = new JLabel();
        jlGameName.setText(GAME_NAME_LABEL);
        jlGameName.setFont(ViewUtilities.getBetweenUsFont(FONT_SIZE));
        jlGameName.setForeground(Color.white);
        jpGameName.add(jlGameName);

        //adding a text field
        jtfName = new JTextField();
        jtfName.setMaximumSize(new Dimension(Integer.MAX_VALUE, jtfName.getMinimumSize().height));
        jpGameName.add(jtfName);
        jpGameName.add(new Box.Filler(minSize,prefSize,maxSize));

        centerPanel.add(jpGameName);

        //Invisible box
        centerPanel.setOpaque(false);
        centerPanel.add(new Box.Filler(minSize,prefSize,maxSize));

        //CHARACTERS
        JPanel jpCharacters = new JPanel();
        jpCharacters.setOpaque(false);
        jpCharacters.setLayout(new BoxLayout(jpCharacters, BoxLayout.X_AXIS));
        jpCharacters.add(new Box.Filler(minSize,prefSize,maxSize));
        JLabel jlCharacters = new JLabel();
        jlCharacters.setText(CHARACTERS_LABEL);
        jlCharacters.setFont(ViewUtilities.getBetweenUsFont(FONT_SIZE));
        jlCharacters.setForeground(Color.white);

        jpCharacters.add(jlCharacters);

        jcbCharacters = new JComboBox<>(new String[] {"4","5","6","7","8","9","10"});
        jcbCharacters.setMaximumSize(new Dimension(Integer.MAX_VALUE, jcbCharacters.getMinimumSize().height));
        jpCharacters.add(jcbCharacters);

        jpCharacters.add(new Box.Filler(minSize,prefSize,maxSize));
        jpCharacters.add(new Box.Filler(minSize,prefSize,maxSize));
        jpCharacters.add(new Box.Filler(minSize,prefSize,maxSize));

        centerPanel.add(jpCharacters);

        //Invisible box
        centerPanel.setOpaque(false);
        centerPanel.add(new Box.Filler(minSize,prefSize,maxSize));

        //IMPOSTORS prt
        JPanel jpImpostors = new JPanel();
        jpImpostors.setOpaque(false);
        jpImpostors.setLayout(new BoxLayout(jpImpostors, BoxLayout.X_AXIS));
        jpImpostors.add(new Box.Filler(minSize,prefSize,maxSize));

        JLabel jlImpostors = new JLabel();
        jlImpostors.setText(IMPOSTORS_LABEL);
        jlImpostors.setFont(ViewUtilities.getBetweenUsFont(FONT_SIZE));
        jlImpostors.setForeground(Color.white);

        jpImpostors.add(jlImpostors);

        jcbImpostors = new JComboBox<>(new String[] {"1","2","3"});
        jcbImpostors.setMaximumSize(new Dimension(Integer.MAX_VALUE, jcbImpostors.getMinimumSize().height));
        jpImpostors.add(jcbImpostors);
        jpImpostors.add(new Box.Filler(minSize,prefSize,maxSize));
        jpImpostors.add(new Box.Filler(minSize,prefSize,maxSize));
        jpImpostors.add(new Box.Filler(minSize,prefSize,maxSize));
        centerPanel.add(jpImpostors);

        //Invisible box
        centerPanel.setOpaque(false);
        centerPanel.add(new Box.Filler(minSize,prefSize,maxSize));

        //COLOR PRT
        selectedColour = -1;
        JPanel jpColor = new JPanel();
        jpColor.setOpaque(false);
        jpColor.setLayout(new BoxLayout(jpColor, BoxLayout.X_AXIS));
        jpImpostors.add(new Box.Filler(minSize,prefSize,maxSize));

        JLabel jlColor = new JLabel();
        jlColor.setText(COLOR_LABEL);
        jlColor.setFont(ViewUtilities.getBetweenUsFont(FONT_SIZE));
        jlColor.setForeground(Color.white);

        jpColor.add(jlColor);

        jpColorsGrid = new JPanel();
        jpColorsGrid.setLayout(new FlowLayout());
        jbColors = new JButton[PALETTE_LENGTH]; // allocate the size of grid
        jpColorsGrid.setBackground(Color.gray);
        jpColorsGrid.setMaximumSize(new Dimension(450, 40));

        for (int i = 0; i < PALETTE_LENGTH; i++) {
            jbColors[i] = new JButton(); // creates new button
            jbColors[i].setPreferredSize(new Dimension(30, 30));
            jbColors[i].setContentAreaFilled(false);
            jbColors[i].setBorder(new LineBorder(ViewUtilities.COLORS[i], 30, true));
            jbColors[i].setActionCommand(BTN_COLOR + i);
            jpColorsGrid.add(jbColors[i]); // adds button to grid
        }

        jpColor.add(jpColorsGrid);

        centerPanel.add(jpColor);

        //Invisible box
        centerPanel.setOpaque(false);
        centerPanel.add(new Box.Filler(minSize,prefSize,maxSize));

        //MAPS
        JPanel jpMaps = new JPanel();
        jpMaps.setOpaque(false);
        jpMaps.setLayout(new FlowLayout(FlowLayout.LEADING));
        jpMaps.add(new Box.Filler(minSize,prefSize,maxSize));

        JLabel jlMaps = new JLabel();
        jlMaps.setText(MAPS_LABEL);
        jlMaps.setFont(ViewUtilities.getBetweenUsFont(FONT_SIZE));
        jlMaps.setForeground(Color.white);
        jpMaps.add(jlMaps);

        jbMap = new JButton(new ImageIcon("images/Map sign.png"));
        jbMap.setBorder(BorderFactory.createEmptyBorder());
        jbMap.setContentAreaFilled(false);
        jbMap.setActionCommand(BTN_MAPS);
        jpMaps.add(jbMap);

        jlChosenMap = new JLabel();
        jlChosenMap.setText(MAPS_LABEL_DEMO);
        jlChosenMap.setFont(ViewUtilities.getBetweenUsFont(FONT_SIZE));
        jlChosenMap.setForeground(Color.white);

        jpMaps.add(jlChosenMap);

        centerPanel.add(jpMaps);

        JPanel jpStart = new JPanel();
        jpStart.setOpaque(false);
        jpStart.setLayout(new FlowLayout());

        jbStart = new JButton(new ImageIcon("images/Start btn.png"));
        jbStart.setBorder(BorderFactory.createEmptyBorder());
        jbStart.setContentAreaFilled(false);
        jbStart.setActionCommand(BTN_START);
        jpStart.add(jbStart);
        centerPanel.add(jpStart);

        add(centerPanel, BorderLayout.CENTER);

        JPanel west = new JPanel();

        west.setPreferredSize(new Dimension(130, 10));
        west.setLayout(new BoxLayout(west, BoxLayout.Y_AXIS));
        west.setOpaque(false);


        // Settings button
        jbSettings = new JButton(new ImageIcon("images/setts.png"));
        jbSettings.setBorder(BorderFactory.createEmptyBorder());
        jbSettings.setContentAreaFilled(false);
        jbSettings.setActionCommand(BTN_SETTINGS);
        west.add(jbSettings);

        // Invisible box
        west.add(new Box.Filler(new Dimension(100, 30),new Dimension(100, 30),new Dimension(100, 30)));

        // Back button
        jbBack = new JButton(new ImageIcon("images/Back btn.png"));
        jbBack.setBorder(BorderFactory.createEmptyBorder());
        jbBack.setContentAreaFilled(false);
        jbBack.setActionCommand(BTN_BACK);
        west.add(jbBack);

        add(west, BorderLayout.WEST);
        // Invisible east panel to align buttons
        JPanel east = new JPanel();
        east.setOpaque(false);
        east.setPreferredSize(new Dimension(200, 10));
        add(east, BorderLayout.EAST);

    }

    /**
     * Register controller.
     *
     * @param listener the listener
     */
    public void registerController(ActionListener listener) {
        jbStart.addActionListener(listener);
        jbMap.addActionListener(listener);
        jbSettings.addActionListener(listener);
        jbBack.addActionListener(listener);
        for (JButton jbColor : jbColors) {
            jbColor.addActionListener(listener);
        }
    }

    @Override
    public void selectedColor(int index, int previousColour) {
        if (previousColour != -1) {
            jbColors[previousColour].setBorder(new LineBorder(ViewUtilities.COLORS[previousColour], 30, true));
        }
        jbColors[index].setBorder(new CompoundBorder(new LineBorder(Color.white, 2), new LineBorder(ViewUtilities.COLORS[index], 30, true)));
        selectedColour = index;
        revalidate();
        repaint();
    }

    @Override
    public void openFileChooser() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir") + "/maps"));
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String mapName = fileChooser.getName(selectedFile);
            jlChosenMap.setText(mapName);
            revalidate();
            repaint();
        }
    }

    @Override
    public void resetUI() {
        jtfName.setText("");
        jcbCharacters.setSelectedItem(jcbCharacters.getItemAt(0));
        jcbImpostors.setSelectedItem(jcbImpostors.getItemAt(0));
        for (int i = 0; i < jbColors.length; i++) {
            jbColors[i].setBorder(new LineBorder(ViewUtilities.COLORS[i], 30, true));
        }
        jlChosenMap.setText(MAPS_LABEL_DEMO);
        revalidate();
        repaint();
    }

    @Override
    public Game createNewGame() {
        if (jlChosenMap.getText().isEmpty() || selectedColour == -1 || jtfName.getText().isEmpty() || jlChosenMap.getText().equals(MAPS_LABEL_DEMO)) {
            return null;
        }
        String name = jtfName.getText();
        int numCharacters = jcbCharacters.getSelectedIndex() + 4;
        int numImpostors = jcbImpostors.getSelectedIndex() + 1;
        int playerColourIndex = selectedColour;
        Map map = Map.readMap(jlChosenMap.getText());
        List<Player> players = new ArrayList<>();
        ArrayList<Room> rooms = map.getRooms();
        String startRoom = "";
        ArrayList<Integer> colourIndices = new ArrayList<>();

        for (int i = 0; i < jbColors.length; i++) {
            if (i != playerColourIndex) {
                colourIndices.add(i);
            }
        }

        // Find the start room
        for (Room room : rooms) {
            if (room.isStartingPoint()) {
                startRoom = room.getName();
                break;
            }
        }

        // Add the user
        Player user = new Crewmate(startRoom,startRoom,UNKNOWN_LABEL,playerColourIndex,true,true,false);
        players.add(user);
        // Add the crewmates
        for (int i = 0; i < numCharacters - numImpostors - 1; i++) {
            int randomIndex = new Random().nextInt(colourIndices.size());
            int color = colourIndices.remove(randomIndex);
            Player player = new Crewmate(startRoom,startRoom,UNKNOWN_LABEL,color,true,false,false);
            players.add(player);
        }

        // Add the impostors
        for (int i = 0; i < numImpostors; i++) {
            int randomIndex = new Random().nextInt(colourIndices.size());
            int color = colourIndices.remove(randomIndex);
            Player player = new Impostor(startRoom,startRoom,UNKNOWN_LABEL,color,true,false,false);
            players.add(player);
        }

        return new Game(name,numCharacters,numImpostors,playerColourIndex,false,0,map,players);
    }
}

