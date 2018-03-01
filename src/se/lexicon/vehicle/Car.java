package se.lexicon.vehicle;

import se.lexicon.utilities.VehichleType;

public class Car extends Vehicle{
	
	private int numberOfSeats;

	public Car(String registrationNumber, String color, int numberOfWheels, VehichleType vehicleType,
			int numberOfSeats) {
		super(registrationNumber, color, numberOfWheels, vehicleType);
		this.numberOfSeats = numberOfSeats;
	}

	@Override
	public String toString() {
		return "Car [numberOfSeats=" + numberOfSeats + ", getRegistrationNumber()=" + getRegistrationNumber()
				+ ", getColor()=" + getColor() + ", getNumberOfWheels()=" + getNumberOfWheels() + ", getVehicleType()="
				+ getVehicleType() + "]";
	}

	
}
