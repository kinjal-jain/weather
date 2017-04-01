package io.egen.weather.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.egen.weather.exception.NotFoundException;
import io.egen.weather.persistence.dto.AverageWeather;
import io.egen.weather.persistence.entity.Weather;

public interface WeatherRepo extends JpaRepository<Weather, String>{

	@Query("SELECT DISTINCT city FROM Weather")
	List<String> getCityList();
	
	@Query("SELECT w FROM Weather w WHERE w.city=:wCity ORDER BY w.timestamp DESC")
	List<Weather> getLatestWeather(@Param("wCity") String city) throws NotFoundException;

	@Query("SELECT NEW io.egen.weather.persistence.dto.AverageWeather(city, ROUND(AVG(humidity),2) AS avgHumidity, ROUND(AVG(pressure),2) AS avgPressure, ROUND(AVG(temperature),2) AS avgTemperature) FROM Weather WHERE city=:wCity AND timestamp>:wTime")
	AverageWeather getAvgWeather(@Param("wCity") String city, @Param("wTime") Date time) throws NotFoundException;
	
	@Query("SELECT w FROM Weather w WHERE w.city=:wCity ORDER BY w.timestamp DESC")
	List<Weather> search(@Param("wCity") String city) throws NotFoundException;

}