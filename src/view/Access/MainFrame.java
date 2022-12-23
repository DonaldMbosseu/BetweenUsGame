package view.Access;

import model.dao.sql.SQLConnector;
import view.BackgroundPanel;
import view.Game.*;
import view.SetupGame.*;

import javax.swing.*;
import java.awt.event.*;

/**
 * The MainFrame class is the class that is the main top-level container.
 * The top-level container is a JFrame.
 *
 * The MainFrame class contains all the panels that will be shown.
 * he BackgroundPanel is the one that will be always present and all the
 * other views will go on top of that one. The updateView method will change
 * the panel in the BackgroundPanel. All views have getters so that they can
 * be accessed from the controllers.
 * There are methods to register all the controllers for all the JPanels.
 *
 * @author  Serge Nzodja (gsheshe13@gmail.com)
 * @version 22/5/2021
 */
public class MainFrame extends JFrame {
    /**
     * The constant FRAME_TITLE.
     */
    public static final String FRAME_TITLE = "Between Us";

    /**
     * The Access panel.
     */
    private AccessPanel accessPanel;
    /**
     * The Login panel.
     */
    private LoginPanel loginPanel;
    /**
     * The Register panel.
     */
    private RegisterPanel registerPanel;
    /**
     * The Background panel.
     */
    private BackgroundPanel backgroundPanel;
    /**
     * The Menu panel.
     */
    private MenuPanel menuPanel;
    /**
     * The Settings panel.
     */
    private SettingsPanel settingsPanel;
    /**
     * The How to panel.
     */
    private HowToPanel howToPanel;
    /**
     * The Credits panel.
     */
    private CreditsPanel creditsPanel;
    /**
     * The New game panel.
     */
    private NewGamePanel newGamePanel;
    /**
     * The Delete game panel.
     */
    private DeleteGamePanel deleteGamePanel;
    /**
     * The Load game panel.
     */
    private LoadGamePanel loadGamePanel;
    /**
     * The Continue game panel.
     */
    private ContinueGamePanel continueGamePanel;
    /**
     * The East game panel.
     */
    private EastGamePanel eastGamePanel;
    /**
     * The West game panel.
     */
    private WestGamePanel westGamePanel;
    /**
     * The Map panel.
     */
    private MapPanel mapPanel;
    /**
     * The Map panel south.
     */
    private MapPanelSouth mapPanelSouth;
    /**
     * The Lose panel.
     */
    private LosePanel losePanel;
    /**
     * The Win panel.
     */
    private WinPanel winPanel;
    /**
     * The Table frame.
     */
    private TableFrame tableFrame;

