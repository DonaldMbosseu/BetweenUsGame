package view.Game;

import model.GameManager;
import model.entity.Log;
import model.entity.Player;
import view.Access.MainFrame;
import view.ViewUtilities;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

/**
 * The class Table frame is a JFrame used to show the JTable of the players from
 * the log system room. It is a JFrame because the view is separated from the game,
 * since it is a big table that would cover the rest of the game is it appeared on the
 * same window. As attributes it needs a JTable, the game manager to load the information
 * from the database, a JScrollPane so that all the data fits in the view, the main view so
 * that it can update the map panel in real time with any changes of the players. This changes
 * happen when the user clicks a certain row. The other attributes are used to render the
 * JTable.
 * @author  Serge Nzodja (gsheshe13@gmail.com)
 * @version 22/5/2021
 */
public class TableFrame extends JFrame {
    /**
     * The constant YELLOW.
     */
    private static final String YELLOW = "yellow";
    /**
     * The constant WHITE.
     */
    private static final String WHITE = "white";
    /**
     * The constant CYAN.
     */
    private static final String CYAN = "cyan";
    /**
     * The constant LIME.
     */
    private static final String LIME = "lime";
    /**
     * The constant GREEN.
     */
    private static final String GREEN = "green";
    /**
     * The constant ORANGE.
     */
    private static final String ORANGE = "orange";
    /**
     * The JTable.
     */
    private JTable jTable;
    /**
     * The Game manager.
     */
    private GameManager gameManager;
    /**
     * The Game name.
     */
    private String gameName;
    /**
     * The User.
     */
    private String user;
    /**
     * The Scroll pane.
     */
    private JScrollPane scrollPane;
    /**
     * The Players.
     */
    private List<Player> players;
    /**
     * The Selection listener.
     */
    private ListSelectionListener selectionListener;
    /**
     * The Table cell renderer.
     */
    private DefaultTableCellRenderer tableCellRenderer;
    /**
     * The White columns render.
     */
    private DefaultTableCellRenderer whiteColumnsRender;
    /**
     * The Main view.
     */
    private MainFrame mainView;

    /**
     * Instantiates a new Table frame.
     *
     * @param manager    the manager
     * @param game       the game
     * @param username   the username
     * @param playerList the player list
     * @param mainFrame  the main frame
     */
    public TableFrame(GameManager manager, String game, String username, List<Player> playerList, MainFrame mainFrame) {
        mainView = mainFrame;
        players = playerList;
        gameName = game;
        user = username;
        gameManager = manager;
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // get data
        jTable = getJTable();
        updateTableData();
        getTableCellRender();
        jTable.setDefaultRenderer(Object.class, tableCellRenderer);
        getColumnCellRender();
        jTable.getColumn("ROOM").setCellRenderer(whiteColumnsRender);
        jTable.getColumn("INSTANT").setCellRenderer(whiteColumnsRender);


        scrollPane = new JScrollPane(jTable);
        add(scrollPane, BorderLayout.CENTER);

        pack();
        setVisible(true);
    }

    /**
     * Gets JTable.
     *
     * @return the new JTable
     */
    private JTable getJTable() {
        String[] colName = {"CREWMATE", "ROOM", "INSTANT"};
        if (jTable == null) {
            jTable = new JTable() {
                public boolean isCellEditable(int nRow, int nCol) {
                    return false;
                }
            };
        }
        DefaultTableModel contactTableModel = (DefaultTableModel) jTable.getModel();
        contactTableModel.setColumnIdentifiers(colName);
        jTable.getTableHeader().setBackground(Color.black);
        jTable.getTableHeader().setForeground(Color.white);
        jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        getSelectionListener();
        jTable.getSelectionModel().addListSelectionListener(selectionListener);
        return jTable;
    }

    /**
     * Updates table data.
     */
    public void updateTableData() {
        DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
        Log log = gameManager.getLog(gameName, user);

        for (int i = 0; i < log.getColorIndex().size(); i++) {
            String[] data = new String[4];

            data[0] = ViewUtilities.ColorStrings[log.getColorIndex().get(i)] + " (" + findRole(log.getColorIndex().get(i)) + ")";
            data[1] = log.getRoom().get(i);
            data[2] = log.getTime().get(i).toString();

            tableModel.addRow(data);
        }
        jTable.setModel(tableModel);
    }

    /**
     * Refreshes the view.
     */
    public void refreshView() {
        jTable.getSelectionModel().removeListSelectionListener(selectionListener);
        DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
        tableModel.setRowCount(0);
        jTable = getJTable();
        updateTableData();
        getTableCellRender();
        jTable.setDefaultRenderer(Object.class, tableCellRenderer);
        jTable.getColumn("ROOM").setCellRenderer(whiteColumnsRender);
        jTable.getColumn("INSTANT").setCellRenderer(whiteColumnsRender);
    }

    /**
     * Gets selection listener.
     */
    private void getSelectionListener() {
        selectionListener = new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // do some actions here, for example
                // print first column value from selected row
                if (!e.getValueIsAdjusting()) {
                    String data = jTable.getValueAt(jTable.getSelectedRow(), 0).toString();
                    int endIndex = data.indexOf(" ");
                    String colorName = data.substring(0, endIndex);
                    int colorIndex = Arrays.asList(ViewUtilities.ColorStrings).indexOf(colorName);
                    // update the value on the main frame
                    updateMainPanel(colorIndex);
                }
            }
        };
    }

    /**
     * Gets table cell render.
     */
    private void getTableCellRender() {
        tableCellRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);

                String data = (String) table.getModel().getValueAt(row, 0);
                int endIndex = data.indexOf(" ");
                String colorName = data.substring(0, endIndex);
                int colorIndex = Arrays.asList(ViewUtilities.ColorStrings).indexOf(colorName);

                setText(value.toString());
                setBackground(ViewUtilities.COLORS[colorIndex]);
                if (!ViewUtilities.ColorStrings[colorIndex].equals(YELLOW) &&
                        !ViewUtilities.ColorStrings[colorIndex].equals(WHITE) &&
                        !ViewUtilities.ColorStrings[colorIndex].equals(CYAN) &&
                        !ViewUtilities.ColorStrings[colorIndex].equals(LIME) &&
                        !ViewUtilities.ColorStrings[colorIndex].equals(GREEN) &&
                        !ViewUtilities.ColorStrings[colorIndex].equals(ORANGE)) {
                    setForeground(Color.white);
                } else {
                    setForeground(Color.black);
                }
                return this;
            }
        };
    }

    /**
     * Gets column cell render.
     */
    private void getColumnCellRender() {
        whiteColumnsRender = new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table,
                                                           Object value,
                                                           boolean isSelected,
                                                           boolean hasFocus,
                                                           int row,
                                                           int column) {
                setText(value.toString());
                setBackground(Color.white);
                setForeground(Color.black);
                return this;
            }
        };
    }

    /**
     * Update main panel.
     *
     * @param colorIndex the color index
     */
    private void updateMainPanel(int colorIndex) {
        // find the player index
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getColourIndex() == colorIndex) {
                mainView.getMapPanelSouth().movePlayer(i, PlayerPanel.RIGHT_LABEL);
                break;
            }
        }
        players = mainView.getMapPanelSouth().getPlayerList();
        refreshView();
    }


    /**
     * Find role string.
     *
     * @param colorIndex the color index
     * @return the string
     */
    private String findRole(int colorIndex) {
        for (Player player : players) {
            if (player.getColourIndex() == colorIndex) {
                return player.getRole();
            }
        }
        return "";
    }

    /**
     * Sets players.
     *
     * @param players the players
     */
    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}

