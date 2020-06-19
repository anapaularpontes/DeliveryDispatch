package com.DeliveryDispatch.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Restaurant {
	
	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="restaurant_id")
	private int id = 0;
	private String name = "";
	private String address = "";
	@ManyToOne
	@JoinColumn(name="city_id")
	private City city;
	@ManyToOne
	@JoinColumn(name="area_id")
	private Area area;
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

	public void setAddress(String address) {
		this.address = address;
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
	
	
}
