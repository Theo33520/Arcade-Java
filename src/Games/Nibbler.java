package Games;

public class Nibbler implements IGAMES{

    private String _namesGames;

    @Override
    public String getName() {
        return _namesGames = "Nibbler";
    }

    @Override
    public void setName(String name) {
        this._namesGames = name;
    }
}
