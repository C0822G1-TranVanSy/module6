package com.codegym.service.impl;

import com.codegym.entity.Pitch;
import com.codegym.repository.IPitchRepository;
import com.codegym.service.IPitchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PitchServiceImpl implements IPitchService {
    @Autowired
    private IPitchRepository iPitchRepository;

    @Override
    public Page<Pitch> searchByThreeField(String pitchName, Long areaId, Long pitchTypeId, Pageable pageable) {
        return iPitchRepository.searchByThreeField(pitchName,areaId,pitchTypeId,pageable);
    }

    @Override
    public Page<Pitch> searchByNameAndArea(String pitchName, Long areaId, Pageable pageable) {
        return iPitchRepository.searchByNameAndArea(pitchName,areaId,pageable);
    }

    @Override
    public Page<Pitch> searchByNameAndPitchType(String pitchName, Long pitchTypeId, Pageable pageable) {
        return iPitchRepository.searchByNameAndPitchType(pitchName,pitchTypeId,pageable);
    }

    @Override
    public Page<Pitch> searchByName(String pitchName, Pageable pageable) {
        return iPitchRepository.searchByName(pitchName,pageable);
    }

    @Override
    public void deleteById(Long id) {
        iPitchRepository.deleteById(id);
    }

    @Override
    public void addPitch(Pitch pitch) {
        iPitchRepository.save(pitch);
    }

    @Override
    public Boolean exitByName(String name) {
        return iPitchRepository.existsByName(name);
    }


}
