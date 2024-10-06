package Menu.UIComponent;

import java.awt.Color;
import javax.swing.JComponent;

public abstract class UIComponent {
    protected String text;
    protected Color backgroundColor;
    protected Color foregroundColor;
    protected int position;
    protected float alignment;

    public UIComponent(String text, Color backgroundColor, Color foregroundColor, int position, float alignment) {
        this.text = text;
        this.backgroundColor = backgroundColor;
        this.foregroundColor = foregroundColor;
        this.position = position;
        this.alignment = alignment;
    }

    public abstract JComponent createComponent();
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public Color getForegroundColor() {
        return foregroundColor;
    }

    public void setForegroundColor(Color foregroundColor) {
        this.foregroundColor = foregroundColor;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public float getAlignment() {
        return alignment;
    }

    public void setAlignment(float alignment) {
        this.alignment = alignment;
    }
}
