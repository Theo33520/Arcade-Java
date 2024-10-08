package Menu.UIComponent;

import java.awt.*;
import javax.swing.*;

public class UILabelComponent extends AbstractUIComponent {

    public UILabelComponent(String text, Color backgroundColor, int position, float alignment) {
        super(text, backgroundColor, position, alignment);
    }

    @Override
    public JLabel createComponent() {
        JLabel label = new JLabel(this.text);
        label.setBackground(this.backgroundColor);
        label.setOpaque(true);
        label.setForeground(this.foregroundColor);
        label.setHorizontalAlignment(this.position);
        label.setAlignmentX(this.alignment);
        this.component = label;
        return label;
    }
}
