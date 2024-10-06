package Menu.UIComponent;

import java.awt.*;
import javax.swing.*;

public interface UIComponentFactory {
    UIComponent createLabelComponent(String text, Color backgroundColor, Color foregroundColor, int position, float alignment);
    UIComponent createPanelComponent(String text, Color backgroundColor, Color foregroundColor, int position, float alignment);
}