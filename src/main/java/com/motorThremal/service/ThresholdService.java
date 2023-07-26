package com.motorThremal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.motorThremal.Repo.ThresholdRepo;
import com.motorThremal.model.Threshold;

@Service
public class ThresholdService {
	@Autowired
	private ThresholdRepo thresholdRepo;

	public Threshold addOrUpdate(Threshold threshold) {

		return thresholdRepo.save(threshold);
	}

	public boolean deleteByID(int id) {
		thresholdRepo.deleteById(id);
		return true;
	}

	public List<Threshold> getAll() {
		return thresholdRepo.findAll();
	}

	public Threshold getByID(int id) {
		return thresholdRepo.findById(id).get();
	}
}
