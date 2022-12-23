import controller.*;
import model.GameManager;
import model.UserManager;
import view.Access.MainFrame;
import view.MusicPlayer;

import javax.swing.*;

/**
 * This is the main class where the program starts.
 */
public class Main {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Create the model.
                UserManager userModel = new UserManager();
                GameManager gameModel = new GameManager();

                // Create the main view.
                MainFrame view = new MainFrame();

                // Create the controller, which will receive both the model and
                // the view to set up its unidirectional associations
                AccessController accessController = new AccessController(view, userModel);
                MenuController menuController = new MenuController(view, gameModel, userModel);
                SettingsController settingsController = new SettingsController(view, userModel);
                StartGameController startGameController = new StartGameController(view, gameModel, userModel);
                DeleteGameController deleteGameController = new DeleteGameController(view, gameModel, userModel);
                LoadGameController loadGameController = new LoadGameController(view, gameModel, userModel);
                GameController gameController = new GameController(view, gameModel, userModel);
                PlayerController playerController = new PlayerController(view, gameModel);
                ContinueGameController continueGameController = new ContinueGameController(view, gameModel, userModel);
                FinishGameController finishGameController = new FinishGameController(view, gameModel, userModel);

                // Register the Controller to the View, which has an indirect
                // dependency on it by using the implemented Listener interface.
                // (View ---notifies---> ActionListener)
                view.registerAccessController(accessController);
                view.registerMenuController(menuController);
                view.registerSettingsController(settingsController);
                view.registerStartGameController(startGameController);
                view.registerDeleteGameController(deleteGameController);
                view.registerLoadGameController(loadGameController);
                view.registerGameController(gameController);
                view.registerPlayerController(playerController);
                view.registerContinueGameController(continueGameController);
                view.registerFinishGameController(finishGameController);


                // Make the frame visible after we have configured the view.
                view.setVisible(true);
            }
        });

        // Play background music
        MusicPlayer.playMusic();
    }
}
