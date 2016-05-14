package org.tutorial.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vehicle {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name = "ID")
	private int vehicleID;
	@Column (name = "Vehicle Type")
	private String vehicleType;
	@Column (name = "VehicleName")
	private String vehicleName;
		
	public int getVehicleID() {
		return vehicleID;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleID(int vehicleID) {
		this.vehicleID = vehicleID;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	
}
