package com.DeliveryDispatch.Boundaries;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.DeliveryDispatch.Entities.Restaurant;

@Component
public interface RestaurantDAO extends CrudRepository<Restaurant, Integer>{

}