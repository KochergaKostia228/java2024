package com.company.model;

public class Bill {
    private int nominal;
    private int count;

    public Bill(int nominal, int count) {
        this.nominal = nominal;
        this.count = count;
    }

    public int getNominal() {
        return nominal;
    }

    public int getCount() {
        return count;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
