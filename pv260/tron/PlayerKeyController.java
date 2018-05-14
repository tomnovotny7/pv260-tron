package pv260.tron;

import com.sun.javafx.scene.traversal.Direction;

public class PlayerKeyController implements IPlayerInputController {
    private final KeyControls keyControls;
    private final Player player;

    public PlayerKeyController(Player player, KeyControls keyControls){
        this.player = player;
        this.keyControls = keyControls;
    }

    @Override
    public void handleInput(int input) {
        if (input == keyControls.getDownKey() && player.getDirection() != Direction.UP) {
            player.setDirection(Direction.DOWN);
        } else if (input == keyControls.getLeftKey() && player.getDirection() != Direction.RIGHT) {
            player.setDirection(Direction.LEFT);
        } else if (input == keyControls.getRightKey() && player.getDirection() != Direction.LEFT) {
            player.setDirection(Direction.RIGHT);
        } else if (input == keyControls.getUpKey() && player.getDirection() != Direction.DOWN) {
            player.setDirection(Direction.UP);
        }
    }
}
