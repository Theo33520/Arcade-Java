package Core;

public enum GAMES {
    SNAKE("Snake"),
    NIBBLER("Nibbler");

    private final String _nameGames;
    GAMES(String nameGames) {
        _nameGames = nameGames;
    }

    String getNameGames() {
        return _nameGames;
    }
}
