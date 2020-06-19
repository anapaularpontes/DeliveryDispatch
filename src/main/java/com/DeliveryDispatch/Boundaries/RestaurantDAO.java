package com.DeliveryDispatch.Boundaries;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.DeliveryDispatch.Entities.Restaurant;

@Component
public interface RestaurantDAO extends CrudRepository<Restaurant, Integer>{
	
	@Query("SELECT r FROM Restaurant r WHERE r.active = true ORDER BY r.name")
	Iterable<Restaurant> getAllRestaurants();

}