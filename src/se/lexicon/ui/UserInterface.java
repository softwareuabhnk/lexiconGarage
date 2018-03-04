package se.lexicon.ui;

import java.util.Scanner;
import java.util.TreeMap;

import se.lexicon.vehicle.VehicleGarage;
import se.lexicon.exception.VehicleGarageFullException;
import se.lexicon.exception.VehicleNotFoundException;
import se.lexicon.utilities.VehichleType;
import se.lexicon.utilities.VehicleFuelType;
import se.lexicon.vehicle.Airplane;
import se.lexicon.vehicle.Boat;
import se.lexicon.vehicle.Bus;
import se.lexicon.vehicle.Car;
import se.lexicon.vehicle.Motorcycle;
import se.lexicon.vehicle.Vehicle;
import se.lexicon.vehicle.VehicleGarageInterface;

public class UserInterface {

	VehicleGarageInterface vehicleGarage = new VehicleGarage();

	public void printHeader() {
		System.out.println("Welcome to Vehicle Garage Parking:");
		System.out.println("----------------------------------");
		System.out.println("");
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
			System.out.println("");
			System.out.println("Enter a number representing your Errand!");
			String stringErrandNo = sc.next();
			System.out.println("Errand number:" + stringErrandNo);
			errandNo = Integer.parseInt(stringErrandNo);

			switch (errandNo) {
			case 1:
				parkYourVehicle();
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
		System.out.println("");
		System.out.println("You have left Vehicle Garage Parking!");

	}

	private void listAllParkedVehicles() {
		System.out.println("");
		System.out.println("List all parked vehicles:");
		TreeMap<String, Vehicle> vehicleMap = vehicleGarage.getVehicleMap();

		for (Vehicle nextVehicle : vehicleMap.values()) {
			System.out.println(nextVehicle.toString());
		}
		System.out.println("");

		if (vehicleMap.size() == 0) {
			System.out.println("No vehicles parked in the Garage");
			System.out.println("");
		}
	}

	private void listAllTypesOfParkedVehicles() {
		System.out.println("");
		System.out.println("List all types of parked vehicles:");
		TreeMap<String, Vehicle> vehicleMap = vehicleGarage.getVehicleMap();

		for (Vehicle nextVehicle : vehicleMap.values()) {
			if (nextVehicle.getVehicleType() == VehichleType.CAR) {
				System.out.println("Vehicle(s) of type " + nextVehicle.getVehicleType() + " is parked");
				break;
			}
		}
		for (Vehicle nextVehicle : vehicleMap.values()) {
			if (nextVehicle.getVehicleType() == VehichleType.BOAT) {
				System.out.println("Vehicle(s) of type " + nextVehicle.getVehicleType() + " is parked");
				break;
			}
		}
		for (Vehicle nextVehicle : vehicleMap.values()) {
			if (nextVehicle.getVehicleType() == VehichleType.AIRPLANE) {
				System.out.println("Vehicle(s) of type " + nextVehicle.getVehicleType() + " is parked");
				break;
			}
		}

		for (Vehicle nextVehicle : vehicleMap.values()) {
			if (nextVehicle.getVehicleType() == VehichleType.BUS) {
				System.out.println("Vehicle(s) of type " + nextVehicle.getVehicleType() + " is parked");
				break;
			}
		}

		for (Vehicle nextVehicle : vehicleMap.values()) {
			if (nextVehicle.getVehicleType() == VehichleType.MOTORCYCLE) {
				System.out.println("Vehicle(s) of type " + nextVehicle.getVehicleType() + " is parked");
				break;
			}
		}

		System.out.println("");
	}

	private void parkYourVehicle() {
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
			String stringVehicleType = sc.next().toLowerCase();
			System.out.println("VehicleType:" + stringVehicleType);

			switch (stringVehicleType) {

			case "car":

				// Unique property number of seats for vehicle of type CAR
				System.out.println("Enter number of seats");
				String stringNumberOfSeats = sc.next();
				System.out.println("Vehicle number of seats:" + stringNumberOfSeats);
				int intNumberOfSeats = Integer.parseInt(stringNumberOfSeats);

				Car newCar = new Car(stringRegistrationNumber, stringColor, intWheels,
						convertStringVehicleTypeToVehicleType(stringVehicleType), intNumberOfSeats);
				vehicleGarage.addVehicle(newCar);

				System.out.println("Your vehicle is now parked!");
				System.out.println("");
				break;

			case "boat":

				// Unique property cylinder volume for vehicle of type BOAT
				System.out.println("Enter vehicle cylinder volume:");
				String stringCylinderVolume = sc.next();
				System.out.println("Vehicle cylinder volume:" + stringCylinderVolume);
				int intCylinderVolume = Integer.parseInt(stringCylinderVolume);

				Boat newBoat = new Boat(stringRegistrationNumber, stringColor, intWheels,
						convertStringVehicleTypeToVehicleType(stringVehicleType), intCylinderVolume);
				vehicleGarage.addVehicle(newBoat);

				System.out.println("Your vehicle is now parked!");
				System.out.println("");
				break;

			case "bus":

				// Unique property length for vehicle of type BUS
				System.out.println("Enter vehicle length:");
				String stringLength = sc.next();
				System.out.println("Vehicle length:" + stringLength);
				int intLength = Integer.parseInt(stringLength);

				Bus newBus = new Bus(stringRegistrationNumber, stringColor, intWheels,
						convertStringVehicleTypeToVehicleType(stringVehicleType), intLength);
				vehicleGarage.addVehicle(newBus);

				System.out.println("Your vehicle is now parked!");
				System.out.println("");
				break;

			case "airplane":

				// Unique property number of engines for vehicle of type AIRPLANE
				System.out.println("Enter vehicle number of engines:");
				String stringNumberOfEngines = sc.next();
				System.out.println("Vehicle number of engines:" + stringNumberOfEngines);
				int intNumberOfEngines = Integer.parseInt(stringNumberOfEngines);

				Airplane newAirplane = new Airplane(stringRegistrationNumber, stringColor, intWheels,
						convertStringVehicleTypeToVehicleType(stringVehicleType), intNumberOfEngines);
				vehicleGarage.addVehicle(newAirplane);

				System.out.println("Your vehicle is now parked!");
				System.out.println("");
				break;

			case "motorcycle":

				// Unique property fuel type for vehicle of type MOTORCYCLE
				System.out.println("Enter vehicle fuel type:");
				String stringFuelType = sc.next().toLowerCase();
				System.out.println("Vehicle fuel type:" + stringFuelType);

				Motorcycle newMotorcycle = new Motorcycle(stringRegistrationNumber, stringColor, intWheels,
						convertStringVehicleTypeToVehicleType(stringVehicleType),
						convertStringVehicleFuelTypeToVehicleFuelType(stringFuelType));
				vehicleGarage.addVehicle(newMotorcycle);

				System.out.println("Your vehicle is now parked!");
				System.out.println("");
				break;

			default:

				System.out.println("Your Vehicle type is " + VehichleType.UNKNOWN + " can not be parked");
				System.out.println("");			
			}

		} catch (VehicleGarageFullException e) {
			System.out.println("Garage full - no parkings slots available");
			System.out.println("");
		}
	}

