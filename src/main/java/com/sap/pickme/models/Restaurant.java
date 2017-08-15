package com.sap.pickme.models;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "RESTAURANT")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @NotEmpty(message = "Cannot be empty")
    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @NotNull
    @Column(name = "PRICE")
    private double price;

    @Column(name = "ALELO")
    private boolean aleloAccepted;

    @Column(name = "LOCATION")
    private String location;

    @URL
    @Column(name = "IMAGE")
    private String image;

    @Transient
    private int votes;

    //TODO

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() { return price; }

    public void setPrice(double price) { this.price = price; }

    public boolean isAleloAccepted() {
        return aleloAccepted;
    }

    public void setAleloAccepted(boolean aleloAccepted) {
        this.aleloAccepted = aleloAccepted;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImage() { return image; }

    public void setImage(String image) {
        this.image = image;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }
}
