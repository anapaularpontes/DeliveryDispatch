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

import com.DeliveryDispatch.Boundaries.CityDAO;
import com.DeliveryDispatch.Entities.City;

@Controller
public class CityController {
	
	@Autowired
	CityDAO cityDAO;
	
	
	@GetMapping("/cities")
	public String ShowAll(Model model) {
		model.addAttribute("city", new City());
		return "cities/cities";
	}
	
	@ModelAttribute("cities")
	public Iterable<City> getAll() {
		return cityDAO.getAllCities();
	}
	
	@PostMapping("/cities")
	public String createCity(@ModelAttribute City city) {
		cityDAO.save(city);
		return "redirect:/cities";
	}
	
	@PutMapping("/cities")
	public String updateCity(@ModelAttribute City city) {
		City city_db = cityDAO.findById(city.getId()).get();
		city_db.setName(city.getName());
		cityDAO.save(city_db);
		return "redirect:/cities";
	}

	@DeleteMapping("/cities")
	public String deleteCity(@ModelAttribute City city) {
		City city_db = cityDAO.findById(city.getId()).get();
		city_db.setActive(false);
		cityDAO.save(city_db);
		return "redirect:/cities";
	}

	@GetMapping("/cities/{id}")
	@ResponseBody
	public City seekCity(@PathVariable String id) {
		try {
			return cityDAO.findById(Integer.parseInt(id)).get();
		} catch(Exception ex) {
			return new City();
		}
	}

}
