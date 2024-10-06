package Menu.UIComponent;

import java.awt.Color;

public class UIComponentFactory {

    public static UILabelComponent createLabelComponent(String text, Color backgroundColor, Color foregroundColor, int position, float alignment) {
        return new UILabelComponent(text, backgroundColor, foregroundColor, position, alignment);
    }

    public static UIPanelComponent createPanelComponent(String text, Color backgroundColor, Color foregroundColor, int position, float alignment) {
        return new UIPanelComponent(text, backgroundColor, foregroundColor, position, alignment);
    }
}

