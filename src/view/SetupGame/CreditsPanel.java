package view.SetupGame;

import view.ViewUtilities;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The class Credits panel shows the creators of this project.
 * It only has one button to go back to the main menu.
 * @author  Serge Nzodja (gsheshe13@gmail.com)
 * @version 22/5/2021
 */
public class CreditsPanel extends JPanel {

    /**
     * The constant CREDITS_LABEL.
     */
    private static final String CREDITS_LABEL = "Credits";
    /**
     * The constant TEAM_LABEL.
     */
    private static final String TEAM_LABEL = "Team:";
    /**
     * The constant AUTHOR_1.
     */
    private static final String AUTHOR_1 = "->Programmer & Designer: Óscar Cubeles Ollé";
    /**
     * The constant AUTHOR_2.
     */
    private static final String AUTHOR_2 = "->Programmer & Designer: Guillermo González López";
    /**
     * The constant AUTHOR_3.
     */
    private static final String AUTHOR_3 = "->Programmer & Designer: Riccardo Giaccalone Roca";
    /**
     * The constant AUTHOR_4.
     */
    private static final String AUTHOR_4 = "->Programmer & Designer: Weriwoh Goddy";
    /**
     * The constant AUTHOR_5.
     */
    private static final String AUTHOR_5 = "->Programmer & Designer: Gonzalo Garcia Rodriguez";
    /**
     * The constant TECHNOLOGIES.
     */
    private static final String TECHNOLOGIES = "Technologies used: ";
    /**
     * The constant DESIGN_TECH.
     */
    private static final String DESIGN_TECH = "Designing platform: Figma";
    /**
     * The constant PROGRAMMING_TECH.
     */
    private static final String PROGRAMMING_TECH = "Programming language: Java (Swing), IDE: IntelliJ IDEA";
    /**
     * The constant BACK_BUTTON_LABEL.
     */
    private static final String BACK_BUTTON_LABEL = "Back";


    /**
     * The Jb back.
     */
    private JButton jbBack;
    /**
     * The constant BTN_BACK.
     */
    public static final String BTN_BACK = "BTN_CBCK";

    /**
     * Instantiates a new Credits panel.
     */
    public CreditsPanel(){
        // Setting the main panel layout
        setLayout(new BorderLayout(50, 50));
        setBorder(new EmptyBorder(20, 20, 20, 20));
        // To put the Center panel transparent
        setOpaque(false);

        LineBorder lineBorder = new LineBorder(Color.WHITE,4,true);
        EmptyBorder emptyBorder = new EmptyBorder(10, 10, 10, 10);

        // Creating an invisible box dimensions to set spaces between buttons
        Dimension minSize = new Dimension(5, 5);
        Dimension prefSize = new Dimension(5, 5);
        Dimension maxSize = new Dimension(Short.MAX_VALUE, 5);

        // Second invisible box dimensions for spacings
        Dimension minSize1 = new Dimension(12, 12);
        Dimension prefSize1 = new Dimension(12, 12);
        Dimension maxSize1 = new Dimension(Short.MAX_VALUE, 12);

        // Third invisible box dimensions for spacings
        Dimension minSize2 = new Dimension(5, 12);
        Dimension prefSize2 = new Dimension(5, 12);
        Dimension maxSize2 = new Dimension(Short.MAX_VALUE, 12);

        // Main panel of the view
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        //Settings Jlabel
        JLabel jlSettings = new JLabel();
        jlSettings.setText(CREDITS_LABEL);
        jlSettings.setFont(ViewUtilities.getBetweenUsFont(50));
        jlSettings.setForeground(Color.white);
        jlSettings.setAlignmentX(0.5f);
        centerPanel.add(jlSettings);

        // JSeparator after the title of the panel
        JSeparator jSeparator = new JSeparator();
        jSeparator.setForeground(Color.white);
        centerPanel.add(jSeparator);

        //Invisible box to add spacing
        centerPanel.setOpaque(false);
        centerPanel.add(new Box.Filler(minSize2,prefSize2,maxSize2));

        // Middle panel where the text will be placed
        JPanel textPanel = new JPanel();
        textPanel.setAlignmentX(0.5f);
        textPanel.setLayout(new BoxLayout(textPanel,BoxLayout.Y_AXIS));
        textPanel.setBorder(new CompoundBorder(lineBorder, emptyBorder));
        textPanel.setBackground(Color.black);

        // Text of the text panel


        // Team
        textPanel.add(ViewUtilities.newCustomTextLabel(TEAM_LABEL,25));
        textPanel.add(new Box.Filler(minSize1,prefSize1,maxSize1));
        // Team members
        textPanel.add(ViewUtilities.newCustomTextLabel(AUTHOR_1,18));
        textPanel.add(new Box.Filler(minSize,prefSize,maxSize));
        textPanel.add(ViewUtilities.newCustomTextLabel(AUTHOR_2,18));
        textPanel.add(new Box.Filler(minSize,prefSize,maxSize));
        textPanel.add(ViewUtilities.newCustomTextLabel(AUTHOR_3,18));
        textPanel.add(new Box.Filler(minSize,prefSize,maxSize));
        textPanel.add(ViewUtilities.newCustomTextLabel(AUTHOR_4,18));
        textPanel.add(new Box.Filler(minSize,prefSize,maxSize));
        textPanel.add(ViewUtilities.newCustomTextLabel(AUTHOR_5,18));
        textPanel.add(new Box.Filler(minSize1,prefSize1,maxSize1));

        // Technologies used
        textPanel.add(ViewUtilities.newCustomTextLabel(TECHNOLOGIES,25));
        textPanel.add(new Box.Filler(minSize1,prefSize1,maxSize1));
        // Description
        textPanel.add(ViewUtilities.newCustomTextLabel(DESIGN_TECH,18));
        textPanel.add(new Box.Filler(minSize,prefSize,maxSize));
        textPanel.add(ViewUtilities.newCustomTextLabel(PROGRAMMING_TECH,18));
        textPanel.add(new Box.Filler(minSize,prefSize,maxSize));
        // Adding the text panel
        centerPanel.add(textPanel);

        //Invisible box to add spacing
        centerPanel.setOpaque(false);
        centerPanel.add(new Box.Filler(minSize2,prefSize2,maxSize2));

        // Back button
        jbBack = new JButton();
        jbBack.setForeground(Color.white);
        jbBack.setText(BACK_BUTTON_LABEL);
        jbBack.setAlignmentX(0.5f);
        jbBack.setFont(ViewUtilities.getBetweenUsFont(30));
        jbBack.setBackground(Color.BLACK);
        jbBack.setBorder(new CompoundBorder(lineBorder,emptyBorder));
        jbBack.setActionCommand(BTN_BACK);
        centerPanel.add(jbBack);

        // adding the center panel to the main panel
        add(centerPanel);


    }

    /**
     * Register controller.
     *
     * @param listener the listener
     */
    public void registerController(ActionListener listener) {
        jbBack.addActionListener(listener);
    }
}
