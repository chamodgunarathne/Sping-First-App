package com.spingsample.backend.repository;

import com.spingsample.backend.model.Sales;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Sales, Long> {
}
