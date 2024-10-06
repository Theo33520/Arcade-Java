package Menu.UIComponent;

import javax.swing.*;
import java.awt.*;

public class UILabelComponent extends UIComponent {

    public UILabelComponent(String text, Color backgroundColor, Color foregroundColor, int position, float alignment) {
        super(text, backgroundColor, foregroundColor, position, alignment);
    }

    @Override
    public JLabel createComponent() {
        JLabel label = new JLabel(this.text);
        label.setBackground(this.backgroundColor);
        label.setOpaque(true);
        label.setForeground(this.foregroundColor);
        label.setHorizontalAlignment(this.position);
        label.setAlignmentX(this.alignment);
        return label;
    }
}
