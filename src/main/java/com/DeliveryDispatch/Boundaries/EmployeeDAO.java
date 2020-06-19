package com.DeliveryDispatch.Boundaries;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.DeliveryDispatch.Entities.Employee;


@Component
public interface EmployeeDAO extends CrudRepository<Employee, Integer>{
	
	@Query("SELECT e FROM Employee e WHERE e.active = true ORDER BY e.firstName")
	Iterable<Employee> getAllEmployees();

}
