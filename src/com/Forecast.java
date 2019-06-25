package org;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Forecast {
	public final int maxHours = 22;
	private ForecastData data[] = new ForecastData[maxHours];
	
	public Forecast()
	{
		try {
			RequestForecast();
			RequestCity();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void RequestForecast() throws Exception {
		//Url of the API
		String url = "https://api.darksky.net/forecast/99045d1c906c28c2c7873bd3ca44b74c/32.9495,-85.9500";
		URL obj = new URL(url);
		//Request Data from URL
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		int responseCode = con.getResponseCode();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		JsonObject myResponse = new JsonParser().parse(response.toString()).getAsJsonObject();
		JsonArray hourly = myResponse.getAsJsonObject("hourly").getAsJsonArray("data").getAsJsonArray();
		JsonArray daily = myResponse.getAsJsonObject("daily").getAsJsonArray("data").getAsJsonArray();
		
		for(int i = 0; i < 13; i++) {
			JsonObject hourlyIndex = hourly.get(i).getAsJsonObject();
			data[i] = new ForecastData();
			data[i].setTemperature(hourlyIndex.get("temperature").getAsFloat());
			data[i].setWindSpeed(hourlyIndex.get("windSpeed").getAsFloat());
			data[i].setHumidity(hourlyIndex.get("humidity").getAsFloat());
			data[i].setPrecipProbability(hourlyIndex.get("precipProbability").getAsFloat());
			data[i].setSummary(hourlyIndex.get("summary").toString());
			data[i].setApparentTemperature(hourlyIndex.get("apparentTemperature").getAsFloat());
			data[i].setTime(hourlyIndex.get("time").getAsInt());
			data[i].setTemperatureHigh(daily.get(0).getAsJsonObject().get("temperatureHigh").getAsFloat());
			data[i].setTemperatureLow(daily.get(0).getAsJsonObject().get("temperatureLow").getAsFloat());
		}
		
		for(int i = 0; i < 8; i++) {
			JsonObject dailyIndex = daily.get(i).getAsJsonObject();
			data[i + 12] = new ForecastData();
			data[i + 12].setTemperature((dailyIndex.get("temperatureHigh").getAsFloat() + dailyIndex.get("temperatureLow").getAsFloat()) / 2);
			data[i + 12].setWindSpeed(dailyIndex.get("windSpeed").getAsFloat());
			data[i + 12].setHumidity(dailyIndex.get("humidity").getAsFloat());
			data[i + 12].setPrecipProbability(dailyIndex.get("precipProbability").getAsFloat());
			data[i + 12].setSummary(dailyIndex.get("summary").toString());
			data[i + 12].setApparentTemperature((dailyIndex.get("apparentTemperatureHigh").getAsFloat() + dailyIndex.get("apparentTemperatureLow").getAsFloat()) / 2);
			data[i + 12].setTime(dailyIndex.get("time").getAsInt());
			data[i + 12].setTemperatureHigh(dailyIndex.get("temperatureHigh").getAsFloat());
			data[i + 12].setTemperatureLow(dailyIndex.get("temperatureLow").getAsFloat());
		}
	}
	
	void GetData() {
		
	}
	
	public void RequestCity() throws Exception {
		String url = "https://api.opencagedata.com/geocode/v1/json?q=32.9495+-85.9500&key=b21dd8140eba48e3942a5f4b2ae7086f";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");

		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		JsonObject myResponse = new JsonParser().parse(response.toString()).getAsJsonObject();
		
		JsonObject components = myResponse.getAsJsonArray("results").get(0).getAsJsonObject();
		
		data[0].setCity(components.getAsJsonObject("components").get("city").toString());
	}
	
	public ForecastData GetHourlyForecast(int index) {
		return data[index];
	}
}
