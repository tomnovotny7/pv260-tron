package pv260.tron;

import com.sun.javafx.scene.traversal.Direction;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class Tron extends Core implements KeyListener, MouseListener, MouseMotionListener {
    private int moveAmount = 5;

    private Player player1;
    private Player player2;

    public void init() {
        super.init();

        player1 = new Player(Color.GREEN, new Point(40, 40), Direction.RIGHT);
        player2 = new Player(Color.RED, new Point(600, 400), Direction.LEFT);

        Window window = screenManager.getFullScreenWindow();
        window.addKeyListener(this);
        window.addMouseListener(this);
        window.addMouseMotionListener(this);
    }

    public void draw(Graphics2D g) {
        movePlayer(player1);
        movePlayer(player2);

        for (int i = 0; i < player1.getPath().size(); i++) {
            if ((player1.getCurrentPosition().equals(player1.getPath().get(i)))
                    || (player1.getCurrentPosition().equals(player2.getPath().get(i)))
                    || (player2.getCurrentPosition().equals(player1.getPath().get(i)))
                    || (player2.getCurrentPosition().equals(player2.getPath().get(i)))) {
                System.exit(0);
            }
        }

        player1.getPath().add(player1.getCurrentPosition());
        player2.getPath().add(player2.getCurrentPosition());

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, screenManager.getWidth(), screenManager.getHeight());
        for (int i = 0; i < player1.getPath().size(); i++) {
            g.setColor(Color.green);
            g.fillRect(player1.getPath().get(i).x, player1.getPath().get(i).y, 10, 10);
            g.setColor(Color.red);
            g.fillRect(player2.getPath().get(i).x, player2.getPath().get(i).y, 10, 10);
        }
    }

    private void movePlayer(Player player){
        Point playerPosition = new Point(player.getCurrentPosition());

        switch (player.getDirection()){
            case UP:
                if (playerPosition.y > 0) {
                    playerPosition.y -= moveAmount;
                } else {
                    playerPosition.y = screenManager.getHeight();
                }
                break;
            case RIGHT:
                if (playerPosition.x < screenManager.getWidth()) {
                    playerPosition.x += moveAmount;
                } else {
                    playerPosition.x = 0;
                }
                break;
            case DOWN:
                if (playerPosition.y < screenManager.getHeight()) {
                    playerPosition.y += moveAmount;
                } else {
                    playerPosition.y = 0;
                }
                break;
            case LEFT:
                if (playerPosition.x > 0) {
                    playerPosition.x -= moveAmount;
                } else {
                    playerPosition.x = screenManager.getWidth();
                }
                break;
        }

        player.setCurrentPosition(playerPosition);
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            if (player1.getDirection() != Direction.DOWN) {
                player1.setDirection(Direction.UP);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (player1.getDirection() != Direction.UP) {
                player1.setDirection(Direction.DOWN);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (player1.getDirection() != Direction.LEFT) {
                player1.setDirection(Direction.RIGHT);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (player1.getDirection() != Direction.RIGHT) {
                player1.setDirection(Direction.LEFT);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_W) {
            if (player2.getDirection() != Direction.DOWN) {
                player2.setDirection(Direction.UP);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            if (player2.getDirection() != Direction.UP) {
                player2.setDirection(Direction.DOWN);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            if (player2.getDirection() != Direction.LEFT) {
                player2.setDirection(Direction.RIGHT);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            if (player2.getDirection() != Direction.RIGHT) {
                player2.setDirection(Direction.LEFT);
            }
        }
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

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {

    }

    public void mouseMoved(MouseEvent e) {

    }
}
