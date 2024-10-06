package Module;

import javax.swing.*;

public class Java2D implements IDisplayModule<JFrame>{

    private String _nameModule;
    private JFrame _frame;

    @Override
    public JFrame createWindow() {
        this._frame = new JFrame();
        this._frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this._frame.setTitle("Java2D");
        this._frame.setSize(400, 300);
        this._frame.setLocationRelativeTo(null);
        this._frame.setVisible(true);
        return this._frame;
    }

    @Override
    public String getName() {
        return this._nameModule = "Java2D";
    }

    @Override
    public void setName(String name) {
        this._nameModule = "Java2D";
    }

    @Override
    public void init() {}

    @Override
    public void stop() {}
}
