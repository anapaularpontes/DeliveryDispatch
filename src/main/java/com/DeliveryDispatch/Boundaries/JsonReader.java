package com.DeliveryDispatch.Boundaries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * A class to read a JSON result from an url
 * 
 * @author Ana Paula Pontes
 *
 */
public class JsonReader {

	/**
	 * Fetch the distance between two places
	 * 
	 * @param url
	 * @return distance
	 * @throws JSONException
	 * @throws IOException
	 */
	public Double getDistance(String url) throws JSONException, IOException {

		JSONObject json = readJsonFromUrl(url);
		double distance = (double) json.getJSONObject("route").get("distance");
		return distance;
	}

	/**
	 * Fetch the latitude and longitude from an address
	 * 
	 * @param url
	 * @return latitude and longitude
	 * @throws JSONException
	 * @throws IOException
	 */
	public List<Double> getLatLng(String url) throws JSONException, IOException {

		JSONObject json = readJsonFromUrl(url);
		JSONObject results = json.getJSONArray("results").getJSONObject(0).getJSONArray("locations").getJSONObject(0)
				.getJSONObject("latLng");
		List<Double> latlng = new ArrayList<>();
		latlng.add((Double) results.get("lat"));
		latlng.add((Double) results.get("lng"));
		return latlng;
	}

	/**
	 * Read a JSON from an url
	 * 
	 * @param url
	 * @return JSON object
	 * @throws IOException
	 * @throws JSONException
	 */
	private static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {

		InputStream is = new URL(url).openStream();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			StringBuilder sb = new StringBuilder();
			int cp;
			while ((cp = br.read()) != -1) {
				sb.append((char) cp);
			}
			JSONObject json = new JSONObject(sb.toString());
			return json;
		} finally {
			is.close();
		}
	}

}
