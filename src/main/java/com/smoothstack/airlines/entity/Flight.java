package com.smoothstack.airlines.entity;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.smoothstack.airlines.entity.primaryKeys.FlightKey;

@Entity
@Table(name = "tbl_flight")
@IdClass(FlightKey.class)
public class Flight {
	
	@Id
	private Integer flightId;

	@Id
	private Timestamp departTime;

	@Id
	private Integer departCityId;

	@Id
	private Integer arriveCityId;

	private Integer seatsAvailable;

	private Float price;

	@OneToMany(mappedBy = "flight", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private Set<Booking> bookings;

	public Set<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}

	public Integer getSeatsAvailable() {
		return seatsAvailable;
	}

	public void setSeatsAvailable(Integer seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String toString() {
		return String.format(
				"-------FLIGHT-------\n" + "FlightId: %s\n" + "DepartTime: %s\n" + "DepartCityId: %d\n"
						+ "ArriveCityId: %d" + "-----------------------",
				getFlightId(), getDepartTime().getTime(), getDepartCityId(),
				getArriveCityId());
	}

	public Integer getFlightId() {
		return flightId;
	}

	public void setFlightId(Integer flightId) {
		this.flightId = flightId;
	}

	public Timestamp getDepartTime() {
		return departTime;
	}

	public void setDepartTime(Timestamp departTime) {
		this.departTime = departTime;
	}

	public Integer getDepartCityId() {
		return departCityId;
	}

	public void setDepartCityId(Integer departCityId) {
		this.departCityId = departCityId;
	}

	public Integer getArriveCityId() {
		return arriveCityId;
	}

	public void setArriveCityId(Integer arriveCityId) {
		this.arriveCityId = arriveCityId;
	}
}
