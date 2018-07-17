package com.weather.arlocation.services;

import com.weather.arlocation.exceptions.BusinessException;

public interface WeatherService {

	void addUsuarioCiudad(String usuario, String ciudad) throws BusinessException;
	
	void removeCiudad(String usuario, String ciudad) throws BusinessException;
}
