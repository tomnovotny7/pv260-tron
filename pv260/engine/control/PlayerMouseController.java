package pv260.engine.control;

import pv260.tron.Player;

public class PlayerMouseController implements IPlayerInputController {
    private final MouseControls mouseControls;
    private final Player player;

    public PlayerMouseController(Player player, MouseControls mouseControls){
        this.player = player;
        this.mouseControls = mouseControls;
    }


    @Override
    public void handleInput(int input) {
        if (input == mouseControls.getLeftButton()){
            player.setDirection(DirectionController.toLeft(player.getDirection()));
        } else if (input == mouseControls.getRightButton()){
            player.setDirection(DirectionController.toRight(player.getDirection()));
        }
    }
}
