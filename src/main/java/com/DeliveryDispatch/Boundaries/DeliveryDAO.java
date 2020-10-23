package com.DeliveryDispatch.Boundaries;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.DeliveryDispatch.Entities.Delivery;

/**
 * Extends CrudRepository for Delivery entity
 * 
 * @author Ana Paula Pontes
 *
 */
@Component
public interface DeliveryDAO extends CrudRepository<Delivery, Integer> {
	
	@Query("SELECT d FROM Delivery d ORDER BY d.deliveryDate DESC, d.restaurant ASC")
	Iterable<Delivery> getAllDeliveries();
	
	@Query(value="SELECT * FROM Delivery "
			+ "JOIN Restaurant ON Restaurant.restaurant_id = Delivery.restaurant_id "
			+ "WHERE Delivery.deliveryDate = CURRENT_DATE() "
			+ "ORDER BY Delivery.timing DESC, Restaurant.area_id ASC", nativeQuery = true)
	Iterable<Delivery> getTodaysDeliveries();

}