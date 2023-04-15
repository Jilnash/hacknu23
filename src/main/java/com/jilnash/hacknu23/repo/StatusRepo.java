package com.jilnash.hacknu23.repo;

import com.jilnash.hacknu23.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepo extends JpaRepository<Status, Long> {
}
