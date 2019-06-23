package org;

import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Window {
	public JFrame frame;

	public static final int WIDTH = 300;
	public static final int HEIGHT = 400;

	private int index = 0;
	private Forecast forecast;
	private CustomLabel city, temperature, hourly;
	private CustomLabel lowTemperatureText, lowTemperature;
	private CustomLabel highTemperatureText, highTemperature;
	private CustomLabel humidityText, humidity;
	private CustomLabel windSpeedText, windSpeed;
	private CustomLabel precipProbabilityText, precipProbability;
	private CustomLabel apparentTemperatureText, apparentTemperature;

	public Window(Forecast forecast) {
		this.forecast = forecast;
		frame = new JFrame();
		frame.setBounds(100, 100, 300, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		// Labels that need to adjust
		city = new CustomLabel(forecast.GetForecast(index).getCity(), 25, 0, 0, 284, 50);
		frame.getContentPane().add(city);

		temperature = new CustomLabel(forecast.GetForecast(index).getTemperature() + "\u00B0", 25, 0, 50, 284, 50);
		frame.getContentPane().add(temperature);

		lowTemperatureText = new CustomLabel("Low", 20, 142, 100, 142, 50);
		frame.getContentPane().add(lowTemperatureText);

		lowTemperature = new CustomLabel(forecast.GetForecast(index).getTemperatureLow() + "\u00B0", 25, 142, 150, 142,50);
		frame.getContentPane().add(lowTemperature);

		highTemperatureText = new CustomLabel("High", 20, 0, 100, 142, 50);
		frame.getContentPane().add(highTemperatureText);

		highTemperature = new CustomLabel(forecast.GetForecast(index).getTemperatureHigh() + "\u00B0", 25, 0, 150, 142,50);
		frame.getContentPane().add(highTemperature);

		humidityText = new CustomLabel("Humidity", 20, 0, 200, 142, 50);
		frame.getContentPane().add(humidityText);

		humidity = new CustomLabel(forecast.GetForecast(index).getHumidity() + "%", 25, 0, 250, 142, 50);
		frame.getContentPane().add(humidity);

		windSpeedText = new CustomLabel("WindSpeed", 20, 142, 200, 142, 50);
		frame.getContentPane().add(windSpeedText);

		windSpeed = new CustomLabel(forecast.GetForecast(index).getWindSpeed() + "MPH", 25, 142, 250, 142, 50);
		frame.getContentPane().add(windSpeed);

		precipProbabilityText = new CustomLabel("RainChance", 20, 0, 300, 142, 50);
		frame.getContentPane().add(precipProbabilityText);

		precipProbability = new CustomLabel(forecast.GetForecast(index).getPrecipProbability() + "%", 25, 0, 350, 142,50);
		frame.getContentPane().add(precipProbability);

		apparentTemperatureText = new CustomLabel("FeelsLike", 20, 142, 300, 142, 50);
		frame.getContentPane().add(apparentTemperatureText);

		apparentTemperature = new CustomLabel(forecast.GetForecast(index).getApparentTemperature() + "\u00B0", 25, 142, 350, 142, 50);
		frame.getContentPane().add(apparentTemperature);
		
		hourly = new CustomLabel("Current", 25, 0, 400, 284, 34);
		frame.getContentPane().add(hourly);

		JSlider slider = new JSlider();
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent evt) {
				JSlider slider = (JSlider) evt.getSource();
				if (slider.getValueIsAdjusting()) {
					int value = slider.getValue();
					index = slider.getValue();
					Update();
					System.out.println(index);
				}
			}
		});
		slider.setSnapToTicks(true);
		slider.setValue(index);
		slider.setMaximum(5);
		slider.setBounds(0, 435, 284, 26);
		frame.getContentPane().add(slider);
	}

	public void Update() {
		temperature.setText(forecast.GetForecast(index).getTemperature() + "\u00B0");
		lowTemperature.setText(forecast.GetForecast(index).getTemperatureLow() + "\u00B0");
		highTemperature.setText(forecast.GetForecast(index).getTemperatureHigh() + "\u00B0");
		humidity.setText(forecast.GetForecast(index).getHumidity() + "%");
		windSpeed.setText(forecast.GetForecast(index).getWindSpeed() + "MPH");
		precipProbability.setText(forecast.GetForecast(index).getPrecipProbability() + "%");
		apparentTemperature.setText(forecast.GetForecast(index).getApparentTemperature() + "\u00B0");
		switch(index)
		{
		case 1:
			hourly.setText("After 1 Hour");
			break;
		case 2:
			hourly.setText("After 2 Hours");
			break;
		case 3:
			hourly.setText("After 3 Hours");
			break;
		case 4:
			hourly.setText("After 4 Hours");
			break;
		case 5:
			hourly.setText("After 5 Hours");
			break;
		default:
			hourly.setText("Current");
			break;
		}
		frame.repaint();
		frame.revalidate();
	}

}
