package org;

public class Forecast {
	private float temperature = 0;
	private float temperatureHigh = 0;
	private float temperatureLow = 0;
	private float windSpeed = 0;
	private float humidity = 0;
	private float precipProbability = 0;
	private float apparentTemperature = 0;
	private String summary = "";
	private String city = "";
	
	public float getTemperatureHigh() {
		return temperatureHigh;
	}

	public void setTemperatureHigh(float temperatureHigh) {
		this.temperatureHigh = temperatureHigh;
	}

	public float getTemperatureLow() {
		return temperatureLow;
	}

	public void setTemperatureLow(float temperatureLow) {
		this.temperatureLow = temperatureLow;
	}

	public float getApparentTemperature() {
		return apparentTemperature;
	}

	public void setApparentTemperature(float apparentTemperature) {
		this.apparentTemperature = apparentTemperature;
	}
	
	public void setCity(String city)
	{
		city = city.replaceAll("^\"|\"$", "");
		this.city = city;
	}
	
	public String getCity()
	{
		return city;
	}
	
	public float getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(float windSpeed) {
		this.windSpeed = windSpeed;
	}

	public float getHumidity() {
		return humidity;
	}

	public void setHumidity(float humidity) {
		this.humidity = humidity * 100;
	}

	public float getPrecipProbability() {
		return precipProbability;
	}

	public void setPrecipProbability(float precipProbability) {
		this.precipProbability = precipProbability * 100;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
	

	public float getTemperature() {
		return temperature;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}
}
