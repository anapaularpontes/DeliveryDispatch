package com.DeliveryDispatch.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.DeliveryDispatch.Boundaries.EmployeeDAO;
import com.DeliveryDispatch.Boundaries.EmployeeRoleDAO;
import com.DeliveryDispatch.Entities.Employee;
import com.DeliveryDispatch.Entities.EmployeeRole;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeDAO employeeDAO;
	
	@Autowired
	EmployeeRoleDAO roleDAO;
	
	
	@GetMapping("/employees")
	public String ShowAll(Model model) {
		model.addAttribute("employee", new Employee());
		return "employees/employees";
	}
	
	@ModelAttribute("employees")
	public Iterable<Employee> getAll() {
		return employeeDAO.getAllEmployees();
	}
	
	@PostMapping("/employees")
	public String createEmployee(@ModelAttribute Employee employee) {
		employeeDAO.save(employee);
		return "redirect:/employees";
	}
	
	@PutMapping("/employees")
	public String updateEmployee(@ModelAttribute Employee employee) {
		Employee employee_db = employeeDAO.findById(employee.getId()).get();
		employee_db.setFirstName(employee.getFirstName());
		employee_db.setLastName(employee.getLastName());
		employee_db.setRole(employee.getRole());
		employeeDAO.save(employee_db);
		return "redirect:/employees";
	}

	@DeleteMapping("/employees")
	public String deleteEmployee(@ModelAttribute Employee employee) {
		Employee employee_db = employeeDAO.findById(employee.getId()).get();
		employee_db.setActive(false);
		employeeDAO.save(employee_db);
		return "redirect:/employees";
	}

	@GetMapping("/employees/{id}")
	@ResponseBody
	public Employee seekEmployee(@PathVariable String id) {
		try {
			return employeeDAO.findById(Integer.parseInt(id)).get();
		} catch(Exception ex) {
			return new Employee();
		}
	}
	
	@ModelAttribute("roles")
	public Iterable<EmployeeRole> getAllRoles() {
		return roleDAO.getAllRoles();
	}

}
