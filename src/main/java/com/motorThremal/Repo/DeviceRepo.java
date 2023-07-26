package com.motorThremal.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.motorThremal.model.DeviceDtls;

public interface DeviceRepo extends JpaRepository<DeviceDtls, Integer> {
	@Query("SELECT d FROM DeviceDtls d WHERE d.deviceType =:n")
	public List<DeviceDtls> getDeviceIdByName(@Param("n") String name);

}
