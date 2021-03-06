package com.fullprojects.fleetapp.controllers;


import com.fullprojects.fleetapp.models.Invoice;
import com.fullprojects.fleetapp.models.JobTitle;
import com.fullprojects.fleetapp.models.Location;
import com.fullprojects.fleetapp.services.JobTitleService;
import com.fullprojects.fleetapp.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class JobTitleController {

    @Autowired
    private JobTitleService jobTitleService;

    @GetMapping("/jobTitles")
    public String getJobTitles(Model model){

        List<JobTitle> jobTitleList = jobTitleService.getJobTitles();
        model.addAttribute("jobTitles", jobTitleList);

        return "jobTitle";
    }

    @PostMapping("/jobTitles/addNew")
    public String addNew(JobTitle jobTitle){
        jobTitleService.save(jobTitle);
        return "redirect:/jobTitles";
    }

    @RequestMapping(value = "/jobTitles/findById")
    @ResponseBody
    public Optional<JobTitle> findById(int id){
        return jobTitleService.findById(id);
    }

    @RequestMapping( value = "/jobTitles/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(JobTitle jobTitle){
        jobTitleService.save(jobTitle);
        return "redirect:/jobTitles";
    }

    @RequestMapping( value = "/jobTitles/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        jobTitleService.delete(id);
        return "redirect:/jobTitles";
    }
}
