package com.hva.tradeforgoals.domain;

import javax.persistence.*;

@Entity
public class Advertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String description;

    @ManyToOne
    private Lid lidId;

    public Advertisement() {

    }

    public Advertisement(String description) {
        this.description = description;
    }

    public long id() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Lid getLidId() {
        return lidId;
    }

    public void setLidId(Lid lidId) {
        this.lidId = lidId;
    }
}
