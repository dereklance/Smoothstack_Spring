package com.smoothstack.airlines.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.smoothstack.airlines.dao.BookingDao;
import com.smoothstack.airlines.dao.BookingsHasTravelersDao;
import com.smoothstack.airlines.dao.FlightDao;
import com.smoothstack.airlines.dao.TravelerDao;
import com.smoothstack.airlines.entity.Booking;
import com.smoothstack.airlines.entity.Flight;
import com.smoothstack.airlines.entity.Traveler;
import com.smoothstack.airlines.entity.primaryKeys.BookingKey;
import com.smoothstack.airlines.exceptions.ResourceExistsException;
import com.smoothstack.airlines.exceptions.ResourceNotFoundException;

@Component
public class BookingService {
	
	@Autowired BookingDao bookingDao;
	@Autowired FlightDao flightDao;
	@Autowired TravelerDao travelerDao;
	@Autowired BookingsHasTravelersDao bookingsHasTravelersDao;
	
	public List<Booking> getBookingsByTraveler(Integer travelerId) throws ResourceNotFoundException {
		Optional<Traveler> traveler = travelerDao.findById(travelerId);
		if(traveler.isEmpty()) {
			throw new ResourceNotFoundException();
		}
		
		Set<BookingKey> bookingKeys = bookingsHasTravelersDao.findByTravelerTravelerId(travelerId).stream()
			.map(result -> {
				Integer bookingId = result.getBookings_bookingId();
				Integer flightId = result.getBookings_flightId();
				return new BookingKey(bookingId, flightId);
			})
			.collect(Collectors.toSet());
		return bookingDao.findAllById(bookingKeys);
	}

	@Transactional
	public Booking createBooking(Booking booking, Integer travelerId) throws ResourceExistsException, ResourceNotFoundException {
		Booking dbBooking = bookingDao.findByBookingId(booking.getBookingId());
		if (dbBooking != null) {
			throw new ResourceExistsException();
		}
		
		Optional<Traveler> traveler = travelerDao.findById(travelerId);
		if (traveler.isEmpty()) {
			throw new ResourceNotFoundException();
		}
		
		booking.getTravelers().add(traveler.get());
		Flight flight = flightDao.findByFlightId(booking.getFlightId());
		
		booking.setFlight(flight);
		return bookingDao.save(booking);
	}

	// ignores update to primary key fields
	public void updateBooking(Booking booking) throws ResourceNotFoundException {
		Booking dbBooking = bookingDao.findByBookingId(booking.getBookingId());
		if (dbBooking == null) {
			throw new ResourceNotFoundException();
		}
		
		dbBooking.setIsActive(booking.getIsActive());
		dbBooking.setStripeId(booking.getStripeId());
		bookingDao.save(dbBooking);
	}

	@Transactional
	public void deleteBooking(Integer bookingId) throws ResourceNotFoundException {
		Booking dbBooking = bookingDao.findByBookingId(bookingId);
		if (dbBooking == null) {
			throw new ResourceNotFoundException();
		}
		
		bookingDao.delete(dbBooking);
	}
}
