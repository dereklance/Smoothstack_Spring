package com.smoothstack.airlines.entity.primaryKeys;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

public class FlightKey implements Serializable {

	private static final long serialVersionUID = -4974417780265156080L;

	private Integer flightId;

	private Timestamp departTime;

	private Integer departCityId;

	private Integer arriveCityId;

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

	@Override
	public int hashCode() {
		return Objects.hash(arriveCityId, departCityId, departTime, flightId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FlightKey other = (FlightKey) obj;
		return Objects.equals(arriveCityId, other.arriveCityId) && Objects.equals(departCityId, other.departCityId)
				&& Objects.equals(departTime, other.departTime) && Objects.equals(flightId, other.flightId);
	}

}
