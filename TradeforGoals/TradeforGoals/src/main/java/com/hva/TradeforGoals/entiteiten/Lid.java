package com.hva.TradeforGoals.entiteiten;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Lid {

    @Id
    @GeneratedValue
    private long id;

    private String firstname;
    private String lastname;
    private String email;
    private String zipcode;
    private int housenumber;
    private String sumOfTradedStuff;
    private int rank;

    @OneToMany
    private Set<Advertisement> advertisements;

    @ManyToMany
    private Set<Trade> trades;

    public Lid(){

    }

    public Lid(String firstname, String lastname, String email, String zipcode, int housenumber) {
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

    public String getSumOfTradedStuff() {
        return sumOfTradedStuff;
    }

    public void setSumOfTradedStuff(String sumOfTradedStuff) {
        this.sumOfTradedStuff = sumOfTradedStuff;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Set<Advertisement> getAdvertisements() {
        return advertisements;
    }

    public void setAdvertisements(Set<Advertisement> advertisements) {
        this.advertisements = advertisements;
    }

    public Set<Trade> getTrades() {
        return trades;
    }

    public void setTrades(Set<Trade> trades) {
        this.trades = trades;
    }
}
