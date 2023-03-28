package com.codegym.service.impl;

import com.codegym.entity.TimeSlot;
import com.codegym.repository.ITimeSlotRepository;
import com.codegym.service.ITimeSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ITimeSlotServiceImpl implements ITimeSlotService {
    @Autowired
    private ITimeSlotRepository iTimeSlotRepository;

    @Override
    public List<TimeSlot> findAll() {
        return iTimeSlotRepository.findAll();
    }
}
