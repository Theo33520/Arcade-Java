package Core;

import Module.IDisplayModule;
import Module.Java2D;
import Games.IGAMES;
import Games.Snake;
import Games.Nibbler;
import Menu.IMenu;
import Menu.MenuJava2D;

public class Core<D extends IDisplayModule, G extends IGAMES> {

    private String _title;
    private MODULE _module;
    private GAMES _game;
    private D _displayModuleInstance;
    private G _gameModule;
    private IMenu _menu;

    public Core(String titleGames, MODULE module) {
        this._title = titleGames;
        this._module = module;
        this._game = GAMES.SNAKE;
    }

    public MODULE getModule() {
        return this._module;
    }

    public GAMES getGame() {
        return this._game;
    }

    public void setGame(GAMES game) {
        this._game = game;
    }

    public void setModule(MODULE module) {
        this._module = module;
    }

    public String libChosen() {
        if (this.getModule() != null && this.getModule() == MODULE.JAVA2D) {
            return MODULE.JAVA2D.getName();
        }
        return MODULE.LIBGDX.getName();
    }

    public D getDisplayModuleInstance() {
        if (this.libChosen().equals(MODULE.JAVA2D.getName())) {
            return (D) new Java2D();
        }
        return null;
    }

    public IMenu getInstanceMenu() {
        if (this._menu == null) {
            this._menu = new MenuJava2D(1920, 1080);
        }
        return this._menu;
    }

    public G getGamesInstance() {
        if (this.getGame() != null && this.getGame() == GAMES.SNAKE) {
            return (G) new Snake();
        } else if (this.getGame() != null && this.getGame() == GAMES.NIBBLER) {
            return (G) new Nibbler();
        }
        return null;
    }

    public void run() {
        D displayModuleInstance = this.getDisplayModuleInstance();
        G displayGamesInstance = this.getGamesInstance();
        IMenu instanceMenu = this.getInstanceMenu();

        if (instanceMenu != null) {
            instanceMenu.displayWindow();
        }
    }
}
