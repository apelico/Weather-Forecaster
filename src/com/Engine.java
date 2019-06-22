package com;

public class Engine implements Runnable {
    private Thread thread;
    private Window window;

	private boolean running = false;

    public void start() {
        window = new Window(this);

        running = true;
        thread = new Thread(this);
        thread.run();
    }

    public void stop() {

    }

    public void run() {
        long initialTime = System.nanoTime();
        final double timeU = 1000000000 / 60.0d;
        final double timeF = 1000000000 / 120.0d;
        double deltaU = 0, deltaF = 0;
        int frames = 0; //Frames per seconds display
        long timer = System.currentTimeMillis();

        while (running) {
            long currentTime = System.nanoTime();
            deltaU += (currentTime - initialTime) / timeU;
            deltaF += (currentTime - initialTime) / timeF;
            initialTime = currentTime;

            if (deltaU >= 1) {
                deltaU--;
            }

            if (deltaF >= 1) {
                window.Render();
                frames++;
                deltaF--;
            }

            if (System.currentTimeMillis() - timer > 1000) {
                fps = frames;
                frames = 0;
                //ticks = 0; System.out.println(ticks); Displays the ticks per second when enabled
                timer += 1000;
            }

        }

        dispose();
    }
    
    public static int fps;

    private void dispose() {

    }

    public Window getWindow() {
        return window;
    }
}