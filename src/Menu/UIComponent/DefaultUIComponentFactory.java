package Menu.UIComponent;

import java.awt.Color;

public class DefaultUIComponentFactory implements UIComponentFactory {

    @Override
    public UIComponent createLabelComponent(String text, Color backgroundColor, Color foregroundColor, int position, float alignment) {
        return new UILabelComponent(text, backgroundColor, foregroundColor, position, alignment);
    }

    @Override
    public UIComponent createPanelComponent(String text, Color backgroundColor, Color foregroundColor, int position, float alignment) {
        return new UIPanelComponent(text, backgroundColor, foregroundColor, position, alignment);
    }
}
