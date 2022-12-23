package view.SetupGame;

import model.UserManager;
import model.entity.Game;

/**
 * The interface Start game is used in the {@link NewGamePanel} and
 * in the {@link LoadGamePanel}. The purpose is to define a set of methods
 * that a panel should have to start a game. These methods are implemented
 * in both views.
 */
public interface StartGame {
    /**
     * Selected color.
     *
     * @param index          the index
     * @param previousColour the previous colour
     */
    void selectedColor(int index, int previousColour);

    /**
     * Open file chooser.
     */
    void openFileChooser();

    /**
     * Reset ui.
     */
    void resetUI();

    /**
     * Create new game game.
     *
     * @return the game
     */
    Game createNewGame();
}
