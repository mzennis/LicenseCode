package com.novia.licencecode.db;

public class PlatNomor {

    public String code;
    public String area;
    public String country;

    public PlatNomor() {
    }

    public PlatNomor(String code, String area, String country) {
        this.code = code;
        this.area = area;
        this.country = country;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}