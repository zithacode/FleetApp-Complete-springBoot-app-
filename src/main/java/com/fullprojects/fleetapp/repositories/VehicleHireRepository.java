package com.fullprojects.fleetapp.repositories;

import com.fullprojects.fleetapp.models.Location;
import com.fullprojects.fleetapp.models.VehicleHire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleHireRepository extends JpaRepository<VehicleHire, Integer> {
}
