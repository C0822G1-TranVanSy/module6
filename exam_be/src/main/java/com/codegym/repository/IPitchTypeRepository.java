package com.codegym.repository;

import com.codegym.entity.PitchType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPitchTypeRepository extends JpaRepository<PitchType, Long> {
}
