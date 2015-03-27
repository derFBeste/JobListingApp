package com.project.jobsfredbesteman;

import java.io.Serializable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class DetailsActivity extends Activity implements OnEditorActionListener
{

	EditText companyEditText;
	EditText contactEditText;
	EditText positionEditText;

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
		company = intent.getStringExtra("company");
		contact = intent.getStringExtra("contact");
		position = intent.getStringExtra("position");
		index = intent.getIntExtra("index", 0);
						
		companyEditText.setText(company);
		contactEditText.setText(contact);
		positionEditText.setText(position);
		
		companyEditText.setOnEditorActionListener(this);
		contactEditText.setOnEditorActionListener(this);
		positionEditText.setOnEditorActionListener(this);
	}


	@Override
	public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
		//make toast here to see if the index is correct, if so rework intent between mainActivity and here
			
		
		
		return false;
	}
	
	
}
