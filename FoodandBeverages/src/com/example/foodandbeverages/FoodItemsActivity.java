package com.example.foodandbeverages;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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
	        ListView listView = getListView();
	        listView.addFooterView(((View)listView.getParent()).findViewById(R.id.orderbutton));
	        
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

	Set<String> orderItems = new HashSet<String>();	
	protected void onListItemClick(ListView l, View v, int position, long id) {
		
		CheckedTextView tt = (CheckedTextView) v;
		String text = tt.getText().toString();
		
		String item = text;//text.substring(0,text.indexOf("\n"));
		//Toast.makeText(this, text, Toast.LENGTH_LONG).show();
		if (!tt.isChecked()) {
			tt.setChecked(true);
			orderItems.add(item);
			tt.setCheckMarkDrawable(android.R.drawable.checkbox_on_background);
		} else {
			tt.setChecked(false);
			orderItems.remove(item);
			tt.setCheckMarkDrawable(android.R.drawable.checkbox_off_background);
		}
		
		//Toast.makeText(this, orderItems.toString()+" position:"+position, Toast.LENGTH_LONG).show();
		
		
	}


	
}
