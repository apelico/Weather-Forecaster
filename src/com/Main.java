package org;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Main {
	// Key
	// https://api.darksky.net/forecast/99045d1c906c28c2c7873bd3ca44b74c/32.9495,-85.9500
	// 32.949538, -85.950022
	
	public static Forecast forecast;
	
	public static void main(String args[]) {
		try {
			//Main.GetForcast();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					forecast = new Forecast();
					Main.GetForcast();
					Main.GetCity();
					Window window = new Window(forecast);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void GetForcast() throws Exception {
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
		JsonObject currently = myResponse.getAsJsonObject("currently");
		JsonObject daily = myResponse.getAsJsonObject("daily");
		forecast.setTemperature(currently.get("temperature").getAsFloat());
		forecast.setWindSpeed(currently.get("windSpeed").getAsFloat());
		forecast.setHumidity(currently.get("humidity").getAsFloat());
		forecast.setPrecipProbability(daily.getAsJsonArray("data").get(0).getAsJsonObject().get("precipProbability").getAsFloat());
		forecast.setSummary(currently.get("summary").toString());
		forecast.setApparentTemperature(currently.get("apparentTemperature").getAsFloat());
		forecast.setTemperatureHigh(daily.getAsJsonArray("data").get(0).getAsJsonObject().get("temperatureHigh").getAsFloat());
		forecast.setTemperatureLow(daily.getAsJsonArray("data").get(0).getAsJsonObject().get("temperatureLow").getAsFloat());
	}
	
	public static void GetCity() throws Exception {
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
		
		forecast.setCity(components.getAsJsonObject("components").get("city").toString());
	}

}
