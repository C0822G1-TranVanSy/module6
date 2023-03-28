package com.codegym.repository;

import com.codegym.entity.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITimeSlotRepository extends JpaRepository<TimeSlot, Long> {
}
