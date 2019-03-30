import utils.Log;

import javax.swing.*;

public class Game extends JFrame {

    private JButton playBtn = new JButton("Play");

    private Config _config;

    Game(Config config) {
        _config = config;

        init();
    }

    private void init() {
        //WINDOW
        this.setTitle("BoxedIn");
        this.setSize(1280, 720);
        this.setVisible( true );
        this.setLayout(null);
        this.setResizable(false);

        //BUTTONS
        playBtn.setBounds(10, 10, 100, 50);

        playBtn.addActionListener((e) -> {

            start();

        });

        this.add(playBtn);
    }

    private void start(){

    }

}
