package com.company;

public enum OperatorCountry {
    Brest("Brest", "\t8-016"),
    Vitebsk("Vitebsk","8-021"),
    Gomel("Gomel", "8-023"),
    Grodno("Grodno", "\t8-015"),
    Minsk("Minsk", "8-017"),
    Mogilev("Mogilev","\t8-022");

    private String title;
    private String code;

    OperatorCountry(String title, String code){
        this.title = title;
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public String getCode() {
        return "\"OperatorCountry\"" + " \"" + code + "\",";
    }
}
