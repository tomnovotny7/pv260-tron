package pv260.snake;

import com.sun.javafx.scene.traversal.Direction;
import pv260.engine.Engine;
import pv260.engine.control.KeyControls;
import pv260.engine.control.MouseControls;
import pv260.engine.control.PlayerKeyController;
import pv260.engine.control.PlayerMouseController;
import pv260.engine.model.Player;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Snake /*extends Engine*/ {
    /*private int score = 0;

    public void init() {
        super.init();

        Player player1 = new Player(Color.GREEN, new Point(40, 40), Direction.RIGHT);

        addPlayer(player1, new PlayerKeyController(player1,
                new KeyControls(KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_RIGHT, KeyEvent.VK_LEFT)));
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
        for (Player player : getPlayers()){
            drawPlayer(graphics, player);
        }
    }

    private void drawPlayer(Graphics2D graphics, Player player){
        graphics.setColor(player.getColor());

        for (Point point : player.getPath()){
            graphics.fillRect(point.x, point.y, LINE_WIDTH, LINE_WIDTH);
        }
    }

    protected boolean isGameFinished(){
        for (Player player1 : getPlayers()){
            for (Point position : player1.getPath()){
                if (player1.getCurrentPosition().equals(position)){
                    return true;
                }
            }
        }

        return false;
    }

    protected void movePlayers(){
        for (Player player : getPlayers()){
            movePlayer(player);
        }
    }

    private void movePlayer(Player player){
        Point playerPosition = new Point(player.getCurrentPosition());

        switch (player.getDirection()){
            case UP:
                if (playerPosition.y > 0) {
                    playerPosition.y -= MOVE_AMOUNT;
                } else {
                    playerPosition.y = screenManager.getHeight();
                }
                break;
            case RIGHT:
                if (playerPosition.x < screenManager.getWidth()) {
                    playerPosition.x += MOVE_AMOUNT;
                } else {
                    playerPosition.x = 0;
                }
                break;
            case DOWN:
                if (playerPosition.y < screenManager.getHeight()) {
                    playerPosition.y += MOVE_AMOUNT;
                } else {
                    playerPosition.y = 0;
                }
                break;
            case LEFT:
                if (playerPosition.x > 0) {
                    playerPosition.x -= MOVE_AMOUNT;
                } else {
                    playerPosition.x = screenManager.getWidth();
                }
                break;
        }

        player.setCurrentPosition(playerPosition);
    }

    private void addPlayersPath(){
        for (Player player : getPlayers()){
            player.getPath().add(player.getCurrentPosition());
        }
    }*/
}
