package com.jilnash.hacknu23.controller;

import com.jilnash.hacknu23.model.Courier;
import com.jilnash.hacknu23.repo.CourierRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/couriers")
@CrossOrigin(origins = "*")
public class CourierController {

    @Autowired
    CourierRepo courierRepo;

    @GetMapping
    public List<Courier> getCouriers() {

        return courierRepo.findAll();
    }

    @GetMapping("/{id}")
    public Courier getCourier(@PathVariable Long id) {

        return courierRepo.getReferenceById(id);
    }

    @PostMapping("/auth")
    public boolean authCourier(@RequestParam String login, @RequestParam String password) {

        Courier courier = courierRepo.findByLoginAndPassword(login, password);

        return courier != null;
    }

    @PostMapping("/{id}")
    public void editCourier(@PathVariable Long id, @RequestBody Courier courier) {

        courierRepo.save(courier);
    }

    @DeleteMapping("/{id}")
    public void deleteCourier(@PathVariable Long id) {

        courierRepo.delete(courierRepo.getReferenceById(id));
    }
}
