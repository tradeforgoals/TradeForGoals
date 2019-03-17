package com.hva.tradeforgoals.domain;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String description;

    @Lob
    private byte[] pictures;

    @ManyToOne
    public Trade trade;

    @OneToOne
    public Advertisement advertisement;

    public Product(){

    }

    public Product(String description, byte[] pictures) {
        this.description = description;
        this.pictures = pictures;
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getPictures() {
        return pictures;
    }

    public void setPictures(byte[] pictures) {
        this.pictures = pictures;
    }

    public Advertisement getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(Advertisement advertisement) {
        this.advertisement = advertisement;
    }
}
