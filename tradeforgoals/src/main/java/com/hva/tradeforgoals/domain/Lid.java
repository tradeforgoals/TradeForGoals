package com.hva.tradeforgoals.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Lid {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String firstname;
    private String lastname;
    private String email;
    private String zipcode;
    private int housenumber;

    public Lid(){

    }

    public Lid(long id,String firstname, String lastname, String email, String zipcode, int housenumber) {
    	this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.zipcode = zipcode;
        this.housenumber = housenumber;
    }

    public long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public int getHousenumber() {
        return housenumber;
    }

    public void setHousenumber(int housenumber) {
        this.housenumber = housenumber;
    }

    public void setId(long id) {
    	this.id = id;
    }
}

