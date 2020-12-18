package com.smoothstack.airlines.dao;

import org.springframework.stereotype.Repository;

import com.smoothstack.airlines.entity.Airport;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AirportDao extends JpaRepository<Airport, Integer> {

	
}
