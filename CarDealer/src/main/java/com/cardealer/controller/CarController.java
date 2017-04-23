package com.cardealer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cardealer.model.Car;
import com.cardealer.service.CarService;

@Controller
public class CarController {

	@Autowired
	CarService carService;

//	@Autowired(required = true)
//	@Qualifier(value = "carService")
//	public void setCarService(CarService cs) {
//		this.carService = cs;
//	}
//
//	@RequestMapping(value = "/cars", method = RequestMethod.GET)
//	public String listsCars(Model model) {
//		model.addAttribute("car", new Car());
//		model.addAttribute("listCars", this.carService.listCars());
//		return "car";
//	}

	@RequestMapping(value = "/add")
	public String addCar(@ModelAttribute Car car) {
		if (car !=null) {
			carService.addCar(car);
		} 
		return "redirect:/listCars";

	}
	
	 @RequestMapping("/listCars")  
	 public ModelAndView listCars() {  
	  List<Car> carList = carService.listCars();  
	  return new ModelAndView("carList", "carList", carList);  
	 }  

//	@RequestMapping("/remove/{id}")
//	public String deleteCar(@PathVariable("id") int id) {
//
//		this.carService.deleteCar(id);
//		return "redirect:/cars";
//	}
//
//	@RequestMapping("/edit/{id}")
//	public String editCar(@PathVariable("id") int id, Model model) {
//		model.addAttribute("car", this.carService.getCarById(id));
//		model.addAttribute("listCars", this.carService.listCars());
//		return "car";
//	}

}
