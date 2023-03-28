package com.codegym.service;

import com.codegym.entity.Pitch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPitchService {
    Page<Pitch> searchByThreeField(String pitchName, Long areaId, Long pitchTypeId, Pageable pageable);

    Page<Pitch> searchByNameAndArea(String pitchName, Long areaId, Pageable pageable);

    Page<Pitch> searchByNameAndPitchType(String pitchName, Long pitchTypeId, Pageable pageable);

    Page<Pitch> searchByName(String pitchName, Pageable pageable);

    void deleteById(Long id);

    void addPitch(Pitch pitch);

    Boolean exitByName(String name);
}
