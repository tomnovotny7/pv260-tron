package pv260.engine.model;

import com.sun.javafx.scene.traversal.Direction;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(color, player.color) &&
                Objects.equals(currentPosition, player.currentPosition) &&
                direction == player.direction &&
                Objects.equals(path, player.path);
    }

    @Override
    public int hashCode() {

        return Objects.hash(color, currentPosition, direction, path);
    }
}
