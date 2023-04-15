package com.jilnash.hacknu23.repo;

import com.jilnash.hacknu23.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepo extends JpaRepository<Service, Long> {
}
