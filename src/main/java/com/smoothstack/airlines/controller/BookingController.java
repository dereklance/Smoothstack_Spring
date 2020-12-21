package com.smoothstack.airlines.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.smoothstack.airlines.entity.Booking;
import com.smoothstack.airlines.exceptions.ResourceExistsException;
import com.smoothstack.airlines.exceptions.ResourceNotFoundException;
import com.smoothstack.airlines.service.BookingService;

@RestController
@RequestMapping("/bookings")
public class BookingController {

	@Autowired
	BookingService bookingService;

	@GetMapping("/travelers/{travelerId}")
	public List<Booking> getAllBookings(@PathVariable Integer travelerId) {
		try {
			return bookingService.getBookingsByTraveler(travelerId);
		} catch (ResourceNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Traveler with id " + travelerId + " not found.");
		}
	}

	@PostMapping("/travelers/{travelerId}")
	public ResponseEntity<Booking> createBooking(@RequestBody Booking booking, @PathVariable Integer travelerId) {
		try {
			bookingService.createBooking(booking, travelerId);
			return ResponseEntity.created(new URI("/bookings/" + booking.getBookingId())).body(booking);
		} catch (ResourceExistsException e) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, "Resource already exists.", e);
		} catch (DataIntegrityViolationException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Constraint failed.", e);
		} catch (URISyntaxException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Malformed location URI", e);
		} catch (ResourceNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Traveler with id " + travelerId + " not found.");
		}
	}

	@PutMapping
	public ResponseEntity<Booking> updateBooking(@RequestBody Booking booking) {
		try {
			bookingService.updateBooking(booking);
			return ResponseEntity.ok(booking);
		} catch (ResourceNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Booking with id " + booking.getBookingId() + " not found.");
		} catch (DataIntegrityViolationException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Constraint failed.", e);
		}
	}
	
	@DeleteMapping("/{bookingId}")
	public ResponseEntity<String> deleteBooking(@PathVariable Integer bookingId) {
		try {
			bookingService.deleteBooking(bookingId);
			return ResponseEntity.ok("Booking deleted successfully.");
		} catch (ResourceNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Booking with id " + bookingId + " not found.");
		}
	}
}
