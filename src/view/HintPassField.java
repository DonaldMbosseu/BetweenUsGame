package view;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * The class Hint pass field is a custom class to add
 * a hint to the JPasswordField.
 * @author  Serge Nzodja (gsheshe13@gmail.com)
 * @version 22/5/2021
 */
public class HintPassField extends JPasswordField implements FocusListener {

    /**
     * The Hint.
     */
    private  String hint;
    /**
     * The Showing hint.
     */
    private boolean showingHint;

    /**
     * Sets showing hint.
     *
     * @param showingHint the showing hint
     */
    public void setShowingHint(boolean showingHint) {
        super.setEchoChar((char) 0);
        this.showingHint = showingHint;
    }

    /**
     * Instantiates a new Hint pass field.
     *
     * @param hint the hint
     */
    public HintPassField(final String hint) {
        super(hint);
        super.setEchoChar((char) 0);
        this.hint = hint;
        this.showingHint = true;
        super.addFocusListener(this);
    }

    @Override
    public void focusGained(FocusEvent e) {
        if(this.getPassword() == null) {
            // 0x2022 is • (hex UTF-16)
            super.setEchoChar((char) 0x2022);
            super.setText("");
            showingHint = false;
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if(this.getPassword() == null) {
            super.setEchoChar((char) 0);
            super.setText(hint);
            showingHint = true;
        }
    }

    @Override
    public char[] getPassword() {
        return showingHint ? null : super.getPassword();
    }

    /**
     * Sets hint.
     *
     * @param hint the hint
     */
    public void setHint(String hint) {
        this.hint = hint;
    }
}

