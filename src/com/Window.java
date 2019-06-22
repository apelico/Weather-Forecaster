package org;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class Window {
    public JFrame frame; 
    private Forecast forecast;

	public static final int WIDTH = 300;
    public static final int HEIGHT = 400;
    //forecast.getTemperature() + "\u00B0"
	public Window(Forecast forecast) {
		this.forecast = forecast;
		frame = new JFrame();
		frame.setTitle("Weather App");
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 300, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
        
		JLabel cityLabel = new JLabel(forecast.getCity());
		cityLabel.setFont(new Font("Monospaced", Font.BOLD, 26));
		cityLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cityLabel.setForeground(Color.WHITE);
		cityLabel.setBounds(0, 0, 284, 40);
		frame.getContentPane().add(cityLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.BLACK);
		tabbedPane.setBounds(0, 51, 284, 310);
		frame.getContentPane().add(tabbedPane);
		
		JPanel todayTab = new JPanel();
		todayTab.setBackground(Color.BLACK);
		tabbedPane.addTab("Today", null, todayTab, null);
		tabbedPane.setBackgroundAt(0, Color.BLACK);
		tabbedPane.setForegroundAt(0, Color.WHITE);
		todayTab.setLayout(null);
		
		JLabel temperature = new JLabel(forecast.getTemperature() + "\u00B0");
		temperature.setBounds(0, 0, 279, 40);
		temperature.setVerticalAlignment(SwingConstants.TOP);
		temperature.setHorizontalAlignment(SwingConstants.CENTER);
		temperature.setFont(new Font("Monospaced", Font.BOLD, 30));
		temperature.setForeground(Color.WHITE);
		todayTab.add(temperature);
		
		JLabel windSpeedLabel = new JLabel("Wind Speed");
		windSpeedLabel.setFont(new Font("Monospaced", Font.PLAIN, 15));
		windSpeedLabel.setBounds(169, 50, 100, 30);
		windSpeedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		windSpeedLabel.setForeground(Color.WHITE);
		todayTab.add(windSpeedLabel);
		
		JLabel windSpeed = new JLabel(forecast.getWindSpeed() + " MPH");
		windSpeed.setHorizontalAlignment(SwingConstants.CENTER);
		windSpeed.setForeground(Color.WHITE);
		windSpeed.setFont(new Font("Monospaced", Font.BOLD, 18));
		windSpeed.setBounds(169, 80, 100, 30);
		todayTab.add(windSpeed);
		
		JLabel apparentTemperatureLabel = new JLabel("Feels Like");
		apparentTemperatureLabel.setHorizontalAlignment(SwingConstants.CENTER);
		apparentTemperatureLabel.setForeground(Color.WHITE);
		apparentTemperatureLabel.setFont(new Font("Monospaced", Font.PLAIN, 15));
		apparentTemperatureLabel.setBounds(10, 50, 100, 30);
		todayTab.add(apparentTemperatureLabel);
		
		JLabel apparentTemperature = new JLabel(forecast.getApparentTemperature() + "\u00B0");
		apparentTemperature.setHorizontalAlignment(SwingConstants.CENTER);
		apparentTemperature.setForeground(Color.WHITE);
		apparentTemperature.setFont(new Font("Monospaced", Font.BOLD, 18));
		apparentTemperature.setBounds(10, 80, 100, 30);
		todayTab.add(apparentTemperature);
		
		JLabel humidityLabel = new JLabel("Humidity");
		humidityLabel.setHorizontalAlignment(SwingConstants.CENTER);
		humidityLabel.setForeground(Color.WHITE);
		humidityLabel.setFont(new Font("Monospaced", Font.PLAIN, 15));
		humidityLabel.setBounds(10, 120, 100, 30);
		todayTab.add(humidityLabel);
		
		JLabel humidity = new JLabel(forecast.getHumidity() + "%");
		humidity.setHorizontalAlignment(SwingConstants.CENTER);
		humidity.setForeground(Color.WHITE);
		humidity.setFont(new Font("Monospaced", Font.BOLD, 18));
		humidity.setBounds(10, 150, 100, 30);
		todayTab.add(humidity);
		
		JLabel precipProbabilityLabel = new JLabel("Rain Chance");
		precipProbabilityLabel.setHorizontalAlignment(SwingConstants.CENTER);
		precipProbabilityLabel.setForeground(Color.WHITE);
		precipProbabilityLabel.setFont(new Font("Monospaced", Font.PLAIN, 15));
		precipProbabilityLabel.setBounds(169, 120, 100, 30);
		todayTab.add(precipProbabilityLabel);
		
		JLabel precipProbability = new JLabel(forecast.getPrecipProbability() + "%");
		precipProbability.setHorizontalAlignment(SwingConstants.CENTER);
		precipProbability.setForeground(Color.WHITE);
		precipProbability.setFont(new Font("Monospaced", Font.BOLD, 18));
		precipProbability.setBounds(169, 150, 100, 30);
		todayTab.add(precipProbability);
		
		JLabel temperatureHighLabel = new JLabel("High");
		temperatureHighLabel.setHorizontalAlignment(SwingConstants.CENTER);
		temperatureHighLabel.setForeground(Color.WHITE);
		temperatureHighLabel.setFont(new Font("Monospaced", Font.PLAIN, 15));
		temperatureHighLabel.setBounds(10, 190, 100, 30);
		todayTab.add(temperatureHighLabel);
		
		JLabel temperatureHigh = new JLabel(forecast.getTemperatureHigh() + "\u00B0");
		temperatureHigh.setHorizontalAlignment(SwingConstants.CENTER);
		temperatureHigh.setForeground(Color.WHITE);
		temperatureHigh.setFont(new Font("Monospaced", Font.BOLD, 18));
		temperatureHigh.setBounds(10, 220, 100, 30);
		todayTab.add(temperatureHigh);
		
		JLabel temperatureLowLabel = new JLabel("Low");
		temperatureLowLabel.setHorizontalAlignment(SwingConstants.CENTER);
		temperatureLowLabel.setForeground(Color.WHITE);
		temperatureLowLabel.setFont(new Font("Monospaced", Font.PLAIN, 15));
		temperatureLowLabel.setBounds(169, 190, 100, 30);
		todayTab.add(temperatureLowLabel);
		
		JLabel temperatureLow = new JLabel(forecast.getTemperatureLow() + "\u00B0");
		temperatureLow.setHorizontalAlignment(SwingConstants.CENTER);
		temperatureLow.setForeground(Color.WHITE);
		temperatureLow.setFont(new Font("Monospaced", Font.BOLD, 18));
		temperatureLow.setBounds(169, 220, 100, 30);
		todayTab.add(temperatureLow);
		
		JPanel HourlyTab = new JPanel();
		HourlyTab.setBackground(Color.BLACK);
		tabbedPane.addTab("Hourly", null, HourlyTab, null);
		tabbedPane.setForegroundAt(1, Color.WHITE);
		
		JPanel DailyTab = new JPanel();
		DailyTab.setBackground(Color.BLACK);
		tabbedPane.addTab("Daily", null, DailyTab, null);
		tabbedPane.setForegroundAt(2, Color.WHITE);
    }
}
