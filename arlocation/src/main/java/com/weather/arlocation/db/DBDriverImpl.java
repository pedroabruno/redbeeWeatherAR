package com.weather.arlocation.db;

import java.sql.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.weather.arlocation.exceptions.BusinessException;

@Service
public class DBDriverImpl implements DBDriver{
	
	@Value("${dbUrl}")
	private String dbUrl;
	
	@Value("${dbUser}")
	private String dbUser;
	
	@Value("${dbPass}")
	private String dbPass;
	
	@Override
	public synchronized void addCiudad(String ciudad) throws BusinessException{
				
		try{
			Connection myConn = DriverManager.getConnection(dbUrl,dbUser,dbPass);
			Statement query = myConn.createStatement();
			try{
				query.executeUpdate("INSERT INTO WEATHER.CIUDAD(idCiudad) VALUES ('"+ciudad+"')");
			}catch(SQLException e){
				e.printStackTrace();
			}
		}catch(SQLException e){
			throw new BusinessException(e.getMessage());
		}
	}
	
	@Override
	public synchronized void addPersonaCiudad(String persona, String ciudad) throws BusinessException{
				
		try{
			Connection myConn = DriverManager.getConnection(dbUrl,dbUser,dbPass);
			Statement query = myConn.createStatement();
			try{
				query.executeUpdate("INSERT INTO WEATHER.RELPERSONACIUDAD VALUES ('"+persona+"','"+ciudad+"')");
			}catch(SQLException e){
				e.printStackTrace();
			}
		}catch(SQLException e){
			throw new BusinessException(e.getMessage());
		}
	}
	
	@Override
	public synchronized void deletePersonaCiudad(String persona, String ciudad) throws BusinessException{
		String query = "DELETE FROM WEATHER.RELPERSONACIUDAD WHERE idPersona = '" + persona + "' and idCiudad = '"+ciudad+ "'";
		dbExecuteUpdate(query);
	}
	
	@Override
	public boolean existePersona(String persona) throws BusinessException{
		String query = "SELECT * FROM WEATHER.PERSONA WHERE idPersona = '" + persona + "'" ;
		ResultSet resultSet = dbExecuteSelect(query);
		try {
			if(!resultSet.next()){
				return false;
			}
		} catch (SQLException e) {
			throw new BusinessException(e.getMessage());
		}
		return true;
	}
	
	@Override
	public boolean existeCiudad(String ciudad) throws BusinessException{
		String query = "SELECT * FROM WEATHER.Ciudad WHERE idCiudad = '" + ciudad + "'" ;
		ResultSet resultSet = dbExecuteSelect(query);
		try {
			if(!resultSet.next()){
				return false;
			}
		} catch (SQLException e) {
			throw new BusinessException(e.getMessage());
		}
		return true;
	}
	
	@Override
	public synchronized void addPersona(String persona) throws BusinessException{
		String query = "INSERT INTO WEATHER.PERSONA values('" + persona + "')";
		dbExecuteUpdate(query);
	}
	
	
	private void dbExecuteUpdate(String nQuery) throws BusinessException{
		
		
		try{
			Connection myConn = DriverManager.getConnection(dbUrl,dbUser,dbPass);
			Statement query = myConn.createStatement();
			query.executeUpdate(nQuery);
		}catch(SQLException e){
			throw new BusinessException(e.getMessage());
		}
	}
	
	private ResultSet dbExecuteSelect(String nQuery) throws BusinessException{
		
		ResultSet resultSet = null;
		try{
			Connection myConn = DriverManager.getConnection(dbUrl,dbUser,dbPass);
			Statement query = myConn.createStatement();
			resultSet = query.executeQuery(nQuery);
		}catch(SQLException e){
			throw new BusinessException(e.getMessage());
		}
		return resultSet;	

	}
	
}
