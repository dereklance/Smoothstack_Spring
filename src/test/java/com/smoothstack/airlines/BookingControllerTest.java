package com.smoothstack.airlines;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import com.smoothstack.airlines.controller.BookingController;
import com.smoothstack.airlines.entity.Booking;
import com.smoothstack.airlines.service.BookingService;

class BookingControllerTest {
	
	@InjectMocks
	private BookingController bookingController;
	
	@Mock
	private BookingService bookingService;

	@Test
	void testGetAllBookings() {
		List<Booking> booking = new ArrayList<>();
		// when(bookingService.getBookingsByTraveler(1)).thenReturn(booking);
		// bookingController.getAllBookings(1);
	}

	@Test
	void testCreateBooking() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateBooking() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteBooking() {
		fail("Not yet implemented");
	}

}
