package gui;

/**
 * Created by Lauri on 10.4.2015.
 */
public class WindowAnimator implements Runnable {
    private Window window;
    private boolean running;

    private static final int FRAME_DELAY = 15;

    public WindowAnimator(Window window) {
        this.window = window;
        this.running = true;
    }

    @Override
    public void run() {
        while(this.running) {
            this.window.repaint();
            try {
                Thread.sleep(FRAME_DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void stop() {
        this.running = false;
    }
}
