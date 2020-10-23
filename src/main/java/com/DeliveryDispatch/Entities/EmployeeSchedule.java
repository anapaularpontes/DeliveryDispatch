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
 * A class that represents the schedule of an employee
 * 
 * @author Ana Paula Pontes
 *
 */
@Entity
public class EmployeeSchedule {

	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "schedule_id")
	private int id = 0;
	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	@DateTimeFormat(pattern = "HH:mm")
	private Date startingTime;

	public EmployeeSchedule() {
		super();
	}

	public EmployeeSchedule(Employee employee, Date date, Date startingTime) {
		super();
		this.employee = employee;
		this.date = date;
		this.startingTime = startingTime;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getStartingTime() {
		return startingTime;
	}

	public void setStartingTime(Date startingTime) {
		this.startingTime = startingTime;
	}
}
