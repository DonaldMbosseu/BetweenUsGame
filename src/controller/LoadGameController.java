package controller;

import model.GameManager;
import model.UserManager;
import model.entity.Game;
import view.Access.MainFrame;
import view.Game.MapPanel;
import view.SetupGame.LoadGamePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class controls the relationship between the logic and the UI.
 * It has the {@link MainFrame}, the {@link UserManager} and the {@link GameManager}.
 * It has other attributes to save the game information and to control the view of the
 * colors, where the user selects a color from an array.
 * @author  Serge Nzodja (gsheshe13@gmail.com)
 * @version 22/5/2021
 */
public class LoadGameController implements ActionListener {
    /**
     * The constant ERROR.
     */
    private static final String ERROR = "Error";
    /**
     * The constant CONFIGURE_ERROR.
     */
    private static final String CONFIGURE_ERROR = "Configure all parameters before starting a new game.";
    /**
     * The constant DUPLICATE_GAME_ERROR.
     */
    private static final String DUPLICATE_GAME_ERROR = "The game name already exists, please change it to continue.";
    /**
     * The constant IMPOSTORS_ERROR.
     */
    private static final String IMPOSTORS_ERROR = "The number of impostors cannot be larger than a third of the total number of characters.";
    /**
     * The View.
     */
    private MainFrame view;
    /**
     * The Game model.
     */
    private GameManager gameModel;
    /**
     * The User model.
     */
    private UserManager userModel;
    /**
     * The Selected colour.
     */
    private int selectedColour;
    /**
     * The Current game.
     */
    private Game currentGame;

    /**
     * Instantiates a new Load game controller.
     *
     * @param view      the view
     * @param gameModel the game model
     * @param userModel the user model
     */
    public LoadGameController (MainFrame view, GameManager gameModel, UserManager userModel) {
        this.view = view;
        this.gameModel = gameModel;
        this.selectedColour = -1;
        this.userModel = userModel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case LoadGamePanel.COMBO_BOX_GAME:
                // Updating the view with the loaded game information
                view.getLoadGamePanel().resetUI();
                selectedColour = view.getLoadGamePanel().getSelectedColour();
                break;
            case LoadGamePanel.BTN_BACK:
                view.updateView(view.getLoadGamePanel(), view.getMenuPanel());
                break;
            case LoadGamePanel.BTN_MAPS:
                view.getLoadGamePanel().openFileChooser();
                break;
            case LoadGamePanel.BTN_SETTINGS:
                view.getSettingsPanel().setPrevious(view.getLoadGamePanel());
                view.updateView(view.getLoadGamePanel(), view.getSettingsPanel());
                break;
            case LoadGamePanel.BTN_START:
                if (startNewGame()) {
                    MapPanel mapPanel = new MapPanel(currentGame, view.getEastGamePanel(), view.getWestGamePanel(), view.getMapPanelSouth(), view, gameModel, userModel.getUsername(), true, userModel);
                    view.setMapPanel(mapPanel);
                    updateMap();
                    view.getMapPanelSouth().setPlayerList(currentGame.getPlayers());
                    view.getWestGamePanel().resumePressed();
                    view.updateView(view.getLoadGamePanel(), mapPanel);
                    view.getMapPanel().startGame();
                }
                break;
            case LoadGamePanel.BTN_COLOR+"0":
                view.changeLoadGameSelectedColour(0, selectedColour);
                selectedColour = 0;
                break;
            case LoadGamePanel.BTN_COLOR+"1":
                view.changeLoadGameSelectedColour(1, selectedColour);
                selectedColour = 1;
                break;
            case LoadGamePanel.BTN_COLOR+"2":
                view.changeLoadGameSelectedColour(2, selectedColour);
                selectedColour = 2;
                break;
            case LoadGamePanel.BTN_COLOR+"3":
                view.changeLoadGameSelectedColour(3, selectedColour);
                selectedColour = 3;
                break;
            case LoadGamePanel.BTN_COLOR+"4":
                view.changeLoadGameSelectedColour(4, selectedColour);
                selectedColour = 4;
                break;
            case LoadGamePanel.BTN_COLOR+"5":
                view.changeLoadGameSelectedColour(5, selectedColour);
                selectedColour = 5;
                break;
            case LoadGamePanel.BTN_COLOR+"6":
                view.changeLoadGameSelectedColour(6, selectedColour);
                selectedColour = 6;
                break;
            case LoadGamePanel.BTN_COLOR+"7":
                view.changeLoadGameSelectedColour(7, selectedColour);
                selectedColour = 7;
                break;
            case LoadGamePanel.BTN_COLOR+"8":
                view.changeLoadGameSelectedColour(8, selectedColour);
                selectedColour = 8;
                break;
            case LoadGamePanel.BTN_COLOR+"9":
                view.changeLoadGameSelectedColour(9, selectedColour);
                selectedColour = 9;
                break;
            case LoadGamePanel.BTN_COLOR+"10":
                view.changeLoadGameSelectedColour(10, selectedColour);
                selectedColour = 10;
                break;
            case LoadGamePanel.BTN_COLOR+"11":
                view.changeLoadGameSelectedColour(11, selectedColour);
                selectedColour = 11;
                break;
        }
    }

    /**
     * Starts a new game if the entered information is valid.
     *
     * @return if the game could start or not.
     */
    private boolean startNewGame() {
        Game game = view.getLoadGamePanel().createNewGame();
        if (game == null) {
            JOptionPane.showMessageDialog(null, CONFIGURE_ERROR, ERROR, JOptionPane.ERROR_MESSAGE);
            return false;
        }
        // check all parameters
        // check that the name is unique
        if (gameModel.nameExists(game.getName())) {
            JOptionPane.showMessageDialog(null, DUPLICATE_GAME_ERROR, ERROR, JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // check the number of characters/impostors
        if (game.getNumImpostors() == 2 && game.getNumCharacters() < 6 || game.getNumImpostors() == 3 && game.getNumCharacters() < 9) {
            JOptionPane.showMessageDialog(null, IMPOSTORS_ERROR, ERROR, JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Add game and players to database
        gameModel.addGame(game, userModel.getUsername());
        for (int i = 0; i < game.getNumCharacters(); i++) {
            gameModel.addPlayer(game.getPlayers().get(i), game.getName(), userModel.getUsername());
        }

        currentGame = game;
        return true;
    }

    /**
     * Updates the map.
     */
    private void updateMap() {
        for (int i = 0; i < currentGame.getPlayers().size(); i++) {
            if (!currentGame.getPlayers().get(i).isUser()) {
                currentGame.getPlayers().get(i).setMap(view.getMapPanel());
            }
        }
    }
}
