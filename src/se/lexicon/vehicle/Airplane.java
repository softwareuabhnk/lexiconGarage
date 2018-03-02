package se.lexicon.vehicle;

import se.lexicon.utilities.VehichleType;

public class Airplane extends Vehicle{
	
	private int numberOfEngines;

	public Airplane(String registrationNumber, String color, int numberOfWheels, VehichleType vehicleType,
			int numberOfEngines) {
		super(registrationNumber, color, numberOfWheels, vehicleType);
		this.numberOfEngines = numberOfEngines;
	}

	@Override
	public String toString() {
		return "Airplane [numberOfEngines=" + numberOfEngines + ", getRegistrationNumber()=" + getRegistrationNumber()
				+ ", getVehicleType()=" + getVehicleType() + "]";
	}
	

	
	
}
