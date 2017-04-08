package com.cardealer.model;

public class Car {

	private static final int MAX_LENGTH_20= 20;
	private static final int MAX_LENGTH_10 = 10;
	
	private int id;
	private String make;
	private String model;
	private int year;
	private String fuel;
	private float engine;
	private String gearbox;
	private String color;
	private int kilometer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) throws InvalidLenghtException {
		if (make.length() <= MAX_LENGTH_20) {
			this.make = make;
		} else {
			throw new InvalidLenghtException("make");
		}
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) throws InvalidLenghtException{
		if(fuel.length() >= MAX_LENGTH_10){
			this.fuel = fuel;			
		}else{
			throw new InvalidLenghtException("fuel");
		}
	}

	public float getEngine() {
		return engine;
	}

	public void setEngine(float engine) {
		this.engine = engine;
	}

	public String getGearbox() {
		return gearbox;
	}

	public void setGearbox(String gearbox) throws InvalidLenghtException{
		if(gearbox.length() <= MAX_LENGTH_10){
			this.gearbox = gearbox;			
		}else{
			throw new InvalidLenghtException("gearbox");
		}
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) throws InvalidLenghtException{
		if (color.length() <= MAX_LENGTH_20){
			this.color = color;			
		}else{
			throw new InvalidLenghtException("color");
		}
	}

	public int getKilometer() {
		return kilometer;
	}

	public void setKilometer(int kilometer) {
		this.kilometer = kilometer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) throws InvalidLenghtException{
		if(model.length() <= MAX_LENGTH_20){
			this.model = model;			
		}else{
			throw new InvalidLenghtException("model");
		}
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", make=" + make + ", model=" + model
				+ ", year=" + year + ", fuel=" + fuel + ", engine=" + engine
				+ ", gearbox=" + gearbox + ", color=" + color + ", kilometer="
				+ kilometer + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
