package io.egen.weather.service;

import java.util.List;

import io.egen.weather.persistence.dto.AverageWeather;
import io.egen.weather.persistence.entity.Weather;

public interface WeatherService {
	
	Weather create(Weather weather);
	List<String> cityList();
	Weather latestWeather(String city);
	AverageWeather avgWeather(String city, String timeframe);
	
	
	
}
