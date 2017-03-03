package io.egen.weather.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.weather.persistence.dto.AverageWeather;
import io.egen.weather.persistence.entity.Weather;
import io.egen.weather.repository.WeatherRepo;
import io.egen.weather.service.WeatherService;

@Service
public class WeatherServiceImpl implements WeatherService {

	@Autowired
	public WeatherRepo repository;
	
	@Override
	@Transactional
	public Weather create(Weather weather) {
		System.out.println(weather.getCity());
		System.out.println(weather.getDescription());
		System.out.println(weather.getHumidity());
		System.out.println(weather.getWind().getDegree());
		System.out.println(weather.getWind().getSpeed());
		return repository.create(weather);
	}

	@Override
	public List<String> cityList(){
		System.out.println(repository.getCityList());
		return repository.getCityList();
	}

	@Override
	public Weather latestWeather(String city) {
		System.out.println(repository.getLatestWeather(city));
		return repository.getLatestWeather(city);
	}

	@Override
	public AverageWeather avgWeather(String city, String timeframe) {
		System.out.println(repository.getAvgWeather(city, timeframe));
		return repository.getAvgWeather(city, timeframe);
	}

	
}
