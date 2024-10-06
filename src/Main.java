
import Core.Core;
import Core.MODULE;
import Module.IDisplayModule;
import Games.IGAMES;

public class Main {
    public static void main(String[] args) {

        Core<IDisplayModule, IGAMES> core = new Core<>("Arcade", MODULE.JAVA2D);
        core.run();
    }
}
