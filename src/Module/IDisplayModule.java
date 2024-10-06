package Module;


public interface IDisplayModule<T> {
    void init();
    void stop();
    String getName();
    void setName(String name);
    T createWindow();
}
