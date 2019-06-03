package com.hva.tradeforgoals.domain;

import javax.persistence.*;

@Entity
@Table(name = "Advertisement")
public class Advertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "advertisement_id")
    private long id;

    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

//    @JoinColumn(name = "product_id")
//    @OneToOne(cascade = CascadeType.ALL)
//    private Product advertisementProduct;

    public Advertisement() {

    }

    public Advertisement(String title, String description) {
        this.title = title;
        this.description = description;
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
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

//    public Product getAdvertisementProduct() {
//        return advertisementProduct;
//    }
//
//    public void setAdvertisementProduct(Product advertisementProduct) {
//        this.advertisementProduct = advertisementProduct;
//    }
}
