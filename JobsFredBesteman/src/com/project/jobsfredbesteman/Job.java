package com.project.jobsfredbesteman;

public class Job {
	private String company;
	private String contact;
	private String title;
	
	
	public Job(String company, String contact, String title){
		super();
		this.company = company;
		this.contact = contact;
		this.title = title;
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


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}
	

}
