package com.codegym.repository;

import com.codegym.entity.Area;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAreaRepository extends JpaRepository<Area, Long> {
}
