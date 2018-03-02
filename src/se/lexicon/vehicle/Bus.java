package se.lexicon.vehicle;

import se.lexicon.utilities.VehichleType;

public class Bus extends Vehicle{
	
	private int length;

	public Bus(String registrationNumber, String color, int numberOfWheels, VehichleType vehicleType, int length) {
		super(registrationNumber, color, numberOfWheels, vehicleType);
		this.length = length;
	}

	@Override
	public String toString() {
		return "Bus [length=" + length + ", getRegistrationNumber()=" + getRegistrationNumber() + ", getColor()="
				+ getColor() + ", getNumberOfWheels()=" + getNumberOfWheels() + ", getVehicleType()=" + getVehicleType()
				+ "]";
	}
	
	

}
