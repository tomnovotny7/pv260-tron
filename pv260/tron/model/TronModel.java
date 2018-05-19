package pv260.tron.model;

import pv260.engine.control.IPlayerInputController;
import pv260.engine.control.InputController;
import pv260.engine.model.IEngineModel;
import pv260.engine.model.Player;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class TronModel implements IEngineModel {
    private List<Player> players;
    private InputController inputController;

    public TronModel(){
        players = new ArrayList<>();
        inputController = new InputController();
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
}
