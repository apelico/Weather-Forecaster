package com;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Window {
    private BufferStrategy bufferStrategy;
    private Graphics2D g;
    private Canvas canvas;
    private JFrame frame; 

	public static final int WIDTH = 1024;
    public static final int HEIGHT = 768;
    
    //Scales the screen
    public static int Scale = 1;
    
    //Zoom variables
    private double zoom = 1;
    private double anchorX, anchorY;
    
    

    public Window(Engine engine) {
        frame = new JFrame("Test Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setAlwaysOnTop(true);

        canvas = new Canvas();
        canvas.setSize(WIDTH * Scale, HEIGHT * Scale);

        frame.setResizable(false);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);

        canvas.createBufferStrategy(3);
        //bufferStrategy = canvas.getBufferStrategy();
        g = (Graphics2D)canvas.getGraphics();
    }
    
    public void Render() {
    	bufferStrategy = canvas.getBufferStrategy();
    	g = (Graphics2D)bufferStrategy.getDrawGraphics();
    	g.clearRect(0, 0, WIDTH, HEIGHT);
    	
    	AffineTransform at = new AffineTransform();
    	//set screen position to center after zoom
    	anchorX = (WIDTH - (WIDTH * (zoom))) / 2;
    	anchorY = (HEIGHT - (HEIGHT * (zoom))) / 2;
    	
    	//zooms the screen in and positions to center 
    	at.translate(anchorX, anchorY);
    	at.scale(zoom * Scale, zoom * Scale);
    	
    	g.setTransform(at);
    	
    	//Draws all objects
    	g.setColor(Color.GREEN);
    	g.fillRect(100, 100, 50, 50);
    	g.setColor(Color.RED);
    	g.fillRect(400, 100, 50, 50);
    	g.setColor(Color.BLUE);
    	g.fillRect(100, 400, 50, 50);
    	//Show
        bufferStrategy.show();
        //g.dispose();
    }

    public Canvas getCanvas() {
        return canvas;
    }
    
    public JFrame getFrame() {
		return frame;
	}
    
    public void setZoom(int amount) {
    	zoom = amount;
    }
}