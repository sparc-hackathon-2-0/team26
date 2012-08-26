package com.example.foodandbeverages;

public class FoodItems {
	private long id;
	  private String foodItem;
	  private String foodCourt;
	  private String price;

	  public long getId() {
	    return id;
	  }

	  public void setId(long id) {
	    this.id = id;
	  }

	  public String getFoodCourt() {
	    return foodCourt;
	  }

	  public void setFoodCourt(String foodcourt) {
	    this.foodCourt = foodcourt;
	  }

	  // Will be used by the ArrayAdapter in the ListView
	  @Override
	  public String toString() {
	    return getFoodItem() + " \n "+ getPrice();
	  }

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getFoodItem() {
		return foodItem;
	}

	public void setFoodItem(String foodItem) {
		this.foodItem = foodItem;
	}

}
