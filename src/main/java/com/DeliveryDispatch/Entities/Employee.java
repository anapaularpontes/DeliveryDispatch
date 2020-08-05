package com.DeliveryDispatch.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.jasypt.util.password.StrongPasswordEncryptor;

@Entity
public class Employee {

	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="employee_id")
	private int id = 0;
	private String firstName = "";
	private String lastName = "";
	private String username = "";
	private String password = "";
	@ManyToOne
	@JoinColumn(name="role_id")
	private EmployeeRole role;
	private boolean active = true;
	
	public Employee() {
		super();
	}

	public Employee(String firstName, String lastName, String username, String password,
			EmployeeRole role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = encodePassword(password);
		this.role = role;
		this.active = true;
	}
	
	public Employee(String firstName, String lastName, EmployeeRole role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.active = true;
		this.username = role.getName().concat(Integer.toString(id));
		this.password = encodePassword("pass1234");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String encodePassword(String strToEncrypt) {
		StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
		return passwordEncryptor.encryptPassword(strToEncrypt);
	}
	
	public boolean validatePassword(String typedPassword) {
		StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
		return passwordEncryptor.checkPassword(typedPassword, password);
	}
	
	public void setPassword(String password) {
		this.password = encodePassword(password);
	}

	public EmployeeRole getRole() {
		return role;
	}

	public void setRole(EmployeeRole role) {
		this.role = role;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	
}
