package com.smoothstack.airlines.entity;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "tbl_traveler")
public class Traveler {
	
	@Id private Integer travelerId;
	
	private String name;
	
	private String address;
	
	private String phone;
	
	private String email;
	
	private Date dob;
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, mappedBy = "travelers")
	private Set<Booking> bookings = new HashSet<>();
}
