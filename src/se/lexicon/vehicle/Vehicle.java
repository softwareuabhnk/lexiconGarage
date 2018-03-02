package se.lexicon.vehicle;

import se.lexicon.utilities.VehichleType;

public abstract class Vehicle {
	
	private String registrationNumber;
	private String color;
	private int numberOfWheels;
	private VehichleType vehicleType;
		
	
	public Vehicle(String registrationNumber, String color, int numberOfWheels, VehichleType vehicleType) {
		//super();
		this.registrationNumber = registrationNumber;
		this.color = color;
		this.numberOfWheels = numberOfWheels;
		this.vehicleType = vehicleType;
	}


	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public String getColor() {
		return color;
	}

	public int getNumberOfWheels() {
		return numberOfWheels;
	}
	
	public VehichleType getVehicleType() {
		return vehicleType;
	}


	@Override
	public String toString() {
		return "Vehicle [registrationNumber=" + registrationNumber + ", color=" + color + ", numberOfWheels="
				+ numberOfWheels + "]";
	}
	
	

}
