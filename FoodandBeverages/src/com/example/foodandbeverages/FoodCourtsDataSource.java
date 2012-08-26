package com.example.foodandbeverages;

import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;



public class FoodCourtsDataSource {
	// Database fields
	  private SQLiteDatabase database;
	  private SQLiteHelper dbHelper;
	  private String[] allColumns = { SQLiteHelper.COLUMN_ID,
	      SQLiteHelper.COLUMN_COMMENT };

	  public FoodCourtsDataSource(Context context) {
	    dbHelper = new SQLiteHelper(context);
	  }

	  public void open() throws SQLException {
	    database = dbHelper.getWritableDatabase();
	  }

	  public void close() {
	    dbHelper.close();
	  }

	  public FoodCourts createComment(String comment) {
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
	  }

	  public void deleteComment(FoodCourts comment) {
	    long id = comment.getId();
	    System.out.println("FoodCourts deleted with id: " + id);
	    database.delete(SQLiteHelper.TABLE_COMMENTS, SQLiteHelper.COLUMN_ID
	        + " = " + id, null);
	  }

	  public List<FoodCourts> getAllFoodcourts() {
		  
		  
	    List<FoodCourts> comments = new ArrayList<FoodCourts>();
	    

	    Cursor cursor = database.query(SQLiteHelper.TABLE_COMMENTS,
	        allColumns, null, null, null, null, null);

	    cursor.moveToFirst();
	    while (!cursor.isAfterLast()) {
	      FoodCourts comment = cursorToComment(cursor);
	      
	    	  comments.add(comment);
	      cursor.moveToNext();
	    }
	    // Make sure to close the cursor
	    cursor.close();
	    return comments;
	  }

	  private FoodCourts cursorToComment(Cursor cursor) {
	    FoodCourts comment = new FoodCourts();
	    comment.setId(cursor.getLong(0));
	    comment.setComment(cursor.getString(1));
	    return comment;
	  }

}
