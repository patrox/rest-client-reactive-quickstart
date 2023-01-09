package org.acme;

import com.fasterxml.jackson.annotation.JsonCreator;

public class BeerDto {

    private String name;

    private String tagline;

    private double abv;

    private BeerDto(String name, String tagline, double abv) {
        this.name = name;
        this.tagline = tagline;
        this.abv = abv;
    }

    @JsonCreator
    public static BeerDto of(String name, String tagline, double abv) {
        return new BeerDto(name, tagline, abv);
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
