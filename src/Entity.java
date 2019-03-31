public class Entity {

    static int lastid = 0;

    private String _type;
    private String _sprite;
    private boolean _solid;
    private int _x;
    private int _y;

    Entity(){}

    public Entity(String type, String sprite, boolean solid, int x, int y) {
        _type = type;
        _sprite = sprite;
        _solid = solid;
        _x = x;
        _y = y;

        lastid++;
    }

    public static String getNextId() {
        return String.valueOf(lastid);
    }

    public String getType() {
        return _type;
    }

    public void setType(String type) {
        _type = type;
    }

    public String getSprite() {
        return _sprite;
    }

    public void setSprite(String sprite) {
        _sprite = sprite;
    }

    public boolean isSolid() {
        return _solid;
    }

    public void setSolid(boolean solid) {
        _solid = solid;
    }

    public int getX() {
        return _x;
    }

    public void setX(int x) {
        _x = x;
    }

    public int getY() {
        return _y;
    }

    public void setY(int y) {
        _y = y;
    }
}
