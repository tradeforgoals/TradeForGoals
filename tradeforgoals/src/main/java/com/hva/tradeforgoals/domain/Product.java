package com.hva.tradeforgoals.domain;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String title;
    private String shortDescription;
    private String catergory;
    private long currentOwner;

//    @Lob
//    private byte[] pictures;

    @ManyToOne
    public Trade trade;

    @OneToOne
    public Advertisement advertisement;

    public Product(){

    }

    public Product(String title, String description, String catergory, Lid lid) {
        this.title = title;
        this.shortDescription = description;
        this.currentOwner = lid.getId();
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return shortDescription;
    }

    public void setDescription(String description) {
        this.shortDescription = description;
    }

//    public byte[] getPictures() {
//        return pictures;
//    }
//
//    public void setPictures(byte[] pictures) {
//        this.pictures = pictures;
//    }

    public Advertisement getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(Advertisement advertisement) {
        this.advertisement = advertisement;
    }

	public String getCatergorie() {
		return catergory;
	}

	public void setCatergorie(String catergorie) {
		this.catergory = catergorie;
	}

	public long getCurrentOwner() {
		return currentOwner;
	}

	public void setCurrentOwner(long currentOwner) {
		this.currentOwner = currentOwner;
	}
}
