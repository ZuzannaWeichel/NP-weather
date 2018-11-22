package com.techelevator.npgeek.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class Survey {

	private int surveyId;
	
	@NotBlank(message="Park is required")
	private String parkCode;
	
	@NotBlank(message="Email is required")
	@Email(message="Enter valid email")
	private String emailAddress;
	
	@NotBlank(message="State is required")
	private String state;
	
	@NotBlank(message="Please make a choice")
	private String activityLevel;

	
	public int getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}

	public String getParkCode() {
		return parkCode;
	}

	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getActivityLevel() {
		return activityLevel;
	}

	public void setActivityLevel(String activityLevel) {
		this.activityLevel = activityLevel;
	}
	
	
}