    /**
     * Instantiates a new Main frame.
     */
    public MainFrame() {
        accessPanel = new AccessPanel();
        loginPanel = new LoginPanel();
        registerPanel = new RegisterPanel();
        menuPanel = new MenuPanel();
        settingsPanel = new SettingsPanel();
        howToPanel = new HowToPanel();
        creditsPanel = new CreditsPanel();
        newGamePanel = new NewGamePanel();
        deleteGamePanel = new DeleteGamePanel();
        loadGamePanel = new LoadGamePanel();
        eastGamePanel = new EastGamePanel();
        westGamePanel = new WestGamePanel();
        mapPanelSouth = new MapPanelSouth();
        losePanel = new LosePanel();
        winPanel = new WinPanel();
        continueGamePanel = new ContinueGamePanel();

        backgroundPanel = new BackgroundPanel(accessPanel);
        add(backgroundPanel);

        configureFrame();

        // Free the memory and disconnect database when closing the frame
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                dispose();
                SQLConnector.getInstance().disconnect();
            }
        });
    }

    /**
     * Swaps a panel with a different panel and updates the view.
     *
     * @param oldPanel the old panel
     * @param newPanel the new panel
     */
    public void updateView(JPanel oldPanel, JPanel newPanel) {
        backgroundPanel.changePanel(oldPanel, newPanel);
    }

    /**
     * Configures the frame.
     */
    private void configureFrame() {
        setSize(1200,800);

        setTitle(FRAME_TITLE);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    /**
     * Register access controller.
     *
     * @param listener the listener
     */
    public void registerAccessController(ActionListener listener) {
        accessPanel.registerController(listener);
        loginPanel.registerController(listener);
        registerPanel.registerController(listener);
    }

    /**
     * Register menu controller.
     *
     * @param listener the listener
     */
    public void registerMenuController(ActionListener listener) {
        menuPanel.registerController(listener);
        creditsPanel.registerController(listener);
        howToPanel.registerController(listener);
    }

    /**
     * Register settings controller.
     *
     * @param listener the listener
     */
    public void registerSettingsController(ActionListener listener) {
        settingsPanel.registerController(listener);
    }

    /**
     * Register start game controller.
     *
     * @param listener the listener
     */
    public void registerStartGameController(ActionListener listener) {
        newGamePanel.registerController(listener);
    }

    /**
     * Register delete game controller.
     *
     * @param listener the listener
     */
    public void registerDeleteGameController(ActionListener listener) {
        deleteGamePanel.registerController(listener);
    }

    /**
     * Register load game controller.
     *
     * @param listener the listener
     */
    public void registerLoadGameController(ActionListener listener){
        loadGamePanel.registerController(listener);
    }

    /**
     * Register game controller.
     *
     * @param listener the listener
     */
    public void registerGameController(ActionListener listener) {
        eastGamePanel.registerController(listener);
        westGamePanel.registerController(listener);
    }

    /**
     * Register continue game controller.
     *
     * @param listener the listener
     */
    public void registerContinueGameController(ActionListener listener){
        continueGamePanel.registerController(listener);
    }

    /**
     * Register finish game controller.
     *
     * @param listener the listener
     */
    public void registerFinishGameController(ActionListener listener) {
        winPanel.registerController(listener);
        losePanel.registerController(listener);
    }

    /**
     * Register player controller.
     *
     * @param listener the listener
     */
    public void registerPlayerController(ActionListener listener) {
        mapPanelSouth.registerController(listener);
    }

    /**
     * Gets access panel.
     *
     * @return the access panel
     */
    public AccessPanel getAccessPanel() {
        return accessPanel;
    }

    /**
     * Gets login panel.
     *
     * @return the login panel
     */
    public LoginPanel getLoginPanel() {
        return loginPanel;
    }

    /**
     * Gets register panel.
     *
     * @return the register panel
     */
    public RegisterPanel getRegisterPanel() {
        return registerPanel;
    }

    /**
     * Get menu panel menu panel.
     *
     * @return the menu panel
     */
    public MenuPanel getMenuPanel(){
        return menuPanel;
    }

    /**
     * Gets settings panel.
     *
     * @return the settings panel
     */
    public SettingsPanel getSettingsPanel() {
        return settingsPanel;
    }

    /**
     * Gets how to panel.
     *
     * @return the how to panel
     */
    public HowToPanel getHowToPanel() {
        return howToPanel;
    }

    /**
     * Gets credits panel.
     *
     * @return the credits panel
     */
    public CreditsPanel getCreditsPanel() {
        return creditsPanel;
    }

    /**
     * Gets new game panel.
     *
     * @return the new game panel
     */
    public NewGamePanel getNewGamePanel() {
        return newGamePanel;
    }

    /**
     * Gets delete game panel.
     *
     * @return the delete game panel
     */
    public DeleteGamePanel getDeleteGamePanel() {
        return deleteGamePanel;
    }

    /**
     * Gets win panel.
     *
     * @return the win panel
     */
    public WinPanel getWinPanel() {
        return winPanel;
    }

    /**
     * Gets lose panel.
     *
     * @return the lose panel
     */
    public LosePanel getLosePanel() {
        return losePanel;
    }

    /**
     * Gets load game panel.
     *
     * @return the load game panel
     */
    public LoadGamePanel getLoadGamePanel() {
        return loadGamePanel;
    }

    /**
     * Gets east game panel.
     *
     * @return the east game panel
     */
    public EastGamePanel getEastGamePanel() {
        return eastGamePanel;
    }

    /**
     * Gets west game panel.
     *
     * @return the west game panel
     */
    public WestGamePanel getWestGamePanel() {
        return westGamePanel;
    }

    /**
     * Gets map panel south.
     *
     * @return the map panel south
     */
    public MapPanelSouth getMapPanelSouth() {
        return mapPanelSouth;
    }

    /**
     * Gets continue game panel.
     *
     * @return the continue game panel
     */
    public ContinueGamePanel getContinueGamePanel() {
        return continueGamePanel;
    }

    /**
     * Gets map panel.
     *
     * @return the map panel
     */
    public MapPanel getMapPanel() {
        return mapPanel;
    }

    /**
     * Sets map panel.
     *
     * @param mapPanel the map panel
     */
    public void setMapPanel(MapPanel mapPanel) {
        this.mapPanel = mapPanel;
    }

    /**
     * Gets table frame.
     *
     * @return the table frame
     */
    public TableFrame getTableFrame() {
        return tableFrame;
    }

    /**
     * Sets table dialog.
     *
     * @param tableFrame the table frame
     */
    public void setTableDialog(TableFrame tableFrame) {
        this.tableFrame = tableFrame;
    }

    /**
     * Change selected colour.
     *
     * @param index         the index
     * @param previousColor the previous color
     */
    public void changeSelectedColour(int index, int previousColor) {
        newGamePanel.selectedColor(index, previousColor);
    }


    /**
     * Change load game selected colour.
     *
     * @param index         the index
     * @param previousColor the previous color
     */
    public void changeLoadGameSelectedColour(int index, int previousColor) {
        loadGamePanel.selectedColor(index, previousColor);
    }
}