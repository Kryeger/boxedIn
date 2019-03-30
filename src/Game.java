public class Game {

    private Window _window;
    private Config _config;

    Game(Window window, Config config) {
        _window = window;
        _config = config;
    }

    public Window getWindow() {
        return _window;
    }

    public void setWindow(Window window) {
        _window = window;
    }

    public Config getConfig() {
        return _config;
    }

    public void setConfig(Config config) {
        _config = config;
    }

    public void start() {

    }

}
