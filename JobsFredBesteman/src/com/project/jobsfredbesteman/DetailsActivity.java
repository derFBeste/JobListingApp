/*Fred Besteman
 * CIS 2818
 * Alan Jackson
 * Application 4: JobsYourName
 * 
 * DetailsActivity.java
 * Provides details about a job and allows users to edit that job.
 */



package com.project.jobsfredbesteman;

import java.io.Serializable;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class DetailsActivity extends Activity
{
	private final String TAG = "**********************";
	
	EditText companyEditText;
	EditText contactEditText;
	EditText positionEditText;
	
	ArrayList<Job> list = ShareData.get().getJobList();
	Job jobSelected;

	String company;
	String contact;
	String position;
	int index;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_details);
		
		companyEditText = (EditText) findViewById(R.id.inputCompany);
		contactEditText = (EditText) findViewById(R.id.inputContact);
		positionEditText = (EditText) findViewById(R.id.inputPostion);
		
		Intent intent = getIntent();
		//Gets the index that was saved in JobsFredBestemanActivity.
		index = intent.getIntExtra("index", 0);
		Log.d(TAG, "array index: " + index);
		
		//Selects the job from the ArrayList and assigns it to a variable.
		jobSelected = list.get(index);
		
		//Sets new values to the object if values are changed.
		Log.d(TAG, "job selected: " + jobSelected);
		companyEditText.setText(jobSelected.getCompany());
		contactEditText.setText(jobSelected.getContact());
		positionEditText.setText(jobSelected.getPosition());
		
		companyEditText.addTextChangedListener(new MyTextWatcher());
		contactEditText.addTextChangedListener(new MyTextWatcher());
		positionEditText.addTextChangedListener(new MyTextWatcher());
	}

class MyTextWatcher implements TextWatcher{	
		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub
			
		}
	
		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {
			Log.d(TAG, "In Text Change Listener");
			
			jobSelected.setCompany(companyEditText.getText().toString());
			jobSelected.setContact(contactEditText.getText().toString());
			jobSelected.setPosition(positionEditText.getText().toString());
		}
			
		@Override
		public void afterTextChanged(Editable s) {
			// TODO Auto-generated method stub
			
		}
	}

	
}
