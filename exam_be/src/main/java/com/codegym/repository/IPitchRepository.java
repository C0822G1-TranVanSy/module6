package com.codegym.repository;

import com.codegym.entity.Pitch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface IPitchRepository extends JpaRepository<Pitch, Long> {
    Boolean existsByName(String name);

    @Query(value = "select p.* from `pitch` p where p.name like concat('%',:pitchName,'%') and p.area_id = :areaId and p.pitch_type_id = :pitchTypeId", nativeQuery = true)
    Page<Pitch> searchByThreeField(@Param("pitchName") String pitchName, @Param("areaId") Long areaId, @Param("pitchTypeId") Long pitchTypeId, Pageable pageable);

    @Query(value = "select p.* from `pitch` p where p.name like concat('%',:pitchName,'%') and p.area_id = :areaId", nativeQuery = true)
    Page<Pitch> searchByNameAndArea(@Param("pitchName") String pitchName, @Param("areaId") Long areaId, Pageable pageable);

    @Query(value = "select p.* from `pitch` p where p.name like concat('%',:pitchName,'%') and p.pitch_type_id = :pitchTypeId", nativeQuery = true)
    Page<Pitch> searchByNameAndPitchType(@Param("pitchName") String pitchName, @Param("pitchTypeId") Long pitchTypeId, Pageable pageable);

    @Query(value = "select p.* from `pitch` p where p.name like concat('%',:pitchName,'%')", nativeQuery = true)
    Page<Pitch> searchByName(@Param("pitchName") String pitchName, Pageable pageable);
}
