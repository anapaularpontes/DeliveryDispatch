package com.DeliveryDispatch.Controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.DeliveryDispatch.Boundaries.EmployeeDAO;
import com.DeliveryDispatch.Entities.Employee;

@Controller 
public class WebSecurityController {
	
	@Autowired
	EmployeeDAO employeeDAO;
    
	// Login form  
    @PostMapping("/") 
	public String login(@RequestParam (value="username") String username, @RequestParam (value="password") String password, Model model){
		Employee employee = employeeDAO.findByUsername(username).get();

		if(employee != null && employee.validatePassword(password)) {
			return "redirect:/deliveries";
		}
		return "index/index";
	}
    
    @GetMapping("/logout")
	public String logout(HttpSession session) {
    	//Employee employee = (Employee) session.getAttribute("employee");
	    //session.removeAttribute("employee");
	    return "redirect:/";
	}

}
