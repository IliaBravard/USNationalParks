package view; // The package where this class is located at

/**
 * @author Ilia Bravard - igbravard
 * CIS175 - Fall 2022
 * Sep 13, 2022
 */

import java.util.Scanner;
import java.util.List;

import controller.USParksHelper; // Allows access to the controller class
import model.USNationalParks; // Allows access to the model class

public class StartPorgram {

	static Scanner in = new Scanner(System.in);
	static USParksHelper uph = new USParksHelper(); // Instantiating a new controller object

	/**
	 * This method displays the console menu to the user with the available database
	 * options.
	 */
	public static void runConsoleGUI() {
		boolean sentinelValue = false;
		System.out.println(" =============================================");
		System.out.println(" | WELCOME TO THE US NATIONAL PARKS DATABASE |");
		System.out.println(" =============================================");

		while (!sentinelValue) {
			System.out.println("\n☕ ☕ ☕ ☕ ☕ ☕ ☕ ☕ ☕ ☕ ☕ ☕ ☕ ☕ ☕ ☕ ☕ ☕");
			System.out.println("|*******************| MENU |*******************|");
			System.out.println(String.format("|%46s|", ""));
			System.out.println("| Option [1] --> ADD a park                    |");
			System.out.println("|--------------------------------------------- |");
			System.out.println("| Option [2] --> EDIT a park                   |");
			System.out.println("|--------------------------------------------- |");
			System.out.println("| Option [3] --> DELETE a park                 |");
			System.out.println("|--------------------------------------------- |");
			System.out.println("| Option [4] --> VIEW the park(s)              |");
			System.out.println("|--------------------------------------------- |");
			System.out.println("| Option [5] --> EXIT the database application |");
			System.out.println("|**********************************************|");
			System.out.println("|~~~~~~~~~ Please Select an Option: ~~~~~~~~~~~|");
			System.out.println("☕ ☕ ☕ ☕ ☕ ☕ ☕ ☕ ☕ ☕ ☕ ☕ ☕ ☕ ☕ ☕ ☕ ☕");

			System.out.print("\n----------------");
			System.out.print("\nOption Choice: ");
			int choice = in.nextInt();
			System.out.println("----------------");

			in.nextLine(); // To prepare the listener for the next incoming string

			switch (choice) { // Using a switch case to invoke each appropriate function
			case 1:
				addPark();
				break;
			case 2:
				editPark();
				break;
			case 3:
				deletePark();
				break;
			case 4:
				viewParks();
				break;
			case 5:
				// Closing the connections after finished with the application
				System.out.println("\n  ☕ ☕ ☕ ☕ ☕ ☕ ☕ ☕ ☕ ☕ ☕ ☕ ☕ ☕ ☕ ☕ ☕");
				System.out.println("      ------------------------------------");
				System.out.println("      THANK YOU FOR USING THE APPLICATION!");
				System.out.println("      ------------------------------------");
				System.out.println("  ☕ ☕ ☕ ☕ ☕ ☕ ☕ ☕ ☕ ☕ ☕ ☕ ☕ ☕ ☕ ☕ ☕");
				sentinelValue = true;
				break;
			}
		}
	}

	/**
	 * This method adds a national park to the database.
	 */
	private static void addPark() {
		System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("--------------------------------------------------------------------");
		System.out.println(String.format("%40s", "/ OPTION 1 /"));
		System.out
				.println(String.format("%39s", "--------------------------------------------------------------------"));

		System.out.print("+ Please enter the name of the park: ");
		String park = in.nextLine();

		System.out.print("+ Please enter the state where the park is located at: ");
		String state = in.nextLine();

		System.out.print("+ Please enter the area of the park (in acres): ");
		double area = in.nextDouble();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n");

		// Wrapping the method into a USNationalParks object to be persisted
		USNationalParks prk = new USNationalParks(park, state, area);
		uph.insertRecord(prk); // Inserts the item in the database
	}