	private void unparkYourVehicle() {
		System.out.println("Unpark your vehicle");

		try {
			Scanner sc = new Scanner(System.in);

			System.out.println("Enter registrationNumber:");
			String stringRegistrationNumber = sc.next();
			System.out.println("Registration number:" + stringRegistrationNumber);
			vehicleGarage.removeVehicle(stringRegistrationNumber);

		} catch (VehicleNotFoundException e) {
			System.out.println("Your vehicle is not parked here");
		}
		System.out.println("");

	}

	private void setVehicleGarageCapacity() {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter max vehicle garage capacity:");
		String stringCapacity = sc.next();
		System.out.println("Capacity:" + stringCapacity);
		int intCapacity = Integer.parseInt(stringCapacity);
		System.out.println("Set vehicle garage capacity to:" + intCapacity);
		vehicleGarage.setVehicleGarageCapacity(intCapacity);
		System.out.println("");
	}

	private void searchForVehicle() {
		System.out.println("Search for Vehicle:");
		try {
			Scanner sc = new Scanner(System.in);

			System.out.println("Enter registrationNumber");
			String stringRegistrationNumber = sc.next();
			System.out.println("Registration number:" + stringRegistrationNumber);

			Vehicle foundVehicle = vehicleGarage.findVehicle(stringRegistrationNumber);
			System.out.println(foundVehicle.toString());

		} catch (VehicleNotFoundException e) {
			System.out.println("Vehicle you searched for is not found");
		}
		System.out.println("");
	}

	private VehichleType convertStringVehicleTypeToVehicleType(String stringVehicleType) {

		VehichleType vehicleType;

		switch (stringVehicleType) {

		case "car":
			vehicleType = VehichleType.CAR;
			break;
		case "boat":
			vehicleType = VehichleType.BOAT;
			break;
		case "airplane":
			vehicleType = VehichleType.AIRPLANE;
			break;
		case "motorcycle":
			vehicleType = VehichleType.MOTORCYCLE;
			break;
		case "bus":
			vehicleType = VehichleType.BUS;
			break;
		default:
			vehicleType = VehichleType.UNKNOWN;
		}
		return vehicleType;
	}

	private VehicleFuelType convertStringVehicleFuelTypeToVehicleFuelType(String stringFuelType) {

		VehicleFuelType fuelType;

		switch (stringFuelType) {

		case "gas":
			fuelType = VehicleFuelType.GAS;
			break;
		case "bio":
			fuelType = VehicleFuelType.BIO;
			break;
		case "diesel":
			fuelType = VehicleFuelType.DIESEL;
			break;
		case "electrical":
			fuelType = VehicleFuelType.ELECTRICAL;
			break;
		case "petrol":
			fuelType = VehicleFuelType.PETROL;
			break;
		default:
			fuelType = VehicleFuelType.UNKNOWN;
		}
		return fuelType;
	}

}
