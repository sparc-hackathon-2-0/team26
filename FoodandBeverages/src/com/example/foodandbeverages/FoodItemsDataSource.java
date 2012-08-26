package com.example.foodandbeverages;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class FoodItemsDataSource {

	
	// Database fields
		  private SQLiteDatabase database;
		  private SQLiteHelper dbHelper;
		  private String[] allColumns = { SQLiteHelper.COLUMN_ITEMSID,
		      SQLiteHelper.COLUMN_FOOD, SQLiteHelper.FOOD_COURT,
		      SQLiteHelper.COLUMN_PRICE};

		  public FoodItemsDataSource(Context context) {
		    dbHelper = new SQLiteHelper(context);
		  }

		  public void open() throws SQLException {
		    database = dbHelper.getWritableDatabase();
		  }

		  public void close() {
		    dbHelper.close();
		  }

		  /*public FoodCourts createComment(String comment) {
		    ContentValues values = new ContentValues();
		    values.put(SQLiteHelper.COLUMN_COMMENT, comment);
		    long insertId = database.insert(SQLiteHelper.TABLE_COMMENTS, null,
		        values);
		    Cursor cursor = database.query(SQLiteHelper.TABLE_COMMENTS,
		        allColumns, SQLiteHelper.COLUMN_ID + " = " + insertId, null,
		        null, null, null);
		    cursor.moveToFirst();
		    FoodCourts newComment = cursorToComment(cursor);
		    cursor.close();
		    return newComment;
		  }*/

		

		  public List<FoodItems> getFoodItemsByFoodCourt(String foodcourt) {
			  
			  
		    List<FoodItems> items = new ArrayList<FoodItems>();
		    
		    String WHERE = "foodcourt like ?";
		    open();
		    Cursor cursor = database.query(SQLiteHelper.TABLE_ITEMS,
		        allColumns, WHERE, new String[]{ foodcourt }, null, null, null);

		    cursor.moveToFirst();
		    while (!cursor.isAfterLast()) {
		      FoodItems item = cursorToFoodItem(cursor);
		      
		    	  items.add(item);
		      cursor.moveToNext();
		    }
		    // Make sure to close the cursor
		    cursor.close();
		    return items;
		  }

		  private FoodItems cursorToFoodItem(Cursor cursor) {
		    FoodItems item = new FoodItems();
		    item.setId(cursor.getLong(0));
		    item.setFoodItem(cursor.getString(1));
		    item.setFoodCourt(cursor.getString(2));
		    item.setPrice(cursor.getString(3));
		    return item;
		  }
}
