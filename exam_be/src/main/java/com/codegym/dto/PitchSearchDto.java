package com.codegym.dto;

public class PitchSearchDto {
    private String name;
    private Long areaId;
    private Long pitchTypeId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public Long getPitchTypeId() {
        return pitchTypeId;
    }

    public void setPitchTypeId(Long pitchTypeId) {
        this.pitchTypeId = pitchTypeId;
    }
}
