package com.DBTool;

public class LAL {
	double latitude, longitude;
	
	public LAL() {
		// TODO Auto-generated constructor stub
	}
	
	public LAL(double latitude, double longitude) {
		super();
		this.latitude = latitude;
		this.longitude=longitude;
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public double getLongitude() {
		return longitude;
	}
	
	public void setLatitude(double latitude) {
		this.latitude=latitude;
	}
	
	public void setLongitude(double longitude) {
		this.longitude=longitude;
	}
	public String toString() {
		return "LAL [latitude="+latitude+",longitude="+longitude+"]";
	}
}
