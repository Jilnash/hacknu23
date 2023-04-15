package com.jilnash.hacknu23.controller;

import com.jilnash.hacknu23.model.Service;
import com.jilnash.hacknu23.repo.ServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
@CrossOrigin(origins = "*")
public class ServiceController {

    @Autowired
    ServiceRepo serviceRepo;

    @GetMapping
    public List<Service> getServices() {

        return serviceRepo.findAll();
    }

    @GetMapping("/{id}")
    public Service getOperator(@PathVariable Long id) {

        return serviceRepo.getReferenceById(id);
    }

    @PostMapping()
    public void editOperator( @RequestBody Service service) {

        serviceRepo.save(service);
    }

    @DeleteMapping("/{id}")
    public void deleteOperator(@PathVariable Long id) {

        serviceRepo.delete(serviceRepo.getReferenceById(id));
    }
}
