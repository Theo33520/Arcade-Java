package Menu;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.awt.event.*;

public class MenuJava2D implements IMenu<JFrame, JLabel, JPanel> {
    private HashMap<Integer, Integer> _windowSizing;
    private ArrayList<String> _gameNames;
    private statusMenu _statusMenu;
    private Game _game;
    private JFrame _window;

    private static final int HEIGHT_DEFAULT = 1080;
    private static final int WIDTH_DEFAULT = 1920;
    private static final int VERTICAL_STRUT_HEIGHT = 10;

    public MenuJava2D(int width, int height) {
        this._windowSizing = new HashMap<>();
        this._windowSizing.put(width, height);
        this._gameNames = new ArrayList<>();
        this._gameNames.add("Snake");
        this._gameNames.add("Nibbler");
    }

    @Override
    public statusMenu getStatus() {
        return this._statusMenu;
    }

    @Override
    public void setStatus(statusMenu statusMenu) {
        this._statusMenu = statusMenu;
    }

    @Override
    public JPanel getPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.BLACK);
        return panel;
    }

    @Override
    public JLabel createLabel(String text, Color colorbg, Color colorfg, int pos, float alignment) {
        JLabel label = new JLabel(text);
        label.setBackground(colorbg);
        label.setOpaque(true);
        label.setForeground(colorfg);
        label.setHorizontalAlignment(pos);
        label.setAlignmentX(alignment);
        return label;
    }

    public void addComponentsToPanel(JPanel panel, ArrayList<JComponent> components) {
        panel.add(Box.createVerticalGlue());

        for (JComponent component : components) {
            panel.add(component);
            panel.add(Box.createVerticalStrut(VERTICAL_STRUT_HEIGHT));
        }
        panel.add(Box.createVerticalGlue());
        this._window.getContentPane().add(panel);
    }


    public ArrayList<JComponent> createComponentList(JLabel... labels) {
        ArrayList<JComponent> components = new ArrayList<>();
        for (JLabel label : labels) {
            components.add(label);
        }
        return components;
    }

    @Override
    public JFrame displayWindow() {
        this._window = new JFrame();
        this._window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this._window.setTitle(this.getNameWindow());
        this._window.getContentPane().setBackground(Color.BLACK);

        JPanel panel = getPanel();

        JLabel snake = createLabel("Snake", Color.BLACK, Color.WHITE, SwingConstants.CENTER, Component.CENTER_ALIGNMENT);
        JLabel nibbler = createLabel("Nibbler", Color.BLACK, Color.WHITE, SwingConstants.CENTER, Component.CENTER_ALIGNMENT);
        ArrayList<JComponent> components = createComponentList(snake, nibbler);
        this.addComponentsToPanel(panel, components);
        this._window.setSize(this.getWidth(), this.getHeight());
        this._window.setLocationRelativeTo(null);
        this._window.setVisible(true);
        return this._window;
    }


    @Override
    public Game getGame() {
        return this._game;
    }

    @Override
    public void setGame(Game game) {
        this._game = game;
    }

    @Override
    public void stop() {
        System.out.println("stop");
    }

    @Override
    public ArrayList<String> getGameName() {
        return _gameNames;
    }

    @Override
    public void setGameName(ArrayList<String> gameNames) {
        this._gameNames = gameNames;
    }

    @Override
    public void addGame(String gameName) {
        if (!_gameNames.contains(gameName)) {
            this._gameNames.add(gameName);
        } else {
            System.out.println("Game already exists: " + gameName);
        }
    }

    @Override
    public String getNameWindow() {
        return "Main Menu";
    }

    @Override
    public Integer getWidth() {
        return this._windowSizing.isEmpty() ? WIDTH_DEFAULT : this._windowSizing.keySet().iterator().next();
    }

    @Override
    public Integer getHeight() {
        return this._windowSizing.isEmpty() ? HEIGHT_DEFAULT : this._windowSizing.get(this.getWidth());
    }
}
