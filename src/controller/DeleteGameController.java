package controller;

import model.GameManager;
import model.UserManager;
import view.SetupGame.DeleteGamePanel;
import view.Access.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class controls the relationship between the logic and the UI.
 * It has the {@link MainFrame}, the {@link UserManager} and the {@link GameManager}.
 * @author  Serge Nzodja (gsheshe13@gmail.com)
 * @version 22/5/2021
 */
public class DeleteGameController implements ActionListener {
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
     * Instantiates a new Delete game controller.
     *
     * @param view      the view
     * @param gameModel the game model
     * @param userModel the user model
     */
    public DeleteGameController(MainFrame view, GameManager gameModel, UserManager userModel) {
        this.view = view;
        this.gameModel = gameModel;
        this.userModel = userModel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case DeleteGamePanel.BTN_DELETE_GAME:
                view.updateView(view.getDeleteGamePanel(), view.getMenuPanel());
                deleteGame();
                break;
            case DeleteGamePanel.BTN_BACK_D:
                view.updateView(view.getDeleteGamePanel(), view.getMenuPanel());
                break;
        }
    }

    /**
     * Deletes a game from the database.
     */
    private void deleteGame() {
        gameModel.deleteGame(view.getDeleteGamePanel().getGameName(), userModel.getUsername());
    }
}