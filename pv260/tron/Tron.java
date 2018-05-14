package pv260.tron;

import com.sun.javafx.scene.traversal.Direction;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

public class Tron extends Core implements KeyListener, MouseListener, MouseMotionListener {
    private int moveAmount = 5;

    private List<Player> players;
    private InputController inputController;

    public void init() {
        super.init();

        players = new ArrayList<>();

        Player player1 = new Player(Color.GREEN, new Point(40, 40), Direction.RIGHT);
        Player player2 = new Player(Color.RED, new Point(600, 400), Direction.LEFT);
        Player player3 = new Player(Color.BLUE, new Point(300, 200), Direction.LEFT);
        players.add(player1);
        players.add(player2);
        players.add(player3);

        inputController = new InputController();
        inputController.addController(new PlayerKeyController(player1,
                new KeyControls(KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_RIGHT, KeyEvent.VK_LEFT)));
        inputController.addController(new PlayerKeyController(player2,
                new KeyControls(KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_D, KeyEvent.VK_A)));
        inputController.addController(new PlayerMouseController(player3,
                new MouseControls(MouseEvent.BUTTON1, MouseEvent.BUTTON3)));



        Window window = screenManager.getFullScreenWindow();
        window.addKeyListener(this);
        window.addMouseListener(this);
        window.addMouseMotionListener(this);
    }

    public void draw(Graphics2D graphics) {
        movePlayers();

        if (isGameFinished()){
            System.exit(0);
        }

        addPlayersPath();

        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, screenManager.getWidth(), screenManager.getHeight());

        drawPlayers(graphics);
    }

    private void drawPlayers(Graphics2D graphics){
        for (Player player : players){
            drawPlayer(graphics, player);
        }
    }

    private void drawPlayer(Graphics2D graphics, Player player){
        graphics.setColor(player.getColor());

        for (Point point : player.getPath()){
            graphics.fillRect(point.x, point.y, 10, 10);
        }
    }

    private boolean isGameFinished(){
        for (Player player1 : players){
            for (Player player2 : players){
                for (Point position : player2.getPath()){
                    if (player1.getCurrentPosition().equals(position)){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private void movePlayers(){
        for (Player player : players){
            movePlayer(player);
        }
    }

    private void movePlayer(Player player){
        Point playerPosition = new Point(player.getCurrentPosition());

        switch (player.getDirection()){
            case UP:
                if (playerPosition.y > 0) {
                    playerPosition.y -= moveAmount;
                } else {
                    playerPosition.y = screenManager.getHeight();
                }
                break;
            case RIGHT:
                if (playerPosition.x < screenManager.getWidth()) {
                    playerPosition.x += moveAmount;
                } else {
                    playerPosition.x = 0;
                }
                break;
            case DOWN:
                if (playerPosition.y < screenManager.getHeight()) {
                    playerPosition.y += moveAmount;
                } else {
                    playerPosition.y = 0;
                }
                break;
            case LEFT:
                if (playerPosition.x > 0) {
                    playerPosition.x -= moveAmount;
                } else {
                    playerPosition.x = screenManager.getWidth();
                }
                break;
        }

        player.setCurrentPosition(playerPosition);
    }

    private void addPlayersPath(){
        for (Player player : players){
            player.getPath().add(player.getCurrentPosition());
        }
    }

    public void keyPressed(KeyEvent e) {
        inputController.handleInput(e.getKeyCode());
    }

    public void keyReleased(KeyEvent e) {

    }

    public void keyTyped(KeyEvent arg0) {

    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent arg0) {
    }

    public void mouseExited(MouseEvent arg0) {
    }

    public void mousePressed(MouseEvent e) {
        inputController.handleInput(e.getButton());
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {

    }

    public void mouseMoved(MouseEvent e) {

    }
}
