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
import com.DeliveryDispatch.Entities.Area;

@Controller
public class AreaController {
	
	@Autowired
	AreaDAO areaDAO;
	
	
	@GetMapping("/areas")
	public String ShowAll(Model model) {
		model.addAttribute("area", new Area());
		return "areas/areas";
	}
	
	@ModelAttribute("areas")
	public Iterable<Area> getAll() {
		return areaDAO.getAllAreas();
	}
	
	@PostMapping("/areas")
	public String createArea(@ModelAttribute Area area) {
		areaDAO.save(area);
		return "redirect:/areas";
	}
	
	@PutMapping("/areas")
	public String updateArea(@ModelAttribute Area area) {
		Area area_db = areaDAO.findById(area.getId()).get();
		area_db.setName(area.getName());
		areaDAO.save(area_db);
		return "redirect:/areas";
	}

	@DeleteMapping("/areas")
	public String deleteArea(@ModelAttribute Area area) {
		Area area_db = areaDAO.findById(area.getId()).get();
		area_db.setActive(false);
		areaDAO.save(area_db);
		return "redirect:/areas";
	}

	@GetMapping("/areas/{id}")
	@ResponseBody
	public Area seekArea(@PathVariable String id) {
		try {
			return areaDAO.findById(Integer.parseInt(id)).get();
		} catch(Exception ex) {
			return new Area();
		}
	}


}
