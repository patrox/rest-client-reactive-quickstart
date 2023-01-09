package org.acme;

import javax.persistence.*;

@Entity
public class Beer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private String tagline;

    private double abv;

    public Beer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Beer(String name, String tagline, double abv) {
        this.name = name;
        this.tagline = tagline;
        this.abv = abv;
    }

    public static Beer of(String name, String tagline, double abv) {
        return new Beer(name, tagline, abv);
    }

    public String getName() {
        return name;
    }

    public String getTagline() {
        return tagline;
    }

    public double getAbv() {
        return abv;
    }

}