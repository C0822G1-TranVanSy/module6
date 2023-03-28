package com.codegym.service.impl;

import com.codegym.entity.PitchType;
import com.codegym.repository.IPitchTypeRepository;
import com.codegym.service.IPitchTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PitchTypeServiceImpl implements IPitchTypeService {
    @Autowired
    private IPitchTypeRepository iPitchTypeRepository;

    @Override
    public List<PitchType> findAll() {
        return iPitchTypeRepository.findAll();
    }
}
