package com.compane.ex_4;

public class Projector {
    private String name;
    private int yearRelease;
    private double pay;
    private String manufacturer;

    public Projector(String name, int yearRelease, double pay, String manufacturer) {
        this.name = name;
        this.yearRelease = yearRelease;
        this.pay = pay;
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearRelease() {
        return yearRelease;
    }

    public void setYearRelease(int yearRelease) {
        this.yearRelease = yearRelease;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
