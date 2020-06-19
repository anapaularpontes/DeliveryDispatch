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

import com.DeliveryDispatch.Boundaries.AreaDAO;
import com.DeliveryDispatch.Boundaries.CityDAO;
import com.DeliveryDispatch.Boundaries.RestaurantDAO;
import com.DeliveryDispatch.Entities.Area;
import com.DeliveryDispatch.Entities.City;
import com.DeliveryDispatch.Entities.Restaurant;

@Controller
public class RestaurantController {
	
	@Autowired
	RestaurantDAO restaurantDAO;
	
	@Autowired
	CityDAO cityDAO;
	
	@Autowired
	AreaDAO areaDAO;
	
	
	@GetMapping("/restaurants")
	public String ShowAll(Model model) {
		model.addAttribute("restaurant", new Restaurant());
		return "restaurants/restaurants";
	}
	
	@ModelAttribute("restaurants")
	public Iterable<Restaurant> getAll() {
		return restaurantDAO.getAllRestaurants();
	}
	
	@PostMapping("/restaurants")
	public String createRestaurant(@ModelAttribute Restaurant restaurant) {
		restaurantDAO.save(restaurant);
		return "redirect:/restaurants";
	}
	
	@PutMapping("/restaurants")
	public String updateRestaurant(@ModelAttribute Restaurant restaurant) {
		Restaurant restaurant_db = restaurantDAO.findById(restaurant.getId()).get();
		restaurant_db.setName(restaurant.getName());
		restaurant_db.setAddress(restaurant.getAddress());;
		restaurant_db.setCity(restaurant.getCity());
		restaurant_db.setArea(restaurant.getArea());;
		restaurantDAO.save(restaurant_db);
		return "redirect:/restaurants";
	}

	@DeleteMapping("/restaurants")
	public String deleteRestaurant(@ModelAttribute Restaurant restaurant) {
		Restaurant restaurant_db = restaurantDAO.findById(restaurant.getId()).get();
		restaurant_db.setActive(false);
		restaurantDAO.save(restaurant_db);
		return "redirect:/restaurants";
	}
	
	@GetMapping("/restaurants/{id}")
	@ResponseBody
	public Restaurant seekRestaurant(@PathVariable String id) {
		try {
			return restaurantDAO.findById(Integer.parseInt(id)).get();
		} catch(Exception ex) {
			return new Restaurant();
		}
	}
	
	@ModelAttribute("areas")
	public Iterable<Area> getAreas() {
		return areaDAO.getAllAreas();
	}
	
	@ModelAttribute("cities")
	public Iterable<City> getCities() {
		return cityDAO.getAllCities();
	}

}
