package com.DeliveryDispatch.Boundaries;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.DeliveryDispatch.Entities.EmployeeRole;

@Component
public interface EmployeeRoleDAO extends CrudRepository<EmployeeRole, Integer>{

}
