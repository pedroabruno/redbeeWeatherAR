package com.weather.arlocation.resources;

import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.weather.arlocation.services.WeatherService;

@RestController
public class ARRestController {
	
	@Autowired
	private WeatherService weatherService;
	
	@RequestMapping("/")
	public String welcome(){
		return "ARLOCATION app is on";
	}
		
	@ModelAttribute
	public void setHeader(HttpServletResponse response) {
	    response.setHeader("Vary", "Accept");
	    response.addHeader("Access-Control-Allow-Origin", "*");
	    response.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
	}  
	
	@RequestMapping(value = "/addLocation", method = RequestMethod.POST, consumes = "application/json")
	public Response agregarCiudad(@RequestBody AddLocationRequest request) {
		try {
			weatherService.addCiudad(request.getUsuario(), request.getCiudad());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return Response.status(400).build();
	}
	
	@RequestMapping(value = "/removeLocation", method = RequestMethod.POST, consumes = "application/json")
	public Response borrarCiudad(@RequestBody AddLocationRequest request) {
		try {
			weatherService.removeCiudad(request.getUsuario(), request.getCiudad());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return Response.status(400).build();
	}
}
