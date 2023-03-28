package com.codegym.service.impl;

import com.codegym.entity.Area;
import com.codegym.repository.IAreaRepository;
import com.codegym.service.IAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements IAreaService {
    @Autowired
    private IAreaRepository iAreaRepository;

    @Override
    public List<Area> findAll() {
        return iAreaRepository.findAll();
    }
}
