package com.motorThremal.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.motorThremal.model.Threshold;

public interface ThresholdRepo extends JpaRepository<Threshold, Integer> {

}
