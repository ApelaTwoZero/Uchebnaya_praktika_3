package com.example.test2.Model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PostGan {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;
    public String name;
    public int boolets;
    public double speed;
    public int gans_range;
    public int disassembly;


    public PostGan(String name, int boolets, double speed, int gans_range, int disassembly) {
        this.name = name;
        this.boolets = boolets;
        this.speed = speed;
        this.gans_range = gans_range;
        this.disassembly = disassembly;
    }

    public PostGan() {

    }


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

    public int getBoolets() {
        return boolets;
    }

    public void setBoolets(int boolets) {
        this.boolets = boolets;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getGans_range() {
        return gans_range;
    }

    public void setGans_range(int gans_range) {
        this.gans_range = gans_range;
    }

    public int getDisassembly() {
        return disassembly;
    }

    public void setDisassembly(int disassembly) {
        this.disassembly = disassembly;
    }


}
