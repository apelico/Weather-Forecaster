package org;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Window {
	public JFrame frame;

	public static final int WIDTH = 300;
	public static final int HEIGHT = 400;

	private int index = 0;
	private boolean hourlyForecast = true;
	private Forecast forecast;
	private CustomLabel city, temperature, hourly;
	private CustomLabel lowTemperatureText, lowTemperature;
	private CustomLabel highTemperatureText, highTemperature;
	private CustomLabel humidityText, humidity;
	private CustomLabel windSpeedText, windSpeed;
	private CustomLabel precipProbabilityText, precipProbability;
	private CustomLabel apparentTemperatureText, apparentTemperature;
	private JSlider slider;

	public Window(Forecast forecast) {
		this.forecast = forecast;
		frame = new JFrame();
		frame.setBounds(100, 100, 300, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		city = new CustomLabel(forecast.GetHourlyForecast(index).getCity(), 25, 0, 0, 284, 50, true);
		frame.getContentPane().add(city);

		temperature = new CustomLabel("", 25, 0, 50, 284, 25, true);
		frame.getContentPane().add(temperature);

		// Left Side

		highTemperatureText = new CustomLabel("High", 20, 0, 100, 142, 25, false);
		frame.getContentPane().add(highTemperatureText);

		highTemperature = new CustomLabel("", 25, 0, 125, 142, 25, true);
		frame.getContentPane().add(highTemperature);

		humidityText = new CustomLabel("Humidity", 20, 0, 175, 142, 25, false);
		frame.getContentPane().add(humidityText);

		humidity = new CustomLabel("", 25, 0, 200, 142, 25, true);
		frame.getContentPane().add(humidity);

		precipProbabilityText = new CustomLabel("RainChance", 20, 0, 250, 142, 25, false);
		frame.getContentPane().add(precipProbabilityText);

		precipProbability = new CustomLabel("", 25, 0, 275, 142, 25, true);
		frame.getContentPane().add(precipProbability);

		// Right Side

		lowTemperatureText = new CustomLabel("Low", 20, 142, 100, 142, 25, false);
		frame.getContentPane().add(lowTemperatureText);

		lowTemperature = new CustomLabel("", 25, 142, 125, 142, 25, true);
		frame.getContentPane().add(lowTemperature);

		windSpeedText = new CustomLabel("WindSpeed", 20, 142, 175, 142, 25, false);
		frame.getContentPane().add(windSpeedText);

		windSpeed = new CustomLabel("", 25, 142, 200, 142, 25, true);
		frame.getContentPane().add(windSpeed);

		apparentTemperatureText = new CustomLabel("FeelsLike", 20, 142, 250, 142, 25, false);
		frame.getContentPane().add(apparentTemperatureText);

		apparentTemperature = new CustomLabel("", 25, 142, 275, 142, 25, true);
		frame.getContentPane().add(apparentTemperature);

		hourly = new CustomLabel("Current", 25, 0, 400, 284, 34, true);
		frame.getContentPane().add(hourly);

		slider = new JSlider();
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent evt) {
				JSlider slider = (JSlider) evt.getSource();
				if (slider.getValueIsAdjusting()) {
					int value = slider.getValue();
					index = slider.getValue();
					Update();
				}
			}
		});
		slider.setSnapToTicks(true);
		slider.setValue(index);
		slider.setMaximum(11);
		slider.setBounds(0, 435, 284, 26);
		frame.getContentPane().add(slider);

		JButton btnHourly = new JButton("Hourly");
		btnHourly.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				hourlyForecast = true;
				slider.setValue(0);
				slider.setMaximum(11);
				index = 0;
				Update();
			}

		});
		btnHourly.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnHourly.setBounds(10, 363, 132, 30);
		frame.getContentPane().add(btnHourly);

		JButton btnDaily = new JButton("Daily");
		btnDaily.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				hourlyForecast = false;
				slider.setValue(0);
				slider.setMaximum(7);
				index = 0;
				Update();
			}
		});
		btnDaily.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDaily.setBounds(142, 363, 132, 30);
		frame.getContentPane().add(btnDaily);

		Update();
	}

	public void Update() {
		if (hourlyForecast) {
			temperature.setText((int) forecast.GetHourlyForecast(index).getTemperature() + "\u00B0");
			lowTemperature.setText((int) forecast.GetHourlyForecast(index).getTemperatureLow() + "\u00B0");
			highTemperature.setText((int) forecast.GetHourlyForecast(index).getTemperatureHigh() + "\u00B0");
			humidity.setText((int) forecast.GetHourlyForecast(index).getHumidity() + "%");
			windSpeed.setText((int) forecast.GetHourlyForecast(index).getWindSpeed() + "MPH");
			precipProbability.setText((int) forecast.GetHourlyForecast(index).getPrecipProbability() + "%");
			apparentTemperature.setText((int) forecast.GetHourlyForecast(index).getApparentTemperature() + "\u00B0");
			if (index == 0) {
				hourly.setText("Currently");
			} else {
				if(forecast.GetHourlyForecast(index).getTime().getHours() > 12) {
					hourly.setText(forecast.GetHourlyForecast(index).getTime().getHours() - 12 + " PM");
				}else
					hourly.setText(forecast.GetHourlyForecast(index).getTime().getHours() + " AM");
			}
		}else {
			temperature.setText((int) forecast.GetHourlyForecast(index + 12).getTemperature() + "\u00B0");
			lowTemperature.setText((int) forecast.GetHourlyForecast(index + 12).getTemperatureLow() + "\u00B0");
			highTemperature.setText((int) forecast.GetHourlyForecast(index + 12).getTemperatureHigh() + "\u00B0");
			humidity.setText((int) forecast.GetHourlyForecast(index + 12).getHumidity() + "%");
			windSpeed.setText((int) forecast.GetHourlyForecast(index + 12).getWindSpeed() + "MPH");
			precipProbability.setText((int) forecast.GetHourlyForecast(index + 12).getPrecipProbability() + "%");
			apparentTemperature.setText((int) forecast.GetHourlyForecast(index + 12).getApparentTemperature() + "\u00B0");
			if (index == 0) {
				hourly.setText("Today" + " " + forecast.GetHourlyForecast(index + 12).getTime().getMonth() + "/" + forecast.GetHourlyForecast(index + 12).getTime().getDate());
			} else {
				hourly.setText(GetDayName(forecast.GetHourlyForecast(index + 12).getTime().getDay()) + " " + forecast.GetHourlyForecast(index + 12).getTime().getMonth() + "/" + forecast.GetHourlyForecast(index + 12).getTime().getDate());
			}
		}
		frame.repaint();
		frame.revalidate();
	}
	
	String GetDayName(int i) {
		switch(i){
		case 0:
			return "Sunday";
		case 1:
			return "Monday";
		case 2:
			return "Tuesday";
		case 3:
			return "Wednesday";
		case 4:
			return "Thursday";
		case 5:
			return "Friday";
		case 6:
			return "Saturday";
			default:
				return "null";
		}
	}

}
