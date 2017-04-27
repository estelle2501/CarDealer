package com.cardealer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public String AddCar(@ModelAttribute Car car) {
		return "add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String AddCar(@ModelAttribute("car") Car car, BindingResult result,
			Model model) {
		model.addAttribute("car", car);
		carService.addCar(car);
		return "redirect:/listCars";
	}

}
