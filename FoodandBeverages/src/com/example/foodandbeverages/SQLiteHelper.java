package com.example.foodandbeverages;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class SQLiteHelper extends SQLiteOpenHelper {

	 public static final String TABLE_COMMENTS = "FoodCourts";
	 
	  public static final String COLUMN_ID = "id";
	  public static final String COLUMN_COMMENT = "name";

	  private static final String DATABASE_NAME = "foodcourts.db";
	  private static final int DATABASE_VERSION = 1;

	  
	  public static final String TABLE_ITEMS = "FoodItems";
	  public static final String COLUMN_ITEMSID = "id";
	  public static final String COLUMN_FOOD= "foodname";
	  public static final String FOOD_COURT= "foodcourt";
	  public static final String COLUMN_PRICE= "price";

	 
	  
	  
	  // Database creation sql statement
	  private static final String DATABASE_CREATE = "create table "
	      + TABLE_COMMENTS + "(" + COLUMN_ID
	      + " integer primary key autoincrement, " + COLUMN_COMMENT
	      + " text not null);";

	  public SQLiteHelper(Context context) {
	    super(context, DATABASE_NAME, null, DATABASE_VERSION);
	  }

	  private static final String DATABASE_FOODITEMS_CREATE="create table "+TABLE_ITEMS+ "(" + COLUMN_ITEMSID
		      + " integer primary key autoincrement, " + COLUMN_FOOD
		      + " text not null, "+ FOOD_COURT +" text, "+ COLUMN_PRICE + " text not null, foreign key ("+ FOOD_COURT +") references "+ TABLE_COMMENTS +"(" + COLUMN_COMMENT +")" +" );";
	  
	  private static final String INSERET_INFOODITEMS1="INSERT INTO FoodItems (foodname, foodcourt, price) " +"VALUES ('ChickenSub','Subway','5.99')";
	  private static final String INSERET_INFOODITEMS2="INSERT INTO FoodItems (foodname, foodcourt, price) " +"VALUES ('VegeSub','Subway','2.99')";
	  private static final String INSERET_INFOODITEMS3="INSERT INTO FoodItems (foodname, foodcourt, price) " +"VALUES ('BaconSub','Subway','1.99')";
	  
	  private static final String INSERET_INFOODITEMS4="INSERT INTO FoodItems (foodname, foodcourt, price) " +"VALUES ('ChickenSub','Steak Escape','5.99')";
	  private static final String INSERET_INFOODITEMS5="INSERT INTO FoodItems (foodname, foodcourt, price) " +"VALUES ('Chicken Salad','Steak Escape','5.99')";
	  private static final String INSERET_INFOODITEMS6="INSERT INTO FoodItems (foodname, foodcourt, price) " +"VALUES ('Veg Sandwich','Steak Escape','5.99')";
	  
	  private static final String INSERET_INFOODITEMS7="INSERT INTO FoodItems (foodname, foodcourt, price) " +"VALUES ('ChickenSandwich','Wendys','5.99')";
	  private static final String INSERET_INFOODITEMS8="INSERT INTO FoodItems (foodname, foodcourt, price) " +"VALUES ('Chickenwrap','Wendys','5.99')";
	  private static final String INSERET_INFOODITEMS9="INSERT INTO FoodItems (foodname, foodcourt, price) " +"VALUES ('Chicken salad',' Wendys','5.99')";
	  
	  private static final String INSERET_INFOODITEMS10="INSERT INTO FoodItems (foodname, foodcourt, price) " +"VALUES ('Vanila Latte','Starbucks','5.99')";
	  private static final String INSERET_INFOODITEMS11="INSERT INTO FoodItems (foodname, foodcourt, price) " +"VALUES ('Mocha ','Starbucks','5.99')";
	  private static final String INSERET_INFOODITEMS12="INSERT INTO FoodItems (foodname, foodcourt, price) " +"VALUES ('Tea',' Starbucks','2.99')";
	  
	  
	  
	  
	  
	  @Override
	  public void onCreate(SQLiteDatabase database) {
	    database.execSQL(DATABASE_CREATE);
	    database.execSQL(DATABASE_FOODITEMS_CREATE);
	    database.execSQL(INSERET_INFOODITEMS1);
	    database.execSQL(INSERET_INFOODITEMS2);
	    database.execSQL(INSERET_INFOODITEMS3);
	    
	    database.execSQL(INSERET_INFOODITEMS4);
	    database.execSQL(INSERET_INFOODITEMS5);
	    database.execSQL(INSERET_INFOODITEMS6);
	    
	    database.execSQL(INSERET_INFOODITEMS7);
	    database.execSQL(INSERET_INFOODITEMS8);
	    database.execSQL(INSERET_INFOODITEMS9);
	    
	    database.execSQL(INSERET_INFOODITEMS10);
	    database.execSQL(INSERET_INFOODITEMS11);
	    database.execSQL(INSERET_INFOODITEMS12);
	    
	    
	    
	  }

	  @Override
	  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	    Log.w(SQLiteHelper.class.getName(),
	        "Upgrading database from version " + oldVersion + " to "
	            + newVersion + ", which will destroy all old data");
	    db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMMENTS);
	    db.execSQL("DROP TABLE IF EXISTS " + TABLE_ITEMS);
	    onCreate(db);
	  }
}
