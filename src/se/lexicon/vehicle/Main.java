package se.lexicon.vehicle;

import se.lexicon.ui.UserInterface;


public class Main {

	public static void main(String[] args) { 
		
		UserInterface ui = new UserInterface();
		
		ui.printHeader();
		ui.start();
		System.exit(0);

	}

}
