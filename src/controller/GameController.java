package controller;

import model.GameManager;
import model.UserManager;
import model.entity.Player;
import view.Access.MainFrame;
import view.Game.EastGamePanel;
import view.Game.TableFrame;
import view.Game.WestGamePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * This class controls the relationship between the logic and the UI.
 * It has the {@link MainFrame}, the {@link UserManager} and the {@link GameManager}.
 * It has other attributes to control the game state.
 * @author  Serge Nzodja (gsheshe13@gmail.com)
 * @version 22/5/2021
 */
public class GameController implements ActionListener {
    /**
     * The constant WAIT_TIME.
     */
    private static final int WAIT_TIME = 60;

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
     * The Time to wait for a user to be able to press the check button.
     */
    private double timeToWait;
    /**
     * The Check button pressed.
     */
    private boolean checkButtonPressed;
    /**
     * The Players hidden boolean, to know if the user should see or not the players.
     */
    private boolean playersHidden;

    /**
     * Instantiates a new Game controller.
     *
     * @param view      the view
     * @param gameModel the game model
     * @param userModel the user model
     */
    public GameController(MainFrame view, GameManager gameModel, UserManager userModel) {
        this.view = view;
        this.gameModel = gameModel;
        this.userModel = userModel;
        checkButtonPressed = false;
        playersHidden = false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case EastGamePanel.BTN_ARROW_UP:
                if (!view.getWestGamePanel().isGameStopped()) {
                    view.getMapPanel().moveUser("UP");
                    playersHidden = true;
                    if (view.getMapPanel().isShowCheck()) {
                        view.getEastGamePanel().showCheckButton();
                    } else if (view.getMapPanel().isShowSearch()) {
                        view.getEastGamePanel().showSearchButton();
                    } else {
                        view.getEastGamePanel().removeButtons();
                    }
                }
                break;
            case EastGamePanel.BTN_ARROW_DOWN:
                if (!view.getWestGamePanel().isGameStopped()) {
                    view.getMapPanel().moveUser("DOWN");
                    playersHidden = true;
                    if (view.getMapPanel().isShowCheck()) {
                        view.getEastGamePanel().showCheckButton();
                    } else if (view.getMapPanel().isShowSearch()) {
                        view.getEastGamePanel().showSearchButton();
                    } else {
                        view.getEastGamePanel().removeButtons();
                    }
                }
                break;
            case EastGamePanel.BTN_ARROW_LEFT:
                if (!view.getWestGamePanel().isGameStopped()) {
                    view.getMapPanel().moveUser("LEFT");
                    playersHidden = true;
                    if (view.getMapPanel().isShowCheck()) {
                        view.getEastGamePanel().showCheckButton();
                    } else if (view.getMapPanel().isShowSearch()) {
                        view.getEastGamePanel().showSearchButton();
                    } else {
                        view.getEastGamePanel().removeButtons();
                    }
                }
                break;
            case EastGamePanel.BTN_ARROW_RIGHT:
                if (!view.getWestGamePanel().isGameStopped()) {
                    view.getMapPanel().moveUser("RIGHT");
                    playersHidden = true;
                    if (view.getMapPanel().isShowCheck()) {
                        view.getEastGamePanel().showCheckButton();
                    } else if (view.getMapPanel().isShowSearch()) {
                        view.getEastGamePanel().showSearchButton();
                    } else {
                        view.getEastGamePanel().removeButtons();
                    }
                }
                break;
            case EastGamePanel.BTN_SEARCH:
                TableFrame tableFrame = new TableFrame(gameModel, view.getMapPanel().getGame().getName(), userModel.getUsername(), view.getMapPanelSouth().getPlayerList(), view);
                view.setTableDialog(tableFrame);
                break;
            case EastGamePanel.BTN_VIEW:
                if (playersHidden) {
                    view.getMapPanel().showPlayers();
                    playersHidden = false;
                } else {
                    view.getMapPanel().hidePlayers();
                    playersHidden = true;
                }
                break;
            case EastGamePanel.BTN_CHECK:
                if (checkButtonPressed) {
                    updateTime();
                }
                if (!checkButtonPressed) {
                    timeToWait = System.currentTimeMillis();
                    checkButtonPressed = true;
                    checkUserInput();
                }
                break;
            case WestGamePanel.BTN_SETTINGS:
                if (!view.getMapPanel().isGamePaused()) {
                    view.getMapPanel().pauseGame();
                }
                view.getSettingsPanel().setPrevious(view.getMapPanel());
                view.updateView(view.getMapPanel(), view.getSettingsPanel());
                break;
            case WestGamePanel.BTN_RESUME:
                view.getWestGamePanel().resumePressed();
                view.getMapPanel().resumeGame();
                break;
            case WestGamePanel.BTN_STOP:
                view.getWestGamePanel().pausePressed();
                view.getMapPanel().pauseGame();
                break;
            case WestGamePanel.BTN_QUIT:
                // close all threads of the players
                for (int i = 0; i < view.getMapPanel().getGame().getPlayers().size(); i++) {
                    if (!view.getMapPanel().getGame().getPlayers().get(i).isUser()) {
                        view.getMapPanel().getGame().getPlayers().get(i).close();
                    }
                }
                // save the current state of the game and players
                view.getMapPanel().getGame().setPauseTime(view.getMapPanel().getGameTime());
                gameModel.updateGame(view.getMapPanel().getGame(), userModel.getUsername());
                for (int i = 0; i < view.getMapPanel().getGame().getNumCharacters(); i++) {
                    // it will add the player if it doesn't exist or update if it exists
                    gameModel.addPlayer(view.getMapPanel().getGame().getPlayers().get(i), view.getMapPanel().getGame().getName(), userModel.getUsername());
                }
                view.updateView(view.getMapPanel(), view.getMenuPanel());
                break;
        }
    }

    /**
     * Checks if the user's guess of who is impostor and crewmate is correct or not.
     */
    private void checkUserInput() {
        List<Player> userGuess = view.getMapPanelSouth().getPlayerList();
        List<Player> gamePlayers = new ArrayList<>(view.getMapPanel().getGame().getPlayers());
        // remove the user from game players
        for (int i = 0; i < gamePlayers.size(); i++) {
            if (gamePlayers.get(i).isUser()) {
                gamePlayers.remove(i);
                break;
            }
        }

        for (int i = 0; i < gamePlayers.size(); i++) {
            if (!gamePlayers.get(i).getType().equals(userGuess.get(i).getRole())) {
                return;
            }
        }

        view.getMapPanel().gameFinished(true);
    }

    /**
     * Updates the time to wait for the user to be able to press the check button.
     */
    private void updateTime() {
        if ((System.currentTimeMillis() - timeToWait) / 1000 >= WAIT_TIME) {
            checkButtonPressed = false;
        }
    }
}
