package com.jilnash.hacknu23.repo;

import com.jilnash.hacknu23.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface OrderRepo extends JpaRepository<Order, Long> {

    List<Order> findAllByDeadlineAfter(Date after);
}
