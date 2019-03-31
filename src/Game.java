import utils.Log;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
    private int _startX = 1;
    private int _startY = 1;

    private boolean _loading = false;

    private ArrayList<ArrayList<ArrayList<String>>> _map;

    private HashMap<String, Entity> _entities;

    private Player _player = new Player("Kryeger", 3, _startX, _startY);
    private String _playerId = "0";

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

        //INIT

        _views = new HashMap<>();
        _entities = new HashMap<>();
        _entities.put(_playerId, _player);

        //LOGIC

        //LOGIC//MAP

        for (int i = 0; i < _mapHeight; i++) {

            _map.add(new ArrayList<>());

            for (int j = 0; j < _mapWidth; j++) {
                _map.get(i).add(new ArrayList<>());

                String nextId = Entity.getNextId();
                _entities.put(Entity.getNextId(), new Entity("floor", "floor.png", false, i, j));

                _map.get(i).get(j).add(nextId);

            }

        }

        //VIEWS

        //VIEWS//PLAY

        JPanel playView = new JPanel();
        playView.setLayout(null);

        //VIEWS//PLAY//BUTTONS

        JButton playBtn = new JButton("Play");

        playBtn.setBounds(10, 10, 100, 50);

        playBtn.addActionListener((e) -> {

            if (!_loading) {

                Log.str("Starting a new game...\n");
                changeView("gameView");
                loop();

            } else {
                Log.str("Can't start yet, still loading.\n");
            }

        });

        playView.add(playBtn);

        //VIEWS//PLAY//PUT

        _views.put("playView", playView);

        //VIEWS//GAME

        //VIEWS//GAME//MOVEMENT

        JPanel gameView = new JPanel();
        gameView.setLayout(null);
        gameView.addKeyListener(new KeyMovement());

        gameView.setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16));
        gameView.setFocusable(true);
        gameView.requestFocus();
        gameView.requestFocusInWindow();
        gameView.getInputMap().put(KeyStroke.getKeyStroke("VK_W"), "up");
        gameView.getActionMap().put("up", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Log.str("asd");
            }
        });

        //VIEWS//GAME//MAP

        updateMap(gameView);

        //VIEWS//GAME//PUT

        _views.put("gameView", gameView);

        //WINDOW
        this.setTitle("BoxedIn");
        this.setSize(1366, 768);
        this.setResizable(false);
        this.setVisible(true);

        //PLAYER

        placeEntity(_playerId, _startX, _startY);

        Log.str("Loading: 100%\n");

        changeView("playView");
    }

    private void changeView(String viewName) {
        Log.str("Changing view to " + viewName + "\n");

        if (!_activeView.equals("")) {
            _views.get(_activeView).setVisible(false);
            this.remove(_views.get(_activeView));
        }

        this.add(_views.get(viewName));
        _views.get(viewName).setVisible(true);
        _activeView = viewName;
    }

    private void loop() {
        //while (_player.isAlive()) {
            updateMap(_views.get("gameView"));
        //}
    }

    private void updateMap(JPanel view) {

        view.removeAll();

        for (int i = 0; i < _mapHeight; i++) {
            for (int j = 0; j < _mapWidth; j++) {

                //for now, it will only display the entity that is on top
                int lastValidIndex = _map.get(i).get(j).size() - 1;
                //Log.str(String.valueOf(lastValidIndex) + " " + i + " " + j + "\n");
                Drawable drawable = new Drawable(_entities.get(_map.get(i).get(j).get(lastValidIndex)));
                drawable.setVisible(true);
                drawable.setLocation(j * spriteSize, i * spriteSize);
                view.add(drawable);
            }
        }
    }

    private boolean canMove(int x, int y){
        for(int i = 0; i < _map.get(x).get(y).size(); i++){
            if(_entities.get(_map.get(x).get(y).get(i)).isSolid()){
                return false;
            }
        }

        return true;
    }

    private boolean placeEntity(String entityId, int x, int y) {
        if(canMove(x, y)){
            _map.get(x).get(y).add(entityId);
            return true;
        }

        return false;
    }

    private boolean moveEntity(String entityId, int x, int y){
        int index = _map.get(x).get(y).indexOf(entityId);

        if(index == -1){
            return false;
        }

        _map.get(x).get(y).remove(index);

        return placeEntity(entityId, x, y);

    }

    class KeyMovement implements KeyListener {
        public void keyTyped(KeyEvent e) {

        }

        public void keyPressed(KeyEvent e) {
            Log.str("asd");
            if(e.getKeyCode() == KeyEvent.VK_W){
                placeEntity("0", _player.getX() - 1, _player.getY());
            }
            if(e.getKeyCode() == KeyEvent.VK_A){
                placeEntity("0", _player.getX(), _player.getY() - 1);
            }
            if(e.getKeyCode() == KeyEvent.VK_S){
                placeEntity("0", _player.getX() + 1, _player.getY());
            }
            if(e.getKeyCode() == KeyEvent.VK_D){
                placeEntity("0", _player.getX(), _player.getY() + 1);
            }
        }

        public void keyReleased(KeyEvent e) {

        }

    }

}
