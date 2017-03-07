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
import io.egen.weather.persistence.dto.SearchResult;
import io.egen.weather.persistence.entity.Weather;
import io.egen.weather.service.WeatherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping(value = "weather-api")
@Api(tags = "weather")
public class WeatherController {

	@Autowired
	public WeatherService service;
	
	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value = "Gets the data")
	public Weather create(@RequestBody Weather weather){
		return service.create(weather);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/cities")
	@ApiOperation(value = "find all cities", notes = "Returns a list of cities of which weather data is present")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error")
	})
	public List<String> uniqueCities(){
		return service.getUniqueCityList();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/latest/{city}")
	@ApiOperation(value = "find latest weather of the city", notes = "Returns the latest weather of the city asked by the user")
	public Weather latestWeather(@PathVariable("city") String city){
		return service.latestWeather(city);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/average")
	@ApiOperation(value = "finds the average data of the city", notes = "Returns the average data of the city's weather for the time period asked by the user")
	public AverageWeather avgWeather(@RequestParam("city") String city, @RequestParam("timeframe") String timeframe){
		return service.avgWeather(city,timeframe);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "latest/search")
	@ApiOperation(value = "finds the latest average data of the city", notes = "Returns the latest average value of the property asked for the city")
	public SearchResult search(@RequestParam("city") String city, @RequestParam("property") String property){
		return service.search(city,property);
	}
	
}