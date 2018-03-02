package se.lexicon.vehicle;

import se.lexicon.utilities.VehichleType;

public class Boat extends Vehicle {
	
	private int cylendarVolume;

	public Boat(String registrationNumber, String color, int numberOfWheels, VehichleType vehicleType,
			int cylendarVolume) {
		super(registrationNumber, color, numberOfWheels, vehicleType);
		this.cylendarVolume = cylendarVolume;
	}

	@Override
	public String toString() {
		return "Boat [cylendarVolume=" + cylendarVolume + ", getRegistrationNumber()=" + getRegistrationNumber()
				+ ", getColor()=" + getColor() + ", getNumberOfWheels()=" + getNumberOfWheels() + ", getVehicleType()="
				+ getVehicleType() + "]";
	}
}
