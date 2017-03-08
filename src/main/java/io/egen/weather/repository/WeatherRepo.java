package io.egen.weather.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import io.egen.weather.persistence.dto.AverageWeather;
import io.egen.weather.persistence.entity.Weather;

public interface WeatherRepo extends JpaRepository<Weather, String>{

	@Query("SELECT DISTINCT city FROM Weather")
	List<String> getCityList();
	
	@Query("SELECT w FROM Weather w WHERE w.city=:wCity ORDER BY w.timestamp DESC")
	List<Weather> getLatestWeather(@Param("wCity") String city);
	
//	@Query("SELECT NEW io.egen.weather.persistence.dto.AverageWeather"
//			+ "(city, "
//			+ "ROUND(AVG(humidity),2) AS avgHumidity, "
//			+ "ROUND(AVG(pressure),2) AS avgPressure, "
//			+ "ROUND(AVG(temperature),2) AS avgTemperature, "
//			+ "ROUND(AVG(speed),2) AS avgWindSpeed, "
//			+ "ROUND(AVG(degree),2) AS avgWindDegree) "
//			+ "FROM Weather w INNER JOIN Wind v ON v.id=w.wind_id "
//			+ "WHERE city=:wCity")
	@Query("SELECT NEW io.egen.weather.persistence.dto.AverageWeather(city, ROUND(AVG(humidity),2) AS avgHumidity, ROUND(AVG(pressure),2) AS avgPressure, ROUND(AVG(temperature),2) AS avgTemperature) FROM Weather WHERE city=:wCity")
	AverageWeather getAvgWeather(@Param("wCity") String city);
	
//				SELECT 
//			    a.nameA, /* TableA.nameA */
//			    d.nameD /* TableD.nameD */
//			FROM TableA a 
//			    INNER JOIN TableB b on b.aID = a.aID 
//			    INNER JOIN TableC c on c.cID = b.cID 
//			    INNER JOIN TableD d on d.dID = a.dID 
//			WHERE DATE(c.`date`) = CURDATE()
//	FROM Orders
//	INNER JOIN Customers
//	ON Orders.CustomerID=Customers.CustomerID;
	
	@Query("SELECT w FROM Weather w WHERE w.city=:wCity ORDER BY w.timestamp DESC")
	List<Weather> search(@Param("wCity") String city);	
}