package io.egen.weather.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.egen.weather.persistence.dto.AverageWeather;
import io.egen.weather.persistence.entity.Weather;
import io.egen.weather.service.WeatherService;


@RestController
@RequestMapping(value = "weather-api")
public class WeatherController {

	@Autowired
	public WeatherService service;
	
	@RequestMapping(method = RequestMethod.POST)
	public Weather create(@RequestBody Weather weather){
		return service.create(weather);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/citylist")
	public List<String> cityList(){
		return service.cityList();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/latest/{city}")
	public Weather latestWeather(@PathVariable("city") String city){
		return service.latestWeather(city);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/average")
	public AverageWeather avgWeather(@RequestParam("city") String city, @RequestParam("timeframe") String timeframe){
		return service.avgWeather(city,timeframe);
	}
	
}
