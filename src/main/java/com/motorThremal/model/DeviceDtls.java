package com.motorThremal.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "T_Device")
public class DeviceDtls {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "deviceid")
	private int id;

	@Column(name = "deviceType")
	private String deviceType;

	@Column(name = "deviceName", unique = true)
	private String deviceDiscr;

	// @JsonIgnoreProperties("deviceDtls")
	@OneToMany(mappedBy = "deviceDtls", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonManagedReference
	private List<Threshold> threshold = new ArrayList<>();

	public void addTempreture(Threshold thresh) {
		threshold.add(thresh);
		thresh.setDeviceDtls(this);
	}

	// Getter Setter Methods......................
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getDeviceDiscr() {
		return deviceDiscr;
	}

	public void setDeviceDiscr(String deviceDiscr) {
		this.deviceDiscr = deviceDiscr;
	}

	public List<Threshold> getThreshold() {
		return threshold;
	}

	public void setThreshold(List<Threshold> threshold) {
		this.threshold = threshold;
	}

}
