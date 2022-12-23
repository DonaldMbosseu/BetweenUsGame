package controller;

import model.GameManager;
import view.Access.MainFrame;
import view.Game.PlayerPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class controls the relationship between the logic and the UI.
 * It has the {@link MainFrame} and the {@link GameManager}.
 * @author  Serge Nzodja (gsheshe13@gmail.com)
 * @version 22/5/2021
 */
public class PlayerController implements ActionListener {
    /**
     * The View.
     */
    private MainFrame view;
    /**
     * The Game model.
     */
    private GameManager gameModel;

    /**
     * Instantiates a new Player controller.
     *
     * @param view      the view
     * @param gameModel the game model
     */
    public PlayerController(MainFrame view, GameManager gameModel) {
        this.view = view;
        this.gameModel = gameModel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case PlayerPanel.LEFT_LABEL+"0":
                view.getMapPanelSouth().movePlayer(0, PlayerPanel.LEFT_LABEL);
                break;
            case PlayerPanel.RIGHT_LABEL+"0":
                view.getMapPanelSouth().movePlayer(0, PlayerPanel.RIGHT_LABEL);
                break;
            case PlayerPanel.LEFT_LABEL+"1":
                view.getMapPanelSouth().movePlayer(1, PlayerPanel.LEFT_LABEL);
                break;
            case PlayerPanel.RIGHT_LABEL+"1":
                view.getMapPanelSouth().movePlayer(1, PlayerPanel.RIGHT_LABEL);
                break;
            case PlayerPanel.LEFT_LABEL+"2":
                view.getMapPanelSouth().movePlayer(2, PlayerPanel.LEFT_LABEL);
                break;
            case PlayerPanel.RIGHT_LABEL+"2":
                view.getMapPanelSouth().movePlayer(2, PlayerPanel.RIGHT_LABEL);
                break;
            case PlayerPanel.LEFT_LABEL+"3":
                view.getMapPanelSouth().movePlayer(3, PlayerPanel.LEFT_LABEL);
                break;
            case PlayerPanel.RIGHT_LABEL+"3":
                view.getMapPanelSouth().movePlayer(3, PlayerPanel.RIGHT_LABEL);
                break;
            case PlayerPanel.LEFT_LABEL+"4":
                view.getMapPanelSouth().movePlayer(4, PlayerPanel.LEFT_LABEL);
                break;
            case PlayerPanel.RIGHT_LABEL+"4":
                view.getMapPanelSouth().movePlayer(4, PlayerPanel.RIGHT_LABEL);
                break;
            case PlayerPanel.LEFT_LABEL+"5":
                view.getMapPanelSouth().movePlayer(5, PlayerPanel.LEFT_LABEL);
                break;
            case PlayerPanel.RIGHT_LABEL+"5":
                view.getMapPanelSouth().movePlayer(5, PlayerPanel.RIGHT_LABEL);
                break;
            case PlayerPanel.LEFT_LABEL+"6":
                view.getMapPanelSouth().movePlayer(6, PlayerPanel.LEFT_LABEL);
                break;
            case PlayerPanel.RIGHT_LABEL+"6":
                view.getMapPanelSouth().movePlayer(6, PlayerPanel.RIGHT_LABEL);
                break;
            case PlayerPanel.LEFT_LABEL+"7":
                view.getMapPanelSouth().movePlayer(7, PlayerPanel.LEFT_LABEL);
                break;
            case PlayerPanel.RIGHT_LABEL+"7":
                view.getMapPanelSouth().movePlayer(7, PlayerPanel.RIGHT_LABEL);
                break;
            case PlayerPanel.LEFT_LABEL+"8":
                view.getMapPanelSouth().movePlayer(8, PlayerPanel.LEFT_LABEL);
                break;
            case PlayerPanel.RIGHT_LABEL+"8":
                view.getMapPanelSouth().movePlayer(8, PlayerPanel.RIGHT_LABEL);
                break;
        }
    }
}
