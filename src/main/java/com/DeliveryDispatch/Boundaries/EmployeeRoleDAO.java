package com.DeliveryDispatch.Boundaries;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.DeliveryDispatch.Entities.EmployeeRole;

/**
 * Extends CrudRepository for EmployeeRole entity
 * 
 * @author Ana Paula Pontes
 *
 */
@Component
public interface EmployeeRoleDAO extends CrudRepository<EmployeeRole, Integer> {

	@Query("SELECT r FROM EmployeeRole r WHERE r.active = true ORDER BY r.name")
	Iterable<EmployeeRole> getAllRoles();

}
