package com.DeliveryDispatch.Boundaries;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.DeliveryDispatch.Entities.City;

@Component
public interface CityDAO extends CrudRepository<City, Integer>{

}
