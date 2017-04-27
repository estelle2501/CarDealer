package com.cardealer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cardealer.model.Car;
import com.cardealer.service.CarService;

@Controller
public class CarController {

	@Autowired
	CarService carService;

	@RequestMapping("/add")
	public ModelAndView addCar (@ModelAttribute Car car){
		return new ModelAndView("add", "car", car);
	}
	
	@RequestMapping("/insert")  
	 public String insertCar(@ModelAttribute Car car) {  
		if (car != null) {
			carService.addCar(car);
		} 
	  return "redirect:/listCars";  
	 }  

	@RequestMapping("/listCars")
	public ModelAndView listCars() {
		List<Car> carList = carService.listCars();
		return new ModelAndView("carList", "carList", carList);
	}

}
