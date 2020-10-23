package com.DeliveryDispatch.Entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * A class that represents a delivery to a restaurant
 * 
 * @author Ana Paula Pontes
 *
 */
@Entity
public class Delivery {

	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "delivery_id")
	private int id = 0;
	@ManyToOne
	@JoinColumn(name = "restaurant_id")
	private Restaurant restaurant;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date deliveryDate;
	private String timing = ""; // EARLY MIDDAY AFTERNOON
	private String instructions = "";
	@ManyToOne
	@JoinColumn(name = "schedule_id")
	private EmployeeSchedule driverSchedule;
	// private boolean sequence = false;

	public Delivery() {
		super();
	}

	public Delivery(Restaurant restaurant, Date deliveryDate, String timing, String instructions) {
		super();
		this.restaurant = restaurant;
		this.deliveryDate = deliveryDate;
		this.timing = timing;
		this.instructions = instructions;
		// this.sequence = false;
	}

	public Delivery(Restaurant restaurant, Date deliveryDate, String timing, String instructions,
			EmployeeSchedule driverSchedule) {
		super();
		this.restaurant = restaurant;
		this.deliveryDate = deliveryDate;
		this.timing = timing;
		this.instructions = instructions;
		this.driverSchedule = driverSchedule;
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

	public EmployeeSchedule getDriverSchedule() {
		return driverSchedule;
	}

	public void setDriverSchedule(EmployeeSchedule driverSchedule) {
		this.driverSchedule = driverSchedule;
	}
}
