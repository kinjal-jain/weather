package io.egen.weather.persistence.dto;

public class AverageWeather {

	private String city;
	private Double avgHumidity;
	private Double avgPressure;
	private Double avgTemperature;
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public AverageWeather(String city, Double avgHumidity, Double avgPressure, Double avgTemperature) {
		this.city= city;
		this.avgHumidity = avgHumidity;
		this.avgPressure = avgPressure;
		this.avgTemperature = avgTemperature;
	}
	public Double getAvgHumidity() {
		return avgHumidity;
	}
	
	public void setAvgHumidity(Double avgHumidity) {
		this.avgHumidity = avgHumidity;
	}
	
	public Double getAvgPressure() {
		return avgPressure;
	}
	
	public void setAvgPressure(Double avgPressure) {
		this.avgPressure = avgPressure;
	}
	
	public Double getAvgTemperature() {
		return avgTemperature;
	}
	
	public void setAvgTemperature(Double avgTemperature) {
		this.avgTemperature = avgTemperature;
	}
}
