import utils.Log;

import javax.swing.*;

public class Drawable extends JLabel {

    public Drawable(Entity e) {

        setIcon(new ImageIcon(getClass().getResource("res/" + e.getSprite())));

        setSize(Game.spriteSize, Game.spriteSize);

    }

}
