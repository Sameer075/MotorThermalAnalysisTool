package com.motorThremal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.motorThremal.model.DeviceDtls;
import com.motorThremal.service.DeviceService;

@RestController
@RequestMapping("/device")
public class DeviceController {
	@Autowired
	private DeviceService deviceService;

	@GetMapping
	private List<DeviceDtls> getAll() {
		return deviceService.getAll();
	}

	@GetMapping("/{id}")
	private DeviceDtls getById(@PathVariable int id) {
		return deviceService.getByID(id);
	}

	@PostMapping
	private ResponseEntity<DeviceDtls> add(@RequestBody DeviceDtls de) {
		DeviceDtls d = null;
		try {
			d = this.deviceService.addOrUpdate(de);
			System.out.print(de);
			return ResponseEntity.of(Optional.of(d));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PutMapping("/{name}/tempreture")
	private DeviceDtls update(@PathVariable String name, @RequestParam double tempreture) {
		return deviceService.storeTemperature(name, tempreture);
	}

	@DeleteMapping("/{name}")
	private void Delete(@PathVariable String name) {
		deviceService.deleteByID(name);
	}
}
