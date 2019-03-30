public class Entity {

    private String _name;
    private String _sprite;
    private boolean _solid;

    public Entity(String name, String sprite, boolean solid) {
        _name = name;
        _sprite = sprite;
        _solid = solid;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
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
}
