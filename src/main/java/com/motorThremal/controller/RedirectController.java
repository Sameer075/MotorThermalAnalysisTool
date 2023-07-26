package com.motorThremal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.motorThremal.model.DeviceDtls;
import com.motorThremal.service.DeviceService;

@Controller
public class RedirectController {
	@Autowired
	private DeviceService deviceService;

	@GetMapping("/storeTemp")
	public String storeTemp() {
		return "storeTemp";
	}

	@GetMapping("/deviceDetails")
	public String device() {
		return "deviceDetails";
	}

	@GetMapping("/about")
	public String about() {
		return "about";
	}

	@GetMapping("/delete")
	public String delete(Model model) {
		List<DeviceDtls> devices = deviceService.getAll();
		model.addAttribute("deviceInfo", devices);
		return "delete";
	}

	@GetMapping("/")
	public String getAll(Model model) {
		List<DeviceDtls> devices = deviceService.getAll();
		model.addAttribute("deviceInfo", devices);
		return "index";
	}

	@GetMapping("/showDevice")
	public String show(Model model) {
		List<DeviceDtls> devices = deviceService.getAll();
		model.addAttribute("deviceInfo", devices);
		return "showDevice";
	}

	@GetMapping("/authenticate")
	public String auth() {
		return "login";
	}
}
