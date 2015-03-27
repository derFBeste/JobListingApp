package com.project.jobsfredbesteman;

public class Job {
	private String company;
	private String contact;
	private String position;
	
	
	public Job(String company, String contact, String title){
		super();
		this.company = company;
		this.contact = contact;
		this.position = title;
	}
	
	@Override
	public String toString(){
		return String.format("%s - %s %n %s", company, contact, position);
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}


	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}


	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}
	

}
