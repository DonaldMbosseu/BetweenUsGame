package view;

import javax.swing.plaf.basic.BasicTextFieldUI;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * The class Hint text field ui is used to add a hint to a
 * JTextField.
 * @author  Serge Nzodja (gsheshe13@gmail.com)
 * @version 22/5/2021
 */
public class HintTextFieldUI extends BasicTextFieldUI implements FocusListener {

    /**
     * The Hint.
     */
    private String hint;
    /**
     * The Hide on focus.
     */
    private boolean hideOnFocus;
    /**
     * The Color.
     */
    private Color color;

    /**
     * Gets color.
     *
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * Sets color.
     *
     * @param color the color
     */
    public void setColor(Color color) {
        this.color = color;
        repaint();
    }

    /**
     * Repaint.
     */
    private void repaint() {
        if(getComponent() != null) {
            getComponent().repaint();
        }
    }

    /**
     * Is hide on focus boolean.
     *
     * @return the boolean
     */
    public boolean isHideOnFocus() {
        return hideOnFocus;
    }

    /**
     * Sets hide on focus.
     *
     * @param hideOnFocus the hide on focus
     */
    public void setHideOnFocus(boolean hideOnFocus) {
        this.hideOnFocus = hideOnFocus;
        repaint();
    }

    /**
     * Gets hint.
     *
     * @return the hint
     */
    public String getHint() {
        return hint;
    }

    /**
     * Sets hint.
     *
     * @param hint the hint
     */
    public void setHint(String hint) {
        this.hint = hint;
        repaint();
    }

    /**
     * Instantiates a new Hint text field ui.
     *
     * @param hint the hint
     */
    public HintTextFieldUI(String hint) {
        this(hint,false);
    }

    /**
     * Instantiates a new Hint text field ui.
     *
     * @param hint        the hint
     * @param hideOnFocus the hide on focus
     */
    public HintTextFieldUI(String hint, boolean hideOnFocus) {
        this(hint,hideOnFocus, null);
    }

    /**
     * Instantiates a new Hint text field ui.
     *
     * @param hint        the hint
     * @param hideOnFocus the hide on focus
     * @param color       the color
     */
    public HintTextFieldUI(String hint, boolean hideOnFocus, Color color) {
        this.hint = hint;
        this.hideOnFocus = hideOnFocus;
        this.color = color;
    }

    @Override
    protected void paintSafely(Graphics g) {
        super.paintSafely(g);
        JTextComponent comp = getComponent();
        if(hint!=null && comp.getText().length() == 0 && (!(hideOnFocus && comp.hasFocus()))){
            if(color != null) {
                g.setColor(color);
            } else {
                g.setColor(comp.getForeground().brighter().brighter().brighter());
            }
            int padding = (comp.getHeight() - comp.getFont().getSize())/2;
            g.drawString(hint, 2, comp.getHeight()-padding-1);
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        if(hideOnFocus) repaint();

    }

    @Override
    public void focusLost(FocusEvent e) {
        if(hideOnFocus) repaint();
    }
    @Override
    protected void installListeners() {
        super.installListeners();
        getComponent().addFocusListener(this);
    }
    @Override
    protected void uninstallListeners() {
        super.uninstallListeners();
        getComponent().removeFocusListener(this);
    }
}