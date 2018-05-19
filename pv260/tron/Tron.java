package pv260.tron;

import com.sun.javafx.scene.traversal.Direction;
import pv260.engine.Engine;
import pv260.engine.control.*;
import pv260.engine.model.Player;
import pv260.tron.model.TronModel;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Tron extends Engine {
    private TronModel tronModel;

    public Tron(TronModel tronModel){
        super(tronModel);

        this.tronModel = tronModel;
    }

    public void init() {
        super.init();

        Player player1 = new Player(Color.GREEN, new Point(40, 40), Direction.RIGHT);
        Player player2 = new Player(Color.RED, new Point(600, 400), Direction.LEFT);
        Player player3 = new Player(Color.BLUE, new Point(300, 200), Direction.LEFT);

        tronModel.addPlayer(player1, new PlayerKeyController(player1,
                new KeyControls(KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_RIGHT, KeyEvent.VK_LEFT)));
        tronModel.addPlayer(player2, new PlayerKeyController(player2,
                new KeyControls(KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_D, KeyEvent.VK_A)));
        tronModel.addPlayer(player3, new PlayerMouseController(player3,
                new MouseControls(MouseEvent.BUTTON1, MouseEvent.BUTTON3)));
    }

    public void tick(){
        movePlayers();

        if (isGameFinished()){
            System.exit(0);
        }

        addPlayersPath();

        draw(screenManager.getGraphics());
    }

    public void draw(Graphics2D graphics) {
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, screenManager.getWidth(), screenManager.getHeight());

        drawPlayers(graphics);
    }

    private void drawPlayers(Graphics2D graphics){
        for (Player player : tronModel.getPlayers()){
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
        for (Player player1 : tronModel.getPlayers()){
            for (Player player2 : tronModel.getPlayers()){
                for (Point position : player2.getPath()){
                    if (player1.getCurrentPosition().equals(position)){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    protected void movePlayers(){
        for (Player player : tronModel.getPlayers()){
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
        for (Player player : tronModel.getPlayers()){
            player.getPath().add(player.getCurrentPosition());
        }
    }
}
