package com.DeliveryDispatch.Entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Delivery {
	
	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id = 0;
	@ManyToOne
	@JoinColumn(name="restaurant_id")
	private Restaurant restaurant;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date deliveryDate;
	private String timing = ""; //EARLY	MIDDAY	AFTERNOON
	private String instructions = "";
	
	public Delivery() {
		super();
	}
	
	public Delivery(Restaurant restaurant, Date deliveryDate, String timing, String instructions) {
		super();
		this.restaurant = restaurant;
		this.deliveryDate = deliveryDate;
		this.timing = timing;
		this.instructions = instructions;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Restaurant getRestaurant() {
		return restaurant;
	}
	
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	
	public String getTiming() {
		return timing;
	}
	
	public void setTiming(String timing) {
		this.timing = timing;
	}
	
	public String getInstructions() {
		return instructions;
	}
	
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

}
