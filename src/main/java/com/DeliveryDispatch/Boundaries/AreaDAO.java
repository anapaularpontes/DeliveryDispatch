package com.DeliveryDispatch.Boundaries;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.DeliveryDispatch.Entities.Area;

@Component
public interface AreaDAO extends CrudRepository<Area, Integer>{

}
