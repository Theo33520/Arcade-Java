package Menu;
import Menu.UIComponent.UIComponent;

import java.awt.*;
import java.util.ArrayList;
import java.util.function.Consumer;

public interface IMenu<Lib, Label, Panel> {

    enum statusMenu {
        OPEN,
        CLOSE,
    }

    enum Game {
        SNAKE("Snake"),
        NIBBLER("Nibller");

        private final String name;
        Game(String name) {
            this.name = name;
        }

        Game getName() {
            return Game.valueOf(name);
        }
    }

    class updateMenuSelected {
        int index;
        updateMenuSelected(int index) {
            this.index = index;
        }
    }

    void setIndexMenuSelected(Consumer<updateMenuSelected> callback);

    statusMenu getStatus();
    void setStatus(statusMenu status);
    Lib displayWindow();
    Game getGame();
    void setGame(Game game);
    void stop();
    ArrayList<String> getGameName();
    void setGameName(ArrayList<String> gameName);
    void addGame(String gameName);
    String getNameWindow();
    Integer getHeight();
    Integer getWidth();
    Panel getPanel();
    UIComponent createLabel(String text, Color colorbg, int pos, float alignment);
    UIComponent createPanel(String text, Color colorbg, int pos, float alignment);

}