	/**
	 * This method displays all national parks within the database.
	 */
	private static void viewParks() {
		List<USNationalParks> allParks = uph.showAllParks();
		System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("--------------------------------------------------------------------");
		System.out.println(String.format("%40s", "/ OPTION 4 /"));
		System.out.println("--------------------------------------------------------------------\n");
		
		if(!allParks.isEmpty()) {
			for (USNationalParks onePark : allParks) { // Using an enhanced for loop to iterate through the list
				System.out.println("★ " + onePark.toString());
			}
		}
		else {
			System.out.println("∅ No records exist in the current database! ∅");
		}
		
		System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	}

	/**
	 * This method deletes a record from the database based on the id of that
	 * record.
	 */
	private static void deletePark() {
		System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("--------------------------------------------------------------------");
		System.out.println(String.format("%40s", "/ OPTION 3 /"));
		System.out.println("--------------------------------------------------------------------");
		System.out.print("+ Enter the name of the park to be deleted: ");
		String parkName = in.nextLine();
		System.out.print("+ Enter the state of the park to be deleted: ");
		String parkState = in.nextLine();
		System.out.print("+ Enter the area of the park to be deleted: ");
		double parkArea = in.nextDouble();
		in.nextLine();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

		USNationalParks parkToDelete = new USNationalParks(parkName, parkState, parkArea);
		uph.deletePark(parkToDelete);
	}

	/**
	 * This method updates the records in the database.
	 */
	private static void editPark() {
		System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("--------------------------------------------------------------------");
		System.out.println(String.format("%40s", "/ OPTION 2 /"));
		System.out.println("--------------------------------------------------------------------");

		System.out.println((String.format("%61s", "~~~~~~ Here are your options for searching ~~~~~~")));
		System.out.println(String.format("%41s", "★ [1] Search by the park's name"));
		System.out.println(String.format("%61s", "★ [2] Search by the state where the park is located"));
		System.out.println(String.format("%41s", "★ [3] Search by the park's area"));

		System.out.print("\n----------------");
		System.out.print("\nOption Choice: ");
		int searchKey = in.nextInt();
		in.nextLine();
		System.out.println("----------------");

		List<USNationalParks> foundRecords; // Stores the found items in a list

		if (searchKey == 1) {
			System.out.print("+ Please enter the park's name: "); // Searches the park to be edited by its name
			String parkName = in.nextLine();
			System.out.print("\n");
			foundRecords = uph.searchForParkByName(parkName);
		} else if (searchKey == 2) {
			System.out.print("+ Please enter the state: "); // Searches the park to be edited by the state
			String parkState = in.nextLine();
			System.out.print("\n");
			foundRecords = uph.searchForParkByState(parkState);
		} else {
			System.out.print("+ Please enter the park's area (in acres): "); // Searches the park to be edited by the
																				// area of the park
			int parkArea = in.nextInt();
			in.nextLine();
			System.out.print("\n");
			foundRecords = uph.searchForParkByArea(parkArea);
		}

		if (!foundRecords.isEmpty()) { // Checks whether the list with found items is empty
			System.out.println(String.format("%52s", "\nSUCCESS!!! We Found Result(s)."));
			System.out.println("\n   ID   |  Details");
			System.out.println("------------------------------------------------------------------------------");
			for (USNationalParks p : foundRecords) { // Using an enhanced for loop to print the items
				System.out.println(p.getId() + "  | " + p.toString());
			}
			System.out.print("\n+ PLease enter the park's ID #: ");
			int idToUpdate = in.nextInt();
			in.nextLine();
			USNationalParks pIdToEdit = uph.searchForParkById(idToUpdate);

			if (searchKey == 1) {
				System.out.print("+ Please enter the NEW park name: ");
				String newName = in.nextLine();
				pIdToEdit.setName(newName);
			} else if (searchKey == 2) {
				System.out.print("+ Please enter the NEW state: ");
				String newState = in.nextLine();
				pIdToEdit.setState(newState);
			} else {
				System.out.print("+ Please enter the NEW acre area: ");
				double newArea = in.nextDouble();
				in.nextLine();
				pIdToEdit.setArea(newArea);
			}
			uph.updatePark(pIdToEdit);
		} else {
			System.out.println("¯\\_(ツ)_/¯ FAILURE!!! We could not find any relevant results");
		}
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	}

	/**
	 * This is the main/driver class.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		runConsoleGUI();
	}
}