package com.api.pojos;

import java.util.List;

public class BodyParams {
	
	  private Dashboard dashboard;
	  private List<Courses> courses;
	  
	public Dashboard getDashboard() {
		return dashboard;
	}
	public void setDashboard(Dashboard dashboard) {
		this.dashboard = dashboard;
	}
	public List<Courses> getCourses() {
		return courses;
	}
	public void setCourses(List<Courses> courses) {
		this.courses = courses;
	}

}
