package pv260.engine;

import java.awt.*;
        import java.awt.event.KeyEvent;
        import java.awt.event.KeyListener;
        import java.awt.event.MouseEvent;
        import java.awt.event.MouseListener;
        import java.awt.event.MouseMotionListener;

public abstract class Engine extends Core implements KeyListener, MouseListener, MouseMotionListener {
    protected final int LINE_WIDTH = 10;

    public void init() {
        super.init();

        Window window = screenManager.getFullScreenWindow();
        window.addKeyListener(this);
        window.addMouseListener(this);
        window.addMouseMotionListener(this);
    }

    public abstract void tick();

    public abstract void keyPressed(KeyEvent e);

    public void exit(){
        stop();
        System.exit(0);
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

    public abstract void mousePressed(MouseEvent e);

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {

    }

    public void mouseMoved(MouseEvent e) {

    }
}