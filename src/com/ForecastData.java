package org;

import java.util.Date;

public class ForecastData {
	private float temperature = 0;
	private float temperatureHigh = 0;
	private float temperatureLow = 0;
	private float windSpeed = 0;
	private float humidity = 0;
	private float precipProbability = 0;
	private float apparentTemperature = 0;
	private Date time;
	
	private String summary = "";
	private String city = "";
	
	/**
	 * Get the High Temperature. Returns a float
	 * @return High Temperature
	 */
	public float getTemperatureHigh() {
		return temperatureHigh;
	}
	
	/**
	 * Sets the High Temperature. 
	 * Takes in a float
	 */
	public void setTemperatureHigh(float temperatureHigh) {
		this.temperatureHigh = temperatureHigh;
	}

	/**
	 * Get the High Temperature. Returns a float
	 * @return Low Temperature
	 */
	public float getTemperatureLow() {
		return temperatureLow;
	}

	/**
	 * Sets the Low Temperature. 
	 * Takes in a float
	 */
	public void setTemperatureLow(float temperatureLow) {
		this.temperatureLow = temperatureLow;
	}

	/**
	 * Get the Apparent Temperature. Returns a float
	 * @return Apparent Temperature
	 */
	public float getApparentTemperature() {
		return apparentTemperature;
	}

	/**
	 * Sets the Apparent Temperature. 
	 * Takes in a float
	 */
	public void setApparentTemperature(float apparentTemperature) {
		this.apparentTemperature = apparentTemperature;
	}
	
	/**
	 * Sets the Apparent Temperature. 
	 * Takes in a String
	 */
	public void setCity(String city)
	{
		city = city.replaceAll("^\"|\"$", "");
		this.city = city;
	}
	
	/**
	 * Get the City Name. Returns a String
	 * @return City Name
	 */
	public String getCity()
	{
		return city;
	}
	
	/**
	 * Get the Wind Speed. Returns a float
	 * @return Wind Speed
	 */
	public float getWindSpeed() {
		return windSpeed;
	}

	/**
	 * Sets the Wind Speed. 
	 * Takes in a float
	 */
	public void setWindSpeed(float windSpeed) {
		this.windSpeed = windSpeed;
	}

	/**
	 * Get the Humidity. Returns a float
	 * @return Humidity
	 */
	public float getHumidity() {
		return humidity;
	}
	
	/**
	 * Sets the Humidity. 
	 * Takes in a float
	 */
	public void setHumidity(float humidity) {
		this.humidity = humidity * 100;
	}

	/**
	 * Get the Precipitation Probability. Returns a float
	 * @return Precipitation Probability
	 */
	public float getPrecipProbability() {
		return precipProbability;
	}

	/**
	 * Sets the Precipitation Probability. 
	 * Takes in a float
	 */
	public void setPrecipProbability(float precipProbability) {
		this.precipProbability = precipProbability * 100;
	}

	/**
	 * Get the summary of the weather. Returns a String
	 * @return Summary
	 */
	public String getSummary() {
		return summary;
	}

	/**
	 * Sets the summary of the weather. 
	 * Takes in a String
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}
	

	/**
	 * Get the Temperature. Returns a float
	 * @return Temperature
	 */
	public float getTemperature() {
		return temperature;
	}

	/**
	 * Sets the Temperature. 
	 * Takes in a float
	 */
	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	/**
	 * Get the Time. Returns a Date
	 * @return Time
	 */
	public Date getTime() {
		return time;
	}

	/**
	 * Sets the Time. 
	 * Takes in a UNIX int
	 */
	public void setTime(int time) {
		this.time = new Date(time * 1000L);
	}
}
