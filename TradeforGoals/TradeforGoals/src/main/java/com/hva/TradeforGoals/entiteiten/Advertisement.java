package com.hva.TradeforGoals.entiteiten;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

public class Advertisement {

    @Id
    @GeneratedValue
    private long advertisementID;

    private String description;

    @OneToMany
    private Set<Product> offeredProducts;

    public Advertisement(){

    }

    public Advertisement(String description, Set<Product> offeredProducts) {
        this.description = description;
        this.offeredProducts = offeredProducts;
    }

    public long getAdvertisementID() {
        return advertisementID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Product> getOfferedProducts() {
        return offeredProducts;
    }

    public void setOfferedProducts(Set<Product> offeredProducts) {
        this.offeredProducts = offeredProducts;
    }
}
