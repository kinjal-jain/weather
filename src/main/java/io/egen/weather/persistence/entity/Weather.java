package io.egen.weather.persistence.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import io.egen.weather.persistence.entity.Wind;

@Entity
@NamedQueries({
	@NamedQuery(name = "Weather.getCityList", query = "SELECT DISTINCT city FROM Weather"),
	@NamedQuery(name = "Weather.getLatestWeather", query = "SELECT w FROM Weather w WHERE w.city=:wCity ORDER BY w.timestamp DESC"),
	@NamedQuery(name = "Weather.getAvgWeather", query = "SELECT ROUND(AVG(humidity),2) AS avgHumidity, ROUND(AVG(pressure),2) AS avgPressure, ROUND(AVG(temperature),2) AS avgTemperature FROM Weather WHERE city=:wCity"),
	@NamedQuery(name = "Weather.getLatestProperty", query = "SELECT w FROM Weather w WHERE w.city=:wCity ORDER BY w.timestamp DESC")
})
public class Weather {

	@Id
	private String id;
	
	private String city;
	private String description;
	private double humidity;
	private double pressure;
	private float temperature;
	
	@OneToOne
	private Wind wind;
	
	private String timestamp;
	
	public Weather() {
		this.id = UUID.randomUUID().toString();
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public double getHumidity() {
		return humidity;
	}
	
	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}
	
	public double getPressure() {
		return pressure;
	}
	
	public void setPressure(double pressure) {
		this.pressure = pressure;
	}
	
	public float getTemperature() {
		return temperature;
	}
	
	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}
	
	public Wind getWind() {
		return wind;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}
	
	public String getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	
}