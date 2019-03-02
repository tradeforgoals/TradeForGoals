package com.hva.TradeforGoals.entiteiten;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;


public class Trade {

    @Id
    @GeneratedValue
    private long tradeId;

    private long providerId;
    private long receiverId;

    @OneToMany
    private Set<Product> productsInvolved;

    public Trade(){

    }

    public Trade(long providerId, long receiverId, Set<Product> productsInvolved) {
        this.providerId = providerId;
        this.receiverId = receiverId;
        this.productsInvolved = productsInvolved;
    }

    public long getTradeId() {
        return tradeId;
    }


    public long getProviderId() {
        return providerId;
    }

    public void setProviderId(long providerId) {
        this.providerId = providerId;
    }

    public long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(long receiverId) {
        this.receiverId = receiverId;
    }

    public Set<Product> getProductsInvolved() {
        return productsInvolved;
    }

    public void setProductsInvolved(Set<Product> productsInvolved) {
        this.productsInvolved = productsInvolved;
    }
}
