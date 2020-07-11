package com.DeliveryDispatch.Controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
import com.DeliveryDispatch.Boundaries.EmployeeScheduleDAO;
import com.DeliveryDispatch.Entities.Employee;
import com.DeliveryDispatch.Entities.EmployeeSchedule;


@Controller
public class EmployeeScheduleController {
	
	@Autowired
	EmployeeScheduleDAO scheduleDAO;
	
	@Autowired
	EmployeeDAO employeeDAO;
	
	@GetMapping("/schedules")
	public String ShowAll(Model model) {
		model.addAttribute("schedule", new EmployeeSchedule());
		return "schedules/schedules";
	}
	
	@ModelAttribute("schedules")
	public Iterable<EmployeeSchedule> getAll() {
		return scheduleDAO.getAllSchedules();
	}
	
	@PostMapping("/schedules")
	public String createSchedule(@ModelAttribute EmployeeSchedule schedule) {
		scheduleDAO.save(schedule);
		return "redirect:/schedules";
	}
	
	@PutMapping("/schedules")
	public String updateSchedule(@ModelAttribute EmployeeSchedule schedule) {
		EmployeeSchedule schedule_db = scheduleDAO.findById(schedule.getId()).get();
		schedule_db.setEmployee(schedule.getEmployee());
		schedule_db.setDate(schedule.getDate());
		schedule_db.setStartingTime(schedule.getStartingTime());
		scheduleDAO.save(schedule_db);
		return "redirect:/schedules";
	}

	@DeleteMapping("/schedules")
	public String deleteSchedule(@ModelAttribute EmployeeSchedule schedule) {
		scheduleDAO.delete(schedule);
		return "redirect:/schedules";
	}

	@GetMapping("/schedules/{id}")
	@ResponseBody
	public EmployeeSchedule seekSchedule(@PathVariable String id) {
		try {
			return scheduleDAO.findById(Integer.parseInt(id)).get();
		} catch(Exception ex) {
			return new EmployeeSchedule();
		}
	}
	
	@ModelAttribute("employees")
	public Iterable<Employee> getDrivers() {
		return employeeDAO.findDrivers();
	}
	
	@ModelAttribute("weekDays")
	public Iterable<Date> getWeekDays() {
		Date today = new Date(new Date().getTime());
		List<Date> weekDays= new ArrayList<>();
		weekDays.clear();
		switch (today.toString().substring(0,3)) {
			case "Mon":
				for(int i = 0; i <6; i++) {
					weekDays.add(java.sql.Date.valueOf(LocalDate.now().plusDays(i)));
				}
				break;
			case "Tue":
				for(int i = -1; i <5; i++) {
					weekDays.add(java.sql.Date.valueOf(LocalDate.now().plusDays(i)));
				}
				break;
			case "Wed":
				for(int i = -2; i <4; i++) {
					weekDays.add(java.sql.Date.valueOf(LocalDate.now().plusDays(i)));
				}
				break;
			case "Thu":
				for(int i = -3; i <3; i++) {
					weekDays.add(java.sql.Date.valueOf(LocalDate.now().plusDays(i)));
				}
				break;
			case "Fri":
				for(int i = -4; i <2; i++) {
					weekDays.add(java.sql.Date.valueOf(LocalDate.now().plusDays(i)));
				}
				break;
			case "Sat":
				for(int i = -5; i <1; i++) {
					weekDays.add(java.sql.Date.valueOf(LocalDate.now().plusDays(i)));
				}
				break;
		}
		return weekDays;
	}

}
