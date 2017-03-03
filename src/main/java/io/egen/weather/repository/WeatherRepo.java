package io.egen.weather.repository;

import java.util.List;

import io.egen.weather.persistence.dto.AverageWeather;
import io.egen.weather.persistence.entity.Weather;

public interface WeatherRepo {

	Weather create(Weather weather);
	
	List<String> getCityList();
	
	Weather getLatestWeather(String city);
	
	AverageWeather getAvgWeather(String city, String timeframe);
	
	Weather search(String city);	
}