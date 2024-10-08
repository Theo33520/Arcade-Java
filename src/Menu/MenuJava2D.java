package Menu;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import Menu.UIComponent.UIComponent;
import Menu.UIComponent.DefaultUIComponentFactory;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.function.Consumer;

import static java.lang.System.exit;

public class MenuJava2D implements IMenu<JFrame, UIComponent, JPanel> {
    private HashMap<Integer, Integer> _windowSizing;
    private ArrayList<String> _gameNames;
    private statusMenu _statusMenu;
    private Game _game;
    private JFrame _window;
    private DefaultUIComponentFactory _factory;
    protected Consumer<updateMenuSelected> _callbackIndex;
    protected Integer _previousNumber;

    private static final int HEIGHT_DEFAULT = 1080;
    private static final int WIDTH_DEFAULT = 1920;
    private static final int VERTICAL_STRUT_HEIGHT = 10;

    public MenuJava2D(int width, int height) {
        this._windowSizing = new HashMap<>();
        this._windowSizing.put(width, height);
        this._gameNames = new ArrayList<>();

        for (Game game : Game.values()) {
            this._gameNames.add(game.name());
        }
        this._gameNames.sort((b, a) -> -1 * a.compareTo(b));
        this._statusMenu = statusMenu.OPEN;
        this._factory = new DefaultUIComponentFactory();
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
    public UIComponent createLabel(String text, Color colorbg, int pos, float alignment) {
        return this._factory.createLabelComponent(text, colorbg, pos, alignment);
    }

    @Override
    public UIComponent createPanel(String text, Color colorbg, int pos, float alignment) {
        return this._factory.createPanelComponent(text, colorbg, pos, alignment);
    }

    public void addComponentsToPanel(JPanel panel, List<JComponent> components) {
        panel.add(Box.createVerticalGlue());
        for (JComponent component : components) {
            panel.add(component);
            panel.add(Box.createVerticalStrut(VERTICAL_STRUT_HEIGHT));
        }
        panel.add(Box.createVerticalGlue());
        this._window.getContentPane().add(panel);
    }

    public ArrayList<JComponent> createComponentList(UIComponent... uiComponents) {
        ArrayList<JComponent> components = new ArrayList<>();
        for (UIComponent component : uiComponents) {
            components.add(component.createComponent());
        }
        return components;
    }

    @Override
    public void setIndexMenuSelected(Consumer<updateMenuSelected> callback) {
        this._callbackIndex = callback;
    }

    @Override
    public JFrame displayWindow() {
        this._window = new JFrame();
        this._window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this._window.setTitle(this.getNameWindow());
        this._window.getContentPane().setBackground(Color.BLACK);

        List<UIComponent> components = new ArrayList<>();

        for (String gameName : this._gameNames) {
            components.add(createLabel(gameName, Color.BLACK, SwingConstants.CENTER, Component.CENTER_ALIGNMENT));
            components.add(createPanel("", Color.DARK_GRAY, SwingConstants.CENTER, Component.CENTER_ALIGNMENT));
        }

        this._window.addKeyListener(new KeyAdapter() {
            int index = 0;
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_ENTER:
                        index = 84;
                        if (_callbackIndex != null) {
                            _callbackIndex.accept(new updateMenuSelected(index));
                        }
                        break;
                    case KeyEvent.VK_UP:
                        index = index - 1;
                        if (_callbackIndex != null) {
                            _callbackIndex.accept(new updateMenuSelected(index));
                        }
                        break;
                    case KeyEvent.VK_DOWN:
                        index = index + 1;
                        if (_callbackIndex != null) {
                            _callbackIndex.accept(new updateMenuSelected(index));
                        }
                        break;
                    default:
                        break;
                }
            }
        });

        setIndexMenuSelected(update -> {
            int selectedIndex = update.index;
            if (selectedIndex == 84) {
                if (this._previousNumber == 0) {
                    System.out.println("The game selected is : Nibbler");
                }
                else if (this._previousNumber == 2) {
                    System.out.println("The game selected is : Snake");
                }
                exit(0);
            }


            if (selectedIndex >= components.size()) {
                selectedIndex = components.size() / 2;
            } else if (selectedIndex < 0) {
                selectedIndex = 0;
            }
            if (selectedIndex % 2 != 0) {
                if (selectedIndex > components.size() / 2) {
                    selectedIndex = components.size() / 2;
                } else {
                    selectedIndex++;
                }
            }
            this._previousNumber = selectedIndex;
            JComponent selectedLabel = components.get(selectedIndex).getComponent();
            for (int i = 0; i < components.size(); i+=2) {
                JComponent comp = components.get(i).getComponent();
                if (i == selectedIndex) {
                    comp.setForeground(Color.YELLOW);
                } else {
                    comp.setForeground(Color.WHITE);
                }
            }
            selectedLabel.revalidate();
            selectedLabel.repaint();
        });
        JPanel panel = getPanel();
        List<JComponent> uiComponents = components.stream()
                .map(UIComponent::createComponent)
                .toList();
        addComponentsToPanel(panel, uiComponents);

        this._window.setSize(getWidth(), getHeight());
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
        System.out.println("Stopping the menu...");
        if (this._window != null) {
            this._window.dispose();
        }
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
