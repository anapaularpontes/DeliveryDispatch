package com.DeliveryDispatch.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * A class that represents the roles of employees
 * 
 * @author Ana Paula Pontes
 *
 */
@Entity
public class EmployeeRole {

	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private int id = 0;
	private String name = "";
	private boolean active = true;

	public EmployeeRole() {
		super();
	}

	public EmployeeRole(String name) {
		super();
		this.name = name;
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
