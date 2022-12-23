package controller;

import model.UserManager;
import view.Access.MainFrame;
import view.SetupGame.SettingsPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class controls the relationship between the logic and the UI.
 * It has the {@link MainFrame} and the {@link UserManager}.
 * It has other attributes to save the game information and to control the view of the
 * colors, where the user selects a color from an array.
 * @author  Serge Nzodja (gsheshe13@gmail.com)
 * @version 22/5/2021
 */
public class SettingsController implements ActionListener {
    /**
     * The View.
     */
    private MainFrame view;
    /**
     * The Model.
     */
    private UserManager model;

    /**
     * Instantiates a new Settings controller.
     *
     * @param view  the view
     * @param model the model
     */
    public SettingsController(MainFrame view, UserManager model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case SettingsPanel.BTN_LOGOUT:
                view.getNewGamePanel().resetUI();
                view.updateView(view.getSettingsPanel(), view.getAccessPanel());
                break;
            case SettingsPanel.BTN_DELETE_ACCOUNT:
                deleteAccount();
                view.getNewGamePanel().resetUI();
                view.updateView(view.getSettingsPanel(), view.getAccessPanel());
                break;
            case SettingsPanel.BTN_BACK_S:
                view.updateView(view.getSettingsPanel(), view.getSettingsPanel().getPrevious());
                if (view.getSettingsPanel().getPrevious() == view.getMapPanel()) {
                    view.getWestGamePanel().resumePressed();
                    view.getMapPanel().resumeGame();
                }
                break;
        }
    }

    /**
     * Deletes a user account from the database.
     */
    private void deleteAccount() {
        if (view.getLoginPanel().getUsernameOrEmail().isEmpty()) {
            model.deleteUser(view.getRegisterPanel().getUsername());
        } else {
            model.deleteUser(view.getLoginPanel().getUsernameOrEmail());
        }
    }
}
