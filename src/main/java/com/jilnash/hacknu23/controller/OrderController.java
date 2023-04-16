package com.jilnash.hacknu23.controller;

import com.jilnash.hacknu23.model.Order;
import com.jilnash.hacknu23.repo.CourierRepo;
import com.jilnash.hacknu23.repo.OrderRepo;
import com.jilnash.hacknu23.repo.ServiceRepo;
import com.jilnash.hacknu23.repo.StatusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "*")
public class OrderController {

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    StatusRepo statusRepo;

    @Autowired
    CourierRepo courierRepo;

    @Autowired
    ServiceRepo serviceRepo;

    @GetMapping
    public List<Order> getOrders() {

//        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//        Date now = new Date();
//        System.out.println(dateFormat.format(now));

        return orderRepo.findAll();
    }

    @GetMapping("/status/{id}")
    public List<Order> getAcceptedOrders(@PathVariable Long id, @RequestParam(required = false) Long sid) {

        if (id == 1)
            return orderRepo.
                    findAllByStatusAndService(statusRepo.getReferenceById(id), serviceRepo.getReferenceById(sid));

        return orderRepo.findAllByStatus(statusRepo.getReferenceById(id));
    }

    @PostMapping
    public void create(@RequestBody Order order) {

        orderRepo.save(order);
    }

    @PostMapping("{id}/process")
    public void acceptOrder(@PathVariable Long id, @RequestParam Long c) {

        Order order = orderRepo.getReferenceById(id);

        order.setStatus(statusRepo.getReferenceById(2L));
        order.setCourier(courierRepo.getReferenceById(c));

        orderRepo.save(order);
    }

    @PostMapping("{id}/finish")
    public void finishOrder(@PathVariable Long id) {

        Order order = orderRepo.getReferenceById(id);

        order.setStatus(statusRepo.getReferenceById(3L));

        orderRepo.save(order);
    }
}
