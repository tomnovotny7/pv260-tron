package pv260.snake;

import com.sun.javafx.scene.traversal.Direction;
import pv260.engine.Engine;
import pv260.engine.control.KeyControls;
import pv260.engine.control.MouseControls;
import pv260.engine.control.PlayerKeyController;
import pv260.engine.control.PlayerMouseController;
import pv260.engine.model.Player;
import pv260.snake.model.SnakeModel;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Snake extends Engine {
    private SnakeModel snakeModel;

    public void init() {
        super.init();

        snakeModel = new SnakeModel(screenManager.getHeight(), screenManager.getWidth());

        Player player1 = new Player(Color.GREEN, new Point(40, 40), Direction.RIGHT);
        Player player2 = new Player(Color.RED, new Point(600, 400), Direction.LEFT);
        Player player3 = new Player(Color.BLUE, new Point(300, 200), Direction.LEFT);

        snakeModel.addPlayer(player1, new PlayerKeyController(player1,
                new KeyControls(KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_RIGHT, KeyEvent.VK_LEFT)));
        snakeModel.addPlayer(player2, new PlayerKeyController(player2,
                new KeyControls(KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_D, KeyEvent.VK_A)));
        snakeModel.addPlayer(player3, new PlayerMouseController(player3,
                new MouseControls(MouseEvent.BUTTON1, MouseEvent.BUTTON3)));
    }

    public void tick(){
        snakeModel.movePlayers();

        if (snakeModel.isGameFinished()){
            exit();
        }

        draw(screenManager.getGraphics());
    }

    private void draw(Graphics2D graphics) {
        drawBackground(graphics);

        drawFood(graphics);

        drawPlayers(graphics);
    }

    private void drawBackground(Graphics2D graphics){
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, screenManager.getWidth(), screenManager.getHeight());
    }

    private void drawPlayers(Graphics2D graphics){
        for (Player player : snakeModel.getPlayers()){
            drawPlayer(graphics, player);
        }
    }

    private void drawFood(Graphics2D graphics){
        Point foodPoint = snakeModel.getFoodPoint();

        graphics.setColor(Color.YELLOW);
        graphics.fillRect(foodPoint.x, foodPoint.y, LINE_WIDTH, LINE_WIDTH);
    }

    private void drawPlayer(Graphics2D graphics, Player player){
        graphics.setColor(player.getColor());

        for (Point point : player.getPath()){
            graphics.fillRect(point.x, point.y, LINE_WIDTH, LINE_WIDTH);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        snakeModel.keyPressed(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        snakeModel.mousePressed(e);
    }
}
