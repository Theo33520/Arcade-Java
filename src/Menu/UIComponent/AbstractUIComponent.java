package Menu.UIComponent;

import java.awt.Color;
import javax.swing.JComponent;

public abstract class AbstractUIComponent implements UIComponent {
    protected String text;
    protected Color backgroundColor;
    protected Color foregroundColor;
    protected int position;
    protected float alignment;

    public AbstractUIComponent(String text, Color backgroundColor, Color foregroundColor, int position, float alignment) {
        this.text = text;
        this.backgroundColor = backgroundColor;
        this.foregroundColor = foregroundColor;
        this.position = position;
        this.alignment = alignment;
    }

    @Override
    public abstract JComponent createComponent();

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public Color getBackgroundColor() {
        return backgroundColor;
    }

    @Override
    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    @Override
    public Color getForegroundColor() {
        return foregroundColor;
    }

    @Override
    public void setForegroundColor(Color foregroundColor) {
        this.foregroundColor = foregroundColor;
    }

    @Override
    public int getPosition() {
        return position;
    }

    @Override
    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public float getAlignment() {
        return alignment;
    }

    @Override
    public void setAlignment(float alignment) {
        this.alignment = alignment;
    }
}
