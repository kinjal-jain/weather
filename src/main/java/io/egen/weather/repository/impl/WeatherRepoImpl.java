package io.egen.weather.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.weather.persistence.dto.AverageWeather;
import io.egen.weather.persistence.dto.SearchResult;
import io.egen.weather.persistence.entity.Weather;
import io.egen.weather.repository.WeatherRepo;

@Repository
public class WeatherRepoImpl implements WeatherRepo {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Weather create(Weather weather) {
		em.persist(weather.getWind());
		em.persist(weather);
		em.flush();
		return weather;
	} 
	
	@Override
	public List<String> getCityList(){
		TypedQuery<String> query = em.createNamedQuery("Weather.getCityList",String.class);
		return query.getResultList();
	}

	@Override
	public Weather getLatestWeather(String city) {
		TypedQuery<Weather> query = em.createNamedQuery("Weather.getLatestWeather",Weather.class);
		query.setParameter("wCity", city);
		List<Weather> weather = query.getResultList();
		return weather.get(0);
	}

	@Override
	public AverageWeather getAvgWeather(String city, String timeframe) {            
		AverageWeather avgWeather = (AverageWeather) em.createNamedQuery("Weather.getAvgWeather",AverageWeather.class)
				.setParameter("wCity", city)
				.getSingleResult();
		return avgWeather;
	}

	@Override
	public Weather search(String city) {
		TypedQuery<Weather> query = em.createNamedQuery("Weather.getLatestProperty",Weather.class);
		query.setParameter("wCity", city);
		List<Weather> weather = query.getResultList();
		return weather.get(0);
	}
}