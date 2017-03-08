package io.egen.weather.persistence.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import io.egen.weather.persistence.entity.Wind;

@Entity
public class Weather {

	@Id
	private String id;
	
	private String city;
	private String description;
	private double humidity;
	private double pressure;
	private float temperature;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Wind wind;
	
	@Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;
	//private String timestamp;
	
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
	
	public Date getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	
}