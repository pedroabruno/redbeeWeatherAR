package com.weather.arlocation.db;

import com.weather.arlocation.exceptions.BusinessException;

public interface DBDriver {
	
	void addCiudad(String ciudad) throws BusinessException;
	
	void addPersona(String persona) throws BusinessException;

	void addPersonaCiudad(String persona, String ciudad) throws BusinessException;
	
	void deletePersonaCiudad(String persona, String ciudad) throws BusinessException;
	
	boolean existePersona(String persona) throws BusinessException;
	
	boolean existeCiudad(String ciudad) throws BusinessException;
	
}
