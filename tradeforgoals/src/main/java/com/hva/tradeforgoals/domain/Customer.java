package com.hva.tradeforgoals.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {

    @Id
    @Column(name = "customer_id")
    private String id;

    @Column(name = "first_name")
    private String firstname;

    @Column(name = "last_name")
    private String lastname;

    @Column(name = "email")
    private String email;

    @Column(name = "zipcode")
    private String zipcode;

    @Column(name = "housenumber")
    private String housenumber;

//    @OneToMany(mappedBy = "customer")
//    private Set<Product> products;
//
//    @OneToMany(mappedBy = "customer")
//    private Set<Advertisement> advertisements;

    public Customer() {

    }
    
    public Customer(String firstname, String lastname, String email, String zipcode, String housenumber, String id) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.zipcode = zipcode;
        this.housenumber = housenumber;
        this.id = id;
    }

    public String getId() {
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

    public String getHousenumber() {
        return housenumber;
    }

    public void setHousenumber(String housenumber) {
        this.housenumber = housenumber;
    }

//    public Set<Product> getProducts() {
//        return products;
//    }
//
//    public void setProducts(Set<Product> products) {
//        this.products = products;
//    }
//
//    public Set<Advertisement> getAdvertisements() {
//        return advertisements;
//    }
//
//    public void setAdvertisements(Set<Advertisement> advertisements) {
//        this.advertisements = advertisements;
//    }
}

