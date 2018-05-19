package pv260.engine.control;

import java.util.ArrayList;
import java.util.List;

public class InputController {
    private final List<IPlayerInputController> playerInputControllers = new ArrayList<>();

    public void addController(IPlayerInputController playerInputController){
        playerInputControllers.add(playerInputController);
    }

    public void handleInput(int input){
        for (IPlayerInputController playerInputController : playerInputControllers){
            playerInputController.handleInput(input);
        }
    }
}
