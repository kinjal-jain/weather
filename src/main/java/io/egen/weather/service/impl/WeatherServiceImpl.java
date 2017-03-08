package io.egen.weather.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.weather.persistence.dto.AverageWeather;
import io.egen.weather.persistence.dto.SearchResult;
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
		return repository.save(weather);
	}

	@Override
	public List<String> getUniqueCityList(){
		return repository.getCityList();
	}

	@Override
	public Weather latestWeather(String city) {
		List<Weather> weather = repository.getLatestWeather(city);
		return weather.get(0);
	}

	@Override
	public AverageWeather avgWeather(String city, String timeframe) {
		return repository.getAvgWeather(city);
	}
	
	@Override
	public SearchResult search(String city, String property) {
		List<Weather> weatherList = repository.search(city);
		Weather weather = weatherList.get(0);
		SearchResult sresult = new SearchResult();
		sresult.setProperty(property);
		switch(property) {
		case "description":
			sresult.setValue(weather.getDescription());
			break;
		case "humidity":
			sresult.setValue(Double.toString(weather.getHumidity()));
			break;
		case "pressure":
			sresult.setValue(Double.toString(weather.getPressure()));
			break;
		case "temperature":
			sresult.setValue(Double.toString(weather.getTemperature()));
			break;
		case "windspeed":
			sresult.setValue(Double.toString(weather.getWind().getSpeed()));
			break;
		case "winddegree":
			sresult.setValue(Double.toString(weather.getWind().getDegree()));
			break;
		case "timestamp":
			sresult.setValue(weather.getTimestamp().toString());
			break;
		default:
			sresult.setProperty("city");
			sresult.setValue(city);
			break;
		}
		return sresult;
	}

	
}