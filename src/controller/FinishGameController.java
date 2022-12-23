package controller;

import model.GameManager;
import model.UserManager;
import view.Access.MainFrame;
import view.Game.LosePanel;
import view.Game.WinPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class controls the relationship between the logic and the UI.
 * It has the {@link MainFrame}, the {@link UserManager} and the {@link GameManager}.
 * @author  Serge Nzodja (gsheshe13@gmail.com)
 * @version 22/5/2021
 */
public class FinishGameController implements ActionListener {
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
     * Instantiates a new Finish game controller.
     *
     * @param view      the view
     * @param gameModel the game model
     * @param userModel the user model
     */
    public FinishGameController(MainFrame view, GameManager gameModel, UserManager userModel) {
        this.view = view;
        this.gameModel = gameModel;
        this.userModel = userModel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case WinPanel.BTN_QUIT_W:
                saveGame();
                view.updateView(view.getWinPanel(), view.getMenuPanel());
                break;
            case WinPanel.BTN_PLAY_AGAIN_W:
                saveGame();
                view.updateView(view.getWinPanel(), view.getNewGamePanel());
                break;
            case LosePanel.BTN_QUIT_L:
                saveGame();
                view.updateView(view.getLosePanel(), view.getMenuPanel());
                break;
            case LosePanel.BTN_PLAY_AGAIN_L:
                saveGame();
                view.updateView(view.getLosePanel(), view.getNewGamePanel());
                break;
        }
    }

    /**
     * Saves the current state of the game in the database.
     */
    private void saveGame() {
        // save the current state of the game and players
        view.getMapPanel().getGame().setPauseTime(view.getMapPanel().getGameTime());
        gameModel.updateGame(view.getMapPanel().getGame(), userModel.getUsername());
    }
}
