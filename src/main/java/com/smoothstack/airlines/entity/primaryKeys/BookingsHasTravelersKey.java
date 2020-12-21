package com.smoothstack.airlines.entity.primaryKeys;

import java.io.Serializable;
import java.util.Objects;

public class BookingsHasTravelersKey implements Serializable {

	private static final long serialVersionUID = 4174396699412867441L;
	
	private Integer bookingsBookingId;
	
	private Integer bookingsFlightId;
	
	private Integer travelerTravelerId;

	@Override
	public int hashCode() {
		return Objects.hash(bookingsBookingId, bookingsFlightId, travelerTravelerId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookingsHasTravelersKey other = (BookingsHasTravelersKey) obj;
		return Objects.equals(bookingsBookingId, other.bookingsBookingId)
				&& Objects.equals(bookingsFlightId, other.bookingsFlightId)
				&& Objects.equals(travelerTravelerId, other.travelerTravelerId);
	}

}
