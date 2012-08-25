package com.example.foodandbeverages;

import java.util.List;
import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;

public class FoodMain extends ListActivity {
	private FoodCourtsDataSource datasource;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_main);
        datasource = new FoodCourtsDataSource(this);
        datasource.open();
        
        
        List<FoodCourts> values = datasource.getAllFoodcourts();
         // Use the SimpleCursorAdapter to show the
        // elements in a ListView
        ArrayAdapter<FoodCourts> adapter = new ArrayAdapter<FoodCourts>(this,
            android.R.layout.simple_list_item_1, values);
        
        setListAdapter(adapter);
        FoodCourts foodcourts = null;
        String[] comments = new String[] { "Steak Escape", " Wendy's ", "Subway" , "Starbucks"};
        
        // Save the new comment to the database
        if(values.isEmpty())
        {
        	for(int i=0;i<comments.length;i++)
        	{
        		foodcourts = datasource.createComment(comments[i]);
        		adapter.add(foodcourts);
        		
        	}
        }
    }

   /* public void onClick(View view) {
        @SuppressWarnings("unchecked")
        ArrayAdapter<FoodCourts> adapter = (ArrayAdapter<FoodCourts>) getListAdapter();
        FoodCourts comment = null;
        switch (view.getId()) {
        case R.id.add:
          String[] comments = new String[] { "Steak Escape", " Wendy's ", "Subway" , "Starbucks"};
          int nextInt = new Random().nextInt(3);
          // Save the new comment to the database
          comment = datasource.createComment(comments[nextInt]);
          adapter.add(comment);
          break;
        case R.id.delete:
          if (getListAdapter().getCount() > 0) {
            comment = (FoodCourts) getListAdapter().getItem(0);
            datasource.deleteComment(comment);
            adapter.remove(comment);
          }
          break;
        }
        adapter.notifyDataSetChanged();
      }*/

      @Override
      protected void onResume() {
        datasource.open();
        super.onResume();
      }

      @Override
      protected void onPause() {
        datasource.close();
        super.onPause();
      }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_food_main, menu);
        return true;
    }
}
