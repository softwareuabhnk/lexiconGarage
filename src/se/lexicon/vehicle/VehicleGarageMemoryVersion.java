package se.lexicon.vehicle;

import java.util.TreeMap;

import se.lexicon.exception.VehicleGarageFullException;
import se.lexicon.exception.VehicleNotFoundException;

public class VehicleGarageMemoryVersion implements VehicleGarageInterface {

	private TreeMap<String, Vehicle> vehicleMap;
	private int maxGarageCapacity;

	public VehicleGarageMemoryVersion() {
		vehicleMap = new TreeMap<String, Vehicle>();

	}

	public  void addVehicle(Vehicle newVehicle) throws VehicleGarageFullException {
		
		//TODO: Check of maxNumberOfCapacity is exceeded
		
		
		if (vehicleMap.size() < maxGarageCapacity) {
		
		vehicleMap.put(newVehicle.getRegistrationNumber(), newVehicle);
		
		} else {
			throw new VehicleGarageFullException();
		}

	}
	
	public  void removeVehicle(String registrationNumber) {
		
		vehicleMap.remove(registrationNumber);
		System.out.println("Vehicle with regNumber removed:" + registrationNumber );

	}
	

	public Vehicle findVehicle(String registrationNumber) throws VehicleNotFoundException {

		registrationNumber = registrationNumber.trim();

		for (Vehicle nextVehicle : vehicleMap.values()) {

			if (nextVehicle.getRegistrationNumber().equalsIgnoreCase(registrationNumber)) {
				return nextVehicle;
			}

		}

		System.out.println("Registration number not found");
		throw new VehicleNotFoundException();
	}
	
	public TreeMap getVehicleMap() {
		return vehicleMap;
	}
	
	public void setVehicleGarageCapacity(int capacity) {
		maxGarageCapacity = capacity;
		
	}
	
	
}
