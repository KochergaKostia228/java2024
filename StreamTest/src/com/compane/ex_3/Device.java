package com.compane.ex_3;

public class Device {
    private String name;
    private int yearRelease;
    private double pay;
    private String color;
    private String type;

    public Device(String name, int yearRelease, double pay, String color, String type) {
        this.name = name;
        this.yearRelease = yearRelease;
        this.pay = pay;
        this.color = color;
        this.type = type;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
