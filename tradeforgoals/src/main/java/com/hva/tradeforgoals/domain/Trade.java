package com.hva.tradeforgoals.domain;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.*;

@Entity
public class Trade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long providerId;
    private long receiverId;
    private LocalDate date;

    public Trade(){

    }

    public Trade(long providerId, long receiverId) {
        this.providerId = providerId;
        this.receiverId = receiverId;
        this.date = LocalDate.now();
    }

    public long getId() {
        return id;
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

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

}

