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

import com.DeliveryDispatch.Boundaries.EmployeeRoleDAO;
import com.DeliveryDispatch.Entities.EmployeeRole;

@Controller
public class EmployeeRoleController {
	
	@Autowired
	EmployeeRoleDAO roleDAO;
	
	
	@GetMapping("/roles")
	public String ShowAll(Model model) {
		model.addAttribute("role", new EmployeeRole());
		return "roles/roles";
	}
	
	@ModelAttribute("roles")
	public Iterable<EmployeeRole> getAll() {
		return roleDAO.getAllRoles();
	}
	
	@PostMapping("/roles")
	public String createRole(@ModelAttribute EmployeeRole role) {
		roleDAO.save(role);
		return "redirect:/roles";
	}
	
	@PutMapping("/roles")
	public String updateRole(@ModelAttribute EmployeeRole role) {
		EmployeeRole role_db = roleDAO.findById(role.getId()).get();
		role_db.setName(role.getName());
		roleDAO.save(role_db);
		return "redirect:/roles";
	}

	@DeleteMapping("/roles")
	public String deleteRole(@ModelAttribute EmployeeRole role) {
		EmployeeRole role_db = roleDAO.findById(role.getId()).get();
		role_db.setActive(false);
		roleDAO.save(role_db);
		return "redirect:/roles";
	}

	@GetMapping("/roles/{id}")
	@ResponseBody
	public EmployeeRole seekRole(@PathVariable String id) {
		try {
			return roleDAO.findById(Integer.parseInt(id)).get();
		} catch(Exception ex) {
			return new EmployeeRole();
		}
	}

}
