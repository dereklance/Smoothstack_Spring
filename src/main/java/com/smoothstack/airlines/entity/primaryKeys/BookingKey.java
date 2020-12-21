package com.smoothstack.airlines.entity.primaryKeys;

import java.io.Serializable;
import java.util.Objects;

public class BookingKey implements Serializable {
	
	private static final long serialVersionUID = -22589358761022863L;

	private Integer bookingId;
	
	private Integer flightId;
	
	public BookingKey() {}
	
	public BookingKey(Integer bookingId, Integer flightId) {
		this.bookingId = bookingId;
		this.flightId = flightId;
	}

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public Integer getFlightId() {
		return flightId;
	}

	public void setFlightId(Integer flightId) {
		this.flightId = flightId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookingId, flightId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookingKey other = (BookingKey) obj;
		return Objects.equals(bookingId, other.bookingId)
				&& Objects.equals(flightId, other.flightId);
	}
	
}
