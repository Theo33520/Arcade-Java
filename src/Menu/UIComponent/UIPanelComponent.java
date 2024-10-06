package Menu.UIComponent;

import java.awt.*;
import javax.swing.*;

public class UIPanelComponent extends AbstractUIComponent {

    public UIPanelComponent(String text, Color backgroundColor, Color foregroundColor, int position, float alignment) {
        super(text, backgroundColor, foregroundColor, position, alignment);
    }

    @Override
    public JPanel createComponent() {
        JPanel panel = new JPanel();
        panel.setBackground(this.backgroundColor);
        panel.setOpaque(true);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        if (this.text != null && !this.text.isEmpty()) {
            JLabel label = new JLabel(this.text);
            label.setForeground(this.foregroundColor);
            label.setHorizontalAlignment(this.position);
            label.setAlignmentX(this.alignment);
            panel.add(label);
        }
        return panel;
    }
}
