package com.emse.spring.faircorp.model;
import javax.persistence.*;
import java.util.Set;

// (1)
@Entity
// (2)
@Table(name="BUILDING")
public class Building {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable=false)
    private String name;
    @Column
    private Double OutsideTemperature;

    @OneToMany(mappedBy = "building")
    private Set<Room> rooms;

    public Building() {
    }


    public Building(String name, double OutsideTemperature) {
        this.name = name;
        this.OutsideTemperature=OutsideTemperature;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getOutsideTemperature() {
        return this.OutsideTemperature;
    }

    public void setOutsideTemperature(double OutsideTemperature) {
        this.OutsideTemperature = OutsideTemperature;
    }

    public Set<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
