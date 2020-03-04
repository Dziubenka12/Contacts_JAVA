package com.example.demo.model;

public enum Operator {
    A1("A1", "44"),
    MTS("MTS", "33"),
    LIFE("Life", "25");

    private String title;
    private String code;

    Operator(String title, String code) {
        this.title = title;
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public String getCode() {
        return " \"" + code + "\"";
    }
}
