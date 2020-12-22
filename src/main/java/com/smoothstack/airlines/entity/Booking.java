package com.smoothstack.airlines.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.smoothstack.airlines.entity.primaryKeys.BookingKey;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "tbl_booking")
@IdClass(BookingKey.class)
public class Booking {

	@Id private Integer bookingId;
	
	@Id private Integer flightId;

	private Boolean isActive;

	private String stripeId;

	private Integer bookerId;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name = "tbl_flight_has_bookings", joinColumns = {
			@JoinColumn(name = "bookings_bookingId", referencedColumnName = "bookingId"),
			@JoinColumn(name = "bookings_flightId", referencedColumnName = "flightId") }, inverseJoinColumns = {
					@JoinColumn(name = "flights_flightId", referencedColumnName = "flightId"),
					@JoinColumn(name = "flights_departTime", referencedColumnName = "departTime"),
					@JoinColumn(name = "flights_departCityId", referencedColumnName = "departCityId"),
					@JoinColumn(name = "flights_arriveCityId", referencedColumnName = "arriveCityId") })
	private Flight flight;

	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name = "tbl_bookings_has_travelers", joinColumns = {
			@JoinColumn(name = "bookings_bookingId", referencedColumnName = "bookingId"),
			@JoinColumn(name = "bookings_flightId", referencedColumnName = "flightId") }, inverseJoinColumns = {
					@JoinColumn(name = "traveler_travelerId", referencedColumnName = "travelerId") })
	private Set<Traveler> travelers = new HashSet<>();
}
