package com.motorThremal.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "T_Threshold")
public class Threshold {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "temp")
	public double temp;

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	@Column(name = "timestamp")
	@CreationTimestamp
	private Timestamp timestamp;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "device_id", referencedColumnName = "deviceid")
	@JsonBackReference
	private DeviceDtls deviceDtls;

	// Getter Setter Methods......................
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getTemp() {
		return temp;
	}

	public void setTemp(double temp) {
		this.temp = temp;
	}

	public DeviceDtls getDeviceDtls() {
		return deviceDtls;
	}

	public void setDeviceDtls(DeviceDtls deviceDtls) {
		this.deviceDtls = deviceDtls;
	}

}
