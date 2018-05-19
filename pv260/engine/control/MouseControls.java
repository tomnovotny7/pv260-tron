package pv260.engine.control;

public class MouseControls {
    private final int leftButton;
    private final int rightButton;

    public MouseControls(int leftButton, int rightButton){
        this.leftButton = leftButton;
        this.rightButton = rightButton;
    }

    public int getLeftButton() {
        return leftButton;
    }

    public int getRightButton() {
        return rightButton;
    }
}
