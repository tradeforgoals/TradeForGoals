package com.hva.TradeforGoals.entiteiten;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private long productId;
    private String description;

    @Lob
    private byte[] pictures;

    public Product(){

    }

    public Product(String description, byte[] pictures) {
        this.description = description;
        this.pictures = pictures;
    }

    public long getProductId() {
        return productId;
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
}
