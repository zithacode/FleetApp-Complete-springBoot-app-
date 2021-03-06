package com.fullprojects.fleetapp.controllers;


import com.fullprojects.fleetapp.models.VehicleStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.fullprojects.fleetapp.services.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleStatusController {


    @Autowired  private VehicleStatusService vehicleStatusService;

    @GetMapping("/vehicleStatuses")
    public String getVehicleStatuses(Model model) {

        List<VehicleStatus> vehicleStatusList = vehicleStatusService.getVehicleStatuses();

        model.addAttribute("vehicleStatuses", vehicleStatusList);
        return "vehicleStatus";
    }

    @PostMapping("/vehicleStatuses/addNew")
    public String addNew(VehicleStatus vehicleStatus) {
        vehicleStatusService.save(vehicleStatus);
        return "redirect:/vehicleStatuses";
    }

    @RequestMapping(value = "/vehicleStatuses/findById")
    @ResponseBody
    public Optional<VehicleStatus> findById(int id) {
        return vehicleStatusService.findById(id);
    }

    @RequestMapping(value="/vehicleStatuses/update", method= {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleStatus vehicleStatus) {
        vehicleStatusService.save(vehicleStatus);
        return "redirect:/vehicleStatuses";
    }

    @RequestMapping(value="/vehicleStatuses/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        vehicleStatusService.delete(id);
        return "redirect:/vehicleStatuses";
    }


}
