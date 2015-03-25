package com.project.jobsfredbesteman;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class JobsFredBestemanActivity extends Activity {
	
	ListView listView;
	
	ArrayList<Job> jobList = new ArrayList<Job>();
	ArrayAdapter<Job> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jobs_fred_besteman);
		
		listView = (ListView) findViewById(R.id.jobList);
		
		Job job1 = new Job("ACME", "DAVE", "Head Honcho");
		Job job2 = new Job("MMMM", "Jojo", "Numero Uno");
		
		jobList.add(job1);
		jobList.add(job2);
		
		adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, jobList);	
		listView.setAdapter(adapter);
		
		listView.setOnItemClickListener(new OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> arg0, View v, int position,
					long id) {
				Job j = (Job) adapter.getItem(position);
				Toast.makeText(getApplicationContext(), position + ": "+ j, Toast.LENGTH_LONG).show();			
			}
			
		});
		
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
		default:
			return super.onOptionsItemSelected(item);
		}
	}
	
	
}
