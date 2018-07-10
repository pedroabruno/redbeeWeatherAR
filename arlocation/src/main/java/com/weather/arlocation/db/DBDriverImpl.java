package com.weather.arlocation.db;

import java.sql.*;

import org.springframework.stereotype.Service;

@Service
public class DBDriverImpl implements DBDriver{
		
	@Override
	public void addCiudad(String usuario, String ciudad){
		
		String loginUrl = "jdbc:mysql://localhost:3306/weather";
		String loginUser = "root";
		String loginPass = "1234";
		
		try{
			Connection myConn = DriverManager.getConnection(loginUrl,loginUser,loginPass);
			Statement query = myConn.createStatement();
			try{
				query.executeUpdate("INSERT INTO WEATHER.RELPERSONACIUDAD VALUES ('"+usuario+"','"+ciudad+"')");
			}catch(SQLException e){
				e.printStackTrace();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	@Override
	public void deleteCiudad(String usuario, String ciudad){
		
		String loginUrl = "jdbc:mysql://localhost:3306/weather";
		String loginUser = "root";
		String loginPass = "1234";
		
		try{
			Connection myConn = DriverManager.getConnection(loginUrl,loginUser,loginPass);
			Statement query = myConn.createStatement();
			try{
				query.executeUpdate("DELETE FROM WEATHER.RELPERSONACIUDAD WHERE idPersona = '" + usuario + "' and codCiudad = '"+ ciudad + "'");
			}catch(SQLException e){
				e.printStackTrace();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
