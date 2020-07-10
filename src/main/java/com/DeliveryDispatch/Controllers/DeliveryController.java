package com.DeliveryDispatch.Controllers;

import java.util.Arrays;
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

import com.DeliveryDispatch.Boundaries.DeliveryDAO;
import com.DeliveryDispatch.Boundaries.RestaurantDAO;
import com.DeliveryDispatch.Entities.Delivery;
import com.DeliveryDispatch.Entities.Restaurant;

@Controller
public class DeliveryController {
	
	@Autowired
	DeliveryDAO deliveryDAO;
	
	@Autowired
	RestaurantDAO restaurantDAO;
	
	
	@GetMapping("/deliveries")
	public String ShowAll(Model model) {
		model.addAttribute("delivery", new Delivery());
		return "deliveries/deliveries";
	}
	
	@ModelAttribute("deliveries")
	public Iterable<Delivery> getAll() {
		return deliveryDAO.getAllDeliveries();
	}
	
	@GetMapping("/deliveries/add")
	public String addPage(Model model) {
		model.addAttribute("delivery", new Delivery());
		return "deliveries/deliveries_add";
	}
	
	@PostMapping("/deliveries/add")
	public String createDelivery(@ModelAttribute Delivery delivery) {
		deliveryDAO.save(delivery);
		return "redirect:/deliveries";
	}

	
	@PutMapping("/deliveries")
	public String updateDelivery(@ModelAttribute Delivery delivery) {
		Delivery delivery_db = deliveryDAO.findById(delivery.getId()).get();
		delivery_db.setRestaurant(delivery.getRestaurant());
		delivery_db.setDeliveryDate(delivery.getDeliveryDate());
		delivery_db.setTiming(delivery.getTiming());
		delivery_db.setInstructions(delivery.getInstructions());
		deliveryDAO.save(delivery_db);
		return "redirect:/deliveries";
	}

	@DeleteMapping("/deliveries")
	public String deleteDelivery(@ModelAttribute Delivery delivery) {
		deliveryDAO.delete(delivery);
		return "redirect:/deliveries";
	}

	@GetMapping("/deliveries/{id}")
	@ResponseBody
	public Delivery seekPath(@PathVariable String id) {
		try {
			return deliveryDAO.findById(Integer.parseInt(id)).get();
		} catch(Exception ex) {
			return new Delivery();
		}
	}
	
	@GetMapping("/deliveries/today")
	public String todaysDeliveries(Model model) {
		model.addAttribute("todaysDeliveries", deliveryDAO.getTodaysDeliveries());
		model.addAttribute("delivery", new Delivery());
		return "deliveries/todays_deliveries";
	}
	
	@ModelAttribute("restaurants")
	public Iterable<Restaurant> getAllRestaurants() {
		return restaurantDAO.getAllRestaurants();
	}
	
	@ModelAttribute("timings")
	public Iterable<String> getTimings() {
		List<String> timings =Arrays.asList("Early", "Midday", "Afternoon");
		return timings;
	}

}
