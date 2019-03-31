import utils.Log;

import javax.swing.*;

public class Drawable extends JLabel {

    public Drawable(Entity entity) {

        setIcon(new ImageIcon(getClass().getResource("res/" + entity.getSprite())));

        setSize(Game.spriteSize, Game.spriteSize);

    }

}
