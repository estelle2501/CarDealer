package com.cardealer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cardealer.model.Car;
import com.cardealer.service.CarService;

@Controller
public class CarController {

	@Autowired
	CarService carService;

	@RequestMapping("/listCars")
	public String listCars(Model model) {
		model.addAttribute("carList", carService.listCars());
		return "carList";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String showAddCar(@ModelAttribute Car car) {
		return "add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addCar(@ModelAttribute("car") Car car, BindingResult result,
			Model model) {
		model.addAttribute("car", car);
		carService.addCar(car);
		return "redirect:/listCars";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String showDeleteCar(@PathVariable("id") int id, Model model  ) {
		model.addAttribute("car", carService.getCarById(id));	
		return  "delete";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public String deleteCar(@ModelAttribute("car") Car car, BindingResult result,
			Model model) {
		model.addAttribute("car", car);
		carService.deleteCar(car.getId());
		return  "redirect:/listCars";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String showEditCar(@PathVariable("id") int id  , Model model) {
		model.addAttribute("car", carService.getCarById(id));	
		return "edit";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String editCar(@ModelAttribute("car") Car car, BindingResult result,
			Model model) {
		model.addAttribute("car", car);
		carService.updateCar(car);
		return "redirect:/listCars";
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accessDenied() {

		ModelAndView model = new ModelAndView();

		// check if user is login
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			model.addObject("username", userDetail.getUsername());
		}

		model.setViewName("403");
		return model;
	}
	
}
