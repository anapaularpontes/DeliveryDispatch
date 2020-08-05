package com.DeliveryDispatch.Controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.DeliveryDispatch.Boundaries.DeliveryDAO;
import com.DeliveryDispatch.Boundaries.DeliverySequenceDAO;
import com.DeliveryDispatch.Boundaries.EmployeeDAO;
import com.DeliveryDispatch.Boundaries.EmployeeScheduleDAO;
import com.DeliveryDispatch.Boundaries.JsonReader;
import com.DeliveryDispatch.Boundaries.RestaurantDAO;
import com.DeliveryDispatch.Entities.Delivery;
import com.DeliveryDispatch.Entities.DeliverySequence;
import com.DeliveryDispatch.Entities.Employee;
import com.DeliveryDispatch.Entities.EmployeeSchedule;
import com.DeliveryDispatch.Entities.Restaurant;

@Controller
public class DeliveryController {
	
	@Autowired
	DeliveryDAO deliveryDAO;
	
	@Autowired
	RestaurantDAO restaurantDAO;
	
	@Autowired
	EmployeeScheduleDAO scheduleDAO;
	
	@Autowired
	DeliverySequenceDAO sequenceDAO;

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
		return "deliveries/add";
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
	
	@PutMapping("/deliveries/today")
	public String updateTodaysDelivery(@ModelAttribute Delivery delivery) {
		Delivery delivery_db = deliveryDAO.findById(delivery.getId()).get();
		delivery_db.setRestaurant(delivery.getRestaurant());
		delivery_db.setDeliveryDate(delivery.getDeliveryDate());
		delivery_db.setTiming(delivery.getTiming());
		delivery_db.setInstructions(delivery.getInstructions());
		deliveryDAO.save(delivery_db);
		return "redirect:/todays_deliveries";
	}
	
	@PutMapping("/assigndrivers")
	public String assignDriver(@RequestParam (value="Id") String deliveryId, @RequestParam (value="Employee") String scheduleId) {
		Delivery delivery_db = deliveryDAO.findById(Integer.parseInt(deliveryId)).get();
		EmployeeSchedule schedule_db = scheduleDAO.findById(Integer.parseInt(scheduleId)).get();
		delivery_db.setDriverSchedule(schedule_db);
		deliveryDAO.save(delivery_db);
		return "redirect:/assigndrivers";
	}

	@DeleteMapping("/deliveries")
	public String deleteDelivery(@ModelAttribute Delivery delivery) {
		deliveryDAO.delete(delivery);
		return "redirect:/deliveries";
	}
	
	@DeleteMapping("/deliveries/today")
	public String deleteTodaysDelivery(@ModelAttribute Delivery delivery) {
		deliveryDAO.delete(delivery);
		return "redirect:/todays_deliveries";
	}

	@GetMapping("/deliveries/{id}")
	@ResponseBody
	public Delivery seekDelivery(@PathVariable String id) {
		try {
			return deliveryDAO.findById(Integer.parseInt(id)).get();
		} catch(Exception ex) {
			return new Delivery();
		}
	}
	
	@GetMapping("/deliveries/today")
	public String todaysDeliveries(Model model) {
		model.addAttribute("delivery", new Delivery());
		return "deliveries/todays_deliveries";
	}
	
	@GetMapping("/assigndrivers")
	public String assignDrivers(Model model) {
		model.addAttribute("delivery", new Delivery());
		return "deliveries/assigndrivers";
	}
	
	@GetMapping("/deliveries/createsequence")
	public String createSequence(Model model) {
		
		List<Delivery> deliverySequence  = new ArrayList<>();
		List<Delivery> deliveriesList = new ArrayList<>();
		List<Delivery> deliveriesListTemp = new ArrayList<>();
		/*List<Delivery> todaysDeliveries = new ArrayList<>();
		List<DeliverySequence> todaysSequences = new ArrayList<>();
		deliveryDAO.getTodaysDeliveries().forEach(todaysDeliveries::add);
		sequenceDAO.getAllTodaysSequences().forEach(todaysSequences::add);
		
		// Remove Deliveries that already are in a sequence
		if(!todaysSequences.isEmpty()) {
			for(DeliverySequence duplicated : todaysSequences) {
				todaysDeliveries.remove(duplicated);
			}
		}*/
		
		JsonReader reader = new JsonReader();
		
		for(EmployeeSchedule es : scheduleDAO.getTodaysSchedules()) {
			deliveriesList.clear();
			deliveriesListTemp.clear();
			for(Delivery d : deliveryDAO.getTodaysDeliveries()) {
				if(d.getDriverSchedule().getEmployee() == es.getEmployee()) {
					deliveriesList.add(d);
					deliveriesListTemp.add(d);
				}	
			}
			
			// Get distance from API
			String destination = "";
			String starting = "700+Royal+Ave,+New+Westminster";
			for(int i = 0; i < deliveriesList.size(); i++) {
				Delivery deliveryTemp = new Delivery();
				double lowerDistance= 1000.0;
				for(Delivery d : deliveriesListTemp) {
					
					
					destination = d.getRestaurant().getAddress() + ",+" + d.getRestaurant().getCity().getName();
					destination = destination.replaceAll(" ", "+");
					double distance = 0.0;
					try {
						distance = reader.getDistance(
								"http://www.mapquestapi.com/directions/v2/route?key=AJfdGQw929GI18MEVWAcTOw0caziblVy&from="
										+ starting + "&to=" + destination);
					} catch (JSONException | IOException e) { }
					
					if (lowerDistance > distance) {
						deliveryTemp = d;
						lowerDistance = distance;
					}
				}
				deliverySequence.add(deliveryTemp);
				deliveriesListTemp.remove(deliveryTemp);
				starting = deliveryTemp.getRestaurant().getAddress() +",+" + deliveryTemp.getRestaurant().getCity().getName();
				starting = starting.replaceAll(" ", "+");
				
			}
			
			// Don't create a delivery sequence for empty sequence
			if(!deliverySequence.isEmpty()) {
				DeliverySequence sequence = new DeliverySequence();
				sequence.setEmployee(es.getEmployee());
				sequence.setDeliveries(deliverySequence);
				sequenceDAO.save(sequence);
				for(Delivery delivery: sequence.getDeliveries()) {
					System.out.println("+> "+delivery.getRestaurant().getName());
					System.out.println("   "+delivery.getId());
				}
			}
			
			deliverySequence.clear();
			
		}
		return "redirect:/deliveries/sequences";
	}
	
	@GetMapping("/deliveries/sequences")
	public String showSequences(Model model) {
		model.addAttribute("sequences", sequenceDAO.findAll());
		return "deliveries/sequences";
	}
	
	@GetMapping("/deliveries/sequence/{id}/detail")
	public String showSequenceDetail(@PathVariable String id, Model model) {
		model.addAttribute("sequence", sequenceDAO.findById(Integer.parseInt(id)).get());
		return "deliveries/sequencedetail";
	}
	
	@GetMapping("/api/sequence/{id}")
	public ResponseEntity<List<Delivery>> getCoordinates(@PathVariable String id) {
		return ResponseEntity.ok(sequenceDAO.findById(Integer.parseInt(id)).get().getDeliveries());
	}
	
	@ModelAttribute("todaysDeliveries")
	public Iterable<Delivery> getTodaysDeliveries() {
		return deliveryDAO.getTodaysDeliveries();
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
	
	@ModelAttribute("todaysSchedules")
	public Iterable<EmployeeSchedule> getSchedules() {
		return scheduleDAO.getTodaysSchedules();
	}

}
