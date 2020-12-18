package com.smoothstack.airlines.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.smoothstack.airlines.dao.AirportDao;
import com.smoothstack.airlines.entity.Airport;
import com.smoothstack.airlines.exceptions.ResourceDoesNotExistException;
import com.smoothstack.airlines.exceptions.ResourceExistsException;

@Component
public class AirportService {

	@Autowired
	AirportDao airportDao;

	public Optional<Airport> getAirportById(int id) {
		return airportDao.findById(id);
	}

	public List<Airport> getAirports() {
		return airportDao.findAll();
	}
	
	public Airport createAirport(Airport airport) throws ResourceExistsException {
		if (airportDao.existsById(airport.getAirportId())) {
			throw new ResourceExistsException();
		}
		return airportDao.save(airport);
	}
	
	public Airport updateAirport(Airport airport) throws ResourceDoesNotExistException {
		if (airportDao.existsById(airport.getAirportId())) {
			return airportDao.save(airport);
		}
		throw new ResourceDoesNotExistException();
	}
	
	public void deleteAirport(int id) throws ResourceDoesNotExistException {
		if (airportDao.existsById(id)) {
			airportDao.deleteById(id);
		}
		else {
			throw new ResourceDoesNotExistException();
		}
	}
}
