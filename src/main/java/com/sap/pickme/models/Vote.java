package com.sap.pickme.models;

import javax.persistence.*;

@Entity
@Table(name = "VOTE")
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="USER_ID", nullable=false)
    private int user_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="RESTAURANT_ID", nullable=false)
    private int restaurant_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "POOL_ID", nullable = false)
    private Pool pool;


    //Getters and Setters

    public int getId() { return id; }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(int restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public Pool getPool() {
        return pool;
    }

    public void setPool(Pool pool) {
        this.pool = pool;
    }


}
