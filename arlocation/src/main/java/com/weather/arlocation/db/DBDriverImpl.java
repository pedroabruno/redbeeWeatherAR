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
		String query = "DELETE FROM WEATHER.RELPERSONACIUDAD WHERE idPersona = '" + usuario + "' and codCiudad = '"+ ciudad + "'";
		dbExecuteUpdate(query);
	}
	
	@Override
	public boolean existeUsuario(String usuario){
		String query = "SELECT * FROM WEATHER.PERSONA WHERE idPersona = '" + usuario + "'" ;
		ResultSet resultSet = dbExecuteSelect(query);
		try {
			if(!resultSet.next()){
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	@Override
	public void addUsuario(String usuario){
		String query = "INSERT INTO WEATHER.PERSONA values('" + usuario + "')";
		dbExecuteUpdate(query);
	}
	
	private void dbExecuteUpdate(String nQuery){
		
		String loginUrl = "jdbc:mysql://localhost:3306/weather";
		String loginUser = "root";
		String loginPass = "1234";
		
		try{
			Connection myConn = DriverManager.getConnection(loginUrl,loginUser,loginPass);
			Statement query = myConn.createStatement();
			query.executeUpdate(nQuery);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	private ResultSet dbExecuteSelect(String nQuery){
		
		String loginUrl = "jdbc:mysql://localhost:3306/weather";
		String loginUser = "root";
		String loginPass = "1234";
		ResultSet resultSet = null;
		try{
			Connection myConn = DriverManager.getConnection(loginUrl,loginUser,loginPass);
			Statement query = myConn.createStatement();
			resultSet = query.executeQuery(nQuery);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return resultSet;	

	}
	
}
