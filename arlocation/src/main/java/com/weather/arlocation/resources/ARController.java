package com.weather.arlocation.resources;

import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.weather.arlocation.exceptions.BusinessException;
import com.weather.arlocation.services.WeatherService;

@RestController
public class ARController {
	
	final static Logger logger = Logger.getLogger(ARController.class);
	
	@Autowired
	private WeatherService weatherService;
	
	@RequestMapping(value = "/addLocation", method = RequestMethod.POST, consumes = "application/json")
	public Response agregarCiudad(HttpServletResponse response, @RequestBody LocationRequest request) {
		logger.info("comienza addLocation");
		try {
			weatherService.addUsuarioCiudad(request.getUsuario(), request.getCiudad());
		}catch(BusinessException e) {
			logger.error(e.getMensaje());
		}
		logger.info("se envia respuesta addLocation");

		return Response.status(200).build();
	}
	
	@RequestMapping(value = "/removeLocation", method = RequestMethod.POST, consumes = "application/json")
	public Response borrarCiudad(HttpServletResponse response, @RequestBody LocationRequest request) {
		logger.info("comienza addLocation");
		try {
			weatherService.removeCiudad(request.getUsuario(), request.getCiudad());
		}catch(BusinessException e) {
			logger.error(e.getMensaje());
		}
		logger.info("se envia respuesta addLocation");
		return Response.status(200).build();
	}
}
