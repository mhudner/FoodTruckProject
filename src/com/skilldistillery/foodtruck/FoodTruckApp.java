package com.skilldistillery.foodtruck;

import java.util.Scanner;

public class FoodTruckApp {

	private int Max_Trucks = 5;
	private FoodTruck trucks[] = new FoodTruck[Max_Trucks];
	private int truckCount;
	private int nextTruckId = 1;

	public void start() {

		Scanner kb = new Scanner(System.in);
		System.out.println("Thank you for coming to our mini Food Truck Festival!!!");
		System.out.println(
				"If you could please provide us with some feedback \non the trucks you visited today we would greatly appreciate it!");
		System.out.println();
		foodTruckUserInput(kb);

		boolean quit = false;

		while (!quit) {
			System.out.println("___________________MENU___________________");
			System.out.println("  1. List all existing food trucks");
			System.out.println("  2. See the average rating of food trucks");
			System.out.println("  3. Display the highest rated food truck");
			System.out.println("  4. Quit the program");

			int choice = Integer.parseInt(kb.nextLine());

			switch (choice) {
			case 1:
				listTrucks();
				break;
			case 2:
				calcAverageRating();
				break;
			case 3:
				displayHighestRated();
				break;
			case 4:
				quit = true;
				System.out.println("You have chosen to quit the program \n Goodbye!");
				break;
			default:
				System.out.println("Invalid choice, please try again");
			}
		}

	}

	private void foodTruckUserInput(Scanner kb) {
		for (int idx = truckCount; idx < Max_Trucks; idx++) {
			System.out.println("What was the name of the Food Truck you visited? (Type \"quit\" at any point to exit)");
			String truckName = kb.nextLine();
			if (truckName.equalsIgnoreCase("quit")) {
				break;
			}

			System.out.println("Please enter the type of food served");
			String foodType = kb.nextLine();

			System.out.println("What rating would you give " + truckName + "?");
			int truckRating = Integer.parseInt(kb.nextLine());

			trucks[truckCount++] = new FoodTruck(truckName, foodType, truckRating);
		}
	}

	private void listTrucks() {
		System.out.println("All food trucks: ");
		System.out.println();
		for (int idx = 0; idx < truckCount; idx++) {
			System.out.println(trucks[idx]);
		}
	}

	private void calcAverageRating() {
		if (truckCount == 0) {
			System.out.println("No trucks to calculate average rating");
			return;
		}

		int totalRating = 0;
		for (int idx = 0; idx < truckCount; idx++) {
			totalRating += trucks[idx].getTruckRating();
		}
		double averageRating = (double) totalRating / truckCount;
		System.out.println("Average rating of foodtrucks: " + averageRating);
	}

	private void displayHighestRated() {
		if (truckCount == 0) {
			System.out.println("No trucks to display");
			return;
		}

		FoodTruck highestRatedTruck = trucks[0];
		for (int idx = 1; idx < truckCount; idx++) {
			if (trucks[idx].getTruckRating() > highestRatedTruck.getTruckRating()) {
				highestRatedTruck = trucks[idx];
			}
		}
		System.out.println("Highest rated food truck: " + highestRatedTruck);
	}

	public static void main(String[] args) {

		FoodTruckApp FoodTruckApp = new FoodTruckApp();
		FoodTruckApp.start();

	}

	public int getNextTruckId() {
		return nextTruckId;
	}

	public void setNextTruckId(int nextTruckId) {
		this.nextTruckId = nextTruckId;
	}
}
