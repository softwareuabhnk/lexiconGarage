package se.lexicon.vehicle;

import se.lexicon.utilities.VehichleType;
import se.lexicon.utilities.VehicleFuelType;

public class Motorcycle extends Vehicle {
	
	private VehicleFuelType fuelType;

	public Motorcycle(String registrationNumber, String color, int numberOfWheels, VehichleType vehicleType,
			VehicleFuelType fuelType) {
		super(registrationNumber, color, numberOfWheels, vehicleType);
		this.fuelType = fuelType;
	}

	@Override
	public String toString() {
		return "Motorcycle [fuelType=" + fuelType + ", getRegistrationNumber()=" + getRegistrationNumber()
				+ ", getColor()=" + getColor() + ", getNumberOfWheels()=" + getNumberOfWheels() + ", getVehicleType()="
				+ getVehicleType() + "]";
	}

	
}