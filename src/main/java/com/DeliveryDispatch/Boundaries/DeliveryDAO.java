package com.DeliveryDispatch.Boundaries;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.DeliveryDispatch.Entities.Delivery;


@Component
public interface DeliveryDAO extends CrudRepository<Delivery, Integer> {
	
	@Query("SELECT d FROM Delivery d ORDER BY d.deliveryDate DESC")
	Iterable<Delivery> getAllDeliveries();
	
	@Query("SELECT d FROM Delivery d WHERE d.deliveryDate = CURRENT_DATE()")
	Iterable<Delivery> getTodaysDeliveries();
	
	/*ORDER BY r.name*/

}