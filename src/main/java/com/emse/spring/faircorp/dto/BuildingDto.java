package com.emse.spring.faircorp.dto;

import com.emse.spring.faircorp.model.Building;
import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.HeaterStatus;

public class BuildingDto {

    private Long id;
    private String name;
    private Double OutsideTemperature;

    public BuildingDto() {
    }

    public BuildingDto(Building building) {
        this.id = building.getId();
        this.name = building.getName();
        this.OutsideTemperature=building.getOutsideTemperature();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getOutsideTemperature() {
        return OutsideTemperature;
    }

    public void setOutsideTemperature(Double OutsideTemperature) {
        this.OutsideTemperature = OutsideTemperature;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
