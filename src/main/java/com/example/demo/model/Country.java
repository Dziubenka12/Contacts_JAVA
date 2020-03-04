package com.example.demo.model;

public enum Country {
    Belarus("BY", "Belarus"),
    Russia("RU", "Russia"),
    Ukraine("UA", "Ukraine"),
    Poland("PL", "Poland");

    private String title;
    private String code;

    Country(String title, String code){
        this.title = title;
        this.code = code;
    }

    public String getTitle() {
        return title;
    }
    public String getCode() {
        return code;
    }
}
