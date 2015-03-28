/*
 * 
 * singleton
 */


package com.project.jobsfredbesteman;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import android.content.Context;
import android.util.Log;

public class ShareData {
	public static final String filename = "my_data.dat";
	private static final String TAG = "*** YOUR TAG ***";
	
	
	private static ShareData sData;
	
	private Job job;
	
	private ArrayList<Job> jobList;
	
	private ShareData(){
		jobList = new ArrayList<Job>();
		
//		Job job1 = new Job("ACME", "DAVE", "Head Honcho");
//		Job job2 = new Job("M & M & M & N CO.", "Jojo", "Numero Uno");
//		Job job3 = new Job("IncInc", "Bruce", "Overlord");
//		
//		jobList.add(job1);
//		jobList.add(job2);
//		jobList.add(job3);
	}
	
	public static ShareData get(){
		if (sData == null){
			sData = new ShareData();
		}
		return sData;
	}
	
//	public int getIndex(ArrayList<Job> jobList){
//		int index = jobList.indexOf(jobList);
//		
//		return index;
//	}
	
	public void setJob(Job job){
		this.job = job;
	}
		
	public Job getJob(){
		return job;
	}
//	public void setPosition(String p){
//		job = getJob();
//	}
	
	public ArrayList<Job> getJobList(){
		return jobList;
	}
	
	public boolean save(Context context){
		FileOutputStream fos;
		ObjectOutputStream os;
		
		try{
			fos = context.openFileOutput(filename, Context.MODE_PRIVATE);
			os = new ObjectOutputStream(fos);
			os.writeObject(job);
			os.flush();
			os.close();
		}
		catch (FileNotFoundException e){
			Log.d(TAG, "Error when saving: " + e);
			return false;
		}
		catch (IOException e){
			Log.d(TAG, "Error when saving: " + e);
		}
		return true;		
	}
	
	public boolean restore(Context context){
		FileInputStream fis;
		ObjectInputStream is;
		
		try {
			fis = context.openFileInput(filename);
			is = new ObjectInputStream(fis);
			job = (Job) is.readObject();
			is.close();
		}
		catch(FileNotFoundException e){
			Log.d(TAG, "Error when restoring: " + e);
			return false;
		}
		catch(IOException e){
			Log.d(TAG, "Error when restoring: " + e);
			return false;
		}
		catch(ClassNotFoundException e){
			Log.d(TAG, "Error when restoring: " + e);
			return false;
		}
		
		return true;
	}
	
}
