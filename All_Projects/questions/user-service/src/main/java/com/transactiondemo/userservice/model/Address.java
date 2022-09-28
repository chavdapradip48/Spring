package com.transactiondemo.userservice.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "cloud_address")
public class Address {

    // Neddable variable fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

   private String general;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="user_fk")
    private User user;

    public Address() {
    }

    public Address(String general, User user) {
        this.general = general;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGeneral() {
        return general;
    }

    public void setGeneral(String general) {
        this.general = general;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", general='" + general + '\'' +
                ", user=" + user +
                '}';
    }
}