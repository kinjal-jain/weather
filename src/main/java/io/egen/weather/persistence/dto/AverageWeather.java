package io.egen.weather.persistence.dto;

public class AverageWeather {

	private String city;
	private String avgHumidity;
	private String avgPressure;
	private String avgTemperature;
	private String avgWindSpeed;
	private String avgWindDegree;
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getAvgHumidity() {
		return avgHumidity;
	}
	
	public void setAvgHumidity(String avgHumidity) {
		this.avgHumidity = avgHumidity;
	}
	
	public String getAvgPressure() {
		return avgPressure;
	}
	
	public void setAvgPressure(String avgPressure) {
		this.avgPressure = avgPressure;
	}
	
	public String getAvgTemperature() {
		return avgTemperature;
	}
	
	public void setAvgTemperature(String avgTemperature) {
		this.avgTemperature = avgTemperature;
	}
	
	public String getAvgWindSpeed() {
		return avgWindSpeed;
	}
	
	public void setAvgWindSpeed(String avgWindSpeed) {
		this.avgWindSpeed = avgWindSpeed;
	}
	
	public String getAvgWindDegree() {
		return avgWindDegree;
	}
	
	public void setAvgWindDegree(String avgWindDegree) {
		this.avgWindDegree = avgWindDegree;
	}
	
}
