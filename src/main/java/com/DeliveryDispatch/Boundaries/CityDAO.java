package com.DeliveryDispatch.Boundaries;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.DeliveryDispatch.Entities.City;

/**
 * Extends CrudRepository for City entity
 * 
 * @author Ana Paula Pontes
 *
 */
@Component
public interface CityDAO extends CrudRepository<City, Integer> {

	@Query("SELECT c FROM City c WHERE c.active = true ORDER BY c.name")
	Iterable<City> getAllCities();

}
