package com.hva.tradeforgoals.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "trade")
public class Trade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "trade_id")
    private long id;

    @OneToMany(mappedBy = "trade")
    private Set<Product> tradingProducts;

    public Trade(){

    }

    public long getId() {
        return id;
    }

    public Set<Product> getTradingProducts() {
        return tradingProducts;
    }

    public void setTradingProducts(Set<Product> tradingProducts) {
        this.tradingProducts = tradingProducts;
    }


}

