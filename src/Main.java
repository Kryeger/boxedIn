public class Main {

    public static void main(String[] args) {

        Config config = new Config(3, 1);
        Window window = new Window();

        Game G = new Game(window, config);
        G.start();

    }
}
