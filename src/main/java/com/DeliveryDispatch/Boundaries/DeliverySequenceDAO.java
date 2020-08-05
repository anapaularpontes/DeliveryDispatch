package com.DeliveryDispatch.Boundaries;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.DeliveryDispatch.Entities.Delivery;
import com.DeliveryDispatch.Entities.DeliverySequence;

@Component
public interface DeliverySequenceDAO extends CrudRepository<DeliverySequence, Integer> {
	
	@Query(value= "SELECT * FROM DeliverySequence ORDER BY sequence ASC, employee DESC", nativeQuery = true)
	Iterable<DeliverySequence> getAllSequences();
	
	@Query(value= "SELECT * FROM DeliverySequence "
			+ "JOIN Delivery ON Delivery.delivery_id =  DeliverySequence.deliveries_delivery_id "
			+ "WHERE Delivery.deliveryDate = CURRENT_DATE() "
			+ "ORDER BY DeliverySequence.sequence ASC, DeliverySequence.employee DESC", nativeQuery = true)
	Iterable<DeliverySequence> getAllTodaysSequences();
}