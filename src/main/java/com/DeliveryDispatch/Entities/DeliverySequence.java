package com.DeliveryDispatch.Entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OrderColumn;

@Entity
public class DeliverySequence {
	
	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id = 0;
	@ManyToOne
	@JoinColumn(name="employee_id")
	private Employee employee;
	@ElementCollection
	@CollectionTable(name = "deliveries", joinColumns=@JoinColumn(name="delivery_id"))
	@OrderColumn(name="sequence")
	private List<Delivery> deliveries;
	
	public DeliverySequence() {
		super();
	}
	
	public DeliverySequence(Employee employee, List<Delivery> deliveries) {
		super();
		this.employee = employee;
		this.deliveries = deliveries;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Employee getEmployee() {
		return employee;
	}
	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public List<Delivery> getDeliveries() {
		return deliveries;
	}
	
	public void setDeliveries(List<Delivery> deliveries) {
		this.deliveries = deliveries;
	}

}
