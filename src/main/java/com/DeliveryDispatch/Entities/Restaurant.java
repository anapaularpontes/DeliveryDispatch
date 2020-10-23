package com.DeliveryDispatch.Entities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.json.JSONException;

import com.DeliveryDispatch.Boundaries.JsonReader;

/**
 * A class that represents a restaurant
 * 
 * @author Ana Paula Pontes
 *
 */
@Entity
public class Restaurant {

	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "restaurant_id")
	private int id = 0;
	private String name = "";
	private String address = "";
	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;
	@ManyToOne
	@JoinColumn(name = "area_id")
	private Area area;
	private double latitude;
	private double longitude;
	private boolean active = true;

	public Restaurant() {
		super();
	}

	public Restaurant(String name, String address, City city, Area area) {
		super();
		this.name = name;
		this.address = address;
		this.city = city;
		this.area = area;
		this.active = true;
		setLatLong();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String newAddress) {
		this.address = newAddress;

	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	/**
	 * Sets the latitude and longitude of an restaurant
	 */
	private void setLatLong() {
		JsonReader reader = new JsonReader();
		List<Double> latlng = new ArrayList<>();
		String location = address + ",+" + city.getName();
		location = location.replaceAll(" ", "+");
		try {
			latlng = reader
					.getLatLng("http://www.mapquestapi.com/geocoding/v1/address?key=YOUR_KEY&location=" + location);
		} catch (JSONException | IOException e) {
		}
		this.latitude = latlng.get(0);
		this.longitude = latlng.get(1);
	}
}
