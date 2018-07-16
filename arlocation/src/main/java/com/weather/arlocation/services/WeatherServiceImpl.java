package com.weather.arlocation.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weather.arlocation.db.DBDriver;

@Service
public class WeatherServiceImpl implements WeatherService  {

	@Autowired
	private DBDriver dbDriver;
	
	@Override
	public void addCiudad(String usuario, String ciudad){
		if(!existeUsuario(usuario)){
			dbDriver.addUsuario(usuario);
		}
		dbDriver.addCiudad(usuario, ciudad);
	}
	
	@Override
	public void removeCiudad(String usuario, String ciudad){
		dbDriver.deleteCiudad(usuario, ciudad);
	}
	
	private boolean existeUsuario(String usuario){
		return dbDriver.existeUsuario(usuario);
	}
}
