package io.egen.weather.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Preconditions;
import com.mysql.cj.core.util.StringUtils;

import io.egen.weather.persistence.dto.AverageWeather;
import io.egen.weather.persistence.dto.SearchResult;
import io.egen.weather.persistence.entity.Weather;
import io.egen.weather.service.WeatherService;


@RestController
@RequestMapping(value = "weather-api")
public class WeatherController {

	@Autowired
	public WeatherService service;
	
	Set<String> propertySet = new HashSet<String>(Arrays.asList("description", "humidity", "pressure", "temperature", "windspeed", "winddegree", "timestamp", "city"));
	
	@RequestMapping(method = RequestMethod.POST)
	public Weather create(@RequestBody Weather weather){
		Preconditions.checkNotNull(weather, "The object provided cannot be null");
		return service.create(weather);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/cities")
	public List<String> uniqueCities(){
		return service.getUniqueCityList();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/latest/{city}")
	public Weather latestWeather(@PathVariable("city") String city){
		Preconditions.checkNotNull(city, "The city provided cannot be null");
		Preconditions.checkArgument(StringUtils.isEmptyOrWhitespaceOnly(city), "The City cannot be empty.");
		return service.latestWeather(city);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/average")
	public AverageWeather avgWeather(@RequestParam("city") String city, @RequestParam("timeframe") String timeframe){
		Preconditions.checkNotNull(city, "The city provided cannot be null");
		Preconditions.checkNotNull(timeframe, "The timeframe provided cannot be null");
		return service.avgWeather(city,timeframe);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "latest/search")
	public SearchResult search(@RequestParam("city") String city, @RequestParam("property") String property){
		Preconditions.checkNotNull(city, "The city provided cannot be null");
		Preconditions.checkArgument(propertySet.contains(property.toLowerCase()), "Not a valid property, property = " + property + ". Please select any one from " + propertySet);
		return service.search(city,property);
	}
	
}