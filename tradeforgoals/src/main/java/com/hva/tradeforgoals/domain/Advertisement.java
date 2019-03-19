package com.hva.tradeforgoals.domain;

import javax.persistence.*;

@Entity
public class Advertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String title;
    private String description;

    @ManyToOne
    private Lid lidId;

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

    public Lid getLidId() {
        return lidId;
    }

    public void setLidId(Lid lidId) {
        this.lidId = lidId;
    }
}
