package controller;

import model.GameManager;
import model.UserManager;
import model.entity.Graph;
import view.Access.MainFrame;
import view.Game.EvolutionPanel;
import view.SetupGame.CreditsPanel;
import view.SetupGame.HowToPanel;
import view.SetupGame.MenuPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class controls the relationship between the logic and the UI.
 * It has the {@link MainFrame}, the {@link UserManager} and the {@link GameManager}.
 * @author  Serge Nzodja (gsheshe13@gmail.com)
 * @version 22/5/2021
 */
public class MenuController implements ActionListener {
    /**
     * The constant EVOLUTION_TITLE.
     */
    private static final String EVOLUTION_TITLE = "Player Evolution";
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
     * Instantiates a new Menu controller.
     *
     * @param view      the view
     * @param gameModel the game model
     * @param userModel the user model
     */
    public MenuController(MainFrame view, GameManager gameModel, UserManager userModel) {
        this.view = view;
        this.gameModel = gameModel;
        this.userModel = userModel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case MenuPanel.BTN_START_NEW_GAME:
                view.updateView(view.getMenuPanel(), view.getNewGamePanel());
                break;
            case MenuPanel.BTN_LOAD_GAME:
                view.getLoadGamePanel().setGames(gameModel.getGames(userModel.getUsername()));
                view.updateView(view.getMenuPanel(), view.getLoadGamePanel());
                break;
            case MenuPanel.BTN_CONTINUE_GAME:
                view.getContinueGamePanel().setGames(gameModel.getGames(userModel.getUsername()));
                view.updateView(view.getMenuPanel(), view.getContinueGamePanel());
                break;
            case MenuPanel.BTN_DELETE_GAME:
                view.getDeleteGamePanel().setGames(gameModel.getGames(userModel.getUsername()));
                view.updateView(view.getMenuPanel(), view.getDeleteGamePanel());
                break;
            case MenuPanel.BTN_EVOLUTION:
                showEvolutionPanel();
                break;
            case MenuPanel.BTN_HOWTO:
                view.updateView(view.getMenuPanel(),view.getHowToPanel());
                break;
            case MenuPanel.BTN_CREDITS:
                view.updateView( view.getMenuPanel(),view.getCreditsPanel());
                break;
            case MenuPanel.BTN_SETTINGS:
                view.getSettingsPanel().setPrevious(view.getMenuPanel());
                view.updateView(view.getMenuPanel(), view.getSettingsPanel());
                break;
            case HowToPanel.BTN_BACK:
                view.updateView(view.getHowToPanel(),view.getMenuPanel());
                break;
            case CreditsPanel.BTN_BACK:
                view.updateView(view.getCreditsPanel(), view.getMenuPanel());
                break;
        }
    }

    /**
     * Shows the evolution panel in a new frame.
     */
    private void showEvolutionPanel() {
        Graph graph = userModel.getGames(userModel.getUsername());
        EvolutionPanel evolutionPanel = new EvolutionPanel(graph);
        evolutionPanel.setPreferredSize(new Dimension(1000, 600));
        JFrame frame = new JFrame(EVOLUTION_TITLE);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(evolutionPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}