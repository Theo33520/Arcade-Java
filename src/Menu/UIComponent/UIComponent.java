package Menu.UIComponent;

import java.awt.Color;
import javax.swing.JComponent;

public interface UIComponent {
    JComponent createComponent();

    void setBackgroundColor(Color color);
    void setForegroundColor(Color color);
    void setPosition(int position);
    void setAlignment(float alignment);
    void setText(String text);

    Color getBackgroundColor();
    Color getForegroundColor();
    int getPosition();
    float getAlignment();
    String getText();

}
