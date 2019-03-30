public class Config {

    private int _lives;
    private int _difficulty;

    Config(int lives, int difficulty){
        _lives = lives;
        _difficulty = difficulty;
    }

    public int getDifficulty() {
        return _difficulty;
    }

    public void setDifficulty(int difficulty) {
        _difficulty = difficulty;
    }

    public int getLives() {
        return _lives;
    }

    public void setLives(int lives) {
        _lives = lives;
    }

}
