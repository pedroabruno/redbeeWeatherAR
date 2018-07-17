package com.weather.arlocation.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weather.arlocation.db.DBDriver;
import com.weather.arlocation.exceptions.BusinessException;

@Service
public class WeatherServiceImpl implements WeatherService  {

	@Autowired
	private DBDriver dbDriver;
	
	@Override
	public void addUsuarioCiudad(String usuario, String ciudad) throws BusinessException{
		if(!existeUsuario(usuario)){
			dbDriver.addPersona(usuario);
		}
		if(!existeCiudad(ciudad)){
			
			dbDriver.addCiudad(ciudad);
		}
		dbDriver.addPersonaCiudad(usuario, ciudad);
	}
	
	@Override
	public void removeCiudad(String usuario, String ciudad) throws BusinessException{
		dbDriver.deletePersonaCiudad(usuario, ciudad);
	}
	
	private boolean existeUsuario(String usuario) throws BusinessException{
		return dbDriver.existePersona(usuario);
	}
	
	private boolean existeCiudad(String usuario) throws BusinessException{
		return dbDriver.existeCiudad(usuario);
	}
}
