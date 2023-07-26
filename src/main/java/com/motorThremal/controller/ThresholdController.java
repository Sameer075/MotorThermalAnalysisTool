package com.motorThremal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.motorThremal.model.Threshold;
import com.motorThremal.service.ThresholdService;

@RestController
@RequestMapping("/threshold")
public class ThresholdController {
	@Autowired
	private ThresholdService thresholdService;

	@GetMapping
	private List<Threshold> getAll() {
		return thresholdService.getAll();
	}

	@GetMapping("/{id}")
	private Threshold getById(@PathVariable int id) {
		return thresholdService.getByID(id);
	}

	@PostMapping
	private Threshold add(@RequestBody Threshold t) {
		return thresholdService.addOrUpdate(t);
	}

	@PutMapping("/{id}")
	private Threshold update(@PathVariable int id, @RequestBody Threshold t) {
		t.setId(id);
		return thresholdService.addOrUpdate(t);
	}

	@DeleteMapping("/{id}")
	private void Delete(@PathVariable int id) {
		thresholdService.deleteByID(id);
	}
}
