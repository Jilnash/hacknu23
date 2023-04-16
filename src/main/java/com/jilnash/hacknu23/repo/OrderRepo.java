package com.jilnash.hacknu23.repo;

import com.jilnash.hacknu23.model.Order;
import com.jilnash.hacknu23.model.Service;
import com.jilnash.hacknu23.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order, Long> {

    List<Order> findAllByStatus(Status status);

    List<Order> findAllByStatusAndService(Status status, Service service);
}
