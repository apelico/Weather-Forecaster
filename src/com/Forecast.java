package org;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Forecast {
	private Window window;
	private ForecastData data[] = new ForecastData[6];
	
	
	private float temperature = 0;
	private float temperatureHigh = 0;
	private float temperatureLow = 0;
	private float windSpeed = 0;
	private float humidity = 0;
	private float precipProbability = 0;
	private float apparentTemperature = 0;
	private String summary = "";
	private String city = "";
	
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
		String url = "https://api.darksky.net/forecast/99045d1c906c28c2c7873bd3ca44b74c/32.9495,-85.9500";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");

		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL: " + url);
		System.out.println("Response Code : " + responseCode);
		
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		JsonObject myResponse = new JsonParser().parse(response.toString()).getAsJsonObject();
		//System.out.println(myResponse.getAsJsonObject("hourly").getAsJsonArray("data").get(0));
		
		for(int i = 0; i < 6; i++) {
			JsonObject hourly = myResponse.getAsJsonObject("hourly").getAsJsonArray("data").get(i).getAsJsonObject();
			data[i] = new ForecastData();
			data[i].setTemperature(hourly.get("temperature").getAsFloat());
			data[i].setWindSpeed(hourly.get("windSpeed").getAsFloat());
			data[i].setHumidity(hourly.get("humidity").getAsFloat());
			data[i].setPrecipProbability(hourly.get("precipProbability").getAsFloat());
			data[i].setSummary(hourly.get("summary").toString());
			data[i].setApparentTemperature(hourly.get("apparentTemperature").getAsFloat());
			data[i].setTemperatureHigh(myResponse.getAsJsonObject("daily").getAsJsonArray("data").get(0).getAsJsonObject().get("temperatureHigh").getAsFloat());
			data[i].setTemperatureLow(myResponse.getAsJsonObject("daily").getAsJsonArray("data").get(0).getAsJsonObject().get("temperatureLow").getAsFloat());
			System.out.println(data[i].getTemperature());
		}
	}
	
	public void RequestCity() throws Exception {
		String url = "https://api.opencagedata.com/geocode/v1/json?q=32.9495+-85.9500&key=b21dd8140eba48e3942a5f4b2ae7086f";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");

		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		System.out.println("\nSending 'GET' request to URL: " + url);
		
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
	
	public ForecastData GetForecast(int index) {
		return data[index];
	}
}
