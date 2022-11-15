package com.emse.spring.faircorp.model;
import javax.persistence.*;

// (1)
@Entity
// (2)
@Table(name="HEATER")
public class Heater {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable=false)
    @Enumerated(EnumType.STRING)
    private HeaterStatus HeaterStatus;

    @Column(nullable=false)
    private String name;

    @Column(nullable=true)
    private Long power;

    @ManyToOne
    private Room room;


    public Heater(){

    }

    public Heater(String name, Long power, Room room, HeaterStatus status) {
        this.HeaterStatus = status;
        this.name = name;
        this.power=power;
        this.room=room;
    }

    public Long getId() {
        return this.id;
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

    public Long getPower() {
        return this.power;
    }

    public void setPower(Long power) {
        this.power = power;
    }

    public Room getRoom() {
        return this.room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public HeaterStatus getHeaterStatus() {
        return HeaterStatus;
    }

    public void setHeaterStatus(HeaterStatus HeaterStatus) {
        this.HeaterStatus = HeaterStatus;
    }


}