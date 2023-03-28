package com.codegym.dto;

import com.codegym.entity.Area;
import com.codegym.entity.Customer;
import com.codegym.entity.PitchType;
import com.codegym.entity.TimeSlot;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class PitchDto implements Validator {
    private Long id;
    @NotBlank(message = "Yêu cầu phải nhập.")
    private String name;
    @NotBlank(message = "Yêu cầu phải nhập.")
    private String address;
    @NotNull(message = "Yêu cầu phải nhập.")
    private PitchType pitchType;
    @NotNull(message = "Yêu cầu phải nhập.")
    private Area area;
    @NotNull(message = "Yêu cầu phải nhập.")
    private TimeSlot timeSlot;
    private Customer customer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public PitchType getPitchType() {
        return pitchType;
    }

    public void setPitchType(PitchType pitchType) {
        this.pitchType = pitchType;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
