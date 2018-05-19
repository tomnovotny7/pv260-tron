package pv260.engine;

import pv260.engine.model.IEngineModel;

import java.awt.*;
        import java.awt.event.KeyEvent;
        import java.awt.event.KeyListener;
        import java.awt.event.MouseEvent;
        import java.awt.event.MouseListener;
        import java.awt.event.MouseMotionListener;

public abstract class Engine extends Core implements KeyListener, MouseListener, MouseMotionListener {
    protected final int MOVE_AMOUNT = 5;
    protected final int LINE_WIDTH = 10;

    private IEngineModel engineModel;

    public Engine(IEngineModel engineModel){
        super();

        this.engineModel = engineModel;
    }

    public void init() {
        super.init();

        Window window = screenManager.getFullScreenWindow();
        window.addKeyListener(this);
        window.addMouseListener(this);
        window.addMouseMotionListener(this);
    }

    public abstract void tick();

    protected abstract boolean isGameFinished();

    protected abstract void movePlayers();

    @Override
    public void keyPressed(KeyEvent e) {
        engineModel.keyPressed(e);
    }

    public void keyReleased(KeyEvent e) {

    }

    public void keyTyped(KeyEvent arg0) {

    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent arg0) {
    }

    public void mouseExited(MouseEvent arg0) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        engineModel.mousePressed(e);
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {

    }

    public void mouseMoved(MouseEvent e) {

    }
}