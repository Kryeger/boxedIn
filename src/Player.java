public class Player extends Entity {

    private String _name;
    private int _lives;

    public Player(String name, int lives, int x, int y) {
        super("player", "player.png", true, x, y);
        _name = name;
        _lives = lives;
    }

    public boolean isAlive() {
        return (_lives != 0);
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public int getLives() {
        return _lives;
    }

    public void setLives(int lives) {
        _lives = lives;
    }

}
