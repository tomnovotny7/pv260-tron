package pv260.tron.model;

import pv260.engine.control.IPlayerInputController;
import pv260.engine.control.InputController;
import pv260.engine.model.IEngineModel;
import pv260.engine.model.Player;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class TronModel implements IEngineModel {
    private final int MOVE_AMOUNT = 5;

    private int screenHeight;
    private int screenWidth;

    private List<Player> players;
    private InputController inputController;

    public TronModel(int screenHeight, int screenWidth){
        players = new ArrayList<>();
        inputController = new InputController();

        this.screenHeight = screenHeight;
        this.screenWidth = screenWidth;
    }

    public void addPlayer(Player player, IPlayerInputController playerInputController){
        players.add(player);
        inputController.addController(playerInputController);
    }

    public List<Player> getPlayers(){
        return players;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        inputController.handleInput(e.getKeyCode());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        inputController.handleInput(e.getButton());
    }

    public boolean isGameFinished(){
        for (Player player1 : getPlayers()){
            for (Player player2 : getPlayers()){
                if (player1.equals(player2)){
                    if (isCollisionWithSelf(player1)){
                        return true;
                    }
                }
                else {
                    if (isCollisionWithOther(player1, player2)){
                        return true;
                    }
                }

            }
        }

        return false;
    }

    private boolean isCollisionWithSelf(Player player){
        ArrayList<Point> path = new ArrayList<>(player.getPath());
        path.remove(path.size() - 1);

        for (Point position : path){
            if (player.getCurrentPosition().equals(position)){
                return true;
            }
        }
        return false;
    }

    private boolean isCollisionWithOther(Player player, Player other){
        for (Point position : other.getPath()){
            if (player.getCurrentPosition().equals(position)){
                return true;
            }
        }

        return false;
    }

    public void movePlayers(){
        for (Player player : getPlayers()){
            movePlayer(player);
        }

        addPlayersPath();
    }

    private void movePlayer(Player player){
        Point playerPosition = new Point(player.getCurrentPosition());

        switch (player.getDirection()){
            case UP:
                if (playerPosition.y > 0) {
                    playerPosition.y -= MOVE_AMOUNT;
                } else {
                    playerPosition.y = screenHeight;
                }
                break;
            case RIGHT:
                if (playerPosition.x < screenWidth) {
                    playerPosition.x += MOVE_AMOUNT;
                } else {
                    playerPosition.x = 0;
                }
                break;
            case DOWN:
                if (playerPosition.y < screenHeight) {
                    playerPosition.y += MOVE_AMOUNT;
                } else {
                    playerPosition.y = 0;
                }
                break;
            case LEFT:
                if (playerPosition.x > 0) {
                    playerPosition.x -= MOVE_AMOUNT;
                } else {
                    playerPosition.x = screenWidth;
                }
                break;
        }

        player.setCurrentPosition(playerPosition);
    }

    private void addPlayersPath(){
        for (Player player : getPlayers()){
            player.getPath().add(player.getCurrentPosition());
        }
    }
}
