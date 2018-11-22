package com.techelevator.npgeek.model;

public class Weather {

	private String parkCode;
	
	private int fiveDayForeCastValue;
	
	private int low;
	
	private int high; 
	
	private String forecast;
	
	private String advisory;

	public String getParkCode() {
		return parkCode;
	}

	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}

	public int getFiveDayForeCastValue() {
		return fiveDayForeCastValue;
	}

	public void setFiveDayForeCastValue(int fiveDayForeCastValue) {
		this.fiveDayForeCastValue = fiveDayForeCastValue;
	}

	public int getLow() {
		return low;
	}

	public void setLow(int low) {
		this.low = low;
	}

	public int getHigh() {
		return high;
	}

	public void setHigh(int high) {
		this.high = high;
	}

	public String getForecast() {
		return forecast;
	}

	public void setForecast(String forecast) {
		this.forecast = forecast;
	}
	public String getAdvisory() {
		String advisory = "";
		
		if (forecast.equals("snow")) {
			advisory = "Pack snowshoes! \n";
		}
		if (forecast.equals("rain")) {
			advisory = "Pack rain gear and wear waterproof shoes! \n";
		}
		if (forecast.equals("thunderstorms")) {
			advisory = "Seek shelter and avoid hiking on exposed ridges! \n";
		}
		if (forecast.equals("sunny")) {
			advisory = "Pack sunblock! \n";
		}
		
		if (high >= 75) {
			advisory += "Bring an extra gallon of water";
		}
		
		if ((high - low) > 20) {
			advisory += "Wear breathable layers";
		}
		if (low < 20) {
			advisory += "DANGER! Beware of freezing temperatures";
		}
		
		
		
		return advisory;
		
	}
}
