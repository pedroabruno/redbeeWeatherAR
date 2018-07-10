package com.weather.arlocation.db;

public interface DBDriver {
	
	void addCiudad(String usuario, String ciudad);
	
	void deleteCiudad(String usuario, String ciudad);
}
