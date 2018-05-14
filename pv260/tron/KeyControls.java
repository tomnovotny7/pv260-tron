package pv260.tron;

public class KeyControls {
    private final int upKey;
    private final int downKey;
    private final int rightKey;
    private final int leftKey;

    public KeyControls(int upKey, int downKey, int rightKey, int leftKey){
        this.upKey = upKey;
        this.downKey = downKey;
        this.rightKey = rightKey;
        this.leftKey = leftKey;
    }

    public int getUpKey() {
        return upKey;
    }

    public int getDownKey() {
        return downKey;
    }

    public int getRightKey() {
        return rightKey;
    }

    public int getLeftKey() {
        return leftKey;
    }
}
