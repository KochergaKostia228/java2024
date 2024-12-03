package com.company;

public class Car implements Runnable{
    private String name;
    private int maxSpeed;

    public Car(int maxSpeed, String name) {
        this.maxSpeed = maxSpeed;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public void run() {
        System.out.println("Машина " + name + " с максимальной скоростью " + maxSpeed + "км/ч едет!");
    }
}
