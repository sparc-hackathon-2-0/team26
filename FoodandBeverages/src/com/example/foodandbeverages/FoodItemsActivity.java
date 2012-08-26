package com.example.foodandbeverages;

import java.util.List;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class FoodItemsActivity extends ListActivity{
	FoodItemsDataSource dataSource ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Bundle extras=getIntent().getExtras();
		String foodCourt = extras.getString("FoodCourt");
		
		dataSource = new FoodItemsDataSource(this);
		List<FoodItems> foodItems= dataSource.getFoodItemsByFoodCourt(foodCourt);
		
		MyArrayAdapter adapter = new MyArrayAdapter(this,R.layout.food_list_item, foodItems);
	        
	        setListAdapter(adapter);
	}
	
	
	class MyArrayAdapter extends ArrayAdapter<FoodItems>{
		List<FoodItems> foodItems;
		public MyArrayAdapter(Context context, int textViewResourceId,
				List<FoodItems> items) {
			super(context, textViewResourceId, items);
			foodItems = items;
		}
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		//return super.getView(position, convertView, parent);
		LayoutInflater inflater=getLayoutInflater();
		View row=inflater.inflate(R.layout.food_list_item, parent, false);
		TextView label=(TextView)row.findViewById(R.id.checkList);
		label.setText(foodItems.get(position).toString());
		
		
		return row;
		}
		}

		
		


	//}
}
