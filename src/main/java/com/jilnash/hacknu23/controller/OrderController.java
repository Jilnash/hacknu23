package com.jilnash.hacknu23.controller;

import com.jilnash.hacknu23.model.Order;
import com.jilnash.hacknu23.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "*")
public class OrderController {

    @Autowired
    OrderRepo orderRepo;

    @GetMapping
    public List<Order> getOrders() {

//        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//        Date now = new Date();
//        System.out.println(dateFormat.format(now));

        return orderRepo.findAll();
    }

    @PostMapping
    public void create(@RequestBody Order order) {

        orderRepo.save(order);
    }
}
