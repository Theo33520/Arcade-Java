package Menu;
import Menu.UIComponent.UIComponent;

import java.awt.*;
import java.util.ArrayList;

public interface IMenu<Lib, Label, Panel> {

    enum statusMenu {
        OPEN,
        CLOSE,
    }

    enum Game {
        SNAKE,
        NIBBLER
    }
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
    UIComponent createLabel(String text, Color colorbg, Color colorfg, int pos, float alignment);
    UIComponent createPanel(String text, Color colorbg, Color colorfg, int pos, float alignment);

}
