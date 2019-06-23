package org;

public class Main {	
	public static void main(String args[]) {
		Forecast forecast = new Forecast();
		Window window = new Window(forecast);
		window.frame.setVisible(true);
	}

}
