package com.DeliveryDispatch.Boundaries;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.DeliveryDispatch.Entities.Area;

/**
 * Extends CrudRepository for Area entity
 * 
 * @author Ana Paula Pontes
 *
 */
@Component
public interface AreaDAO extends CrudRepository<Area, Integer> {

	@Query("SELECT a FROM Area a WHERE a.active = true ORDER BY a.name")
	Iterable<Area> getAllAreas();

}
