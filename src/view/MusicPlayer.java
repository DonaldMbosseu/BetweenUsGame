package view;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


/**
 * The class Music player is used to play background music.
 * @author  Serge Nzodja (gsheshe13@gmail.com)
 * @version 22/5/2021
 */
public class MusicPlayer {
    /**
     * The constant ERROR_PLAY.
     */
    private static final String ERROR_PLAY = "System was unable to play the music";
    /**
     * The constant ERROR_FIND.
     */
    private static final String ERROR_FIND = "System could not find the music theme";

    /**
     * Play music.
     */
    public static void playMusic() {
        try {
            File file = new File("Music/BetweenUsSong.mp3");

            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

            try {
                AdvancedPlayer player = new AdvancedPlayer(bufferedInputStream);
                player.play();

            } catch(JavaLayerException e){
                System.err.println(ERROR_PLAY);
                e.printStackTrace();
            }
        } catch(FileNotFoundException e) {
            System.err.println(ERROR_FIND);
            e.printStackTrace();
        }
    }
}
