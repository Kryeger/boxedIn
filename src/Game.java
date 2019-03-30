import utils.Log;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Game extends JFrame {

    static public int spriteSize = 32;

    private HashMap<String, JPanel> _views;
    private String _activeView = "";

    private Config _config;
    //later, Level.mapWidth etc.
    private int _mapWidth = 40;
    private int _mapHeight = 22;
    private boolean _loading = false;


    private ArrayList<ArrayList<Entity>> _map;

    Game(Config config) {

        Log.str("Starting BoxedIn\n");

        _config = config;

        _map = new ArrayList<>();

        _loading = true;
        init();
        _loading = false;
    }

    private void init() {

        Log.str("Loading: 0%\n");

        //LOGIC

        //LOGIC//MAP

        for(int i = 0; i < _mapHeight; i++){

            _map.add(new ArrayList<>());

            for (int j = 0; j < _mapWidth; j++) {
                _map.get(i).add(new Entity("Empty", "floor.png", false));
            }

        }

        _views = new HashMap<>();

        //VIEWS

        //VIEWS//PLAY

        JPanel playView = new JPanel();
        playView.setLayout(null);

        //VIEWS//PLAY//BUTTONS

        JButton playBtn = new JButton("Play");

        playBtn.setBounds(10, 10, 100, 50);

        playBtn.addActionListener((e) -> {

            if(!_loading){

                Log.str("Starting a new game...\n");
                changeView("gameView");
                loop();

            } else {
                Log.str("Can't start yet, still loading");
            }

        });

        playView.add(playBtn);

        //VIEWS//PLAY//PUT

        _views.put("playView", playView);

        //VIEWS//GAME

        JPanel gameView = new JPanel();
        gameView.setLayout(null);

        //VIEWS//GAME//MAP

        for(int i = 0; i < _mapHeight; i++){
            for (int j = 0; j < _mapWidth; j++) {
                Drawable drawable = new Drawable(_map.get(i).get(j));
                drawable.setVisible(true);
                drawable.setLocation(j * spriteSize, i * spriteSize);
                gameView.add(drawable);
            }
        }

        //VIEWS//GAME//PUT

        _views.put("gameView", gameView);

        //WINDOW
        this.setTitle("BoxedIn");
        this.setSize(1366, 768);
        this.setResizable(false);
        this.setVisible( true );

        Log.str("Loading: 100%\n");

        changeView("playView");
    }

    private void changeView(String viewName){
        Log.str("Changing view to " + viewName + "\n");

        if(!_activeView.equals("")){
            _views.get(_activeView).setVisible(false);
            this.remove(_views.get(_activeView));
        }

        this.add(_views.get(viewName));
        _views.get(viewName).setVisible(true);
        _activeView = viewName;
    }

    private void loop(){

    }

}
