package pv260.engine;

import java.awt.*;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class ScreenManager {

    private GraphicsDevice graphicsDevice;

    public ScreenManager() {
        GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
        graphicsDevice = e.getDefaultScreenDevice();
    }

    public DisplayMode[] getCompatibleDisplayModes() {
        return graphicsDevice.getDisplayModes();
    }

    public DisplayMode findFirstCompatibleMode(DisplayMode[] modes) {

        DisplayMode goodModes[] = graphicsDevice.getDisplayModes();
        for (int i = 0; i < modes.length; i++) {
            for (int j = 0; j < goodModes.length; j++) {
                if (displayModesMatch(modes[i], goodModes[j])) {
                    return modes[i];
                }
            }
        }
        return null;
    }

    public DisplayMode getCurrentDisplayMode() {
        return graphicsDevice.getDisplayMode();
    }

    public boolean displayModesMatch(DisplayMode displayMode1, DisplayMode displayMode2) {
        if (displayMode1.getWidth() != displayMode2.getWidth() || displayMode1.getHeight() != displayMode2.getHeight()) {
            return false;
        }
        if (displayMode1.getBitDepth() != DisplayMode.BIT_DEPTH_MULTI
                && displayMode2.getBitDepth() != DisplayMode.BIT_DEPTH_MULTI
                && displayMode1.getBitDepth() != displayMode2.getBitDepth()) {
            return false;
        }
        if (displayMode1.getRefreshRate() != DisplayMode.REFRESH_RATE_UNKNOWN
                && displayMode2.getRefreshRate() != DisplayMode.REFRESH_RATE_UNKNOWN
                && displayMode1.getRefreshRate() != displayMode2.getRefreshRate()) {
            return false;
        }
        return true;
    }

    public void setFullScreen(DisplayMode displayMode) {
        JFrame frame = new JFrame();
        frame.setUndecorated(true);
        frame.setIgnoreRepaint(true);
        frame.setResizable(false);
        graphicsDevice.setFullScreenWindow(frame);

        if (displayMode != null && graphicsDevice.isDisplayChangeSupported()) {
            try {
                graphicsDevice.setDisplayMode(displayMode);
            } catch (Exception ex) {
            }
            frame.createBufferStrategy(2);
        }
    }

    public Graphics2D getGraphics() {
        Window window = graphicsDevice.getFullScreenWindow();
        if (window != null) {
            BufferStrategy bufferStrategy = window.getBufferStrategy();
            return (Graphics2D) bufferStrategy.getDrawGraphics();
        } else {
            return null;
        }
    }

    public void update() {
        Window window = graphicsDevice.getFullScreenWindow();
        if (window != null) {
            BufferStrategy bufferStrategy = window.getBufferStrategy();
            if (!bufferStrategy.contentsLost()) {
                bufferStrategy.show();
            }
        }
    }

    public Window getFullScreenWindow() {
        return graphicsDevice.getFullScreenWindow();
    }

    public int getWidth() {
        Window window = graphicsDevice.getFullScreenWindow();
        if (window != null) {
            return window.getWidth();
        } else {
            return 0;
        }
    }

    public int getHeight() {
        Window window = graphicsDevice.getFullScreenWindow();
        if (window != null) {
            return window.getHeight();
        } else {
            return 0;
        }
    }

    public void restoreScreen() {
        Window window = graphicsDevice.getFullScreenWindow();
        if (window != null) {
            window.dispose();
        }
        graphicsDevice.setFullScreenWindow(null);
    }
}
