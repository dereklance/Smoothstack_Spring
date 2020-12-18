package com.smoothstack.airlines.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smoothstack.airlines.entity.Airport;
import com.smoothstack.airlines.exceptions.ResourceDoesNotExistException;
import com.smoothstack.airlines.exceptions.ResourceExistsException;
import com.smoothstack.airlines.service.AirportService;

@RestController
@RequestMapping("/airport")
public class AirportController {

	@Autowired
	AirportService airportService;

	@GetMapping("/{airportId}")
	public Airport getAirportsById(@PathVariable int airportId, HttpServletResponse response) {
		Optional<Airport> airport = airportService.getAirportById(airportId);
		if (airport.isEmpty()) {
			response.setStatus(HttpStatus.NOT_FOUND.value());
			return null;
		}
		return airport.get();
	}

	@GetMapping
	public List<Airport> getAirports(HttpServletResponse response) {
		return airportService.getAirports();
	}
	
	@PostMapping
	public Airport createAirport(@RequestBody Airport airport, HttpServletResponse response) {
		try {
			return airportService.createAirport(airport);
		} catch (ResourceExistsException e) {
			// TODO Auto-generated catch block
			response.setStatus(HttpStatus.BAD_REQUEST.value());
			return null;
		}
	}
	
	@PutMapping
	public Airport updateAirport(@RequestBody Airport airport, HttpServletResponse response) {
		try {
			return airportService.updateAirport(airport);
		} catch (ResourceDoesNotExistException e) {
			response.setStatus(HttpStatus.BAD_REQUEST.value());
			return null;
		}
	}
	
	@DeleteMapping
	public void deleteAirport(@RequestBody int airportId, HttpServletResponse response) {
		try {
			airportService.deleteAirport(airportId);
		} catch (ResourceDoesNotExistException e) {
			response.setStatus(HttpStatus.BAD_REQUEST.value());
		}
	}
	
}
