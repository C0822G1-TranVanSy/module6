package com.codegym.service;

import com.codegym.entity.Area;
import com.codegym.entity.PitchType;

import java.util.List;

public interface IPitchTypeService {
    List<PitchType> findAll();
}
