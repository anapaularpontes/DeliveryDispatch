package com.DeliveryDispatch.Boundaries;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.DeliveryDispatch.Entities.Delivery;
import com.DeliveryDispatch.Entities.DeliverySequence;

@Component
public interface DeliverySequenceDAO extends CrudRepository<DeliverySequence, Integer> {
	
	@Query(value= "SELECT * FROM DeliverySequence ORDER BY employee ASC, sequence ASC", nativeQuery = true)
	Iterable<DeliverySequence> getAllSequences();
}