package controller;

import model.GameManager;
import model.UserManager;
import model.entity.Game;
import model.entity.Player;
import view.Access.MainFrame;
import view.Game.MapPanel;
import view.SetupGame.ContinueGamePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * This class controls the relationship between the logic and the UI.
 * It has the {@link MainFrame}, the {@link UserManager}, the {@link GameManager} and the {@link Game} model.
 * @author  Serge Nzodja (gsheshe13@gmail.com)
 * @version 22/5/2021
 */
public class ContinueGameController implements ActionListener {
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
     * The Current game.
     */
    private Game currentGame;

    /**
     * Instantiates a new Continue game controller.
     *
     * @param view      the view
     * @param gameModel the game model
     * @param userModel the user model
     */
    public ContinueGameController(MainFrame view, GameManager gameModel, UserManager userModel) {
        this.view = view;
        this.gameModel = gameModel;
        this.userModel = userModel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case ContinueGamePanel.BTN_CONTINUE_GAME:
                currentGame = view.getContinueGamePanel().getSelectedGame();
                List<Player> players = gameModel.getPlayers(currentGame.getName(), userModel.getUsername());
                currentGame.setPlayers(players);

                MapPanel mapPanel = new MapPanel(currentGame, view.getEastGamePanel(), view.getWestGamePanel(), view.getMapPanelSouth(), view, gameModel, userModel.getUsername(), false, userModel);
                view.setMapPanel(mapPanel);
                updateMap();
                view.getMapPanelSouth().setPlayerList(currentGame.getPlayers());
                view.getWestGamePanel().resumePressed();
                view.updateView(view.getContinueGamePanel(), mapPanel);
                view.getMapPanel().startGame();
                break;
            case ContinueGamePanel.BTN_BACK_C:
                view.updateView(view.getContinueGamePanel(), view.getMenuPanel());
                break;
        }
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
