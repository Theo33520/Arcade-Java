package Games;

public class Snake implements IGAMES{

    private String _nameGames;

    @Override
    public String getName() {
        return this._nameGames ="Snake";
    }

    @Override
    public void setName(String name) {
        this._nameGames = name;
    }
}
