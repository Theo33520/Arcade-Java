package Core;

public enum MODULE {
    LIBGDX("libgbx"),
    JAVA2D("java2D");

    private final String name;
    MODULE(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
