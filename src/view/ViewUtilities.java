package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * The class View utilities stores some constants which are commonly
 * used in several views. These constants are static so that they are accessible
 * without the need of creating a new class.
 * @author  Serge Nzodja (gsheshe13@gmail.com)
 * @version 22/5/2021
 */
public class ViewUtilities {
    /**
     * The constant blue.
     */
    public static Color blue = new Color(41,54,117);

    /**
     * The constant COLORS.
     */
    public static final Color[] COLORS = {Color.red, Color.blue, Color.green, Color.pink, Color.orange, Color.yellow, Color.black, Color.white,
            new Color(109, 22, 219), new Color(81,59,2), new Color(92,251,232), new Color(187,242,97)};

    /**
     * The constant ColorStrings.
     */
    public static final String[] ColorStrings = {"red", "blue", "green", "pink", "orange", "yellow", "black", "white", "purple", "brown", "cyan", "lime"};

    /**
     * Gets between us font.
     *
     * @param size the size
     * @return the between us font
     */
    public static Font getBetweenUsFont(float size) {
        try {
            //create the font to use. Specify the size!
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("font/VCR_OSD_MONO_1.001.ttf")).deriveFont(size);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            //register the font
            ge.registerFont(customFont);
            return customFont;
        } catch (IOException | FontFormatException e) {
            System.out.println("Custom font replaces with default font.");
        }

        return new Font("OCR A Extended", Font.BOLD, (int)size);
    }

    /**
     * New custom text label j label.
     *
     * @param text     the text
     * @param textSize the text size
     * @return the j label
     */
    public static JLabel newCustomTextLabel(String text, float textSize){
        JLabel jLabel = new JLabel();
        jLabel.setOpaque(false);
        jLabel.setForeground(Color.white);
        jLabel.setFont(ViewUtilities.getBetweenUsFont(textSize));
        jLabel.setBorder(new EmptyBorder(0,0,0,0));
        jLabel.setText(text);
        return jLabel;
    }
}
