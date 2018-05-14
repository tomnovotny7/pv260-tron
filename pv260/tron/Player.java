package pv260.tron;

import com.sun.javafx.scene.traversal.Direction;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private Color color;
    private Point currentPosition;
    private Direction direction;
    private List<Point> path;

    public Player(Color color, Point startingPosition, Direction startingDirection){
        this.color = color;
        currentPosition = startingPosition;
        direction = startingDirection;
        path = new ArrayList<>();
    }

    public Color getColor() {
        return color;
    }

    public Point getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Point currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public List<Point> getPath() {
        return path;
    }
}
