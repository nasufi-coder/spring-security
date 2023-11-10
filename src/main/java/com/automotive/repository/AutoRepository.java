package com.automotive.repository;

import com.automotive.models.entity.AutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutoRepository extends JpaRepository<AutoEntity, Integer> {
}
