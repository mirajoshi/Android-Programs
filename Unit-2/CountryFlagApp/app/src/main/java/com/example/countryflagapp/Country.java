package com.example.countryflagapp;

public class Country {
    private String name;
    private int flagResId; // drawable resource ID

    public Country(String name, int flagResId) {
        this.name = name;
        this.flagResId = flagResId;
    }

    public String getName() { return name; }
    public int getFlagResId() { return flagResId; }
}
