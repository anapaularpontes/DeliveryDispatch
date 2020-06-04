package com.DeliveryDispatch.Boundaries;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.DeliveryDispatch.Entities.Employee;


@Component
public interface EmployeeDAO extends CrudRepository<Employee, Integer>{

}
