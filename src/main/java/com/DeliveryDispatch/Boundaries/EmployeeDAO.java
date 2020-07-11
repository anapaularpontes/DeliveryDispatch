package com.DeliveryDispatch.Boundaries;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.DeliveryDispatch.Entities.Employee;


@Component
public interface EmployeeDAO extends CrudRepository<Employee, Integer>{
	
	@Query("SELECT e FROM Employee e WHERE e.active = true ORDER BY e.firstName")
	Iterable<Employee> getAllEmployees();

	@Query(value="SELECT * FROM Employee WHERE role_id = 3 AND active = true ORDER BY firstName", nativeQuery = true)
	Iterable<Employee> findDrivers();

}
