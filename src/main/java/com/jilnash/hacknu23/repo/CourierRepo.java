package com.jilnash.hacknu23.repo;

import com.jilnash.hacknu23.model.Courier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourierRepo extends JpaRepository<Courier, Long> {

    Courier findByLoginAndPassword(String login, String password);
}
