package com.DeliveryDispatch.Entities;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Delivery {
	
	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="city_id")
	private int id = 0;
	@ManyToOne
	@JoinColumn(name="restaurant_id")
	private Restaurant restaurant;
	@Basic
	@Temporal(TemporalType.DATE)
	private Date deliveryDate;
	private String timing; //EARLY	MIDDAY	AFTERNOON
	private String instructions;

}
