package com.example.foodandbeverages;

public class FoodCourts {
	private long id;
	  private String foodcourt;

	  public long getId() {
	    return id;
	  }

	  public void setId(long id) {
	    this.id = id;
	  }

	  public String getComment() {
	    return foodcourt;
	  }

	  public void setComment(String foodcourt) {
	    this.foodcourt = foodcourt;
	  }

	  // Will be used by the ArrayAdapter in the ListView
	  @Override
	  public String toString() {
	    return foodcourt;
	  }

}
