package se.lexicon.ui;

import java.util.Scanner;
import java.util.TreeMap;

import se.lexicon.vehicle.VehicleGarageMemoryVersion;
import se.lexicon.exception.VehicleGarageFullException;
import se.lexicon.exception.VehicleNotFoundException;
import se.lexicon.utilities.VehichleType;
import se.lexicon.utilities.VehicleStatusType;
import se.lexicon.vehicle.Car;
import se.lexicon.vehicle.Vehicle;
import se.lexicon.vehicle.VehicleGarageInterface;

public class UserInterface {

	VehicleGarageInterface vehicleGarage = new VehicleGarageMemoryVersion();

	public void printHeader() {
		System.out.println("Wellcome to Vehicle Garage parking");
	}

	public void printDialog() {

		System.out.println(" 1 - Park your Vehicle");
		System.out.println(" 2 - Unpark your Vehicle");
		System.out.println(" 3 - List all parked Vehicles");
		System.out.println(" 4 - List all types of parked Vehicles");
		System.out.println(" 5 - Search for Vehicle");
		System.out.println(" 6 - Set Vehicle Garage capacity");
		System.out.println(" 7 - Exit Vehicle Garage parking");
	}

	public void start() {
		int errandNo;
		Scanner sc = new Scanner(System.in);

		do {
			printDialog();
			System.out.println("Enter your Errand");
			String stringErrandNo = sc.next();
			System.out.println("Errand number:" + stringErrandNo);
			errandNo = Integer.parseInt(stringErrandNo);

			switch (errandNo) {
			case 1:
				parkYOurVehicle();
				break;
			case 2:
				unparkYourVehicle();
				break;
			case 3:
				listAllParkedVehicles();
				break;
			case 4:
				listAllTypesOfParkedVehicles();
				break;
			case 5:
				searchForVehicle();
				break;
			case 6:
				setVehicleGarageCapacity();
				break;
			default:
				errandNo = 7;
			}

		} while (errandNo != 7);

		sc.close();

	}

	private void listAllParkedVehicles() {
		System.out.println("List all parked vehicles");
		TreeMap<String, Vehicle> vehicleMap = vehicleGarage.getVehicleMap();
		
		for (Vehicle nextVehicle : vehicleMap.values()) {
			System.out.println(nextVehicle.toString());					
		}
	}

	private void listAllTypesOfParkedVehicles() {
		System.out.println("List all types of parked vehicles");
	}

	private void parkYOurVehicle() {
		System.out.println("Park your vehicle");
		
		try {		
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter registrationNumber");
		String stringRegistrationNumber = sc.next();
		System.out.println("Registration number:" + stringRegistrationNumber);

		System.out.println("Enter color");
		String stringColor = sc.next();
		System.out.println("Color:" + stringColor);

		System.out.println("Enter number of wheels");
		String stringWheels = sc.next();
		System.out.println("Color:" + stringWheels);
		int intWheels = Integer.parseInt(stringWheels);

		System.out.println("Enter Vehicle type");
		String stringVehicleType = sc.next();
		System.out.println("VehicleType:" + stringVehicleType);

		System.out.println("Enter number of seats");
		String stringNumberOfSeats = sc.next();
		System.out.println("Vehicle number of seats:" + stringNumberOfSeats);
		int intNumberOfSeats = Integer.parseInt(stringNumberOfSeats);

		// TODO: Convert intVehicleType to vehicleType

		Car newCar = new Car(stringRegistrationNumber, stringColor, intWheels, VehichleType.CAR, intNumberOfSeats);		
		vehicleGarage.addVehicle(newCar);
		
		} catch (VehicleGarageFullException e) {
			System.out.println("Garage full - no parkings slots available");
		}
	}

	private void unparkYourVehicle() {
		System.out.println("Unpark your vehicle");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter registrationNumber");
		String stringRegistrationNumber = sc.next();
		System.out.println("Registration number:" + stringRegistrationNumber);
		vehicleGarage.removeVehicle(stringRegistrationNumber);
		
	}

	private void setVehicleGarageCapacity() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter max vehicle garage capacity");
		String stringCapacity = sc.next();
		System.out.println("Capacity:" + stringCapacity);
		int intCapacity = Integer.parseInt(stringCapacity);
		System.out.println("Set vehicle garage capacity:" + intCapacity);
		vehicleGarage.setVehicleGarageCapacity(intCapacity);
	}

	private void searchForVehicle() {
		System.out.println("Search for Vehicle");
		try {
			Scanner sc = new Scanner(System.in);

			System.out.println("Enter registrationNumber");
			String stringRegistrationNumber = sc.next();
			System.out.println("Registration number:" + stringRegistrationNumber);

			Vehicle foundVehicle = vehicleGarage.findVehicle(stringRegistrationNumber);
			System.out.println(foundVehicle.toString());
		} catch (VehicleNotFoundException e) {
			System.out.println("Vehicle not found");
		}
	}

}
