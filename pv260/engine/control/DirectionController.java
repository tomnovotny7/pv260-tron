package pv260.engine.control;

import com.sun.javafx.scene.traversal.Direction;

public class DirectionController {
    public static Direction toLeft(Direction direction){
        switch (direction){
            case DOWN:
                return Direction.RIGHT;
            case RIGHT:
                return Direction.UP;
            case UP:
                return Direction.LEFT;
            case LEFT:
                return Direction.DOWN;
        }

        return direction;
    }

    public static Direction toRight(Direction direction){
        switch (direction){
            case DOWN:
                return Direction.LEFT;
            case RIGHT:
                return Direction.DOWN;
            case UP:
                return Direction.RIGHT;
            case LEFT:
                return Direction.UP;
        }

        return direction;
    }
}
