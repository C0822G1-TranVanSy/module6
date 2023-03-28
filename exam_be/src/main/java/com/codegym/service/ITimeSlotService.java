package com.codegym.service;

import com.codegym.entity.TimeSlot;

import java.util.List;

public interface ITimeSlotService {
    List<TimeSlot> findAll();
}
