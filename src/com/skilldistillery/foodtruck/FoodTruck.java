package com.skilldistillery.foodtruck;

public class FoodTruck extends FoodTruckApp{
	
	private static int nextTruckId = 1;
	private int id;
	private String truckName;
	private String foodType;
	private int truckRating;
	
	
	public FoodTruck() {
		
	}
	
	public FoodTruck(String truckName, String foodType, int truckRating) {
		this.truckName = truckName;
		this.foodType = foodType;
		this.truckRating = truckRating;
		this.id = nextTruckId++;
	}
	
	public int getId() {
		return id;
	}
	public String getTruckName() {
		return truckName;
	}
	public String getFoodType() {
		return foodType;
	}
	public int getTruckRating() {
		return truckRating;
	}
	public String toString() {
		return "Food Truck name (Id #: " + id + ")\n " + truckName + "\n Type of food served: " + foodType + "\n Truck rating: " + truckRating;
	}

}
