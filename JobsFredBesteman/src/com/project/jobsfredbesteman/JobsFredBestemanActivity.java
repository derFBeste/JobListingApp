package com.project.jobsfredbesteman;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class JobsFredBestemanActivity extends Activity implements OnItemClickListener{
	
	ListView listView;
	
	ArrayList<Job> list = ShareData.get().getJobList();
	ArrayAdapter<Job> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jobs_fred_besteman);

		
		ShareData.get().restore(getApplicationContext()); //calls restore to get data stored on disk
		
		
		listView = (ListView) findViewById(R.id.jobList);
		registerForContextMenu(listView);
		
		listView.setOnItemClickListener(this);

		
		adapter = new ArrayAdapter<Job>(this, android.R.layout.simple_list_item_1, list);	
		listView.setAdapter(adapter);
		
	}//end onCreate

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Job job = (Job) adapter.getItem(position);
		
		int index = adapter.getPosition(job);
		
		//intent code is used to pass information to DetailsActivity
		Intent intent = new Intent(this, DetailsActivity.class);
		intent.putExtra("index", index);
		this.startActivity(intent);
		
		startActivity(new Intent(getApplicationContext(), DetailsActivity.class));
	}
	
	@Override
	public void onPause(){
		super.onPause();
		ShareData.get().save(getApplicationContext());
	}
	
	@Override
	public void onResume(){
		super.onResume();
		adapter.notifyDataSetChanged();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		this.getMenuInflater().inflate(R.menu.options_menu, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		switch(item.getItemId()){
		case R.id.about:
			startActivity(new Intent(getApplicationContext(), AboutActivity.class));
			return true;
		case R.id.add:
			startActivity(new Intent(getApplicationContext(), AddActivity.class));
		default:
			return super.onOptionsItemSelected(item);
		}
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View view, ContextMenuInfo menuInfo){
		getMenuInflater().inflate(R.menu.main_activity_list_context, menu);
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item){
		AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
		int position = info.position;
		Job selectedItem = adapter.getItem(position);
		
		switch(item.getItemId()){
		case R.id.delete:
			list.remove(selectedItem);
			adapter.notifyDataSetChanged();
			return true;
		}
		
		return super.onContextItemSelected(item);
	}


}
