package com.fullprojects.fleetapp.services;

import com.fullprojects.fleetapp.models.Location;
import com.fullprojects.fleetapp.models.State;
import com.fullprojects.fleetapp.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    //Return List of countries
    public List<Location> getLocations(){
        return locationRepository.findAll();
    };

    //add/save Countries to database
    public void save( Location location){
        locationRepository.save(location);
    }

    //get by id
    public Optional<Location> findById(int id){
        return locationRepository.findById(id);
    }

    public void delete(Integer id) {
        locationRepository.deleteById(id);
    }


}
