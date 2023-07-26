package com.motorThremal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.motorThremal.Repo.DeviceRepo;
import com.motorThremal.Repo.ThresholdRepo;
import com.motorThremal.model.DeviceDtls;
import com.motorThremal.model.Threshold;

@Service
public class DeviceService {
	@Autowired
	private DeviceRepo deviceRepo;

	@Autowired
	private ThresholdRepo thresholdRepo;
	private Threshold threshold;

	public DeviceService(DeviceRepo deviceRepo, ThresholdRepo thresholdRepo) {
		this.deviceRepo = deviceRepo;
		this.thresholdRepo = thresholdRepo;
	}

	public DeviceDtls addOrUpdate(DeviceDtls device) {

		return deviceRepo.save(device);
	}

	public DeviceDtls storeTemperature(String name, Double temperature) {
		List<DeviceDtls> deviceList = deviceRepo.getDeviceIdByName(name);
		Integer deviceId = null;

		for (DeviceDtls device : deviceList) {
			System.out.println(device.getId());
			deviceId = device.getId();
		}
		System.out.println(deviceId);
		if (deviceId != null) {
			DeviceDtls device = deviceRepo.findById(deviceId)
					.orElseThrow(() -> new IllegalArgumentException("Device not found with ID: "));

			Threshold threshold = new Threshold();
			threshold.setTemp(temperature);
			device.addTempreture(threshold);

			return deviceRepo.save(device);
		} else {
			throw new IllegalArgumentException("Device not found with name: M1TY");
		}
	}

	public boolean deleteByID(String name) {
		List<DeviceDtls> deviceList = deviceRepo.getDeviceIdByName(name);
		Integer deviceId = null;

		for (DeviceDtls device : deviceList) {
			System.out.println(device.getId());
			deviceId = device.getId();
		}
		System.out.println(deviceId);
		if (deviceId != null) {
			deviceRepo.deleteById(deviceId);
			return true;

		} else {
			throw new IllegalArgumentException("Device not found with name: M1TY");
		}

	}

	public List<DeviceDtls> getAll() {
		return deviceRepo.findAll();
	}

	public DeviceDtls getByID(int id) {
		return deviceRepo.findById(id).get();
	}

}
