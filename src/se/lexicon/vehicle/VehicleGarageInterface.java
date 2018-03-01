package se.lexicon.vehicle;

import java.util.TreeMap;

import se.lexicon.exception.VehicleGarageFullException;
import se.lexicon.exception.VehicleNotFoundException;

public interface VehicleGarageInterface {
	
	public void addVehicle(Vehicle newVehicle) throws VehicleGarageFullException;
	
	public void removeVehicle(String registrationNumber);
	
	public TreeMap<String, Vehicle> getVehicleMap();
	
	public Vehicle findVehicle(String registrationNumber) throws VehicleNotFoundException;
	
	public void setVehicleGarageCapacity(int capacity);

}
