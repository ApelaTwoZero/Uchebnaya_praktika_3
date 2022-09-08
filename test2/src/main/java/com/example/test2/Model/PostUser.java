package com.example.test2.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PostUser {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;

    public String name;
    public String surname;
    public String midlname;
    public int age;
    public int growth;
    public  double weight;

    public PostUser(String name, String surname, String midlname, int age, int growth, double weight) {
        this.name = name;
        this.surname = surname;
        this.midlname = midlname;
        this.age = age;
        this.growth = growth;
        this.weight = weight;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMidlname() {
        return midlname;
    }

    public void setMidlname(String midlname) {
        this.midlname = midlname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGrowth() {
        return growth;
    }

    public void setGrowth(int growth) {
        this.growth = growth;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }



    public PostUser() {

    }
}
