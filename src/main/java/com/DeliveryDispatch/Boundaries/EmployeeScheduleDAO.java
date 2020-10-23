package com.DeliveryDispatch.Boundaries;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.DeliveryDispatch.Entities.EmployeeSchedule;

/**
 * Extends CrudRepository for EmployeeSchedule entity
 * 
 * @author Ana Paula Pontes
 *
 */
@Component
public interface EmployeeScheduleDAO extends CrudRepository<EmployeeSchedule, Integer> {

	@Query("SELECT s FROM EmployeeSchedule s ORDER BY s.date DESC, s.startingTime ASC")
	Iterable<EmployeeSchedule> getAllSchedules();

	@Query("SELECT s FROM EmployeeSchedule s WHERE s.date = CURRENT_DATE() ORDER BY s.startingTime ASC")
	Iterable<EmployeeSchedule> getTodaysSchedules();
}
