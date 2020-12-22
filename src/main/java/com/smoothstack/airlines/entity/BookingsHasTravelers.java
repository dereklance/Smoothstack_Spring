package com.smoothstack.airlines.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.smoothstack.airlines.entity.primaryKeys.BookingsHasTravelersKey;

import lombok.Data;

@Data
@Entity
@IdClass(BookingsHasTravelersKey.class)
@Table(name = "tbl_bookings_has_travelers")
public class BookingsHasTravelers {
	
	@Id
	@Column(name = "bookings_bookingId")
	private Integer bookingsBookingId;
	
	@Id
	@Column(name = "bookings_flightId")
	private Integer bookingsFlightId;
	
	@Id
	@Column(name = "traveler_travelerId")
	private Integer travelerTravelerId;

//	public Integer getBookings_bookingId() {
//		return bookingsBookingId;
//	}
//
//	public void setBookings_bookingId(Integer bookings_bookingId) {
//		this.bookingsBookingId = bookings_bookingId;
//	}
//
//	public Integer getBookings_flightId() {
//		return bookingsFlightId;
//	}
//
//	public void setBookings_flightId(Integer bookings_flightId) {
//		this.bookingsFlightId = bookings_flightId;
//	}
//
//	public Integer getTraveler_travelerId() {
//		return travelerTravelerId;
//	}
//
//	public void setTraveler_travelerId(Integer traveler_travelerId) {
//		this.travelerTravelerId = traveler_travelerId;
//	}
}
