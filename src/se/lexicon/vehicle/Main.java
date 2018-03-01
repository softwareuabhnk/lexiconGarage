package se.lexicon.vehicle;

import java.util.Scanner;

import se.lexicon.ui.UserInterface;


public class Main {

	public static void main(String[] args) { 
		
		UserInterface ui = new UserInterface();
		
		ui.printHeader();
		ui.start();

		System.out.println("You have exited Vehicle Garage parking");
		System.exit(0);

	}

}
